import React from "react";
import MovieItem from "./MovieItem.jsx";
const MovieOverview = ({ data }) => {
  return (
    <div>
      {data.map(movie => (
        <div key={movie.id} data-testid="movie-item">
          <MovieItem data={movie} />
        </div>
      ))}
    </div>
  );
};
export default MovieOverview;
