package com.kevin.jvm.simples.tools;

/**
 * @author kevin
 */
public class Person {

  private String name = "张三";

  private int age;

  private final double salary = 1000;

  private static String address;

  private final static String hobby = "programming";

  private static Object obj = new Object();

  public void say() {
    System.out.println(this.name + "say...");
  }

  public static int calc(int first, int second) {
    return first + second;
  }

  public static void main(String[] args) {
    calc(1, 2);
  }

}
