package cn.gaoyuexiang.guess.number.view;

import cn.gaoyuexiang.guess.number.service.NumberGuesserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleViewer {

  private Map<Integer, String> comparatorMap;

  public ConsoleViewer() {
    this.comparatorMap = new HashMap<>();
    comparatorMap.put(1, "You guessed a bigger number. Please try again!");
    comparatorMap.put(0, "You guessed right number!");
    comparatorMap.put(-1, "You guessed a smaller number. Please try again!");
  }

  public void dealConsole() {
    Scanner consoleScanner = new Scanner(System.in);
    while (true) {
      System.out.println("Please input your number:");
      int count = 0;
      NumberGuesserService guesserService = new NumberGuesserService();
      guesserService.buildNumberX();
      while (true) {
        int guessedNumber = consoleScanner.nextInt();
        count++;
        int differ = guesserService.compareGuessNumber(guessedNumber);
        System.out.println(comparatorMap.get(differ));
        if (differ == 0) {
          System.out.printf("You guessed %d times", count);
          break;
        }
      }
      System.out.println("Do yout want to try again?(y/N)");
      if (consoleScanner.hasNext() && consoleScanner.next().equalsIgnoreCase( "y"))
        continue;
      break;
    }
    consoleScanner.close();
  }

}