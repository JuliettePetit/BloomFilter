/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package code;

/**
 *
 * @author julietpetit
 */
public class BloomFilter {

    public static void main(String[] args) {
        System.out.println("Simple array");
        int a = 15642;
        int b = 3;
        ArrayFilter tab = new ArrayFilter(2,10);
        tab.initialize();
        tab.insertInto(a);
        tab.insertInto(b);
        for (int i =0; i<10; i++)
            System.out.println(tab.bloomTab[i]);
        System.out.println("--------------------------------------------------");
        System.out.println("Array list");
        ArrayListFilter arr = new ArrayListFilter(2,10);
        arr.initialize();
        arr.insertInto(a);
        arr.insertInto(b);
        for (int i : arr.bloomArrayList){
            System.out.println(i);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Linked list");
        LinkedListFilter lin = new LinkedListFilter(2,10);
        lin.initialize();
        lin.insertInto(a);
        lin.insertInto(3842);
        for (int i : lin.bloomLinkedList){
            System.out.println(i);
        }
        System.out.println(lin.contains(3842));
    }
}
