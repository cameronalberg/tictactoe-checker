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
  public void testFullBoardXWinsHorizontal() {
    TicTacToeBoard board = new TicTacToeBoard(".xo.xo.x.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testFullBoardXWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("xxx..o.Oo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testFullBoardOWinsVertical() {
    TicTacToeBoard board = new TicTacToeBoard("ooo..x.xX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

}
