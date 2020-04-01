const fetchData = (data) => {
    return (
        {
            type: "FETCH_SINGLE_MOVIE_DATA",
            payload: data,
        }
    );
}
const fetchSingleMovieData= (apiUrl) => {
    const foo = (dispatch) => {
        fetch(apiUrl)
            .then(res => res.json())
            .then(res => {
                if (res.error) {
                    throw res.error;
                }
                dispatch(fetchData(res))
                return res;
            })
    };
    return foo;
}; 
export {fetchSingleMovieData}