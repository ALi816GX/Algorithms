package leetCode;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/15
 * @Time:17:02
 * @description: 给出一个二维字符数组和一个单词，判断单词是否在数组中出现，
 * 单词由相邻单元格的字母连接而成，相邻单元指的是上下左右相邻。同一单元格的字母不能多次使用。
 * 例如：
 * 给出的字符数组=
 * [↵  ["ABCE"],↵  ["SFCS"],↵  ["ADEE"]↵]
 * 单词 ="ABCCED", -> 返回 true,
 * 单词 ="SEE", ->返回 true,
 * 单词 ="ABCB", -> 返回 false.
 */
public class LC70 {
    public static void main(String[] args) {
        char[][] charList = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] charList = {{'A', 'A'}};
        LC70 lc70 = new LC70();
        System.out.println(lc70.exist(charList, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        char head = word.charAt(0);
        ArrayList<String> result = new ArrayList<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (head == board[x][y]) {
                    char[][] newBoard = deepClone(board);
                    newBoard[x][y] = ' ';
                    findRoute(result, newBoard, word, "" + head, 0, x, y);
                    if (!result.isEmpty()) {
                        return true;
                    } else {
                        result.clear();
                    }
                }
            }
        }
        return !result.isEmpty();
    }

    private void findRoute(ArrayList<String> result, char[][] board, String originalWord, String currentWord, int index, int rowIndex, int colIndex) {
        if (index == originalWord.length() - 1) {
            result.add(currentWord);
        } else {
            int maxCol = board[0].length;
            int maxRow = board.length;
            char currentChar = originalWord.charAt(index + 1);
            //right
            if (colIndex + 1 < maxCol && board[rowIndex][colIndex + 1] == currentChar) {
                char[][] newBoard = deepClone(board);
                newBoard[rowIndex][colIndex + 1] = ' ';
                findRoute(result, newBoard, originalWord, currentWord + currentChar, index + 1, rowIndex, colIndex + 1);
            }
            //down
            if (rowIndex + 1 < maxRow && board[rowIndex + 1][colIndex] == currentChar) {
                char[][] newBoard = deepClone(board);
                newBoard[rowIndex + 1][colIndex] = ' ';
                findRoute(result, newBoard, originalWord, currentWord + currentChar, index + 1, rowIndex + 1, colIndex);
            }
            //left
            if (colIndex - 1 >= 0 && board[rowIndex][colIndex - 1] == currentChar) {
                char[][] newBoard = deepClone(board);
                newBoard[rowIndex][colIndex - 1] = ' ';
                findRoute(result, newBoard, originalWord, currentWord + currentChar, index + 1, rowIndex, colIndex - 1);
            }
            //up
            if (rowIndex - 1 >= 0 && board[rowIndex - 1][colIndex] == currentChar) {
                char[][] newBoard = deepClone(board);
                newBoard[rowIndex - 1][colIndex] = ' ';
                findRoute(result, newBoard, originalWord, currentWord + currentChar, index + 1, rowIndex - 1, colIndex);

            }
        }
    }

    public char[][] deepClone(char[][] original) {
        char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone();
        }
        return result;
    }


    /**
     * public class Solution {
     *
     *     public boolean exist(char[][] board, String word) {
     *         int m = board.length;
     *         int n = board[0].length;
     *         boolean[][] visited = new boolean[m][n];
     *         for(int i = 0; i < m; i++){
     *             for(int j = 0; j < n; j++){
     *                 if(dfs(board, word, visited, i, j, m, n, 0))
     *                    return true;
     *             }
     *         }
     *         return false;
     *     }
     *
     *     private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int m, int n, int count){
     *         if(count == word.length()){
     *             return true;
     *         }
     *         if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(count))
     *             return false;
     *         if(visited[i][j])
     *             return false;
     *         visited[i][j] = true;
     *         boolean res = dfs(board, word, visited, i - 1, j, m, n, count + 1) ||
     *             dfs(board, word, visited, i + 1, j, m, n, count + 1) ||
     *             dfs(board, word, visited, i, j - 1, m, n, count + 1)||
     *             dfs(board, word, visited, i, j + 1, m, n, count + 1);
     *         visited[i][j] = false;
     *         return res;
     *     }
     * }
     */

}
