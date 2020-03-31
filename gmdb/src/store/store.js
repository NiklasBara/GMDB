import { createStore, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import rootReducer from "./../reducer/rootReducer";

// TODO:  Create your redux store, apply thunk as a middleware, and export it!
const store = createStore(rootReducer, applyMiddleware(thunk));

export default store;
