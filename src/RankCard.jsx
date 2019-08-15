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

import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';

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

    const makeLiComponent = (datas) => {
        const arr = datas.map(data => {
            return (
            <Card>
                <CardContent>
                <ListItem alignItems="flex-start">
                <ListItemAvatar>
                  <Avatar alt="Remy Sharp" src={data.img} />
                </ListItemAvatar>
                <ListItemText
                  primary={data.name} key={data.id}
                />
              </ListItem>
              </CardContent>
              </Card>
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