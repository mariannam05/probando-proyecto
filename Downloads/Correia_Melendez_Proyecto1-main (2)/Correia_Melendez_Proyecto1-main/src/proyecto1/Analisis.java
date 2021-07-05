/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import static java.lang.System.nanoTime;

/**
 *
 * @author Sabrina Correia
 */
public class Analisis {

    public String analizar(String key, HashTable table) {
        long  time1 =  nanoTime();
        Investigacion inv = (Investigacion) table.get(key);
        String text = "ANALISIS DE LA INVESTIGACION: \n";
        text += "-----------\n";
        text += "Nombre del trabajo: " + inv.getTitle() + "\n" + "Autores: " + inv.getAuthors().replace("]", "").replace("[", "").replace(",", ",  ") + "\n";
        text += "-----------\n";
        text += "-Palabras claves / frecuencia-\n";
        String[] keywords = inv.getKeywords().split(", ");
        int[] cantwords = new int[keywords.length];
        
        for (int i = 0; i < keywords.length; i++) {
            int count = 0, fromIndex = 0;

            while ((fromIndex = inv.getSummary().indexOf(keywords[i], fromIndex)) != -1) {
//                System.out.println("Found at index: " + fromIndex);
                count++;
                fromIndex++;
            }
            cantwords[i] = count;
        }
        
        
        for (int i = 0; i < keywords.length; i++) {
            text += keywords[i] + " / " + cantwords[i] + "\n";
        }
        text += "-----------\n";
        text += "Número de palabras del resumen: " + inv.getSummary().split(" ").length+"\n";
        long  time2 =  nanoTime();        
        text += "Tiempo de analisis: " + (time2-time1)+" Nanosegundos";
        return text;

    }
}
