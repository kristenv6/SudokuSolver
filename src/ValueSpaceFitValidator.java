/**
 * Created by kristenviola on 1/3/20.
 */
public final class ValueSpaceFitValidator {

    public ValueSpaceFitValidator() {}

    public static boolean valueFitsInSpace(int[][] currBoard, int value, int row, int col) {
        boolean rowConflict = isValuePresentInRow(currBoard, value, row);
        boolean colConflict = isValuePresentInCol(currBoard, value, col);
        boolean squareConflict = isValuePresentinSquare(currBoard, value, row, col);
        return (rowConflict || colConflict || squareConflict) == false;
    }


    private static boolean isValuePresentInCol(int[][] currBoard, int value, int colNum) {
        for(int i = 0; i < 9; i++) {
            if(currBoard[i][colNum] == value) {
                return true;
            }
        }
        return false;
    }


    private static boolean isValuePresentInRow(int[][] currBoard, int value, int rowNum) {
        for(int j = 0; j < 9; j++) {
            if(currBoard[rowNum][j] == value) {
                return true;
            }
        }
        return false;
    }


    private static boolean isValuePresentinSquare(int[][] currBoard, int value, int rowNum, int colNum) {
        int squareNum = ((rowNum / 3) * 3) + (colNum / 3);
        int rowStart = (squareNum / 3) * 3;
        int colStart = (squareNum % 3) * 3;
        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(currBoard[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
