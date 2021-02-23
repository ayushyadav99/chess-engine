package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Move {
    private final Piece startPiece;
    private final Position destPos;
}
