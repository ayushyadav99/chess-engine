package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Castling {
    private Boolean whiteKingSide;
    private Boolean whiteQueenSide;
    private Boolean blackKingSide;
    private Boolean blackQueenSide;

    public static Castling getCastlingFromState(String castlingState) {
        Boolean whiteKingSide = castlingState.contains("K");
        Boolean whiteQueenSide = castlingState.contains("Q");
        Boolean blackKingSide = castlingState.contains("k");
        Boolean blackQueenSide = castlingState.contains("q");

        return new Castling(whiteKingSide, whiteQueenSide, blackKingSide, blackQueenSide);
    }
}
