package com.chess.backend.game;

import com.chess.backend.core.Colour;
import com.chess.backend.core.Move;
import com.chess.backend.core.State;

public class HumanGameUser extends GameUser{
    // Make it account later
    Integer id;

    public HumanGameUser(ChessClock chessClock, Colour colour) {
        super(chessClock, colour);
    }

    @Override
    public Move makeMove(State state) {
        // Meh, remove later nulls bad
        return null;
    }
}
