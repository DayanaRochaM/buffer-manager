/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd.filemanager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author pucks
 */
public class ArchiveReader {
    
    public static String loadLine(int key) throws FileNotFoundException, IOException{
        
        String path = new File("").getAbsolutePath() + "/src/sgbd/filemanager";
        FileReader archive = new FileReader(path + "/arquivo.txt"); 
        BufferedReader bufferedArchive = new BufferedReader(archive);
        String line = bufferedArchive.readLine();
        int lineNumber = 1;
        
        while(line != null){
        
            if (key == lineNumber){
                return line;
            }
            line = bufferedArchive.readLine();
            lineNumber++;
        }
        return null;
    }
}
