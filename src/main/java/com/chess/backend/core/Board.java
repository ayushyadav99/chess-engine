package com.chess.backend.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    public abstract Piece getPiece(Position position);

    public abstract List<Piece> getAttackingPositions(Position position);

    public abstract String generateFen();

    // Using simple for now. Can be changed to bitboard in the future
    public static Board generateBoardFromFenBoard(String boardState) {
        Map<Character, PieceType> fenTypeMap = new HashMap<Character, PieceType>();

        fenTypeMap.put('K', PieceType.KING);
        fenTypeMap.put('Q', PieceType.QUEEN);
        fenTypeMap.put('B', PieceType.BISHOP);
        fenTypeMap.put('N', PieceType.KNIGHT);
        fenTypeMap.put('P', PieceType.PAWN);
        fenTypeMap.put('R', PieceType.ROOK);

        return SimpleBoard.generateBoardFromFenBoard(boardState, fenTypeMap);
    }
}
