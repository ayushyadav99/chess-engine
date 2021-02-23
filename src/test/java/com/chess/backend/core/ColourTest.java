package com.chess.backend.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColourTest {
    @Test
    public void getTurnFromStateTest() {
        Assertions.assertThat(Colour.WHITE)
                .isEqualByComparingTo(Colour.getTurnFromState("w"));
        Assertions.assertThat(Colour.BLACK)
                .isEqualByComparingTo(Colour.getTurnFromState("b"));
    }
}
