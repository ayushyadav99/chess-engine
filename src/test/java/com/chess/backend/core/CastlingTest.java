package com.chess.backend.game;

import com.chess.backend.core.Castling;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class CastlingTest {
    @Test
    public void getCastlingFromStateAllStatesTest() {
        Castling actualCastling = Castling.getCastlingFromState("KQkq");
        Castling expectedCastling = new Castling(true,true,
                true, true);
//        Assertions.assertThat(expectedCastling, actualCastling);
        Assertions.assertThat(actualCastling)
                .usingRecursiveComparison()
                .isEqualTo(expectedCastling);
    }

    @Test
    public void getCastlingFromStateQueenTest() {
        Castling actualCastling = Castling.getCastlingFromState("Qq");
        Castling expectedCastling = new Castling(false,true,
                false, true);
        Assertions.assertThat(actualCastling)
                .usingRecursiveComparison()
                .isEqualTo(expectedCastling);
    }

    @Test
    public void getCastlingFromStateNoTest() {
        Castling actualCastling = Castling.getCastlingFromState("-");
        Castling expectedCastling = new Castling(false, false,
                false, false);
        Assertions.assertThat(actualCastling)
                .usingRecursiveComparison()
                .isEqualTo(expectedCastling);
    }
}
