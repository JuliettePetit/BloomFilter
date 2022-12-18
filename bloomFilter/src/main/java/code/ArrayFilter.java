/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package code;
/**
 *
 * @author julietpetit
 */
public class ArrayFilter extends Filter{
    int k;
    int m;
    int[] bloomTab;
    
    /**
     * if we net to use same k and m for all the filter, we can change it only once
     */
    public ArrayFilter(){
        this.k = super.getK();
        this.m = super.getM();
        bloomTab = new int[this.m];
    }
    
    /**
     * if we need to test for a particular value
     * @param k : int, the number of hash functions
     * @param m : int, the length of the filter
     */
    public ArrayFilter(int k, int m){
        super.setK(k);
        super.setM(m);
        this.k = super.getK();
        this.m = super.getM();
        bloomTab = new int[this.m];
    }
    
    @Override
    public void initialize(){
        for (int i = 0; i < m ; i++)
            bloomTab[i]=0;
    }
    
    @Override
    public void insertInto(int e){
        for (int i=1; i<k+1; i++){
            bloomTab[(h(e)*i)%m] = 1;
        }
    }
    
    @Override
    public boolean contains(int e){
        boolean doContains = true;
        for (int i=1; i<k+1; i++){
            if (bloomTab[(h(e)*i)%m] != 1){
                doContains = false;
            }
        }
        return doContains;
    }
}
