import React from "react";
import { render } from "@testing-library/react";
import MovieOverview from "../component/MovieOverview";
import rootReducer from "../reducer/rootReducer";
import { createStore, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import {act} from "react-dom/test-utils";

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

let component;

beforeEach(async() => {
  const store = createStore(rootReducer, applyMiddleware(thunk));
  const mockSuccesResponse = fakeData;
  const mockJsonPromise = Promise.resolve(mockSuccesResponse);
  const mockFetchPromise = Promise.resolve({
      json: () => mockJsonPromise,
  });
  jest.spyOn(global, 'fetch').mockImplementation(() => mockFetchPromise);

    await act(async () => {
       component = render(<MovieOverview store={store} />);
    })
});

test("renders several movieItems in a table", () => {
  const { queryAllByTestId } = component;
  const result = queryAllByTestId("movie-item");
  expect(result.length).toEqual(2);
});
