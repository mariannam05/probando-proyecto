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
public class linkedlist <T>{
    
    private Node<T> head;
    private Node<T> tail;

    
    public linkedlist() {
        this.head = this.tail = null;
    }

    public linkedlist(Node<T> n) {
        this.head = this.tail = n;
    }
    
    
    private boolean isEmpty() {
        return this.head == null;
    }
    
    
    public int size() {
        int i = 0;
        
        if (isEmpty()) {
            return 0;
        }
        
        Node<T> aux = this.head;
        while(aux != null) {
            aux = aux.getNext();
            i++;
        }
        return i;
    }
    
    
    public void addFirst(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    
    
    public void addLast(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    
    public boolean buscar(T valor){
        Node<T> aux = this.head;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (valor == aux.getData()){
                encontrado = true;
            }
            else{
                aux = aux.getNext();
            }
        }
        return encontrado;
    }
    
    
    public void add(T datum, int i) {
        if (isEmpty() || i == 0) {
            this.addFirst(datum);
        } else if (i >= (size() - 1)) {
            this.addLast(datum);
        } else if (i < 0) {
            this.add(datum, size() + i);
        }else {
            Node<T> n = new Node(datum);
            Node aux = this.head; // Nodo previo
            int count = 0;
            while(count < i -1) {
                aux = aux.getNext();
                count++;
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }

    
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = this.head;
        this.head= this.head.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> pre = this.head;
        while(pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        Node<T> temp = pre.getNext();
        pre.setNext(null);
        this.tail = pre;
        temp.setNext(null);
        return temp.getData();
        
    }
    
    
    public T delete(int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            return deleteFirst();
        } else if (i == size() -1) {
            return deleteLast();
        } else if (i < 0)  {
            return delete(size() + i);
        } else if (i > size() - 1) {
            System.out.println("\nError");
            return null;
        } else {
            Node<T> aux = this.head;
            int count = 0;
            while(count < i-1) {
                aux = aux.getNext();
                count++;
            }
            Node<T> del = aux.getNext();
            aux.setNext(del.getNext());
            del.setNext(null);
            return del.getData();
        }
    }
    
    public void getPosicion(T valor){
        if (buscar(valor)) {
            Node<T> aux = this.head;
            int count = 0;
            while(valor != aux.getData()){
                aux = aux.getNext();
                count++;
            }
            System.out.println("la posicion de "+ valor + " en la lista es " + count);
        } else {
            System.out.println("Valor inexistente en la lista.");
        }
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.head;
            int i = 0;
            while (aux != null) {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }

    
    public void showsize() {     //ese nombre porque puse size y exploto
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.head;
            int i = 0;
            while (aux != null) {
                aux = aux.getNext();
                i++;
            }
            System.out.println("El tamaño de la lista es de " + i);
        }
    }
    

    public Node getNode(int valor){
        if (!isEmpty() && valor < size()) {
            Node<T> aux = this.head;
            for (int i = 0; i < valor; i++) {
                aux = aux.getNext();
            }
            return aux;
        }else {
                return null;
        }
    }

    public Object[] convertVector(){
        Object array[] = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = getNode(i).getData();
        }
        return array;
    }
    
    public void setHead(Node <T> head){
        this.head = head;
    }
    
    public void setTail(Node <T> head){
        this.tail = head;
    }
    
    
    public void Reverse(){
        Node prev = null;
        Node current = this.head;
        Node next = null;
        this.setTail(current);
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.setHead(prev);
    }
    
}



           