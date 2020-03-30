import React from "react";
import { render } from "@testing-library/react";
import MovieItem from "./MovieItem";

const data = {
  id: 1,
  title: "Star Wars",
  year: 2000,
  genre: "Fantasy",
  runtime: 300,
  rating: 5.5
};

let component;

beforeEach(() => {
  component = render(<MovieItem data={data} />);
});

test("renders movieItem properties correctly", () => {
  const { getByText } = component;
  const id = getByText("1");
  const title = getByText("Star Wars");
  const year = getByText("2000");
  const genre = getByText("Fantasy");
  const runtime = getByText("300");
  const rating = getByText("5.5");
  expect(id).toBeInTheDocument();
  expect(title).toBeInTheDocument();
  expect(year).toBeInTheDocument();
  expect(genre).toBeInTheDocument();
  expect(runtime).toBeInTheDocument();
  expect(rating).toBeInTheDocument();
});
