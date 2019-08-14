import React, { useState } from "react";
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';

const BasicCard = (props) => {
    return (
        <Card>
        <CardContent><h1>{props.data}</h1></CardContent>
        <CardActions>
            <Button size="small" color="primary" onClick={props.onClick}>랭킹보기</Button>
        </CardActions>
    </Card>
    )
}

export default BasicCard;