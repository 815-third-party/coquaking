import React, { useState, useEffect } from "react";
import Header from './Header';
import KingCard from './KingCard';
import styled, { createGlobalStyle } from "styled-components";


function App() {
  const [mandam, setMandam] = useState([])
  const [earlyBird, setEarlyBird] = useState([])
  const [emoji, setEmoji] = useState([])
  const [soccer, setSoccer] = useState([])

  useEffect(() => {
    setMandam(['michelle', "mindy", "andole"]);
    setEarlyBird(['mindy', "michelle", "andole"]);
    setEmoji(['andole', "mindy", "michelle"]);
    setSoccer(['saru', "mindy", "andole"]);
  }, [])

  return (
    <React.Fragment>
    <Header></Header>
    <DIV>
    <KingCard data={mandam}></KingCard>
    <KingCard data={earlyBird}></KingCard>
    </DIV>
    <DIV>
    <KingCard data={emoji}></KingCard>
    <KingCard data={soccer}></KingCard>
    </DIV>
    </React.Fragment>
  );
}

const DIV = styled.div`
  display: flex;
  justify-content: space-around;
`

export default App;
