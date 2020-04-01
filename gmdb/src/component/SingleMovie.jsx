import React from "react";

const SingleMovie = props => {
  return (
    <div>
      <div>{props.data.id}</div>
      <div>{props.data.title}</div>
      <div>{props.data.year}</div>
      <div>{props.data.genre}</div>
      <div>{props.data.runtime}</div>
      <div>{props.data.rating}</div>
      <div>{}</div>
    </div>
  );
};

export default SingleMovie;