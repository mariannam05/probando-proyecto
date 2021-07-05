/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Sabrina Correia
 */
public class WriteJSON {
    public void writeJson(HashTable table) {
        LinkedList list = table.getHashList();
        Node aux = list.getHead();
        JSONArray researchList = new JSONArray();
        
        for (int i = 0; i < list.size(); i++) {
            Investigacion inv = (Investigacion) aux.getData();
            JSONObject researchDetails = new JSONObject();
            researchDetails.put("title", inv.getTitle());
            researchDetails.put("keywords", inv.getKeywords());
            researchDetails.put("authors", inv.getAuthors());
            researchDetails.put("summary", inv.getSummary());
            
            researchList.add(researchDetails);
//            playlistObject.put(inv.getTitle(), playlistDetails);
            aux= aux.getNext();
        }


       
//        JSONArray playlistList = new JSONArray();
//        playlistList.add(playlistObject);

    
        try (FileWriter file = new FileWriter("src\\files\\research.json")) {
            
            file.write(researchList.toJSONString());
            file.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
