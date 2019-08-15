import React, { useState, useEffect } from "react";
import Header from './Header';
import KingCard from './KingCard';
import PaperSheet from './PaperSheet';
import styled, { createGlobalStyle } from "styled-components";


function App() {
  const [mandam, setMandam] = useState([])
  const [emoji, setEmoji] = useState([])
  const [earlyBird, setEarlyBird] = useState([])
  const [soccer, setSoccer] = useState([])

  const fetchData = async (url) => {
    const response = await fetch(url);
    const jsonData = await response.json();

    const mandomData = jsonData[0];
    const emojiData = jsonData[1];
    
    const mandomArr = [
      {title: "투머치토커 ", name : mandomData.first.name, img : mandomData.first.thumbnail, id: mandomData.first.id},
      {title: "투머치토커 ", name : mandomData.second.name, img : mandomData.second.thumbnail, id: mandomData.second.id},
      {title: "투머치토커 ", name : mandomData.third.name, img : mandomData.third.thumbnail, id: mandomData.third.id},
    ]

    const emojiArr = [
      {title: "공감요정 ", name : emojiData.first.name, img : emojiData.first.thumbnail, id: emojiData.first.id},
      {title: "공감요정 ", name : emojiData.second.name, img : emojiData.second.thumbnail, id: emojiData.second.id},
      {title: "공감요정 ", name : emojiData.third.name, img : emojiData.third.thumbnail, id: emojiData.third.id},
    ]

    const earlyBirdArr = [
      {title: "바지런쟁이 ", name : 'Michelle', img : "https://avatars0.githubusercontent.com/u/18614517?s=460&v=4", id: 1},
      {title: "바지런쟁이 ", name : 'MINDY', img : "https://avatars2.githubusercontent.com/u/33537899?s=400&v=4", id: 2},
      {title: "바지런쟁이 ", name : 'andole', img : "https://avatars3.githubusercontent.com/u/40727649?s=400&v=4", id: 3},
    ]
    
    console.log(mandomArr);
    console.log(emojiArr);
    setMandam(mandomArr);
    setEmoji(emojiArr);
    setEarlyBird(earlyBirdArr);
  }
  

  useEffect(() => {
   fetchData("http://54.180.32.184/api/archives/");
  }, [])

  return (
    <React.Fragment>
    <GlobalStyle />
    <Header></Header>
    <DIV>
    <KingCard data={mandam}></KingCard>
    <KingCard data={emoji}></KingCard>
    </DIV>
    <DIV2>
    <PaperSheet></PaperSheet>
    </DIV2>
    <DIV>
    <KingCard data={earlyBird}></KingCard>
    </DIV>
    </React.Fragment>
  );
}

const DIV = styled.div`
  display: flex;
  justify-content: space-around;
`

const DIV2 = styled.div`
  background-color: #FFE57F;
  width: 100%;
  height: 60px;
  line-height: 60px;
  color: #424242;
  font-size: 20px;
  font-weight: 800;
`

const GlobalStyle = createGlobalStyle`
  body {
    background-color: #D6E7FC;
  }
`;

export default App;
