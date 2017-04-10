package cn.gaoyuexiang.guess.number.service;

import java.util.Random;

public class NumberGuesserService {

  private int numberX;

  public void buildNumberX() {
    this.numberX = new Random().nextInt(100) + 1;
  }

  public int getNumberX() {
    return numberX;
  }

  public void setNumberX(int numberX) {
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
