package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Move {
    private final Piece startPiece;
    private final Position destPos;
    private final Turn turn;
}
