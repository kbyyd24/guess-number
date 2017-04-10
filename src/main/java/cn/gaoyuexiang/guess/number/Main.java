package cn.gaoyuexiang.guess.number;

import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    Stream.of(args).forEach(System.out::println);
  }
}
