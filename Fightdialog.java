/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

//战斗
public class Fightdialog extends JDialog 
    implements ActionListener{

    Player player;
    int first;
    int second;//若为1，则战斗结束
    int temp ;//monster数量
    Monster[] monster;
    Battle battle;
    
    JPanel1 panel1;//容器，存放组件
    JPanel2 panel2;
    JPanel panel3;
    
    JButton attack = new JButton("普通攻击");
    JButton prop = new JButton("使用道具");
    JButton leave = new JButton("逃跑");
    JButton skill = new JButton("使用武功");
    
    //地图随机遇怪的构造方法
    Fightdialog(Player player) {
        temp = (int)(Math.random()*10/4)+1;
        monster =new Monster[temp];
        
        this.player = player;
        for(int j=0;j<temp;j++){
        monster[j] = incident.getMonster();//每次遇到的monster都是随机产生
      }
        battle = new Battle();
        battle.battleBegin(player);
        
        panel1 = new JPanel1(player);//主角面板
        panel1.setBounds(0, 0, 300, 400);//重新放置 component
        
        
        
        panel2 = new JPanel2(monster);//怪物面板,把PLAYER改掉
        panel2.setBounds(300, 0, 300, 400);
        
        panel3 = new JPanel();//按钮面板
        panel3.setBounds(0, 400, 600, 200);
        
        panel3.setLayout(new GridLayout(2,2));
        panel3.add(attack);
        panel3.add(prop);
        panel3.add(skill);
        panel3.add(leave);
        
        
        
        this.setBounds(300, 100, 605, 635);
        this.setLayout(null);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        
        
        attack.addActionListener(this);
        prop.addActionListener(this);
        skill.addActionListener(this);
        leave.addActionListener(this);
        
        this.setTitle("战斗画面");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }
    
    //指定战斗的对象的构造方法
    Fightdialog(Player player , Monster[] monster) {
        temp = 1;
        this.player = player;
        this.monster = monster;
        
        battle = new Battle();
        battle.battleBegin(player);
        
        panel1 = new JPanel1(player);//主角面板
        panel1.setBounds(0, 0, 300, 400);
        
        
        
        panel2 = new JPanel2(monster);//怪物面板
        panel2.setBounds(300, 0, 300, 400);
        
        panel3 = new JPanel();//按钮面板
        panel3.setBounds(0, 400, 600, 200);
        
        panel3.setLayout(new GridLayout(2,2));
        panel3.add(attack);
        panel3.add(prop);
        panel3.add(skill);
        panel3.add(leave);
        
        
        
        this.setBounds(300, 100, 605, 635);
        this.setLayout(null);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        
        
        attack.addActionListener(this);
        prop.addActionListener(this);
        skill.addActionListener(this);
        leave.addActionListener(this);
        
        this.setTitle("战斗画面");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }
    
    //内部类
    //主角面板
    public class JPanel1 extends JPanel{
        Player player;
        public JPanel1(Player player){
            this.player = player;
        }
        protected void paintComponent(Graphics g){
           g.drawImage(player.image, 50, 0, this);//图片位置
           g.drawString("名字： "+player.name, 50, 140);//名字
           g.drawString("等级： "+player.level, 50, 160);
           g.drawString("生命： "+player.hpp+"/"+player.hp, 50, 180);
           g.drawString("技能： "+player.mpp+"/"+player.mp, 50, 200);
           g.drawString("攻击： "+player.attactt, 50, 220);
           g.drawString("防御： "+player.defencee ,50, 240);
           g.drawString("速度： "+player.speedd, 50, 260);
        }
    }
    
    //怪物面板
    public class JPanel2 extends JPanel{
        Monster monster[];
        public JPanel2(Monster monster[]){
            this.monster = monster;
        }
        protected void paintComponent(Graphics g){
            for(int i = 0 ; i < temp ; i++){
           g.drawImage(monster[i].image, 0+(i%2*150), 0+(i/2)*200, this);//图片位置
           g.drawString("名字： "+monster[i].name, 50+(i%2*150), 110+(i/2)*200);//名字
           g.drawString("等级： "+monster[i].level, 50+(i%2*150), 130+(i/2)*200);
           if (monster[i].hpp<=0)
		      {
        	     g.drawString("生命： "+0+"/"+monster[i].hp, 50+(i%2*150), 150+(i/2)*200);
		       }
           g.drawString("生命： "+monster[i].hpp+"/"+monster[i].hp, 50+(i%2*150), 150+(i/2)*200);
           g.drawString("攻击： "+monster[i].attactt, 50+(i%2*150), 170+(i/2)*200);
           g.drawString("防御： "+monster[i].defencee, 50+(i%2*150), 190+(i/2)*200);
           g.drawString("速度： "+monster[i].speedd,50+(i%2*150) ,  210+(i/2)*200);
            }
            switch(temp){
                 case 1: second=battle.checkBattle(monster[0]);break;//判断战斗是否结束
                 case 2: second=battle.checkBattle(monster[0],monster[1]);break;
                 case 3: second=battle.checkBattle(monster[0],monster[1],monster[2]);break;
             } 
 /*           if(second==1)//战斗结束时monster生命值为0
            {
                for(int i = 0 ; i < temp ; i++){
           g.drawImage(monster[i].image, 0+(i%2*150), 0+(i/2)*200, this);
           g.drawString("名字： "+monster[i].name, 50+(i%2*150), 110+(i/2)*200);//名字
           g.drawString("等级： "+monster[i].level, 50+(i%2*150), 130+(i/2)*200);
           g.drawString("生命： "+0+"/"+monster[i].hp, 50+(i%2*150), 150+(i/2)*200);
           g.drawString("技能： "+monster[i].mpp+"/"+monster[i].mp, 50+(i%2*150), 170+(i/2)*200);
           g.drawString("攻击： "+monster[i].attactt, 50+(i%2*150), 190+(i/2)*200);
           g.drawString("防御： "+monster[i].defencee, 50+(i%2*150), 210+(i/2)*200);
           g.drawString("速度: "+monster[i].speedd,50+(i%2*150) ,  210+(i/2)*200);
            }
            }                             */
        }
    }


    public void actionPerformed(ActionEvent e) {
        
       if(e.getActionCommand().equals("普通攻击")){
               
                Choosedialog choose = new Choosedialog(monster ,temp);
                if(temp==3&&battle.checkSpeedd(player, monster[0], monster[1], monster[2])==1)
                	first=2;//比3个monster都快
                if(temp==2&&battle.checkSpeedd(player, monster[0], monster[1])==1)
                	first=1;//比2个monster都快
                if(temp==1&&battle.checkSpeedd(player, monster[0])==1)
                	first=0;
                
                
                if(first==1||first==2||first==0){
               
                        if(temp==1){
                            battle.attracts(player,monster[temp-1]);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts(player,monster[choose.getN()]);
                            repaint();
                        }
                        if(temp==3){
                            battle.attracts( player,monster[choose.getN()]);
                            repaint();
                       
                        }
                        this.repaint();
                    }
                
                    if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                  
              
                    
                  
           
                
              this.repaint();
              switch(temp){
                 case 1: second=battle.checkBattle(monster[0]);break;
                 case 2: second=battle.checkBattle(monster[0],monster[1]);break;
                 case 3: second=battle.checkBattle(monster[0],monster[1],monster[2]);break;
             } 
               if(second!=1) second=battle.checkBattle(player);
               if(second==1&&player.hpp!=0){                                        //战斗胜利
                 switch(temp){
                 case 1: battle.getExp(monster[0], player);break;
                 case 2: battle.getExp(monster[0],monster[1], player);break;
                 case 3: battle.getExp(monster[0],monster[1],monster[2], player);break;
             }  
                 this.repaint();
                  switch(temp){
                 case 1: battle.fallItem(monster[0],player);break;
                 case 2: battle.fallItem(monster[0],monster[1],player);break;
                 case 3: battle.fallItem(monster[0],monster[1],monster[2],player);break;
                 } 
                 new Textdialog("战斗结束");
                 for(int i = 0;i<3;i++){
                     if(player.xpp>=player.xp)
                     new Textdialog(player.levelup(player.xp, player.xpp));
                 }
                  this.dispose();
               } 
 }      
       
    if(e.getActionCommand().equals("使用道具")){
               Choosedialog choose = new Choosedialog(player);
           
                if(temp==3&&battle.checkSpeedd(player, monster[0], monster[1], monster[2])==1)
                	first=2;
                if(temp==2&&battle.checkSpeedd(player, monster[0], monster[1])==1)
                	first=1;
                if(temp==1&&battle.checkSpeedd(player, monster[0])==1)
                	first=0;
                if(first==1||first==2||first==0){
                player.item[choose.getN()].useItem(player);
                   if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts( player,monster[choose.getN()]);
                            repaint();
                           
                        }
                        if(temp==3){
                            battle.attracts( player,monster[choose.getN()]);
                            repaint();
                           
                        }
                        this.repaint();
                         repaint();
                        }
              
                      if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        this.repaint();
                        player.item[choose.getN()].useItem(player);  
             
    }
        if(e.getActionCommand().equals("使用武功")){
           Choosedialog choose = new Choosedialog(player.skill ,10);
           
           Choosedialog choose1 = new Choosedialog(monster ,temp);
     
           
                if(temp==3&&battle.checkSpeedd(player, monster[0], monster[1], monster[2])==1)
                	first=2;
                if(temp==2&&battle.checkSpeedd(player, monster[0], monster[1])==1)
                	first=1;
                if(temp==1&&battle.checkSpeedd(player, monster[0])==1)
                	first=0;
                
                
                if(first==1||first==2||first==0){
           if(temp==1)
        	   battle.useskill(player.skill[choose.getN()], player, monster[0], choose1.getN()+1);     
           if(temp==2)
        	   battle.useskill(player.skill[choose.getN()], player, monster[0], monster[1], choose1.getN()+1);     
           if(temp==3)
        	   battle.useskill(player.skill[choose.getN()], player, monster[0], monster[1], monster[2], choose1.getN()+1);
                 
           this.repaint();
                        if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        this.repaint();
                }
                else{
               if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        this.repaint();
                            if(temp==1)battle.useskill(player.skill[choose.getN()], player, monster[0], choose1.getN()+1);     
                            if(temp==2)battle.useskill(player.skill[choose.getN()], player, monster[0], monster[1], choose1.getN()+1);     
                            if(temp==3)battle.useskill(player.skill[choose.getN()], player, monster[0], monster[1], monster[2], choose1.getN()+1);
                 
                            this.repaint();
                }
           
             
                 switch(temp){
                 case 1: second=battle.checkBattle(monster[0]);break;
                 case 2: second=battle.checkBattle(monster[0],monster[1]);break;
                 case 3: second=battle.checkBattle(monster[0],monster[1],monster[2]);
             } 
                if(second!=1) second=battle.checkBattle(player);
               if(second==1&&player.hpp!=0){
                 switch(temp){
                 case 1: battle.getExp(monster[0], player);break;
                 case 2: battle.getExp(monster[0],monster[1], player);break;
                 case 3: battle.getExp(monster[0],monster[1],monster[2], player);
             }  
                 
                  panel1.repaint();
                  panel2.repaint();
                 switch(temp){
                 case 1: battle.fallItem(monster[0],player);break;
                 case 2: battle.fallItem(monster[0],monster[1],player);break;
                 case 3: battle.fallItem(monster[0],monster[1],monster[2],player);break;
                 } 
                  
                 new Textdialog("战斗结束");
                 for(int i = 0;i<3;i++){
                     if(player.xpp>=player.xp)
                     new Textdialog(player.levelup(player.xp, player.xpp));
                 }
                 
               
              
                
                this.dispose();
             }  
        
    }
        if(e.getActionCommand().equals("逃跑")){
                if(temp==3&&battle.checkSpeedd(player, monster[0], monster[1], monster[2])==1)
                	first=2;
                if(temp==2&&battle.checkSpeedd(player, monster[0], monster[1])==1)
                	first=1;
                if(temp==1&&battle.checkSpeedd(player, monster[0])==1)
                	first=0;
                
                
                if(first==1||first==2||first==0){
                     if(battle.runAway(player, monster[0])==1){
                    second =1 ;
                    this.dispose();
                  }
                else{
                        if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        
                        if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                         
                        
                    }
                }
                else{
                     if(temp==1){
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        
                       if(temp==2){
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                       
                        if(temp==3){
                            battle.attracts(monster[temp-3], player);
                            repaint();
                            battle.attracts(monster[temp-2], player);
                            repaint();
                            battle.attracts(monster[temp-1], player);
                            repaint();
                        }
                        
                          if(battle.runAway(player, monster[0])==1){
                          second =1 ;
                          this.dispose();
                               }
                      }
        }
    }
                        
    public int getSecond(){
        return second;//判断战斗是否结束，若为1，则结束
    }
}
