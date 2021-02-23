import React from "react";
import ReactDOM from "react-dom";
import "./index.css"

// represents on of the 64 squares on the board.
class Sqaure extends React.Component{

}

//represents the chess board
// should keep track of the pieces in different squares by having 64 square objects
// must interact with bussiness-logic to determine and display 
    // + valid moves
    // + board updates
class Board extends React.Component{

}

// Represents the entire game
// Board should be a child
class Game extends React.Component{

}

ReactDOM.render(
    <Game/>,
   document.getElementById("root")
);
