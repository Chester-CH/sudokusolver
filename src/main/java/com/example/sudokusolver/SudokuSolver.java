package com.example.sudokusolver;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    private Set<Integer> number;

    public SudokuSolver() {
        number = new HashSet<Integer>();
        for (int i=1; i<=9; i++){
            number.add(i);
        }
    }

    public boolean checkRow(GameBoard board, int x) {
        Set<Integer> row = new HashSet<Integer>(number);
        for(int y=0;y<9;y++) {
            Integer index = board.get(y, x);
            if(index!=null) {
                if(!row.contains(index)) {
                    return false;
                }else {
                    row.remove(index);
                }
            }
        }
        return true;
    }

    public boolean checkAllRows(GameBoard board) {
        for(int x=0; x<9; x++) {
            if(!checkRow(board, x)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(GameBoard board, int y) {
        Set<Integer> column = new HashSet<Integer>(number);
        for(int x=0; x<9; x++) {
            Integer i = board.get(y, x);
            if(i != null) {
                if(!column.contains(i)) {
                    return false;
                }else {
                    column.remove(i);
                }
            }
        }
        return true;
    }

    public boolean checkAllColumns(GameBoard board) {
        for(int y=0; y<9; y++) {
            if(!checkColumn(board, y)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(GameBoard board, int yy, int xx) {
        Set<Integer> square = new HashSet<Integer>(number);
        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                Integer i = board.get(yy+y, xx+x);
                if(i!=null) {
                    if(!square.contains(i)) {
                        return false;
                    }else {
                        square.remove(i);
                    }
                }
            }
        }
        return true;
    }

    public boolean checkAllSquares(GameBoard board) {
        for(int x=0; x<9; x+=3) {
            for(int y=0; y<9; y+=3) {
                if(!checkSquare(board, y, x)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean finalCheck(GameBoard board) {
        return checkAllRows(board) && checkAllColumns(board) && checkAllSquares(board);
    }

    public boolean complete(GameBoard board) {
        for(int x=0; x<9; x++) {
            for(int y=0; y<9; y++) {
                if(board.get(y, x)==null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean completeCheck(GameBoard board) {
        return finalCheck(board) && complete(board);
    }

    GameBoard solve(GameBoard board) {
        if(!finalCheck(board)) {
            return null;
        }
        if(completeCheck(board)) {
            return board;
        }

        GameBoard temp = new GameBoard(board);
        for(int x=0; x<9; x++) {
            for(int y=0; y<9; y++) {
                Integer i = temp.get(y, x);
                if(i==null) {
                    Set<Integer> help = new HashSet<Integer>(number);
                    for(Integer num: help) {
                        temp.set(y, x, num);
                        GameBoard answer = solve(temp);
                        if(answer!=null) {
                            return answer;
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
