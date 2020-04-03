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
import HeartIcon from '@material-ui/icons/Favorite';
import MovieIcon from '@material-ui/icons/Movie';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import { Link as RouterLink } from "react-router-dom";
import Link from '@material-ui/core/Link'

const useStyles = makeStyles((theme) => ({
  root: {
    // maxWidth: 600,
    // minWidth: 600,
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

const tryRequire = title => {
  try {
    return require(`../img/${title}.jpg`);
  } catch (err) {
    return require(`../img/placeholder.jpg`);
  }
}


const MovieItem = props => {

  const classes = useStyles();

  const [expanded, setExpanded] = useState(false);
  const [iconClicked, setIconClicked] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <Card className={classes.root}>
      <Link color='textPrimary' underline='none' component={RouterLink} to={`/movie/details/${props.data.id}`}>
        <CardHeader className={classes.header} title={props.data.title} subheader={`Avg. Rating: ${props.data.averageRating !== -1 ? props.data.averageRating : 'kein Rating vorhanden'}`} />
        <CardMedia
          className={classes.media}
          //   image={require("../img/Film1.jpg")}
          image={tryRequire(props.data.title)}
          title={props.data.title}
        />
        <CardContent>
          <Typography variant="body2" color="textSecondary" component="p">{`ID: ${props.data.id}`}</Typography>
          <Typography variant="body2" color="textSecondary" component="p">{`Release-Year: ${props.data.releaseYear}`}</Typography>
          <Typography variant="body2" color="textSecondary" component="p">{`Genre: ${props.data.genre}`}</Typography>
          <Typography variant="body2" color="textSecondary" component="p">{`Runtime: ${props.data.runtime} Minutes`}</Typography>
        </CardContent>
      </Link>
      <CardActions disableSpacing>
        <IconButton color={iconClicked ? "secondary" : "default"} onClick={() => setIconClicked(!iconClicked)} aria-label="Favorite" >
          <HeartIcon />
        </IconButton>
        <IconButton aria-label="Add to Watchlist" >
          <MovieIcon />
        </IconButton>
      </CardActions>
    </Card>
  );
};

export default MovieItem;
