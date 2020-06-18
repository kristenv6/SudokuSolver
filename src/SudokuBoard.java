/**
 * Created by kristenviola on 1/3/20.
 */
public class SudokuBoard {

    private int[][] _gameBoard;
    private ValueSpaceFitValidator _valueSpaceFitValidator;

    public SudokuBoard(int[][] inputBoard, ValueSpaceFitValidator valueSpaceFitValidator) {
        _gameBoard = inputBoard;
        _valueSpaceFitValidator = valueSpaceFitValidator;
    }

    public int getValueFromRowAndCol(int row, int col) {
        return _gameBoard[row][col];
    }

    public void setValueAtRowAndCol(int value, int row, int col) {
        _gameBoard[row][col] = value;
    }

    public boolean valueFitsInSpace(int value, int row, int col) {
        return _valueSpaceFitValidator.valueFitsInSpace(_gameBoard, value, row, col);
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardString += _gameBoard[i][j];
                if ((j + 1) % 3 == 0) {
                    boardString += "|";
                }
            }
            boardString += "\n";
            if ((i + 1) % 3 == 0) {
                boardString += "------------\n";
            }
        }

        return boardString;
    }

}
