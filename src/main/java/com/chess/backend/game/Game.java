package com.chess.backend.game;

import com.chess.backend.core.Move;
import com.chess.backend.core.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Game {
    private final GameUser userWhite;
    private final GameUser userBlack;
    private final State currState;

    public void makeMove(GameUser userWhite, GameUser userBlack, State currState) {

    }

    public void updateState(Move move) {
        currState.updateState(move);
    }
}
