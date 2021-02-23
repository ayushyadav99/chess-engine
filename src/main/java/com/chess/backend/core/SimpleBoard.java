package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class SimpleBoard extends Board {
    ArrayList<Piece> board;

    @Override
    public Piece getPiece(Position position) {
        return new Piece();
    }

    @Override
    public List<Piece> getAttackingPositions(Position position) {
        return new ArrayList<Piece>();
    }

    public static SimpleBoard generateBoardFromFenBoard(String boardState) {
        return new SimpleBoard(new ArrayList<>());
    }
}
