package com.chess.backend.game;

import com.chess.backend.core.Move;
import com.chess.backend.core.State;

public class HumanGameUser extends GameUser{
    // Make it account later
    Integer id;

    public HumanGameUser(ChessClock chessClock) {
        super(chessClock);
    }

    @Override
    public Move makeMove(State state) {
        // Meh, remove later nulls bad
        return null;
    }
}
