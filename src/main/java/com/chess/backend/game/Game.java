package com.chess.backend.game;

import com.chess.backend.core.Move;
import com.chess.backend.core.State;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private final GameUser userWhite;
    private final GameUser userBlack;
    private final List<State> states;

    public Game(GameUser userWhite, GameUser userBlack, State currState) {
        this.userWhite = userWhite;
        this.userBlack = userBlack;
        states = new ArrayList<State>(List.of(currState));
    }

    public void makeMove(GameUser userWhite, GameUser userBlack, State currState) {

    }

    // Make this function better, for now it should never give an error
    public State getCurrentState() {
        return states.get(states.size()-1);
    }

    public void updateState(Move move) {
        State state = getCurrentState();
        states.add(state.getNewUpdatedState(move));
    }
}
