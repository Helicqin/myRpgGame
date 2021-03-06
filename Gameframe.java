/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;



public class Gameframe extends JFrame implements ActionListener{
    
    public Player player = new Player("执念");
    
    Mappanel mappanel; 
    Statepanel statepanel = new Statepanel(player);
    JButton close = new JButton("离开游戏");
    Music music;
    
        
   
    public Gameframe(){
        music = new Music("./util/游戏配乐.au");
        Choosedialog1 choose = new Choosedialog1("             是否要从上次存档的地方继续开始？");
        
        if(choose.getI() == -1)
             this.dispose();
        else{
        if(choose.getI() == 1)
             player.load();
        
         
        
        mappanel = new Mappanel(statepanel,player);
        
        if(choose.getI() == 0)
        {
         new Textdialog("故事发生在一个黑暗混乱的时期\n");
         new Textdialog("三国纷争，战乱不断       \n   魏国强盛，蜀吴衰败\n ");
         new Textdialog(player.name+"  诞生于黎明前的黑暗 \n");
         new Homedialog(player);
        }
        
        this.setLayout(null);
        this.setBounds(300, 100, 605+200, 635);
        this.add(mappanel);
        this.add(statepanel);
        statepanel.setBounds(600, 0, 200, 550);
        this.add(close);
        close.setBounds(625 ,560 , 150 , 30);
        close.addActionListener(this);
        
        this.addKeyListener(mappanel);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        
        
        
        }
        
        
       
        

        
  }



    public void actionPerformed(ActionEvent e) {
        new Textdialog("游戏关闭");
        music.Close();
        this.dispose();
    }
    
   
    
    
    
   
}
