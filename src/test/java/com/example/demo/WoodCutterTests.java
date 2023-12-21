package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WoodCutterTests {

  @Test
  void givenNoPieceReturnNoCuts() {
    List<Piece> pieces = new ArrayList<>();

    var cuts = WoodCutter.getCuts(pieces);
    Assertions.assertEquals(new ArrayList<>(), cuts);
  }

  @Test
  void givenCutOfEntireBoardReturnCut() {
    Piece piece = new Piece(12*4, 12*8);
    List<Piece> pieces = List.of(piece);

    var cuts = WoodCutter.getCuts(pieces);
    Assertions.assertEquals(List.of(new Cut(0, 0, piece)), cuts);
  }

  @Test
  void givenTooWideOfPieceThrowsException() {
    Piece piece = new Piece(13*4, 12*8);
    List<Piece> pieces = List.of(piece);

    Assertions.assertThrows(IllegalArgumentException.class, () -> WoodCutter.getCuts(pieces));
  }

  @Test
  void givenTooLongOfPieceThrowsException() {
    Piece piece = new Piece(12*4, 12*9);
    List<Piece> pieces = List.of(piece);

    Assertions.assertThrows(IllegalArgumentException.class, () -> WoodCutter.getCuts(pieces));
  }

  @Test
  void givenTwoPiecesReturnCuts() {
    Piece piece = new Piece(2*12,2*12);
    List<Piece> pieces = List.of(piece, piece);

    var cuts = WoodCutter.getCuts(pieces);
    Assertions.assertEquals(List.of(new Cut(0,0, piece), new Cut(0,2*12, piece)), cuts);
  }

  @Test
  void givenThreePiecesReturnCuts() {
    Piece piece = new Piece(2*12,2*12);
    List<Piece> pieces = List.of(piece, piece, piece);

    var cuts = WoodCutter.getCuts(pieces);
    Assertions.assertEquals(List.of(
            new Cut(0,0, piece),
            new Cut(0,2*12, piece),
            new Cut(2*12, 0, piece)),
        cuts);
  }

}
