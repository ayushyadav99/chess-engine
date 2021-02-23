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

    public static SimpleBoard generateBoardFromFenBoard(String boardState,
                                                        Map<Character, PieceType> fenTypeMap) {
        List<String> fenRows = new ArrayList<String>(Arrays.asList(boardState.split("/")));
        Collections.reverse(fenRows);
        List<Piece> board = new ArrayList<Piece>();

        for(int i = 0;i < 8; i++) {
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
                for( ; val > 0; val--) {
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

    public String generateFenString() {
        Map<PieceType, Character> reverseFenMap = generateReverseFenMap();
        StringBuilder fenString = new StringBuilder();

        for(int i = 7;i >= 0; i--) {
            StringBuilder rowFenString = new StringBuilder();
            for(int j = 0; j < 8; j++) {
                int index = i * 8 + j;
                Piece piece = board.get(index);
                Character pieceChar = reverseFenMap.get(piece.getPieceType());
                if(piece.getColour().equals(Colour.BLACK)) {
                    pieceChar = Character.toLowerCase(pieceChar);
                }
                rowFenString.append(pieceChar);
            }
            String finalRowFenString = compressFenString(rowFenString.toString());
            fenString.append(finalRowFenString);

            if(i != 0) {
                fenString.append('/');
            }
        }

        return fenString.toString();
    }

    private Map<PieceType, Character> generateReverseFenMap() {
        Map<PieceType, Character> reverseFenMap = new HashMap<PieceType, Character>();
        reverseFenMap.put(PieceType.KING, 'K');
        reverseFenMap.put(PieceType.QUEEN, 'Q');
        reverseFenMap.put(PieceType.BISHOP, 'B');
        reverseFenMap.put(PieceType.KNIGHT, 'N');
        reverseFenMap.put(PieceType.PAWN, 'P');
        reverseFenMap.put(PieceType.ROOK, 'R');
        reverseFenMap.put(PieceType.NONE, 'O');
        return reverseFenMap;
    }

    private String compressFenString(String fenString) {
        StringBuilder compressedFenString = new StringBuilder();

        Integer spaceCounter = 0;
        for(Character c : fenString.toCharArray()) {
            if(c.equals('O')) {
                spaceCounter++;
            }
            else {
                if(spaceCounter != 0) {
                    compressedFenString.append(spaceCounter.toString());
                    spaceCounter = 0;
                }
                compressedFenString.append(c);
            }
        }

        if(spaceCounter != 0) {
            compressedFenString.append(spaceCounter.toString());
        }
        return compressedFenString.toString();
    }
}
