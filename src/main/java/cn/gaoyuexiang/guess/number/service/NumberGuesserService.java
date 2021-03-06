package cn.gaoyuexiang.guess.number.service;

import java.util.Random;

public class NumberGuesserService {

  private int numberX;

  @Deprecated
  public NumberGuesserService() {}

  public NumberGuesserService(int start, int end) {
    this.numberX = new Random().nextInt(end - start + 1) + start;
  }

  @Deprecated
  public void buildNumberX() {
    this.numberX = new Random().nextInt(100) + 1;
  }

  int getNumberX() {
    return numberX;
  }

  void setNumberX(int numberX) {
    this.numberX = numberX;
  }

  public int compareGuessNumber(int guessedNumber) {
    if (guessedNumber > numberX) {
      return 1;
    } else if (guessedNumber == numberX) {
      return 0;
    } else {
      return -1;
    }
  }
}
