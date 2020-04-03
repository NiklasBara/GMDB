const fetchPending = (date) => {
    return (
        {
            type: 'FETCH_MOVIE_PENDING',
            timestamp: date,
        }
    );
}

const fetchData = (data) => {
    return (
        {
            type: "FETCH_MOVIE_DATA",
            payload: data,
        }
    );
}
const fetchMovieData = (apiUrl) => {
    const foo = (dispatch) => {
        const timestamp = Date.now();
        dispatch(fetchPending(timestamp));
        fetch(apiUrl)
            .then(res => res.json())
            .then(res => {
                if (res.error) {
                    throw res.error;
                }
                // setTimeout(() => dispatch(fetchData(res)), 200)
                dispatch(fetchData(res))
                return res;
            })
    };
    return foo;
}; 
export {fetchMovieData}