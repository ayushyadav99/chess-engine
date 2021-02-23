package com.chess.backend.game;

import com.chess.backend.core.Colour;
import com.chess.backend.core.Move;
import com.chess.backend.core.State;

public class ComputerUser extends GameUser{
    // Change to AI instance ID later
    Integer id;

    public ComputerUser(ChessClock chessClock, Colour colour) {
        super(chessClock, colour);
    }

    @Override
    public Move makeMove(State state) {
        return null;
    }
}
