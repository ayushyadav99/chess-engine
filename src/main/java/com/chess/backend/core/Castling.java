package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Castling {
    private Boolean whiteKingSide;
    private Boolean whiteQueenSide;
    private Boolean blackKingSide;
    private Boolean blackQueenSide;
    private Boolean tempDisableWhiteCastling;
    private Boolean tempDisableBlackCastling;

    public static Castling getCastlingFromState(String castlingState) {
        Boolean whiteKingSide = castlingState.contains("K");
        Boolean whiteQueenSide = castlingState.contains("Q");
        Boolean blackKingSide = castlingState.contains("k");
        Boolean blackQueenSide = castlingState.contains("q");

        return new Castling(whiteKingSide, whiteQueenSide, blackKingSide, blackQueenSide,
                false, false);
    }

    public Boolean getWhiteKingSide() {
        return whiteKingSide && !tempDisableWhiteCastling;
    }

    public Boolean getWhiteQueenSide() {
        return whiteQueenSide && !tempDisableBlackCastling;
    }

    public Boolean getBlackKingSide() {
        return blackKingSide && !tempDisableBlackCastling;
    }

    public Boolean getBlackQueenSide() {
        return blackQueenSide && !tempDisableBlackCastling;
    }

    public void updateCastling(Move move) {
        updateTempDisabledCastlingFlags(move);
    }

    public void updateTempDisabledCastlingFlags(Move move) {
        tempDisableBlackCastling = false;
        tempDisableWhiteCastling = false;

        if(move.getIsCheck()) {
            if(move.getColour().equals(Colour.WHITE)) {
                tempDisableBlackCastling = true;
            }
            else {
                tempDisableWhiteCastling = true;
            }
        }
    }
}
