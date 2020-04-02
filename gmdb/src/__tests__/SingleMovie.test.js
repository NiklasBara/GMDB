import React from "react";
import SingleMovie from "../component/SingleMovie";
import { render } from "@testing-library/react";
import rootReducer from "../reducer/rootReducer";
import { createStore, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import {act} from "react-dom/test-utils";


const fakeData = {
    id: 1,
    title: "Star Wars",
    year: 2000,
    genre: "Fantasy",
    runtime: 300,
    rating: 5.5,
    reviews: [
        {
            id: 1,
            text: "was good"
        },
        {
            id: 2,
            text: "was not good"
        }
    ]
}

let component;

test("renders a movie", async() => {
    const store = createStore(rootReducer, applyMiddleware(thunk));
    const mockSuccesResponse = fakeData;
    const mockJsonPromise = Promise.resolve(mockSuccesResponse);
    const mockFetchPromise = Promise.resolve({
        json: () => mockJsonPromise,
    });
    jest.spyOn(global, 'fetch').mockImplementation(() => mockFetchPromise);

    const defaultProps = {
        params: { id: 123 } ,
    };

    await act(async () => {
       component = render(<SingleMovie match={defaultProps} store={store} />);
    })
    const {getByText } = component;
    const reviewOne = getByText("was good");
    const reviewTwo = getByText("was not good");
    const id = getByText("1");
    const title = getByText("Star Wars");
    const year = getByText("2000");
    const genre = getByText("Fantasy");
    const runtime = getByText("300");
    const rating = getByText("5.5");
    expect(reviewOne).toBeInTheDocument();
    expect(reviewTwo).toBeInTheDocument();
    expect(id).toBeInTheDocument();
    expect(title).toBeInTheDocument();
    expect(year).toBeInTheDocument();
    expect(genre).toBeInTheDocument();
    expect(runtime).toBeInTheDocument();
    expect(rating).toBeInTheDocument();
    
})
