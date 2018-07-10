package com.dahu.tt;

import java.math.BigDecimal;

/**
 * Created by zzh on 2018/6/20.
 */
public class NoVisibility {
  private static boolean ready;
  private static int number;
  private static class ReaderThread extends Thread {
    @Override
    public void run() {

      while(!ready) {
        System.out.println("0000");
        Thread.yield();
      }
      System.out.println(number);
    }
  }
  public static void main(String[] args) {
    // create a BigDecimal object
    BigDecimal bg;

    // create a Long Object
    Long l = new Long("12345678");

    // assign the bigdecimal value of l to bg
    // scale is 4
    bg = BigDecimal.valueOf(l, 2);

    String str = "The Value of BigDecimal using scale 4 is " + bg;

    // print bg value
    System.out.println( str );
  }

}
