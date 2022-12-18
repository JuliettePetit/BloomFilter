/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benchmark;
import code.ArrayListFilter;
import code.LinkedListFilter;
import code.ArrayFilter;
import java.util.Random;

/**
 *
 * @author julietpetit
 */
public class FilterBenchmark {
    public static void main(String[] args){

      ArrayFilter arr = new ArrayFilter(3,10000);
      arr.initialize();
      Random rd = new Random();
      for (int i = 0; i <1000; i++){
          int nb = rd.nextInt(10000);
          arr.insertInto(nb);
      }

      ArrayListFilter a = new ArrayListFilter(3,10000);
      a.initialize();
      for (int i = 0; i <1000; i++){
          int nb = rd.nextInt(10000);
          a.insertInto(nb);
      }
      a.insertInto(3);
        
      LinkedListFilter l = new LinkedListFilter(3,10000);
      l.initialize();
      for (int i = 0; i <1000; i++){
          int nb = rd.nextInt(10000);
          l.insertInto(nb);
      }

      /* Table test */
      long startTime = System.nanoTime();
      // Here is the code to measure
       for (int i = 0; i <100; i++){
          arr.contains(rd.nextInt(10000));
      }
      // stop stopwatch
      long endTime = System.nanoTime();
      System.out.println("tab is computed in : " + (endTime - startTime) + " ns");
      
      /* Array list test */
      startTime = System.nanoTime();
      for (int i = 0; i <100; i++){
          a.contains(rd.nextInt(10000));
      }
      endTime = System.nanoTime();
      System.out.println("array list is computed in : " + (endTime - startTime) + " ns");
      
      /* Linked list test */
      startTime = System.nanoTime();
      for (int i = 0; i <100; i++){
          l.contains(rd.nextInt(10000));
      }
      endTime = System.nanoTime();
      System.out.println("linked list is computed in : " + (endTime - startTime) + " ns");
    }

}
