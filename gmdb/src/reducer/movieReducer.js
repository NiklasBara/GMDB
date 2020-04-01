const initialState = { 
    movie: []
 };
const movieReducer = (state = initialState, action) => {
    switch (action.type) {
        case "FETCH_MOVIE_DATA":
            return {
                 ...state,
                movie: action.payload
                 }
        default: 
            return state
        
    }
} 
export default movieReducer;