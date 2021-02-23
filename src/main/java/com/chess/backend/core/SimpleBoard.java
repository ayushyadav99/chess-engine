package com.chess.backend.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

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

    public static SimpleBoard generateBoardFromFenBoard(String boardState, Map<Character, PieceType> fenTypeMap) {
        List<String> fenRows = new ArrayList<String>(Arrays.asList(boardState.split("/")));
        Collections.reverse(fenRows);
        List<Piece> board = new ArrayList<Piece>();

        for(int i=0;i<8;i++) {
            String row = fenRows.get(i);
            addFenRowsToBoard(row, i, board, fenTypeMap);
        }

        return new SimpleBoard(board);
    }

    private static void addFenRowsToBoard(String fenRow, Integer row, List<Piece> board,
                                          Map<Character, PieceType> fenTypeMap) {
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
                addPieceToBoard(c, row, col, board, fenTypeMap);
                col++;
            }
        }
    }

    private static void addPieceToBoard(Character piece, Integer row, Integer col, List<Piece> board,
                                        Map<Character, PieceType> fenTypeMap) {

        Position currentPosition = new Position(row, col);
        PieceType pieceType = fenTypeMap.get(Character.toUpperCase(piece));
        Colour colour = Character.isUpperCase(piece) ? Colour.WHITE : Colour.BLACK;

        board.add(new Piece(pieceType, currentPosition, colour));
    }
}
