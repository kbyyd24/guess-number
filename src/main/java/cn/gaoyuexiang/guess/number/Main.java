package cn.gaoyuexiang.guess.number;

import cn.gaoyuexiang.guess.number.service.NumberGuesserService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner consoleScanner = new Scanner(System.in);
    System.out.println("Please input your number:");
    int count = 0;
    NumberGuesserService guesserService = new NumberGuesserService();
    guesserService.buildNumberX();
    while (true) {
      int guessedNumber = consoleScanner.nextInt();
      count++;
      int differ = guesserService.compareGuessNumber(guessedNumber);
      if (differ == 0) {
        System.out.println("You guess right");
        System.out.println("You used " + count + " times");
        break;
      } else if (differ > 0) {
        System.out.println("You guessed a bigger number. Please try again");
      } else {
        System.out.println("You guessed a smaller number. Please try again");
      }
    }
  }
}
