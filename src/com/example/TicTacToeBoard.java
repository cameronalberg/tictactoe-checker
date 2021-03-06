package com.example;

import java.util.Locale;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  //set to fixed size until I can figure out how to assign it during creation
  private char[][] gameGrid;
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
    int boardPosition = 0;

    //check length of input string
    assert (Math.sqrt(board.length()) % 1 == 0 && board.length() > 8) : "Invalid Board Dimensions";
    boardLength = (int) Math.sqrt(board.length());
    gameGrid  = new char[boardLength][boardLength];
    board = board.toLowerCase();

    //check characters of string and add them to grid, counting Xs and Os
    for (int i = 0; i < boardLength; i++) {
      for (int j = 0; j < boardLength; j++) {
        if (board.charAt(boardPosition) == 'x') {
          gameGrid[i][j] = 'x';
          xCount++;
        } else if (board.charAt(boardPosition) == 'o') {
          gameGrid[i][j] = 'o';
          oCount++;
        }
        boardPosition++;
      }
    }

    //check for diagonals separately (only starting at top two corners)
    if (DiagonalCheck('x') > 0) {
      xWinCount += (DiagonalCheck('x'));
    }
    if (DiagonalCheck('o') > 0) {
      oWinCount += (DiagonalCheck('o'));
    }
    //check if X or O wins horizontally and vertically, track wins
    for (int i = 0; i < boardLength; i++)
    {
      for (int j = 0; j < boardLength; j++) {
        if ((i == 0 && j > 0) || (j == 0 && i > 0)) {
          if (HorizontalCheck(i, 'x') || VerticalCheck(i, 'x')) {
            xWinCount++;
          } else if (HorizontalCheck(i, 'o') || VerticalCheck(i, 'o')) {
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

  //checks characters diagonally, returns 0, 1 or 2 wins found
  private int DiagonalCheck(char player) {
    int winCount = 0;
    boolean diagRight = true;
    boolean diagLeft = true;

    for (int i = 0; i < boardLength - 1; i++) {
      if (gameGrid[i][i] != player || gameGrid[i][i] != gameGrid[i + 1][i + 1]) {
        diagRight = false;
      }
      if (gameGrid[i][boardLength - i - 1] != player || gameGrid[i][boardLength - i - 1] != gameGrid[i + 1][boardLength - i - 2]) {
        diagLeft = false;
      }
    }
    if (diagRight){
      winCount++;
    }
    if (diagLeft){
      winCount++;
    }
    return winCount;
  }
}
