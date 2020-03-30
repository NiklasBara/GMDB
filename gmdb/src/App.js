import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./component/Home";
import MovieOverview from "./component/MovieOverview";

const App = () => {
  return (
    <Router>
      <Switch>
        <Route path="/movie" component={MovieOverview} />
        <Route path="/" component={Home} />
      </Switch>
    </Router>
  );
};

export default App;
