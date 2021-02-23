package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    // 0-based indexed
    private Integer row;
    private Integer col;

    // Implement this in a better way in the future
    public String getChessSquare() {
        String colName = ((Character) (char) ('a' + col)).toString();
        String rowName = ((Integer)(row+1)).toString();
        return colName + rowName;
    }

    public static Position getPositionFromChessSquare(String chessSquare) {
        if(chessSquare.equals("-")) {
            return new Position(-1,-1);
        }
        Integer row = Integer.parseInt(chessSquare.substring(1))-1;
        Integer col = chessSquare.charAt(0) - 'a';
        return new Position(row, col);
    }

    public Integer getIndex() {
        return row * 8 + col;
    }

    public String generateFenString() {
        if(row == -1 && col == -1) {
            return "-";
        }
        else {
            return getChessSquare();
        }
    }
}
