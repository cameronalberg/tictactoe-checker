package com.example;

import java.util.Locale;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  private char[][] grid = new char[3][3];
  private double board_length;
  private int xcount = 0;
  private int ocount = 0;
  private int xwins = 0;
  private int owins = 0;
  private char result = ' ';

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {

    //check length of input string
    board_length = Math.sqrt(board.length());
    assert board_length % 1 == 0 : "Invalid Board Dimensions";

    //check characters of string and add them to grid, counting Xs and Os
    int k = 0;
    for (int i = 0; i < board_length; i++) {
      for (int j = 0; j < board_length; j++) {
        if (board.charAt(k) == 'x' || board.charAt(k) == 'X') {
          grid[i][j] = 'x';
          xcount++;
        } else if (board.charAt(k) == 'o' || board.charAt(k) == 'O') {
          grid[i][j] = 'o';
          ocount++;
        }
        k++;
      }
    }

    //look at xcount and ocount to determine if board is valid
    if (xcount - ocount > 1 || ocount > xcount) {
      result = '0';
      return;
    }
    //check if X or O wins
    for (int i = 0; i < board_length; i++)
    {
      for (int j = 0; j < board_length; j++) {
        if ((i == 0 && j > 0) || (j == 0 && i > 0) || (i == 0 && j == 0)) {
          if (HorizontalCheck(i, j) == 'x' || VerticalCheck(i, j) == 'x' || DiagonalCheck(i, j) == 'x') {
            xwins++;
          }
          else if (HorizontalCheck(i, j) == 'o' || VerticalCheck(i, j) == 'o' || DiagonalCheck(i, j) == 'o') {
            owins++;
          }
        }
      }
    }
    if (owins > 0 && xwins == 0) {
      result = 'o';
    }
    else if (xwins > 0 && owins == 0) {
      result = 'x';
    }
  }

  private char HorizontalCheck(int row, int column) {
    char player_win = '0';
    for (int j = 0; j < board_length - 1; j++)
    {
      if (grid[row][j] != grid[row][j + 1]) {
         return player_win;
      }
    }
    player_win = grid[row][column];
    return player_win;
  }
  private char VerticalCheck(int row, int column) {
    char player_win = '0';
    for (int i = 0; i < board_length - 1; i++)
    {
      if (grid[i][column] != grid[i + 1][column]) {
        return player_win;
      }
    }
    player_win = grid[row][column];
    return player_win;
  }

  private char DiagonalCheck(int row, int column) {
    char player_win = '0';
    if (row == column) {
      for (int i = 0; i < board_length - 1; i++)
      {
        if (grid[row][column] != grid[row + 1][column + 1]) {
          return player_win;
        }
        column++;
        row++;
      }
      player_win = grid[row][column];
      return player_win;
    }
    else {
      return player_win;
    }
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    switch (result) {
      case '0': {
        return Evaluation.UnreachableState;
      }
      case 'x': {
        return Evaluation.Xwins;
      }
      case 'o': {
        return Evaluation.Owins;
      }
      default: {
        return Evaluation.NoWinner;
      }
    }
  }
}
