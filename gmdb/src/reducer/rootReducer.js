import { combineReducers } from "redux";
import movieReducer from "./movieReducer";
import singleMovieReducer from "./singleMovieReducer";
const rootReducer = combineReducers({
    movieReducer,singleMovieReducer
});

export default rootReducer;
