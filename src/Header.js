import React, { useState, useEffect, useRef } from "react";
import styled, { createGlobalStyle } from "styled-components";

const Header = () => {
  return (
    <DIV>
      <img width="459" alt="imgNavyLogo@2x" src="https://user-images.githubusercontent.com/18614517/63075924-449da280-bf6e-11e9-8ff2-a9c033f245a6.png"></img>
    </DIV>
  );
}

const DIV = styled.div`
  height: 50px;
  text-align: center;
  font-weight: 800;
  font-size: 30px;
  line-height: 60px;
`


export default Header;
