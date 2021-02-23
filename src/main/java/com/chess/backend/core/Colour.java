package com.chess.backend.core;

public enum Colour {
    WHITE,
    BLACK,
    NONE;

    public static Colour getTurnFromState(String colourState) {
        return colourState.equals("w") ? WHITE : BLACK;
    }
}
