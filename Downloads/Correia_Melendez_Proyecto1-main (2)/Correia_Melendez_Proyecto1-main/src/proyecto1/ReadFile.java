/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Ksotillo
 */
public class ReadFile {
    
    /**
     *
     * @param path
     * @return
     */
    public JSONArray readJson(String path) {
        JSONParser parser = new JSONParser();
        
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            JSONArray data = (JSONArray) parser.parse(fr);
            return data;

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
    
    
    public HashTable mapDataFromJSON(JSONArray data, HashTable hashTable) {
//        HashTable<String, Investigacion> hashTable = new HashTable<>();

        for (Object s : data) {
            JSONObject songJSON = (JSONObject) s;
            Object[] entries = songJSON.entrySet().toArray();
            String[] attributes = new String[entries.length];
            String[] values = new String[entries.length];

            for (int i = 0; i < entries.length; i++) {
                String[] entry = entries[i].toString().split("=");
                attributes[i] = entry[0];
//                System.out.println(entry[0]);
                if (entry[0].equals("album")) {
                    Map.Entry albumEntry = (Map.Entry) entries[i];
//                    System.out.println(albumEntry.getValue());
                    JSONObject album = (JSONObject) albumEntry.getValue();
                    values[i] = album.get("title").toString();
                } else {
                    values[i] = entry[1];
                }
            }

            Investigacion investigacion = mapDataToSong(attributes, values);
//            System.out.println(investigacion.getTitle()+"\n"+investigacion);
            hashTable.add(investigacion.getTitle(), investigacion);

        }

        return hashTable;
    }

    private Investigacion mapDataToSong(String[] attributes, String[] values) {
        Investigacion inv = new Investigacion();
        for (int i = 0; i < attributes.length; i++) {
            String attribute = attributes[i].replace("\"", "");
            String value = values[i].replace("\"", "");

            switch (attribute) {
                case "summary":
                    inv.setSummary(value);
                    break;
                case "authors":
                    inv.setAuthors(value);
                    break;
                case "keywords":
                    inv.setKeywords(value);
                    break;    
                case "title":
                    inv.setTitle(value);
                    break; 
                default:
                    break;
            }

        }

        return inv;
    }
    
}
