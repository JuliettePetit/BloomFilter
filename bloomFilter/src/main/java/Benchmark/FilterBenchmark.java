/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benchmark;
import code.ArrayListFilter;
import code.LinkedListFilter;
import code.ArrayFilter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julietpetit
 */
public class FilterBenchmark {
    public static void main(String[] args){
     
        System.out.println("Analyze of render time for each data structure");
        for(int i=0; i<10; i++){
            timeTest();
            System.out.println("------------------------------------------------------------------------");
        }            
        
        System.out.println("Analyze of error rate in the arrayList");
        int m = 10000;
        
        // different k and same n = 1%
        errorRateTest(1, m*1/100, m);
        errorRateTest(500, m*1/100, m);
        errorRateTest(1000, m*1/100, m);
        
        // different k and same n = 5%
        errorRateTest(1, m*5/100, m);
        errorRateTest(500, m*5/100, m);
        errorRateTest(1000, m*5/100, m);
        
        // different k and same n = 10%
        errorRateTest(1, m*10/100, m);
        errorRateTest(500, m*10/100, m);
        errorRateTest(1000, m*10/100, m);
        
    }
    
    
    public static void timeTest(){
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

        LinkedListFilter l = new LinkedListFilter(3,10000);
        l.initialize();
        for (int i = 0; i <1000; i++){
            int nb = rd.nextInt(10000);
            l.insertInto(nb);
        }
        
        /* Simple array test */
        long startTime = System.nanoTime();
        // Here is the code to measure
         for (int i = 0; i <10000; i++){
            arr.contains(rd.nextInt(10000));
        }
        // stop stopwatch
        long endTime = System.nanoTime();
        System.out.println("simple array is computed in : " + (endTime - startTime) + " ns");

        /* Array list test */
        startTime = System.nanoTime();
        for (int i = 0; i <10000; i++){
            a.contains(rd.nextInt(10000));
        }
        endTime = System.nanoTime();
        System.out.println("array list is computed in : " + (endTime - startTime) + " ns");

        /* Linked list test */
        startTime = System.nanoTime();
        for (int i = 0; i <10000; i++){
            l.contains(rd.nextInt(10000));
        }
        endTime = System.nanoTime();
        System.out.println("linked list is computed in : " + (endTime - startTime) + " ns");
    }
    
    public static void errorRateTest(int k, int n, int m){     
        int c = 0;
        Random rd = new Random();       
        ArrayList<Integer> value = new ArrayList<>();
        
        // initialize the arrayList
        ArrayListFilter a1 = new ArrayListFilter(k,m);
        a1.initialize();
        // fill the arrayList
        for (int i = 0; i <n; i++){
            int tmp = rd.nextInt(m);
            value.add(tmp);
            a1.insertInto(tmp);
        }
        // check the presence of the elements previously added
        for (int i = 0; i < m; i++){
            if (a1.contains(i)&& !value.contains(i)){
                c++; 
            }
        }
        System.out.println("number of objects inserted : "+ n + "\nnumber of hash functions : " + k);
        //System.out.println("number of wrong object found in the bloom filter :" + c/n);
        System.out.println((c*100)/m + "%");
        //return c/n; 
    }
}
