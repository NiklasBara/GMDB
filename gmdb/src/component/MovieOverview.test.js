import React from "react";
import { render, getByText } from "@testing-library/react";
import MovieOverview from "./MovieOverview";

const data = [
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

beforeEach(() => {
  component = render(<MovieOverview data={data} />);
});

test("renders several movieItems in a table", () => {
  const { queryAllByTestId } = component;
  const result = queryAllByTestId("movie-item");
  expect(result.length).toEqual(2);
});
