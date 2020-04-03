import React, { useEffect } from "react";
import { fetchSingleMovieData } from "../action/fetchSingleMovieData";
import { connect } from "react-redux";
import MovieItem from "./MovieItem";
import Box from '@material-ui/core/Box';
const SingleMovie = props => {
  let fetchData = {};
  useEffect(() => {
    fetchData = props.fetchSingleMovieData(`http://localhost:8080/api/movie/${props.match.params.id}`);
  }, []);
  return (
    <Box mt={5} ml="25%" mr="25%">
      <MovieItem data={props.data} />
      <div>
        {
          props.data.reviews.map(review => {
            return <div key={review.id}>{review.text}</div>
          })
        }</div>
    </Box>

  );
};
const mapStateToProps = state => {
  return {
    data: state.singleMovieReducer
  }
}

const mapDispatchToProps = {
  fetchSingleMovieData
}

export default connect(mapStateToProps, mapDispatchToProps)(SingleMovie);