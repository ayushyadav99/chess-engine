package com.chess.backend.core;

import java.util.List;

public abstract class Board {
    public abstract Piece getPiece(Position position);

    public abstract List<Piece> getAttackingPositions(Position position);

    // Using simple for now. Can be changed to bitboard in the future
    public static Board generateBoardFromFenBoard(String boardState) {
        return SimpleBoard.generateBoardFromFenBoard(boardState);
    }
}
