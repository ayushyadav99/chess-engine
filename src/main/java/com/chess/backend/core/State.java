package com.chess.backend.core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class State {
    private final Board board;
    private final Piece enPassantPawn;
    private final Turn turn;
    private final Integer halfMoveCounter;
    private final Integer fullMoveCounter;
    private final Map<Piece, List<Move>> validMoveForPieceMap;

    State(Board board, Piece enPassantPawn, Turn turn,
          Integer halfMoveCounter, Integer fullMoveCounter) {
        this.board = board;
        this.enPassantPawn = enPassantPawn;
        this.turn = turn;
        this.halfMoveCounter = halfMoveCounter;
        this.fullMoveCounter = fullMoveCounter;
        validMoveForPieceMap = computeAllValidMoves();
    }


    List<Move> getValidMoves(Piece piece) {
        return new ArrayList<Move>();
    }

    public Map<Piece, List<Move>> computeAllValidMoves() {
        return new HashMap<Piece, List<Move>>();
    }

    public State getNextState(Move move) {
        return this;
    }
}
