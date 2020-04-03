import React, { useEffect } from "react";
import MovieItem from "./MovieItem.jsx";
import { connect } from "react-redux";
import { fetchMovieData } from "../action/fetchMovieData";
import s from "../styles/MovieOverview.module.css";
import { Container, Grid } from '@material-ui/core';


const MovieOverview = (props) => {
  let fetchData = [];
  useEffect(() => {
    fetchData = props.fetchMovieData('http://localhost:8080/api/movie');
  }, []);

  return (
    <Container maxWidth="xl">
      <Grid container spacing={5}>
        
          {
            props.movie.map(movie => (
              <Grid item xl={4} key={movie.id} data-testid="movie-item">
                <MovieItem data={movie} />
              </Grid>
            ))
          }
        
      </Grid>
    </Container >
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
