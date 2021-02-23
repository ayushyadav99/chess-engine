package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class SimpleBoard extends Board {
    List<Piece> board;

    @Override
    public Piece getPiece(Position position) {
        return board.get(position.getIndex());
    }

    @Override
    public List<Piece> getAttackingPositions(Position position) {
        return new ArrayList<Piece>();
    }

    public static SimpleBoard generateBoardFromFenBoard(String boardState) {
        List<String> fenRows = new ArrayList<String>(Arrays.asList(boardState.split("/")));
        Collections.reverse(fenRows);
        List<Piece> board = new ArrayList<Piece>();

        for(int i=0;i<8;i++) {
            String row = fenRows.get(i);
            addFenRowsToBoard(row, i, board);
        }

        return new SimpleBoard(board);
    }

    private static void addFenRowsToBoard(String fenRow, Integer row, List<Piece> board) {
        Integer col = 0;
        for(Character c : fenRow.toCharArray()) {
            if(Character.isDigit(c)) {
                int val =  Integer.parseInt(c.toString());
                for(; val > 0; val--) {
                    board.add(new Piece(new Position(row, col)));
                    col++;
                }
            }
            else {
                addPieceToBoard(c, row, col, board);
                col++;
            }
        }
    }

    private static void addPieceToBoard(Character piece, Integer row, Integer col, List<Piece> board) {
        Position currentPosition = new Position(row, col);
        switch(piece) {
            case 'K':
                board.add(new Piece(PieceType.KING, currentPosition, Colour.WHITE));
                break;
            case 'k':
                board.add(new Piece(PieceType.KING, currentPosition, Colour.BLACK));
                break;
            case 'Q':
                board.add(new Piece(PieceType.QUEEN, currentPosition, Colour.WHITE));
                break;
            case 'q':
                board.add(new Piece(PieceType.QUEEN, currentPosition, Colour.BLACK));
                break;
            case 'B':
                board.add(new Piece(PieceType.BISHOP, currentPosition, Colour.WHITE));
                break;
            case 'b':
                board.add(new Piece(PieceType.BISHOP, currentPosition, Colour.BLACK));
                break;
            case 'R':
                board.add(new Piece(PieceType.ROOK, currentPosition, Colour.WHITE));
                break;
            case 'r':
                board.add(new Piece(PieceType.ROOK, currentPosition, Colour.BLACK));
                break;
            case 'N':
                board.add(new Piece(PieceType.KNIGHT, currentPosition, Colour.WHITE));
                break;
            case 'n':
                board.add(new Piece(PieceType.KNIGHT, currentPosition, Colour.BLACK));
                break;
            case 'P':
                board.add(new Piece(PieceType.PAWN, currentPosition, Colour.WHITE));
                break;
            case 'p':
                board.add(new Piece(PieceType.PAWN, currentPosition, Colour.BLACK));
                break;
            default:
                break;
        }
    }
}
