package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  //set to fixed size until I can figure out how to assign it during creation
  private char[][] gameGrid = new char[3][3];
  private int boardLength;

  //initialize variables to track characters and # of completed rows
  private int xCount = 0;
  private int oCount = 0;
  private int xWinCount = 0;
  private int oWinCount = 0;

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {

    //check length of input string
    assert (Math.sqrt(board.length()) % 1 == 0 && board.length() > 8) : "Invalid Board Dimensions";
    boardLength = (int) Math.sqrt(board.length());

    //check characters of string and add them to grid, counting Xs and Os
    for (int i = 0; i < boardLength; i++) {
      for (int j = 0; j < boardLength; j++) {
        if (board.charAt(i + j) == 'x') {
          gameGrid[i][j] = 'x';
          xCount++;
        } else if (board.charAt((i + j)) == 'o') {
          gameGrid[i][j] = 'o';
          oCount++;
        }
      }
    }

    //check if X or O wins, track wins
    for (int i = 0; i < boardLength; i++)
    {
      for (int j = 0; j < boardLength; j++) {
        if ((i == 0 && j > 0) || (j == 0 && i > 0) || (i == 0 && j == 0)) {
          if (HorizontalCheck(i, 'x') || VerticalCheck(i, 'x') || DiagonalCheck('x')) {
            xWinCount++;
          }
          else if (HorizontalCheck(i, 'o') || VerticalCheck(i, 'o')|| DiagonalCheck('o')) {
            oWinCount++;
          }
        }
      }
    }
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {

    //look at xCount and oCount to determine if board is valid
    if (xCount - oCount > 1 || oCount > xCount) {
      return Evaluation.UnreachableState;
    } else if (oWinCount == 0 && xWinCount == 0) {
      return Evaluation.NoWinner;
    } else if (oWinCount > 0 && xWinCount == 0) {
      return Evaluation.Owins;
    } else if (xWinCount > 0 && oWinCount == 0) {
      return Evaluation.Xwins;
    } else {
      return Evaluation.UnreachableState;
    }
  }

  //checks characters horizontally, matching to starting character
  private boolean HorizontalCheck(int row, char player) {
    for (int j = 0; j < boardLength - 1; j++) {
      if (gameGrid[row][j] != player || gameGrid[row][j] != gameGrid[row][j + 1]) {
        return false;
      }
    }
    return true;
  }

  //checks characters vertically, matching to starting character
  private boolean VerticalCheck(int column, char player) {
    for (int i = 0; i < boardLength - 1; i++)
    {
      if (gameGrid[i][column] != player || gameGrid[i][column] != gameGrid[i + 1][column]) {
        return false;
      }
    }
    return true;
  }

  //checks characters diagonally, matching to starting character
  private boolean DiagonalCheck(char player) {
    for (int i = 0; i < boardLength - 1; i++)
    {
      if (gameGrid[i][i] != player || gameGrid[i][i] != gameGrid[i + 1][i + 1]) {
        return false;
      }
    }
    return true;
  }
}
