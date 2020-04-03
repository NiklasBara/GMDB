import React, { useEffect } from "react";
import MovieItem from "./MovieItem.jsx";
import { connect } from "react-redux";
import { fetchMovieData } from "../action/fetchMovieData";
import s from "../styles/MovieOverview.module.css";
import { Container, Grid } from '@material-ui/core';
import Box from '@material-ui/core/Box';
import { CircularProgress } from '@material-ui/core';

const MovieOverview = (props) => {
  let fetchData = [];
  useEffect(() => {
    fetchData = props.fetchMovieData('http://localhost:8080/api/movie');
  }, []);

  const theme = {
    spacing: 5,
  }

  if (props.pending) {
    return (
      <Box mt={15} display="flex" flexDirection="column" alignItems="center" justifyContent="center" >

        <CircularProgress size="200px" />
        <Box mt={10} >
          Loading Movies...
            </Box>
      </Box >
    )
  } else {

    return (
      <Box mt={5}>
        <Container maxWidth="xl" >
          <Grid container spacing={5}>
            {
              props.movie.map(movie => (
                <Grid item lg={3} md={4} sm={6} xs={12} key={movie.id} data-testid="movie-item" >
                  <MovieItem data={movie} />
                </Grid>
              ))
            }
          </Grid>
        </Container >
      </Box >
    );
  }

};
const mapStateToProps = state => {
  return {
    movie: state.movieReducer.movie,
    pending: state.movieReducer.pending,
  }
}

const mapDispatchToProps = {
  fetchMovieData
}

export default connect(mapStateToProps, mapDispatchToProps)(MovieOverview);
