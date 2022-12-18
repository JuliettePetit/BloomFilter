/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.ArrayList;

/**
 *
 * @author julietpetit
 */
public class ArrayListFilter extends Filter{
    int k;
    int m;
    ArrayList<Integer> bloomArrayList = new ArrayList<>();
    
    public ArrayListFilter(){
        this.k = super.getK();
        this.m = super.getM();
    }
    
    /**
     * if we need to test for a particular value
     * @param k : int, the number of hash functions
     * @param m : int, the length of the filter
     */
    public ArrayListFilter(int k, int m){
        super.setK(k);
        super.setM(m);
        this.k = super.getK();
        this.m = super.getM();
    }
    
    @Override
    public void initialize(){
        for (int i = 0; i < m; i++)
            bloomArrayList.add(0);
    }
    
    @Override
    public void insertInto(int e){
        
        for (int i = 1; i < k+1; i++){
            bloomArrayList.set((h(e)*i)%m, 1);
        }
    }
    
    @Override
    public boolean contains(int e){
        boolean doContains = true;
        for (int i=1; i<k+1; i++){
            if (bloomArrayList.get((h(e)*i)%m) != 1){
                doContains = false;
            }
        }
        return doContains;
    }
    
}
