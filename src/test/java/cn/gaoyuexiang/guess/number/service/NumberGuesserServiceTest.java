package cn.gaoyuexiang.guess.number.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberGuesserServiceTest {

  private NumberGuesserService service;

  @Test
  public void should_return_random_number_between_1_to_100() {
    service = new NumberGuesserService();
    service.buildNumberX();
    int numberX = service.getNumberX();
    assertTrue(numberX <= 100);
    assertTrue(numberX >= 1);
  }

  @Test
  public void should_return_positive_number_when_given_guess_number_bigger_than_X() throws Exception {
    service = new NumberGuesserService();
    service.setNumberX(1);
    int differ = service.compareGuessNumber(4);
    assertTrue(differ == 1);
  }

  @Test
  public void should_return_negative_number_when_given_guess_number_smaller_than_X() throws Exception {
    service = new NumberGuesserService();
    service.setNumberX(100);
    int differ = service.compareGuessNumber(96);
    assertTrue(differ == -1);
  }

  @Test
  public void should_return_0_when_given_guess_number_same_with_X() throws Exception {
    service = new NumberGuesserService();
    service.buildNumberX();
    int differ = service.compareGuessNumber(service.getNumberX());
    assertTrue(differ == 0);
  }

  @Test
  public void should_build_random_number_between_start_and_end() throws Exception {
    int end = 50;
    int start = 29;
    service = new NumberGuesserService(start, end);
    int numberX = service.getNumberX();
    assertTrue(numberX >= start);
    assertTrue(numberX <= end);
  }
}
