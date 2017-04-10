package cn.gaoyuexiang.guess.number.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterServiceTest {

  @Test
  public void should_return_remainder_times_when_has_remainder_chance() throws Exception {
    CounterService service = new CounterService(4);
    int remainderChances = service.useOne();
    assertEquals(3, remainderChances);
  }
}