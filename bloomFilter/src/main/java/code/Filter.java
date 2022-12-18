/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package code;

/**
 *
 * @author julietpetit
 */
public abstract class Filter {
    
    private int k;
    private int m;
    
    public void setK(int i){
        k = i;
    }
    public void setM(int i){
        m = i;
    }
    public int getK(){
        return k;
    }
    public int getM(){
        return m;
    }
    /**
     * To insert a new value in our bloom filter.
     * @param e the int to insert
     */
    public abstract void insertInto(int e);
    /**
     * to initialize the bloom filter with the rigth size and everything at false.
     */
    public abstract void initialize();
    /**
     * To verify if the filter contains an element
     * @param i the int to verify
     * @return a boolean wich is true if we detect the presence.
     */
    public abstract boolean contains(int i);
    
     /**
     * Hash function is created following the multiplication method
     * @param k is an int (4 bytes)
     * @return a int, the value of the hash
     */
    public static int h(int k){
        int w =32;
        double s = 2654435769L; //as knuth said
        double ks = k*s;
        int length = 10; // the length (in bits) of the hash

        int r1 = (int)(ks/Math.pow(2, w)); // the decimal part
        int r0 = (int) (ks - (r1 * Math.pow(2, w) )); // the fractional part
        
        String bin = Integer.toBinaryString(r0); //string containing the binary number for r0
        if (bin.length()>=length)
            bin = bin.substring(0,length); 

        return Integer.parseInt(bin, 2); // we reconvert the string into int
    }
    
}
