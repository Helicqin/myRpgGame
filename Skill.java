/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.StringTokenizer;


public class Skill {
     
     int serialNumber;//文本记录数，技能的序号
     String defi;//技能说明
     String definition;
     String definitionHpp;
     String definitionMpp;
     String definitionSpeedd;
     String definitionAttactt;
     String definitionDefencee;;
     String name ;
     int hpp;
     int mpp;
     int speedd;
     int attactt;
     int defencee;
     int area;//技能作用范围。单体或者全体
    
     public Skill(int serialNumber){
         skillParticular(serialNumber) ;
      }
     
    //从文件得到技能信息 
     public void skillParticular(int serialNumber){
         try{
                BufferedReader input;
   /*Reads text from a character-input stream, buffering characters so as to provide 
    * for the efficient reading of characters, arrays, and lines. */      
                FileReader reader=  new FileReader("./util/Skill.txt");// 创建输入流
                input=new BufferedReader(reader);
                for(int i=0;i<serialNumber;i++)
                	input.readLine();

                
 /*The following is one example of the use of the tokenizer. The code: 

     StringTokenizer st = new StringTokenizer("this is a test");
     while (st.hasMoreTokens()) {
         System.out.println(st.nextToken());
     }
 prints the following output: 
     this
     is
     a
     test
 */
                 StringTokenizer intro = new StringTokenizer(input.readLine()," ");//以空格作为分隔符
                 intro.nextToken();
                 area = Integer.parseInt(intro.nextToken());
                 //System.out.println("this is area");System.out.println(area);
                 name = intro.nextToken();
                 hpp = Integer.parseInt(intro.nextToken());
                 //System.out.println(hpp);
                 mpp = Integer.parseInt(intro.nextToken());
                 speedd = Integer.parseInt(intro.nextToken());
                 attactt = Integer.parseInt(intro.nextToken());
                 defencee = Integer.parseInt(intro.nextToken());
                 defi=intro.nextToken();
                 reader.close();
                 input.close(); 
                 }catch (FileNotFoundException ex) {
                 }catch (IOException ex) {}
   }
     
     //怪物承受技能
     public void skillToMonster(Monster monster , Player player){
           
         monster.attactt+=this.attactt;
         if(attactt<0)
        	 definitionAttactt = "攻击力减少  "+Math.abs(this.attactt) + "\n";
         else if(attactt>0)
        	 definitionAttactt = "攻击力增加  "+this.attactt + "\n";
         else 
        	 definitionAttactt = "";
         
         monster.defencee+=this.defencee;
         if(defencee<0)
        	 definitionDefencee = "防御力减少  "+Math.abs(this.defencee) + "\n";
         else if(defencee>0)
        	 definitionDefencee = "防御力增加  "+this.defencee + "\n";
         else 
        	 definitionDefencee = "";
         
         if(hpp<0)
         {
        	 int temp =(int)(hpp*(Math.random()+0.5));
        	 monster.hpp+=temp;
             definitionHpp = "HP减少  "+Math.abs(temp) + "\n";
         }
         else if(hpp>0)
         {
        	 int temp =(int)(hpp*(Math.random()+0.5));
        	 monster.hpp+=temp;
        	 definitionHpp = "HP回复  "+ temp + "\n";
         }
         else 
        	 definitionHpp = "";
         player.mpp-=this.mpp ;
         if(this.mpp>0)
        	 definitionMpp = "消耗MP  "+this.mpp + "\n";
         monster.speedd+=this.speedd;
         if(speedd<0)
        	 definitionSpeedd = "速度降低  "+Math.abs(this.speedd) + "\n";
         else if(speedd>0)
        	 definitionSpeedd = "速度提升  "+this.speedd + "\n";
         else
        	 definitionSpeedd = "";
         definition = definitionAttactt+"  "+ definitionDefencee +"  "+ definitionHpp +"  "
         + definitionMpp+"  " + definitionSpeedd ;
      }
     
      public void useSkill(Monster monster , Player player){
           if(player.mpp<=this.mpp){
             new Textdialog("少侠内力不足，无法使用技能");
             definition="无效果";
             return;
            }
         skillToMonster(monster,player);
     }
     public void useSkill(Monster monster1 ,Monster monster2 , Player player){
          if(player.mpp<=this.mpp*2){
             new Textdialog("少侠内力不足，无法使用技能");
             definition="无效果";
             return;
            }
          skillToMonster(monster1,player);
          skillToMonster(monster2,player);
      }
     public void useSkill(Monster monster1,Monster monster2,Monster monster3 , Player player){
          if(player.mpp<=this.mpp*3){
             new Textdialog("少侠内力不足，无法使用技能");
             definition="无效果";
             return;
            }
         skillToMonster(monster1,player);
         skillToMonster(monster2,player);
         skillToMonster(monster3,player);
    }
/*     public void miss(){
         
     }
 */   
     //人物承受技能,扩展功能
     public void skillToCharacter(Player player , Monster monster){
         if(monster.mpp<this.mpp){
             definition="无效果";
             return;       
         }
         player.attactt+=this.attactt;
          if(attactt<0)
        	  definitionAttactt = "攻击力减少  "+this.attactt + "\n";
         else if(attactt>0)
        	 definitionAttactt = "攻击力增加  "+this.attactt + "\n";
         else 
        	 definitionAttactt = "";
         player.defencee=this.defencee;
          if(defencee<0)
        	  definitionDefencee = "防御力减少  "+this.attactt + "\n";
         else if(defencee>0)
        	 definitionDefencee = "防御力增加  "+this.attactt + "\n";
         else 
        	 definitionDefencee = "";
         if(hpp<0)
         {
         int temp =(int)(hpp*(Math.random()+0.5));
         player.hpp+=temp;
         definitionHpp = "HP减少  "+ temp + "\n"; }
         else if(hpp>0){
        	 int temp =(int)(hpp*(Math.random()+0.5));
        	 player.hpp+=temp;
        	 definitionHpp = "自己HP回复  "+ temp + "\n"; }
         else 
        	 definitionHpp = "";
         monster.mpp-= this.mpp ;
         if(mpp<0)
        	 definitionMpp = "消耗MP  "+this.mpp + "\n";
         player.speedd+=this.speedd;
         if(speedd<0)
        	 definitionSpeedd = "速度降低  "+this.attactt + "\n";
         else if(speedd>0)
        	 definitionSpeedd = "速度提升  "+this.attactt + "\n";
         else definitionSpeedd = "";
         definition = definitionAttactt+"  " + definitionDefencee +"  "+ definitionHpp +"  "+ definitionMpp +"  "+ definitionSpeedd  ;
     }
     public void useSkill(Player player, Monster monster){
         skillToCharacter(player,monster);
     }
     public void useSkill(Player player1,Player player2,Monster monster){
         skillToCharacter(player1,monster);skillToCharacter(player2,monster);
     }
     public void useSkill(Player player1,Player player2,Player player3,Monster monster){
         skillToCharacter(player1,monster);skillToCharacter(player2,monster);skillToCharacter(player3,monster);
     }
}

