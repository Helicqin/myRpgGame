/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

//读取洛阳文档
public class Filedialog extends JDialog{

    private JTextArea textarea = new JTextArea();
    
    
    public Filedialog(){
        this.setLayout(null);
        
        //读文件内容到textpanel
        BufferedReader input = null;
        int i;
        String[] string = new String[100];
        String longstring = "";
            try {
                input = new BufferedReader(new FileReader("./util/洛阳.txt"));
                i = 0; //第几行
                while ((string[i] = input.readLine()) != null) {
                    i++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            i= 0;
            while(string[i]!=null){
                longstring = longstring+string[i]+"\n";
                i++;
            }
            
        
        textarea.setColumns(10);
        textarea.setFont(new Font("" , Font.BOLD , 18));
        textarea.setText(longstring);   
        textarea.setBounds(0, 0, 900, 700);
        this.add(textarea);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocation(200, 50);
        this.setSize(900,700);
        this.setModal(true);
        this.setVisible(true);
    }
  
    public Filedialog(String filename){
        this.setLayout(null);
        
        //读文件内容到textpanel
        BufferedReader input = null;
        int i;
        String[] string = new String[100];
        String longstring = "";
            try {
                input = new BufferedReader(new FileReader(filename));
                i = 0; //第几行
                while ((string[i] = input.readLine()) != null) {
                    i++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(Filedialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            i= 0;
            while(string[i]!=null){
                longstring = longstring+string[i]+"\n";
                i++;
            }
            textarea.setColumns(10);
            textarea.setFont(new Font("" , Font.BOLD , 18));
            textarea.setText(longstring);
        
            
        textarea.setBounds(0, 0, 900, 700);
        this.add(textarea);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocation(200, 50);
        this.setSize(900,700);
        this.setModal(true);
        this.setVisible(true);
    }

    
}
