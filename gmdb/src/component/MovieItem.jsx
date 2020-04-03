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
  header: {

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
      <CardHeader className={classes.header} title={props.data.title} subheader={`Avg. Rating: ${props.data.rating}`} />
      <CardMedia
        className={classes.media}
        //   image={require("../img/Film1.jpg")}
        image={require(`../img/${props.data.title}.jpg`)}
        title="King Kong"
      />
      <CardContent>

        <Typography variant="body2" color="textSecondary" component="p">{`ID: ${props.data.id}`}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{`Release-Year: ${props.data.year}`}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{`Genre: ${props.data.genre}`}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">{`Runtime: ${props.data.runtime}`}</Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="Go to Details" component={Link} to={`/movie/details/${props.data.id}`}>
          <MovieIcon />
        </IconButton>
      </CardActions>
    </Card>
  );
};

export default MovieItem;
