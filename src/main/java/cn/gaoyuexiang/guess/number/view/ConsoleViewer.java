package cn.gaoyuexiang.guess.number.view;

import cn.gaoyuexiang.guess.number.service.CounterService;
import cn.gaoyuexiang.guess.number.service.NumberGuesserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleViewer {

  private static final int START = 1;
  private static final int END = 100;
  private static final int ALL_CHANCES = 8;
  public static final String EXIT = "n";
  public static final String AGAIN = "y";
  private Map<Integer, String> comparatorMap;

  public ConsoleViewer() {
    this.comparatorMap = new HashMap<>();
    comparatorMap.put(1, "You guessed a bigger number. Please try again!");
    comparatorMap.put(0, "You guessed right number!");
    comparatorMap.put(-1, "You guessed a smaller number. Please try again!");
  }

  public void dealConsole() {
    Scanner consoleScanner = new Scanner(System.in);
    boolean isGoOn = true;
    while (isGoOn) {
      playOneGame(consoleScanner);
      isGoOn = isGoOn(consoleScanner);
    }
    consoleScanner.close();
  }

  private void playOneGame(Scanner consoleScanner) {
    System.out.println("Please input your number:");
    CounterService counterService = new CounterService(ALL_CHANCES);
    NumberGuesserService guesserService = new NumberGuesserService(START, END);
    guesserService.buildNumberX();
    boolean isFinish = false;
    while (!isFinish) {
      int guessedNumber = consoleScanner.nextInt();
      int differ = guesserService.compareGuessNumber(guessedNumber);
      System.out.println(comparatorMap.get(differ));
      int count = counterService.useOne();
      isFinish = dealIfFinished(count, differ);
    }
  }

  private boolean dealIfFinished(int count, int differ) {
    if (count <= 0) {
      System.out.println("You have No Chance for this turn.");
      return true;
    }
    if (differ == 0) {
      System.out.printf("You guessed %d times\n", ALL_CHANCES - count);
      return  true;
    }
    return false;
  }

  private boolean isGoOn(Scanner consoleScanner) {
    while (true) {
      System.out.printf("Do you want to try again?(%s/%s)\n", AGAIN, EXIT);
      String answer = consoleScanner.next();
      if (answer.equalsIgnoreCase(EXIT)) {
        return false;
      } else if (answer.equalsIgnoreCase(AGAIN)) {
        return true;
      } else {
        System.out.println("Please input right answer");
      }
    }
  }

}
