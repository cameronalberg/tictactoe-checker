package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testPartialBoardUnreachableState() {
    TicTacToeBoard board = new TicTacToeBoard("oO.xxXX..");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testFullBoardUnreachableState() {
    TicTacToeBoard board = new TicTacToeBoard("xOoxxXXxo");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testPartialBoardXWinsHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard(".xo.xo.x.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testPartialBoardXWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("xxx..o.Oo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testPartialBoardOWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("ooo..x.xX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testPartialBoardXWinsVerticalLeft() {
    TicTacToeBoard board = new TicTacToeBoard("xooXXOxox");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testNoWinnerEmptyBoardwithChars() {
    TicTacToeBoard board = new TicTacToeBoard("flasaksdl");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testInvalidBoardTooManyOs() {
    TicTacToeBoard board = new TicTacToeBoard("xox-o--o-");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardXWinsDiagRight() {
    TicTacToeBoard board = new TicTacToeBoard("x-o-xo--x");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsVerticalLeft() {
    TicTacToeBoard board = new TicTacToeBoard("x-oxxooxo");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWinsDiagLeft() {
    TicTacToeBoard board = new TicTacToeBoard("x-o-o-oxx");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testNoWinnerAllCorners() {
    TicTacToeBoard board = new TicTacToeBoard("x-o---o-x");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testXWinsHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard("-o-xxx-o-");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testNoWinnerWrongChars() {
    TicTacToeBoard board = new TicTacToeBoard("aaa-b--b-");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardLarger() {
    TicTacToeBoard board = new TicTacToeBoard("ox---ox--xo-x--o");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testNoWinnerEarlyGame() {
    TicTacToeBoard board = new TicTacToeBoard("ox-------");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardXwinsBothDiag() {
    TicTacToeBoard board = new TicTacToeBoard("xoxoxoxox");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

 /*
  * assertion error tests - should return assertion error: Invalid Board Dimensions
  @Test
  public void testInvalidBoardWrongNumChars() {
    TicTacToeBoard board = new TicTacToeBoard("aaaa-b--b-");
    board.evaluate();
  }

  @Test
  public void testInvalidBoardTooSmall() {
    TicTacToeBoard board = new TicTacToeBoard("xo-x");
    board.evaluate();
  }

  @Test
  public void testInvalidBoardEmptyBoard() {
    TicTacToeBoard board = new TicTacToeBoard("");
    board.evaluate();
  }

  */

}
