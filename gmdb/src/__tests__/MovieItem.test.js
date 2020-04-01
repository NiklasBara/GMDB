import React from "react";
import { render, fireEvent } from "@testing-library/react";
import MovieItem from "../component/MovieItem";
import { BrowserRouter as Router } from "react-router-dom";
import { Link } from "react-router-dom";


import Enzyme from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
 
Enzyme.configure({ adapter: new Adapter() });

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
    component = render(<Router><MovieItem data={data} /></Router>);
});

test("renders movieItem properties correctly", () => {
    const { getByText } = component;
    const id = getByText("1");
    const title = getByText("Star Wars");
    const year = getByText("2000");
    const genre = getByText("Fantasy");
    const runtime = getByText("300");
    const rating = getByText("5.5");
    const link = getByText("Details...");
    expect(id).toBeInTheDocument();
    expect(title).toBeInTheDocument();
    expect(year).toBeInTheDocument();
    expect(genre).toBeInTheDocument();
    expect(runtime).toBeInTheDocument();
    expect(rating).toBeInTheDocument();
    expect(link).toBeInTheDocument();
});

it('includes link to Detail Page', () => {
    const wrapper = Enzyme.mount(<Router><MovieItem data={data} /></Router>);
    expect(wrapper.find(Link).props().to).toBe(`/movie/details/${data.id}`);
});