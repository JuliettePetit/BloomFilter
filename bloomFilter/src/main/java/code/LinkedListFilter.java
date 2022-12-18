/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.LinkedList;

/**
 *
 * @author julietpetit
 */
public class LinkedListFilter extends Filter {
    int k;
    int m;
    LinkedList<Integer> bloomLinkedList = new LinkedList<>();
    
    /**
     * if we net to use same k and m for all the filter, we can change it only once
     */
    public LinkedListFilter(){
        this.k = super.getK();
        this.m = super.getM();
    }
    
    /**
     * if we need to test for a particular value
     * @param k : int, the number of hash functions
     * @param m : int, the length of the filter
     */
    public LinkedListFilter(int k, int m){
        super.setK(k);
        super.setM(m);
        this.k = super.getK();
        this.m = super.getM();
    }
    
    @Override
    public void initialize(){
        for (int i = 0; i <m ; i++)
            bloomLinkedList.add(0);
    }
    
    @Override
    public void insertInto(int e){
        
        for (int i=1; i<k+1; i++){
            bloomLinkedList.set((h(e)*i)%m, 1);
        }
    }
    
    @Override
    public boolean contains(int e){
        boolean doContains = true;
        for (int i=1; i<k+1; i++){
            if (bloomLinkedList.get((h(e)*i)%m) != 1){
                doContains = false;
            }
        }
        return doContains;
    }
}
