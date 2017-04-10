package cn.gaoyuexiang.guess.number.service;

public class CounterService {

  private int chances;

  public CounterService(int allChances) {
    this.chances = allChances;
  }

  public int useOne() {
    return --chances;
  }
}
