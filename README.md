# myRpgGame
it is a small rpg game which is written by Java.


Fightdialog类（核心类）：继承自 JDialog类，实现了ActionListener接口（鼠标响应事件），与monster战斗的主界面；地图随机遇怪的构造方法

Gameframe： 继承自 JFrame类，实现了ActionListener接口，（鼠标响应事件），初始化游戏和关闭游戏

Homedialog ：extends javax.swing.JDialog，第一个场景家的主界面实现


incident:随机产生monster,getMonster()


Mappanel:地图类，键盘响应事件，使用【20】【20】数组填充地图


Statepanel：主角状态类，显示主角状态


Player： extends Character  主角类


Monster： extends Character  怪物类


skill类：初始化技能，使用技能。skillParticular(int serialNumber)，skillToMonster(Monster monster , Player player)，useSkill（）；

程序从test.java开始执行
