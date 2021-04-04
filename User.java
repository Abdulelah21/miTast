/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import sun.java2d.pipe.BufferedBufImgOps;

/**
 *
 * @author gg
 */
public class User {
    
    public static ArrayList<String> username = new ArrayList<String>();
    public static ArrayList<String> password = new ArrayList<String>();

    File f = new File("UserTest");
    FileWriter fw;
    BufferedWriter bw;

    FileReader fr;
    BufferedReader br;
    
    public void addUser(String u,String p) throws IOException{
    
        
        fw = new FileWriter(f,true);
        bw = new BufferedWriter(fw);
        
        bw.write(u);
        bw.newLine();
        bw.write(p);
        bw.newLine();
        bw.close();
    }
    
    public boolean cheackUser(String u) throws FileNotFoundException, IOException{
        
        FileReader fr ;
        BufferedReader br;
        
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        String line = br.readLine();
        
        while(line!=null){
            if(line.equals(u)){
                line = br.readLine();
                return true;
            }
            line = br.readLine();
        }
        br.close();
         return false;
    }
   
    

}
