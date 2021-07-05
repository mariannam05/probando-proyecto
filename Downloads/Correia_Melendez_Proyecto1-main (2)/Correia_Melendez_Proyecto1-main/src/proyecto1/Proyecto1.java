/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import org.json.simple.JSONArray;

/**
 *
 * @author Sabrina Correia
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable<String, Investigacion> hashTable = new HashTable<>();
        ReadFile reader = new ReadFile();
        
        
//        System.out.println(readJson(""));
        JSONArray investigaciones = reader.readJson("src\\files\\research.json");
        reader.mapDataFromJSON(investigaciones, hashTable);
//        hashTable.print();
        
        ventana1 v1 = new ventana1(hashTable);
        
        
        
        
    }
    
}
