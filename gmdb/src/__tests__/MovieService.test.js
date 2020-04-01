import React from "react";
import { render } from "@testing-library/react";
import rootReducer from "../reducer/rootReducer";
import { createStore, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import MovieOverview from "../component/MovieOverview";
import {act} from "react-dom/test-utils";
import { MemoryRouter as Router } from "react-router-dom";
const fakeData = [
    {
        id: 1,
        title: "Star Wars",
        year: 2000,
        genre: "Fantasy",
        runtime: 300,
        rating: 5.5
    },
    {
        id: 2,
        title: "King Kong",
        year: 2100,
        genre: "Fantasy",
        runtime: 280,
        rating: 3.1
    }
];

test("testing fetches data from server", async(done) => {

    const store = createStore(rootReducer, applyMiddleware(thunk));
    const mockSuccesResponse = fakeData;
    const mockJsonPromise = Promise.resolve(mockSuccesResponse);
    const mockFetchPromise = Promise.resolve({
        json: () => mockJsonPromise,
    });
    jest.spyOn(global, 'fetch').mockImplementation(() => mockFetchPromise);
    let component; 
    await act(async () => {
       component = render(<Router><MovieOverview store={store} /></Router>);
    })

    expect(global.fetch).toHaveBeenCalledTimes(1);
    expect(global.fetch).toHaveBeenCalledWith('http://localhost:8080/api/movies');

    process.nextTick(() => { 
        const { queryAllByTestId } = component;
        const result = queryAllByTestId("movie-item");
        expect(result.length).toEqual(2);
        
        global.fetch.mockClear(); 
        done(); 
    });
});


