package com.chess.backend.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    public void fenGeneratorTest1() {
        String fenString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        State state = State.generateStateFromFen(fenString);
        String finalFenString = state.generateFenString();
        Assertions.assertThat(finalFenString).isEqualTo(fenString);
    }

    @Test
    public void fenGeneratorTest2() {
        String fenString = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1";
        State state = State.generateStateFromFen(fenString);
        String finalFenString = state.generateFenString();
        Assertions.assertThat(finalFenString).isEqualTo(fenString);
    }

    @Test
    public void fenGeneratorTest3() {
        String fenString = "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2";
        State state = State.generateStateFromFen(fenString);
        String finalFenString = state.generateFenString();
        Assertions.assertThat(finalFenString).isEqualTo(fenString);
    }

    @Test
    public void fenGeneratorTest4() {
        String fenString = "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w Kq c6 0 2";
        State state = State.generateStateFromFen(fenString);
        String finalFenString = state.generateFenString();
        Assertions.assertThat(finalFenString).isEqualTo(fenString);
    }

    @Test
    public void fenGeneratorTest5() {
        String fenString = "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w - - 0 2";
        State state = State.generateStateFromFen(fenString);
        String finalFenString = state.generateFenString();
        Assertions.assertThat(finalFenString).isEqualTo(fenString);
    }
}
