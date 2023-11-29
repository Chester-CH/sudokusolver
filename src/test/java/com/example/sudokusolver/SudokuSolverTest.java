package com.example.sudokusolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuSolverTest {
    @Test
    void testCheckRow() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 1);
        assertTrue(solver.checkRow(board, 0)); //should be valid, there is only one num1 in the row

        board.set(0, 1, 2);
        board.set(1, 1, 2);
        assertTrue(!solver.checkRow(board, 1));
    }

    @Test
    void testCheckColumn() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 9);
        assertTrue(solver.checkColumn(board, 0));

        board.set(1, 0, 9);
        board.set(1, 1, 9);
        assertTrue(!solver.checkColumn(board, 1));
    }

    @Test
    void testCheckSquare() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 9);
        assertTrue(solver.checkSquare(board, 0, 0));

        board.set(1, 1, 9);
        assertTrue(!solver.checkSquare(board, 0, 0));
    }

    @Test
    void testCheckAllRows() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 6);
        board.set(1, 1, 6);
        board.set(2, 2, 6);
        board.set(3, 3, 6);
        board.set(4, 4, 6);
        board.set(5, 5, 6);
        board.set(6, 6, 6);
        board.set(7, 7, 6);
        board.set(8, 8, 6);
        assertTrue(solver.checkAllRows(board));

        board.set(7, 8, 6);
        assertTrue(!solver.checkAllRows(board));
    }

    @Test
    void testCheckAllColumns() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 6);
        board.set(1, 1, 6);
        board.set(2, 2, 6);
        board.set(3, 3, 6);
        board.set(4, 4, 6);
        board.set(5, 5, 6);
        board.set(6, 6, 6);
        board.set(7, 7, 6);
        board.set(8, 8, 6);
        assertTrue(solver.checkAllColumns(board));

        board.set(8, 7, 6);
        assertTrue(!solver.checkAllColumns(board));
    }

    @Test
    void testCheckAllSquares() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 6);
        board.set(3, 0, 6);
        board.set(6, 0, 6);
        board.set(0, 3, 6);
        board.set(3, 3, 6);
        board.set(6, 3, 6);
        board.set(0, 6, 6);
        board.set(3, 6, 6);
        board.set(6, 6, 6);
        assertTrue(solver.checkAllSquares(board));

        board.set(8, 8, 6);
        assertTrue(!solver.checkAllSquares(board));
    }

    @Test
    void testcompleteCheck() {
        /*
         * https://dingo.sbs.arizona.edu/~sandiway/sudoku/examples.html
         * using the last board in the test
         *
         * 1 2 6 4 3 7 9 5 8
         * 8 9 5 6 2 1 4 7 3
         * 3 7 4 9 8 5 1 2 6
         * 4 5 7 1 9 3 8 6 2
         * 9 8 3 2 4 6 5 1 7
         * 6 1 2 5 7 8 3 9 4
         * 2 6 9 3 1 4 7 8 5
         * 5 4 8 7 6 9 2 3 1
         * 7 3 1 8 5 2 6 4 9
         */
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 1);
        board.set(1, 0, 2);
        board.set(2, 0, 6);
        board.set(3, 0, 4);
        board.set(4, 0, 3);
        board.set(5, 0, 7);
        board.set(6, 0, 9);
        board.set(7, 0, 5);
        board.set(8, 0, 8);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 1, 8);
        board.set(1, 1, 9);
        board.set(2, 1, 5);
        board.set(3, 1, 6);
        board.set(4, 1, 2);
        board.set(5, 1, 1);
        board.set(6, 1, 4);
        board.set(7, 1, 7);
        board.set(8, 1, 3);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 2, 3);
        board.set(1, 2, 7);
        board.set(2, 2, 4);
        board.set(3, 2, 9);
        board.set(4, 2, 8);
        board.set(5, 2, 5);
        board.set(6, 2, 1);
        board.set(7, 2, 2);
        board.set(8, 2, 6);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 3, 4);
        board.set(1, 3, 5);
        board.set(2, 3, 7);
        board.set(3, 3, 1);
        board.set(4, 3, 9);
        board.set(5, 3, 3);
        board.set(6, 3, 8);
        board.set(7, 3, 6);
        board.set(8, 3, 2);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 4, 9);
        board.set(1, 4, 8);
        board.set(2, 4, 3);
        board.set(3, 4, 2);
        board.set(4, 4, 4);
        board.set(5, 4, 6);
        board.set(6, 4, 5);
        board.set(7, 4, 1);
        board.set(8, 4, 7);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 5, 6);
        board.set(1, 5, 1);
        board.set(2, 5, 2);
        board.set(3, 5, 5);
        board.set(4, 5, 7);
        board.set(5, 5, 8);
        board.set(6, 5, 3);
        board.set(7, 5, 9);
        board.set(8, 5, 4);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 6, 2);
        board.set(1, 6, 6);
        board.set(2, 6, 9);
        board.set(3, 6, 3);
        board.set(4, 6, 1);
        board.set(5, 6, 4);
        board.set(6, 6, 7);
        board.set(7, 6, 8);
        board.set(8, 6, 5);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 7, 5);
        board.set(1, 7, 4);
        board.set(2, 7, 8);
        board.set(3, 7, 7);
        board.set(4, 7, 6);
        board.set(5, 7, 9);
        board.set(6, 7, 2);
        board.set(7, 7, 3);
        board.set(8, 7, 1);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 8, 7);
        board.set(1, 8, 3);
        board.set(2, 8, 1);
        board.set(3, 8, 8);
        board.set(4, 8, 5);
        board.set(5, 8, 2);
        board.set(6, 8, 6);
        board.set(7, 8, 4);
        board.set(8, 8, 9);
        assertTrue(solver.finalCheck(board));
        assertTrue(solver.completeCheck(board));
    }

    @Test
    void testSolve() {
        SudokuSolver solver = new SudokuSolver();
        GameBoard board = new GameBoard();
        board.set(0, 0, 1);
        board.set(1, 0, 2);
        board.set(2, 0, 6);
        board.set(3, 0, 4);
        board.set(4, 0, 3);
        board.set(5, 0, 7);
        board.set(6, 0, 9);
        board.set(7, 0, 5);
        board.set(8, 0, 8);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 1, 8);
        board.set(1, 1, 9);
        board.set(2, 1, 5);
        board.set(3, 1, 6);
        board.set(4, 1, 2);
        board.set(5, 1, 1);
        board.set(6, 1, 4);
        board.set(7, 1, 7);
        board.set(8, 1, 3);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 2, 3);
        board.set(1, 2, 7);
        board.set(2, 2, 4);
        board.set(3, 2, 9);
        board.set(4, 2, 8);
        board.set(5, 2, 5);
        board.set(6, 2, 1);
        board.set(7, 2, 2);
        board.set(8, 2, 6);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 3, 4);
        board.set(1, 3, 5);
        board.set(2, 3, 7);
        board.set(3, 3, 1);
        board.set(4, 3, 9);
        board.set(5, 3, 3);
        board.set(6, 3, 8);
        board.set(7, 3, 6);
        board.set(8, 3, 2);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 4, 9);
        board.set(1, 4, 8);
        board.set(2, 4, 3);
        board.set(3, 4, 2);
        board.set(4, 4, 4);
        board.set(5, 4, 6);
        board.set(6, 4, 5);
        board.set(7, 4, 1);
        board.set(8, 4, 7);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 5, 6);
        board.set(1, 5, 1);
        board.set(2, 5, 2);
        board.set(3, 5, 5);
        board.set(4, 5, 7);
        board.set(5, 5, 8);
        board.set(6, 5, 3);
        board.set(7, 5, 9);
        board.set(8, 5, 4);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 6, 2);
        board.set(1, 6, 6);
        board.set(2, 6, 9);
        board.set(3, 6, 3);
        board.set(4, 6, 1);
        board.set(5, 6, 4);
        board.set(6, 6, 7);
        board.set(7, 6, 8);
        board.set(8, 6, 5);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 7, 5);
        board.set(1, 7, 4);
        board.set(2, 7, 8);
        board.set(3, 7, 7);
        board.set(4, 7, 6);
        board.set(5, 7, 9);
        board.set(6, 7, 2);
        board.set(7, 7, 3);
        board.set(8, 7, 1);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        board.set(0, 8, 7);
        board.set(1, 8, 3);
        board.set(2, 8, 1);
        board.set(3, 8, 8);
        board.set(4, 8, 5);
        board.set(5, 8, 2);
        board.set(6, 8, 6);
        board.set(7, 8, 4);
        //board.set(8, 8, 9);
        assertTrue(solver.finalCheck(board));
        assertTrue(!solver.completeCheck(board));

        GameBoard help = solver.solve(board);
        assertTrue(help.get(8, 8) == 9);
    }
}
