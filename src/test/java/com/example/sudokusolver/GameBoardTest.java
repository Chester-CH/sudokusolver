package com.example.sudokusolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameBoardTest {


    @Test
    void testGameBoard() {
        GameBoard board = new GameBoard();
    }

    @Test
    void testGameBoardGameBoard() {
        GameBoard board = new GameBoard();
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                board.set(y,x,2);
            }
        }
        GameBoard b1 = new GameBoard(board);
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                assertTrue(b1.get(y, x)==2);
            }
        }
    }

    @Test
    void testGet() {
        GameBoard board = new GameBoard();
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                assertTrue(board.get(0, 0)==null);
            }
        }
    }

    @Test
    void testSet() {
        GameBoard board = new GameBoard();
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                board.set(y,x,9);
            }
        }
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                assertTrue(board.get(y, x)==9);
            }
        }
    }

}