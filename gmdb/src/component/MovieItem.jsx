// import React from "react";


import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import MovieIcon from '@material-ui/icons/Movie';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import { Link } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    maxWidth: 345,
  },
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  expand: {
    transform: 'rotate(0deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    transform: 'rotate(180deg)',
  },
  avatar: {
    backgroundColor: red[500],
  },
}));




const MovieItem = props => {

  const classes = useStyles();

  const [expanded, setExpanded] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <Card className={classes.root}>
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.id}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.title}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.year}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.genre}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.runtime}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{props.data.rating}</Typography>
        <IconButton aria-label="Go to Details" component={Link} to={`/movie/details/${props.data.id}`}>
          <MovieIcon />
        </IconButton>
      </CardContent>
    </Card>
  );
};

export default MovieItem;
