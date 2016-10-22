package demo;

public class incident {
//每次遇到的monster都是随机产生
    public static Monster getMonster(){
        Monster monster = new Monster((int)(Math.random()*31+1));//monster编号1-31，在txt文件里
        return monster;
    }
}
