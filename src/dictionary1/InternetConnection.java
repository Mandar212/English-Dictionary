/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import javax.swing.JOptionPane;

/**
 *
 * @author Mandar
 */
public class InternetConnection {
 
    public String getOnlineData(String word){
        String data="";
        String decodeData="";
        try{
            
            URL url=new URL("https://api.dictionaryapi.dev/api/v1/entries/en/"+word);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            
            if(con.getResponseCode()==200){
                InputStream im=con.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(im));
                String line=br.readLine();
                while(line!=null){
                    data=data+line;
                    line=br.readLine();
                }
                br.close();
                JSONDecoder jd=new JSONDecoder();
                decodeData=jd.decoder(data);
            }else{
                
                decodeData="error";
            }
        }
        catch(Exception e){
            try{
                decodeData="error";
                System.out.println(e);
            }catch(Exception e1){
                System.out.println(e1);
            }
        }
        return decodeData;
    }
    
}
