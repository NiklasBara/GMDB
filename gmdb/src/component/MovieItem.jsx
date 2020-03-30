import React from "react";

const MovieItem = props => {
  return (
    <div>
      <div>{props.data.id}</div>
      <div>{props.data.title}</div>
      <div>{props.data.year}</div>
      <div>{props.data.genre}</div>
      <div>{props.data.runtime}</div>
      <div>{props.data.rating}</div>
    </div>
  );
};

export default MovieItem;
// id: 1,
// title: "Star Wars",
// year: 2000,
// genre: "Fantasy",
// runtime: 300,
// rating: 5.5
