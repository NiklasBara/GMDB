import React,{useEffect} from "react";
import {fetchSingleMovieData} from "../action/fetchSingleMovieData";
import {connect} from "react-redux";

const SingleMovie = props => {
  let fetchData = {};
  useEffect(()=> {
    fetchData = props.fetchSingleMovieData(`http://localhost:8080/api/movies/${props.match.params.id}`);
  });
  return (
    <div>
      <div>{props.data.id}</div>
      <div>{props.data.title}</div>
      <div>{props.data.year}</div>
      <div>{props.data.genre}</div>
      <div>{props.data.runtime}</div>
      <div>{props.data.rating}</div>
      <div>
        {
        props.data.reviews.map(review => {
        return <div key={review.id}>{review.text}</div>
      })
      }</div>
    </div>
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