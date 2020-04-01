const initialState = {};

const singleMoviereducer = (state = initialState, action) => {
    switch (action.type) {
        case "FETCH_SINGLE_MOVIE_DATA":
            return action.payload           
        default: 
            return state
        
    }
}
export default singleMoviereducer;