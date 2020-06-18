/**
 * Created by kristenviola on 6/12/19.
 */
import java.util.ArrayList;

public class SudokuSolver {

    private SudokuBoard _sudokuBoard;
    private ValueSpaceFitValidator _valueSpaceFitValidator;
    private PossibleValueCalculator _possibleValueCalculator;
    private ArrayList<Integer>[][] possibleValues = new ArrayList[9][9];

    public SudokuSolver(int[][] gameBoard) {
        _valueSpaceFitValidator = new ValueSpaceFitValidator();
        _sudokuBoard = new SudokuBoard(gameBoard, _valueSpaceFitValidator);
        _possibleValueCalculator = new PossibleValueCalculator(_sudokuBoard);
        possibleValues = _possibleValueCalculator.getPossibleValues();
    }

    public SudokuBoard solvePuzzle() {
        boolean solved = backTrackSearch();
        if(solved) {
            return _sudokuBoard;
        } else {
            return null;
        }
    }

    private boolean backTrackSearch() {
        //set a square to a val from its possible values
        //recalculate possible values
        //if next square has no possible values, backtrack
        int[] currSpace = firstOpenSpace();
        int i = currSpace[0];
        int j = currSpace[1];
        ArrayList<Integer> currPossibleValues = possibleValues[i][j];
        for(int possibleVal : currPossibleValues) {
            if(_sudokuBoard.valueFitsInSpace(possibleVal, i ,j)) {
                _sudokuBoard.setValueAtRowAndCol(possibleVal, i, j);
                boolean solved = isSolved() || backTrackSearch();
                if(solved) {
                    return true;
                }
            }
        }
        _sudokuBoard.setValueAtRowAndCol(0, i, j);
        return false;
    }

    private boolean isSolved() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(_sudokuBoard.getValueFromRowAndCol(i, j) == 0) return false;
            }
        }
        return true;
    }

    private int[] firstOpenSpace() {
        int[] openSpace = {-1,-1};
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(_sudokuBoard.getValueFromRowAndCol(i, j) == 0) {
                    openSpace[0] = i;
                    openSpace[1] = j;
                    return openSpace;
                }
            }
        }
        return openSpace;
    }

}
