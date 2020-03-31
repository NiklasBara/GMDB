import React,{useEffect} from "react";
import MovieItem from "./MovieItem.jsx";
import {connect} from "react-redux";
import {fetchMovieData} from "../action/fetchMovieData";
const MovieOverview = (props) => {
let fetchData = [];
  useEffect(()=> {
   fetchData = props.fetchMovieData('http://localhost:8080/movie');
  }, []);

  return (
    <div>
      {props.movie.map(movie => (
        <div key={movie.id} data-testid="movie-item">
          <MovieItem data={movie} />
        </div>
      ))}
    </div>
  );
};
const mapStateToProps = state => {
  return {
    movie: state.movieReducer.movie,
  }
}

const mapDispatchToProps = {
  fetchMovieData
}

export default connect(mapStateToProps, mapDispatchToProps)(MovieOverview);
