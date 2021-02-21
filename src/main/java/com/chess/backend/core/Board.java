package com.chess.backend.core;

import java.util.List;

public abstract class Board {
    public abstract Piece getPiece(Position position);

    public abstract List<Piece> getAttackingPositions(Position position);

    public abstract void generateBoardFromFen(String fen);
}
