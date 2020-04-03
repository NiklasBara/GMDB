const initialState = {
    movie: [],
    pending: false,
    timestamp: undefined,
};
const movieReducer = (state = initialState, action) => {
    switch (action.type) {
        case "FETCH_MOVIE_PENDING":
            return {
                ...state,
                pending: true,
                timestamp: action.timestamp
            }
        case "FETCH_MOVIE_DATA":
            return {
                ...state,
                movie: action.payload,
                pending: false,
            }
        default:
            return state

    }
}
export default movieReducer;