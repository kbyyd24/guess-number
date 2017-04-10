package cn.gaoyuexiang.guess.number.service;

import org.junit.Before;
import org.junit.Test;

public class NumberGuesserServiceTest {

  private NumberGuesserService service;

  @Before
  public void setUp() throws Exception {
    service = new NumberGuesserService();
  }

  @Test
  public void should_return_random_number_between_1_to_100() {
    service.buildNumberX();
    int numberX = service.getNumberX();
    assert numberX <= 100;
    assert numberX >= 1;
  }

}
