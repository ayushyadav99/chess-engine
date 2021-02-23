package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Piece {
    private PieceType pieceType;
    private Position position; // Is this needed?
    private Colour colour;
}
