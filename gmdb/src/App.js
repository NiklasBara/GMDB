import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./component/Home";
import Movie from "./component/Movie";

const App = () => {
  return (
    <Router>
      <Switch>
        <Route path="/movie" component={Movie} />
        <Route path="/" component={Home} />
      </Switch>
    </Router>
  );
};

export default App;
