import React from "react";
import {Link} from "react-router-dom";
const MovieItem = props => {
  return (
    <div>
      <div>{props.data.id}</div>
      <div>{props.data.title}</div>
      <div>{props.data.year}</div>
      <div>{props.data.genre}</div>
      <div>{props.data.runtime}</div>
      <div>{props.data.rating}</div>
      <Link to={`movie/details/${props.data.id}`}>Details...</Link>
    </div>
  );
};

export default MovieItem;
