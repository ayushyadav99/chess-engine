package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
    // 0-based indexed
    private Integer row;
    private Integer col;

    // Implement this in a better way in the future
    String getChessSquare() {
        String colName = ((Character) (char) ('a' + col)).toString();
        String rowName = ((Integer)(row+1)).toString();
        return colName + rowName;
    }
}
