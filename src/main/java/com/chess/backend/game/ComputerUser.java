package com.chess.backend.game;

import com.chess.backend.core.Move;
import com.chess.backend.core.State;

public class ComputerUser extends GameUser{
    // Change to AI instance ID later
    Integer id;

    public ComputerUser(ChessClock chessClock) {
        super(chessClock);
    }

    @Override
    public Move makeMove(State state) {
        return null;
    }
}
