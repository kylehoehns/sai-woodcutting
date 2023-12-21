package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class WoodCutter {
  final static int BOARD_WIDTH = 12*4;
  final static int BOARD_LENGTH = 12*8;
  public static List<Cut> getCuts(List<Piece> pieces) {
    int lengthCoord = 0;
    int widthCoord = 0;

    List<Cut> cuts = new ArrayList<>();

    for (Piece piece : pieces) {
      if (piece.width() > BOARD_WIDTH || piece.length() > BOARD_LENGTH) throw new IllegalArgumentException();
      if (piece.width() + widthCoord > BOARD_WIDTH) {
        widthCoord = 0;
        lengthCoord = 2 * 12;
      }
      cuts.add(new Cut(lengthCoord, widthCoord, piece));
      widthCoord += piece.width();

    }

    return cuts;
  }
}
