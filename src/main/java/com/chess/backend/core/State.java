package com.chess.backend.core;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class State {
    private Board board;
    private Colour colourToMove;
    private Castling castlingState;
    private Position enPassantPawnPosition;
    private Integer halfMoveCounter;
    private Integer fullMoveCounter;
    private Map<Piece, List<Move>> validMoveForPieceMap;

    State(Board board, Colour colourToMove, Castling castlingState,
          Position enPassantPawnPosition, Integer halfMoveCounter, Integer fullMoveCounter) {
        this.board = board;
        this.enPassantPawnPosition = enPassantPawnPosition;
        this.colourToMove = colourToMove;
        this.castlingState = castlingState;
        this.halfMoveCounter = halfMoveCounter;
        this.fullMoveCounter = fullMoveCounter;
        validMoveForPieceMap = computeAllValidMoves();
    }

    public static State generateStateFromFen(String fen) {
        List<String> states = new ArrayList<String>(Arrays.asList(fen.split(" ")));

        String boardState = states.get(0);
        String colourState = states.get(1);
        String castlingState = states.get(2);
        String enPassantState = states.get(3);
        String halfMoveState = states.get(4);
        String fullMoveState = states.get(5);

        Board board = Board.generateBoardFromFenBoard(boardState);
        Colour colour = Colour.getTurnFromState(colourState);
        Castling castling = Castling.getCastlingFromState(castlingState);
        Position position  = Position.getPositionFromChessSquare(enPassantState);
        Integer halfMoveCounter = Integer.parseInt(halfMoveState);
        Integer fullMoveCounter = Integer.parseInt(fullMoveState);

        return new State(board, colour, castling, position, halfMoveCounter, fullMoveCounter);
    }

    List<Move> getValidMoves(Piece piece) {
        return new ArrayList<Move>();
    }

    public Map<Piece, List<Move>> computeAllValidMoves() {
        return new HashMap<Piece, List<Move>>();
    }

    public void updateState(Move move) {

    }
}
