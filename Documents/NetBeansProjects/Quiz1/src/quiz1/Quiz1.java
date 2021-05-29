/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz1;

import javax.swing.JOptionPane;

/**
 *
 * @author Marianna
 */
public class Quiz1 {
    static int[][] boxBlur(int[][] image) {
        int ancho = image.length;
        int largo = image[0].length;
        //segun wikipedia tenemos que sumar cuadrito por cuadrito para calcular el promedio
        //al hacerlo debemos quitar los bordes
        int[][] matrix = new int[ancho-1][largo-1];
        for (int j = 1; j < ancho-1; j++) {
            //esto lo puse aqui asi para que se imprimiera bonito
            for (int k = 1; k < largo-1; k++) {
                matrix[j-1][k-1] = promedio(image, j, k);
            }
        }
        return matrix;
    }
        
    public static int promedio(int[][] image, int j, int k) {
        //aqui haremos la suma de wikipedia
        int sum = ((image[j - 1][k + 1]) + (image[j + 0][k + 1]) + (image[j + 1][k + 1]) + (image[j - 1][k + 0]) + (image[j + 0][k + 0]) + (image[j + 1][k + 0]) + (image[j - 1][k - 1]) + (image[j + 0][k - 1]) + (image[j + 1][k - 1]))/9;
        return sum;
    }
    
    
    public static void print (int[][] a){
        for (int i=0; i < a.length; i++) {
            for (int j=0; j < a[i].length; j++) {
                System.out.print("| " + a[i][j] + "\t");
                if (j==a[0].length - 1) System.out.print("|");
            }
        System.out.println("");
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] imagen = {{7, 4, 0, 1}, 
                        {5, 6, 2, 2}, 
    	    		{6, 10, 7, 8}, 
                        {1, 4, 2, 0}};
        
        int[][] intento2 = { { 1, 1, 1 }, 
                            { 1, 7, 1 },
                            { 1, 1, 1 }  };
        
        //este lo hice a amano primero para comprobar xd
        int[][] intento3 = {{2, 4, 6, 8}, 
                            {1, 2, 3, 4}, 
                            {0, 2, 4, 6}, 
                            {1, 3, 5, 7}};

        print(imagen);
        System.out.println("");
        System.out.println("");
        int[][] ola = boxBlur(imagen);
        print(ola);
        System.out.println("");
        System.out.println("");
        print(intento2);
        System.out.println("");
        System.out.println("");
        int[][] ola2 = boxBlur(intento2);
        print(ola2);
        System.out.println("");
        System.out.println("");
        print(intento3);
        System.out.println("");
        System.out.println("");
        int[][] ola3 = boxBlur(intento3);
        print(ola3);
        
        //disculpe por todo el fastidio durante el quiz 
        //no se me enoje tqm
        //aqui un JOption pane
        JOptionPane.showMessageDialog(null,"modo triste por no poder hacer mi interfaz en la 2 :c","unu", JOptionPane.PLAIN_MESSAGE);
        
        
        
        }
    }
        
        



    

