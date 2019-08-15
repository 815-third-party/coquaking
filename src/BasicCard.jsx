import React, { useState } from "react";
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import { makeStyles } from '@material-ui/core/styles';
import Avatar from '@material-ui/core/Avatar';
import Grid from '@material-ui/core/Grid';
import styled, { createGlobalStyle } from "styled-components";

const useStyles = makeStyles({
    avatar: {
      margin: 10,
    },
    bigAvatar: {
      margin: 10,
      width: 80,
      height: 80,
    },
  });

const BasicCard = (props) => {
    const [first, setFirst] = useState({})
    const classes = useStyles();
    console.log('BasicCard');
    return (
        <Card>
        <CardContent>
            <div>
            <H1 class="king-name">
            {props.data ? props.data.title : '무슨왕'}
            </H1>
            <IMG src="https://postfiles.pstatic.net/MjAxOTA4MTVfMTUx/MDAxNTY1ODUyODMyOTA4.YQg1bBDPwQ2tmnf9xnbHEMRgfoNK6rcRhJu56TfCsUgg.DzlL65T23PyvmbaXYMxdxGlk1Fps-D7VMzfO5Ft_fRUg.PNG.hrr11/imgCrown.png?type=w773"></IMG>
            <Grid container justify="center" alignItems="center">
      <Avatar alt="Remy Sharp" src={props.data? props.data.img : 'https://avatars3.githubusercontent.com/u/28622146?s=460&v=4'} className={classes.bigAvatar} />
    </Grid>
    <H3>{props.data ? props.data.name : 'loading'}</H3>
            </div>
        </CardContent>
        <CardActions>
            <Button size="small" color="primary" onClick={props.onClick}>랭킹보기</Button>
        </CardActions>
    </Card>
    )
}

const H1 = styled.h1`
    color: #424242;
    text-align: center;
`

const H3 = styled.h3`
    color: #424242; 
    text-align: center;
`

const IMG = styled.img`
    position: relative;
    left: 110px;
    top: 20px; 
    width: 60px;
    height: 60px;
`

export default BasicCard;