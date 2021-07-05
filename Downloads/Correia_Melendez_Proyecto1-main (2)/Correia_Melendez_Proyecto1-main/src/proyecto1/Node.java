/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Sabrina Correia
 */
public class Node<T> {
    private T data;
    private Node next;
    
    /**
     *
     * @param datum
     */
    public Node (T datum) {
        this.data = datum;
        this.next = null;
    }

    /**
     * Get Node's data
     * @return the data inside Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets new data to Node
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    public static int comparator(Node firstNode, Node secondNode, int op) {
        Investigacion data1 = (Investigacion) firstNode.getData();
        Investigacion data2 = (Investigacion) secondNode.getData();
        switch (op) {
            case 0:
                int firstDataInteger = data1.getSummary().length();
                int secondDataInteger = data2.getSummary().length();
                if (firstDataInteger > secondDataInteger) {
                    
                    return 1;
                } else if (secondDataInteger > firstDataInteger) {
                    return -1;
                } else {
                    return 0;
                }
            case 1:
            {
                String firstDataString = data1.getTitle();
                String secondDataString = data2.getTitle();
                if (firstDataString.compareToIgnoreCase(secondDataString) > 0) {
                    return 1;
                } else if (firstDataString.compareToIgnoreCase(secondDataString) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
            case 2:
            {
                String firstDataString = data1.getTitle();
                String secondDataString = data2.getTitle();
                if (firstDataString.compareToIgnoreCase(secondDataString) < 0) {
                    return 1;
                } else if (firstDataString.compareToIgnoreCase(secondDataString) > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
            
            case 3:
            {
                String firstDataString = data1.getKeywords();
                String secondDataString = data2.getKeywords();
                String[] first = firstDataString.split(",");
                String[] second = secondDataString.split(",");
                if (first.length > second.length) {
                    
                    return 1;
                } else if (second.length > first.length) {
                    return -1;
                } else {
                    return 0;
                }
            }
            

            default:
                break;
        }

        return 0;
    }
    
    
}
