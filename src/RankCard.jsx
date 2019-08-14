import React, { useState } from "react";
import { makeStyles } from '@material-ui/core/styles';
import CardActions from '@material-ui/core/CardActions';
import Button from '@material-ui/core/Button';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Divider from '@material-ui/core/Divider';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';

const useStyles = makeStyles(theme => ({
    root: {
      width: '100%',
      maxWidth: 360,
      backgroundColor: theme.palette.background.paper,
    },
    inline: {
      display: 'inline',
    },
  }));
  

const RankCard = (props) => {

    const classes = useStyles();

    const randomIdGenerator = () => {
        const randomId = Math.floor(Math.random() * 9999) + 1;
        return randomId;
      };
    
    const makeLiComponent = (datas) => {
        const arr = datas.map(data => {
            return (
                <div>
                <ListItem alignItems="flex-start">
                <ListItemAvatar>
                  <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
                </ListItemAvatar>
                <ListItemText
                  primary={data} key={randomIdGenerator()}
                />
              </ListItem>
              <Divider variant="inset" component="li" /> 
              </div>
            )
        })
        return arr;
    }

    return (
    <React.Fragment>
    <List>
    {makeLiComponent(props.data)}
    </List>
    <CardActions>
    <Button size="small" color="primary" onClick={props.onClick}>랭킹보기</Button>
    </CardActions>
    </React.Fragment>
    )
}

export default RankCard;