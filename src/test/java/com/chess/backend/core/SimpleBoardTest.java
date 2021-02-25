package com.chess.backend.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleBoardTest {

    @Test
    public void fenStringGeneratorTest() {
        String initialFenString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        String boardFenString = initialFenString.split(" ")[0];
        Board board = Board.generateBoardFromFenBoard(boardFenString);
        String resultantFen = board.generateFenString();
        Assertions.assertThat(resultantFen).isEqualTo(boardFenString);
    }
}
