/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;


public class Battle {
     String definition;
     String definition2=" ";//  definition2 = player.name + "体力不支退出战斗\n"; 
    // Monster[] monster =new Monster[3];
     
     int aim;//判断被攻击的怪物
    //战斗属性初始化
    public void battleBegin(Player player){
        player.attactt = player.attact;
        player.defencee = player.defence;
        player.speedd = player.speed;
        player.state = 0;
    }
    

    
    //战斗结束后获得经验值 和 金钱,三个重载函数分别对应3,2,1个怪兽
    public void getExp(Monster monster,Monster monster2,Monster monster3,Player player){
        int temp =(int)((monster.strength + monster.intelligence + monster.speed +monster.level+
                monster2.strength + monster2.intelligence + monster2.speed +monster2.level+
                monster3.strength + monster3.intelligence + monster3.speed+monster3.level)*(Math.random()+0.5)) ;
        player.xpp+=temp;
        int temp2 = (int)((monster.strength + monster.intelligence + monster.speed +monster.level+
                monster2.strength + monster2.intelligence + monster2.speed +monster2.level+
                monster3.strength + monster3.intelligence + monster3.speed+monster3.level)*(Math.random()+0.5)) ;
        player.money+=temp2;
        new Textdialog(player.name+"获得经验 "+ temp + " 获得金钱 "+temp2);
    } 
     public void getExp(Monster monster,Monster monster2,Player player){
        int temp =(int)((monster.strength + monster.intelligence + monster.speed +monster.level+
                monster2.strength + monster2.intelligence + monster2.speed+monster2.level)*(Math.random()+0.4)) ;
        player.xpp+=temp;
        int temp2 = (int)((monster.strength + monster.intelligence + monster.speed +monster.level+
                monster2.strength + monster2.intelligence + monster2.speed +monster2.level)*(Math.random()+0.4)) ;
        player.money+=temp2;
        new Textdialog(player.name+"获得经验 "+ temp + " 获得金钱 "+temp2);
    } 
     public void getExp(Monster monster,Player player){
        int temp =(int)((monster.strength + monster.intelligence + monster.speed+monster.level )*(Math.random()+0.3)) ;
        player.xpp+=temp;
        int temp2 = (int)((monster.strength + monster.intelligence + monster.speed)*(Math.random()+0.3)) ;
        player.money+=temp2;
        new Textdialog(player.name+"获得经验 "+ temp +  "获得金钱 "+temp2);
                
    } 
    
    
    //判定战斗是否结束，此为多个主角的扩展功能
     
 /*   public int checkBattle(Player player,Player player2,Player player3){
        if(player.hpp==0&&player2.hpp==0&&player3.hpp==0)
        	return 1;
        else 
        	return 0;   
   }
    public int checkBattle(Player player,Player player2){
        if(player.hpp==0&&player2.hpp==0)
        	return 1;
        else 
        	return 0;   
   }
  */
    public int checkBattle(Player player){
        if(player.hpp==0)
        	return 1;
        else 
        	return 0;   
   }
    public int checkBattle(Monster player,Monster player2,Monster player3){
        if(player.hpp==0&&player2.hpp==0&&player3.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Monster player,Monster player2){
        if(player.hpp==0&&player2.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Monster player){
        if(player.hpp==0)return 1;
        else return 0;   
   }

    
    //判定物体是否能还有攻击的能力
    public int checkAction(Player player){
        if(player.hpp==0)
        	return 1;
        return 0;
    }
     public int checkAction(Monster monster){
        if(monster.hpp==0)
        	return 1;
        return 0;
    }
     
    //判定character是否被打倒
    public int checkHp(Player player){
        if(player.hpp<=0) {
            player.hpp = 0 ;
            definition2 = player.name + "体力不支退出战斗\n"; 
            new Textdialog(definition2);//  definition2 = player.name + "体力不支,退出战斗\n"; 
            return 1;
        }
        else definition2="";return 0;
    }
    
    public int checkHp(Monster monster){
        if(monster.hpp <=0) {
            monster.hpp = 0 ;
            definition2 ="恭喜"+ monster.name + ",被你打倒了\n";
            new Textdialog(definition2);
            return 1;
        }
        else definition2="";return 0;
    }
    
    //人物普通攻击输出 可能被怪物回避
    
    //人物攻击力计算公式    double damage = attack(Math.random()+0.8);
   public void attracts(Player player,Monster monster){
	   
       if(checkAction(player)==1)
       { 
    	   new Textdialog("体力不支，快逃跑吧！");
    	}
       double temp = player.speedd - monster.speedd;//判断是否能够逃跑
       //double l=player.level-monster.level;后期加入等级判断
      
       if(temp <0&&Math.random()<0.3)
       { 
    	 definition = monster.name+"躲避了"+player.name+"的攻击\n";
         new Textdialog(definition); 
       }
       if(temp >=0&& Math.random()<0.1)
       { 
    	 definition = monster.name+"躲避了"+player.name+"的攻击\n";
         new Textdialog(definition);
       }
       int tmp = (int)(player.attactt*(Math.random()+0.8)-monster.defencee * (Math.random()+0.5));//人物对怪兽造成的伤害值
       if(tmp<=0) 
    	   tmp=1;//最低伤害为1
       monster.hpp -= tmp;
       //new Music("攻击.au");
       definition = player.name + "对"+monster.name+"造成了  " + tmp +"  点伤害\n";
       new Textdialog(definition);    
       checkHp(monster);
   } 
      //怪物攻击计算公式
     public void attracts(Monster monster , Player player){
       if(checkAction(monster)==1) return ;
       double temp = monster.speedd -player.speedd;
      
       if(temp <0&& Math.random()<0.7){ definition = player.name+"躲避了"+monster.name+"的攻击\n";
           new Textdialog(definition);return;
       }
       if(temp >=0&& Math.random()>0.7){ definition = player.name+"躲避了"+monster.name+"的攻击\n";
           new Textdialog(definition);return;
       }
       int tmp = (int)(monster.attactt * 1.5 * (Math.random()+0.5)-monster.defencee);
       if(tmp<=0)tmp=1;
       player.hpp -= tmp;
       //new Music("攻击.au");
       definition = monster.name + "对"+player.name+"造成了  " + tmp +"  点伤害\n";
       new Textdialog(definition); 
       checkHp(player);
   } 
    //人物释放技能 
     public void useskill(Skill skill ,Player player, Monster monster1 , int i){
            if(checkAction(player)==1) return ;
           if(skill.area==0){
             switch(i){
             case 1: skill.useSkill(monster1,player);
             definition = player.name + "使用" +skill.name + "  对"+ monster1.name+ "造成了:  "+skill.definition  ;break;
             
         }   
            new Textdialog(definition);
            checkHp(monster1);
             
          }
          if(skill.area==1){
           skill.useSkill(monster1, player);
           definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition;
           new Textdialog(definition);
           checkHp(monster1);
           
          }
      }
     public void useskill(Skill skill ,Player player, Monster monster1 ,Monster monster2, int i){
         if(checkAction(player)==1) return ;
         if(skill.area==0){
             switch(i){
             case 1: skill.useSkill(monster1,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  "+skill.definition  ;break;
             case 2: skill.useSkill(monster2,player);definition = player.name + "使用" +skill.name + "  对"+ monster2.name +"造成了:  "+skill.definition  ;break;
         }   
            new Textdialog(definition);
            checkHp(monster1);
            checkHp(monster2); 
          }
          if(skill.area==1){
           skill.useSkill(monster1, monster2, player);
           definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition+ "  对"+ monster2.name +"造成了:  "+skill.definition ;
           new Textdialog(definition);
           checkHp(monster1);
           checkHp(monster2);
          }
     }
     public void useskill(Skill skill ,Player player, Monster monster1 ,Monster monster2 ,Monster monster3,int i){
         if(checkAction(player)==1) return ;
       if(skill.area==0){
             switch(i){
             case 1: skill.useSkill(monster1,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  "+skill.definition  ;break;
             case 2: skill.useSkill(monster2,player);definition = player.name + "使用" +skill.name + "  对"+ monster2.name +"造成了:  "+skill.definition  ;break;
             case 3: skill.useSkill(monster3,player);definition = player.name + "使用" +skill.name + "  对"+ monster3.name +"造成了:  "+skill.definition  ;break;
         }    
        new Textdialog(definition);
        checkHp(monster1);
        checkHp(monster2);
        checkHp(monster3);
       }
       if(skill.area==1){
           skill.useSkill(monster1, monster2, monster3,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition+ "  对"+ monster2.name +"造成了:  " +skill.definition+ "  对"+ monster3.name +"造成了:  "+skill.definition;
        new Textdialog(definition);
        checkHp(monster1);
        checkHp(monster2);
        checkHp(monster3);
       }
      
       
        
     }
    //怪物释放技能,扩展功能
      public void useskill(Skill skill , Monster monster , Player player1 ,int i){
          if(checkAction(monster)==1) return ;
       if(skill.area==0){
         switch(i){
           case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
           
         }     
        new Textdialog(definition);
        checkHp(player1);
     
       }
       if(skill.area==1){
           skill.useSkill(player1, monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  " +skill.definition;
          
        new Textdialog(definition);
        checkHp(player1);
       
       }  
     
}
       public void useskill(Skill skill , Monster monster , Player player1 ,Player player2 ,Player player3,int i){
           if(checkAction(monster)==1) return ;
       if(skill.area==0){
         switch(i){
           case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
           case 2: skill.useSkill(player2,monster);definition = monster.name + "使用" +skill.name + "  对"+ player2.name +"造成了:  "+skill.definition  ;break;
           case 3: skill.useSkill(player3,monster);definition = monster.name + "使用" +skill.name + "  对"+ player3.name +"造成了:  "+skill.definition  ;break;
         }     
        new Textdialog(definition);
        checkHp(player1);
        checkHp(player2);
        checkHp(player3);
       }
       if(skill.area==1){
           skill.useSkill(player1, player2, player3,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"   造成了:    " +skill.definition+ "  对"+ player2.name +"造成了:  "+skill.definition + "  对"+ player3.name +"造成了:  "+skill.definition;
          
        new Textdialog(definition);
        checkHp(player1);
        checkHp(player2);
        checkHp(player3);
       }  
     
}
     public void useskill(Skill skill , Monster monster , Player player1 ,Player player2 ,int i){
         if(checkAction(monster)==1) return ;
       if(skill.area==0){
         switch(i){
           case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
           case 2: skill.useSkill(player2,monster);definition = monster.name + "使用" +skill.name + "  对"+ player2.name +"造成了:  "+skill.definition  ;break;
           
         }     
        new Textdialog(definition);
        checkHp(player1);
        checkHp(player2);
        
       }
       if(skill.area==1){
           skill.useSkill(player1, player2, monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  " +skill.definition+ "  对"+ player2.name +"造成了:  "+skill.definition ;
          
        new Textdialog(definition);
        checkHp(player1);
        checkHp(player2);
        
       }  
     
}
     
     public int runAway(Player player,Monster monster){
          
          
        double temp = (player.speedd - monster.speedd)*Math.random();
        if(temp <0&& Math.random() < 0.7){ 
        	
        		definition = "逃跑成功";player.money-=50;
        	  if(player.money<0)  player.money=0;
        	    new Textdialog(definition+",损失金钱50两");
                 return 1; 
       }
       if(temp >=0&& Math.random() >0.7){ 
    	
    	   definition = "逃跑成功";player.money-=50;
    	   if(player.money<0) player.money=0;
    	   new Textdialog(definition+",损失金钱50两");
    	   return 1;
       }
       new Textdialog("逃跑失败");
         return 0;//逃跑失败
       
     }
     
    //速度比较
     public int checkSpeedd(Player player,Monster monster1,Monster monster2,Monster monster3){
              if(player.speedd>=monster1.speedd&&player.speedd>=monster2.speedd&&player.speedd>=monster3.speedd)
                         return 1;
              return 0;
     }
     public int checkSpeedd(Player player,Monster monster1,Monster monster2){
              if(player.speedd>=monster1.speedd&&player.speedd>=monster2.speedd)
                          return 1;
              return 0;
     }
     public int checkSpeedd(Player player,Monster monster1){
              if(player.speedd>=monster1.speedd)
                          return 1;
              return 0;
     }
     //打赢monster后可能会掉落道具
     public int fallItem(Monster monster,Player player){
         if(Math.random()>=0.8){
              player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
         }
         return 0;
     }
     public int fallItem(Monster monster,Monster monster2,Player player){
         if(Math.random()>=0.6){
             player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
         }
         return 0;
     }
     public void fallItem(Monster monster,Monster monster2,Monster monster3,Player player){
         if(Math.random()>=0.4){
             player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
         }
       
     }
     
}
