/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary1;

import org.json.simple.*;

/**
 *
 * @author Mandar
 */
public class JSONDecoder {
    public String decoder(String data){
        String deData="";
        try{
            Object obj=JSONValue.parse(data);
            JSONArray ja=(JSONArray) obj;
            
            JSONObject jo=(JSONObject) ja.get(0);
            
            deData=deData+" Word:- "+jo.get("word");
            
            JSONObject jo1=(JSONObject) jo.get("meaning");
            
            JSONArray ja1=(JSONArray)jo1.get("noun");
            
            JSONObject jo2=(JSONObject) ja1.get(0);
            deData=deData+"\n Part Of Speech:- Noun";
            deData=deData+"\n Definition:- "+jo2.get("definition");
//            deData=deData+"\n Example:- "+jo2.get("example");
            
//            JSONObject ja3=(JSONObject) jo2.get("synonyms");
//            if(ja3 != null){
//                deData=deData+"Synonyms:-";
//                for(int i=0;i<ja3.size();i++){
//                    deData=deData+"\n \t"+ja3.get(i);
//                }
//            } else {
//            }
            
        }catch(Exception e){
            System.out.println(e);
            deData="error";
        }
        return deData;
    }
    
}
