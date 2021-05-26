/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Marianna
 */
public class main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n = new Node<Integer>(10);
        linkedlist list = new linkedlist<Integer>(n);
        list.addFirst(45);
        list.addLast(90);
        list.add(80, 0);
        list.add(100, 2);
        list.add(70, 5);
        list.print();
        list.getPosicion(70);
        list.convertVector();
        list.Reverse();
        list.print();
        
        
    }
    
}
