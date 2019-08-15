import React, { useState, useEffect } from "react";
import BasicCard from './BasicCard.jsx'
import RankCard from './RankCard.jsx'
import styled from 'styled-components'
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';

const KingCard = (props) => {
    const [first, setFirst] = useState({});
    const [second, setSecond] = useState({});
    const [third, setThird] = useState({});
    const [clicked, setClicked] = useState(false);
    
    const onClickHandler = () => {
        if (clicked) setClicked(false);
        else setClicked(true);
    }

    const define = () => {
        if (clicked) {
            return (<RankCard data={props.data} onClick = {onClickHandler}></RankCard>)
        }
        return (
        <BasicCard data={props.data[0]} onClick = {onClickHandler}></BasicCard>
        )
    }
    
    return (
        <DIV>
            {define()}
        </DIV>
    )
}

const DIV = styled.div`
    width: 300px;
    margin-top: 10px;
`

export default KingCard; 