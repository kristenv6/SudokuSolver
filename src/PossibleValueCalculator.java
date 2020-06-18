import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kristenviola on 1/3/20.
 */
public class PossibleValueCalculator {

    private SudokuBoard gameBoard;
    private ArrayList<Integer>[][] possibleValues;

    public PossibleValueCalculator(SudokuBoard inputBoard) {
        gameBoard = inputBoard;
        possibleValues = new ArrayList[9][9];
    }

    public ArrayList<Integer>[][] getPossibleValues() {
        initializeAllPossibleValues();
        narrowPossibleValues();
        return possibleValues;
    }

    private void initializeAllPossibleValues() {
        Integer[] allValsArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> allVals = new ArrayList(Arrays.asList(allValsArr));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                possibleValues[i][j] = new ArrayList(allVals);
            }
        }
    }

    private void narrowPossibleValues() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (gameBoard.getValueFromRowAndCol(i, j) == 0) {
                    ArrayList<Integer> currPossibleValues = possibleValues[i][j];
                    for (int x = 0; x < currPossibleValues.size(); x++) {
                        int possibleVal = currPossibleValues.get(x);
                        if (gameBoard.valueFitsInSpace(possibleVal, i, j) == false) {
                            currPossibleValues.remove((int) x);
                            x--;
                        }
                    }
                } else {
                    possibleValues[i][j] = new ArrayList<Integer>();
                    possibleValues[i][j].add(gameBoard.getValueFromRowAndCol(i, j));
                }
            }
        }
    }
}
