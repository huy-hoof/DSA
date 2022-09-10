import java.util.HashSet;

public class ValidSodoku {
    public static void main(String... args) {
        ValidSodoku run = new ValidSodoku();

        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        // 0 - 2 3 - 5 6 - 8
        // 2

        // 3
        // 5

        // 6
        // 8

        boolean isValid = run.isValidSudoku(board);
        System.out.println(isValid);
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rowList = new HashSet[9];
        intializeArray(rowList);

        HashSet<Integer>[] colList = new HashSet[9];
        intializeArray(colList);

        HashSet<Integer>[][] sub3by3List = new HashSet[3][3];
        intializeArray(sub3by3List[0]);
        intializeArray(sub3by3List[1]);
        intializeArray(sub3by3List[2]);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    Integer digit = Integer.valueOf(board[i][j] + "");

                    if (isRepeatedDigit(rowList[i], digit)) {
                        return false;
                    }

                    if (isRepeatedDigit(colList[j], digit)) {
                        return false;
                    }

                    if (isRepeatedDigit(sub3by3List[i / 3][j / 3], digit)) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    public void intializeArray(HashSet[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new HashSet<>();
        }
    }

    public boolean isRepeatedDigit(HashSet set, Integer digit) {
        if (set.contains(digit)) {
            return true;
        } else {
            set.add(digit);
        }

        return false;
    }

}
