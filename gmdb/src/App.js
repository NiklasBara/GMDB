import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./component/Home";
import MovieOverview from "./component/MovieOverview";
import SingleMovie from "./component/SingleMovie";

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

const App = () => {
  return (
    <Router>
      <Switch>
        <Route path="/movie">
          <MovieOverview data={data} />
        </Route>
        <Route path="/" component={Home} />
        <Route path="/movie/details/:id" component={SingleMovie} />
      </Switch>
    </Router>
  );
};

export default App;
