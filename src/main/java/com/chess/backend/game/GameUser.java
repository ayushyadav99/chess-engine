package com.chess.backend.game;

import com.chess.backend.core.Colour;
import com.chess.backend.core.Move;
import com.chess.backend.core.State;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class GameUser {
    ChessClock chessClock;
    Colour colour;

    public abstract Move makeMove(State state);
}
