// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

class Solution {
  public static void main (String[] args){
    char[][] board = new char[][]{
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };
    System.out.println(search(board, "ABCCED"));
    System.out.println(search(board, "SEEE"));
    System.out.println(search(board, "ABCB"));
  }

  public static boolean search(char[][] board, String word){
    // boolean [][] visited
    boolean [][] visited = new boolean[board.length][board[0].length];
      for (int i = 0; i < board.length; i++){
       for (int j = 0; j < board[0].length; j++){
         if (dfs (visited, board, word, 0, i, j) == true){
           return true;
         }
       }
      }
      return false;
  }

  public static boolean dfs(boolean[][] visited, char[][] board, String word, int index, int i, int j){
    if (index == word.length()){
      return true;
    }

    if( i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }
    boolean exist = false;
    if (visited[i][j] == false && board[i][j] == word.charAt(index)){
      visited[i][j] = true;
        exist = dfs(visited, board, word, index + 1, i , j - 1) ||
        dfs(visited, board, word, index + 1, i + 1, j) ||
        dfs(visited, board, word, index + 1, i, j + 1) ||
        dfs(visited, board, word, index + 1, i - 1, j);
    }
    visited[i][j] = false;

    return exist;

  }

}
