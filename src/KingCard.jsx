import React, { useState } from "react";
import BasicCard from './BasicCard.jsx'
import RankCard from './RankCard.jsx'
import styled from 'styled-components'

const KingCard = (props) => {
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
    border: 1px solid black;
    width: 400px;
    margin-top: 60px;
`

export default KingCard; 