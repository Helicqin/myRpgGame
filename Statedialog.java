/*
 * Statedialog1.java
 *
 * Created on 2008年10月24日, 下午11:35
 */

package demo;

import javax.swing.WindowConstants;

/**
 *
 * @author  Administrator
 */
public class Statedialog extends javax.swing.JDialog {

    Player player;
    int close = 0;
    
    public Statedialog(Player player) {
        
       
        
        this.player = player;
        initComponents();
        
        this.setBounds(100, 100, 600, 600);
        this.setTitle("人物状态");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statepanel = new Statepanel(player);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout statepanelLayout = new javax.swing.GroupLayout(statepanel);
        statepanel.setLayout(statepanelLayout);
        statepanelLayout.setHorizontalGroup(
            statepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        statepanelLayout.setVerticalGroup(
            statepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );

        jLabel1.setText("  物品");

        jLabel2.setText("  装备");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {player.item[0].name , player.item[1].name ,player.item[2].name ,player.item[3].name ,player.item[4].name
                ,player.item[5].name ,player.item[6].name ,player.item[7].name ,player.item[8].name ,player.item[9].name
                ,player.item[10].name ,player.item[11].name ,player.item[12].name ,player.item[13].name ,player.item[14].name
                ,player.item[15].name ,player.item[16].name ,player.item[17].name ,player.item[18].name ,player.item[19].name };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("武功");

        jButton1.setText("关闭菜单");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("使用物品");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("装备");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("使用武功");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {player.equipment[0].name ,player.equipment[1].name ,player.equipment[2].name ,player.equipment[3].name ,
                player.equipment[4].name,player.equipment[5].name,player.equipment[6].name,player.equipment[7].name,
                player.equipment[8].name,player.equipment[9].name};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {player.skill[0].name ,player.skill[1].name ,player.skill[2].name ,player.skill[3].name ,
                player.skill[4].name,player.skill[5].name,player.skill[6].name,player.skill[7].name,
                player.skill[8].name,player.skill[9].name};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList3ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel4.setFont(new java.awt.Font("黑体", 1, 36));
        jLabel4.setText("菜单");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
     this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    //状态面板重画
    if(jList1.getSelectedIndex()==-1)return;
    player.item[jList1.getSelectedIndex()].useItem(player);
    player.ite[jList1.getSelectedIndex()]=1;
    statepanel.repaint();
    
    //道具面板重画
    jList1.setModel(new javax.swing.AbstractListModel() {
    String[] strings = {player.item[0].name , player.item[1].name ,player.item[2].name ,player.item[3].name ,player.item[4].name
        ,player.item[5].name ,player.item[6].name ,player.item[7].name ,player.item[8].name ,player.item[9].name
        ,player.item[10].name ,player.item[11].name ,player.item[12].name ,player.item[13].name ,player.item[14].name
        ,player.item[15].name ,player.item[16].name ,player.item[17].name ,player.item[18].name ,player.item[19].name };
    public int getSize() { return strings.length; }
    public Object getElementAt(int i) { return strings[i]; }
});
   jList1.repaint();
    
}//GEN-LAST:event_jButton2ActionPerformed

private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
// TODO add your handling code here:
    if(jList1.getSelectedIndex()==-1)return;
    jTextArea1.setText(player.item[jList1.getSelectedIndex()].definition+"\n"
            +"加血 "+player.item[jList1.getSelectedIndex()].hp+"\n"
            +"加内力 "+player.item[jList1.getSelectedIndex()].mp);
}//GEN-LAST:event_jList1ValueChanged

private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
// TODO add your handling code here:
    jTextArea1.setText(player.equipment[jList2.getSelectedIndex()].definition+"\n"
            +"加外功 "+player.equipment[jList2.getSelectedIndex()].attact+"\n"
            +"加防守 "+player.equipment[jList2.getSelectedIndex()].defence+"\n"
            +"加速度 "+player.equipment[jList2.getSelectedIndex()].speed);
}//GEN-LAST:event_jList2ValueChanged

private void jList3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList3ValueChanged
// TODO add your handling code here:
    if(player.skill[jList3.getSelectedIndex()].area==1)
    jTextArea1.setText(player.skill[jList3.getSelectedIndex()].defi+"\n"
            +"加攻击力 "+player.skill[jList3.getSelectedIndex()].attactt+"\n"
            +"加防守 "+player.skill[jList3.getSelectedIndex()].defencee+"\n"
            +"加速度 "+player.skill[jList3.getSelectedIndex()].speedd+"\n"
            +"范围攻击\n"
            +"加/减血 "+player.skill[jList3.getSelectedIndex()].hpp+"\n"
            +"消耗内力 "+player.skill[jList3.getSelectedIndex()].mpp+"*N个动物\n");
    else jTextArea1.setText(player.skill[jList3.getSelectedIndex()].defi+"\n"
            +"加攻击力 "+player.skill[jList3.getSelectedIndex()].attactt+"\n"
            +"加防守 "+player.skill[jList3.getSelectedIndex()].defencee+"\n"
            +"加速度 "+player.skill[jList3.getSelectedIndex()].speedd+"\n"
            +"个体攻击\n"
            +"加/减血 "+player.skill[jList3.getSelectedIndex()].hpp+"\n"
            +"消耗内力 "+player.skill[jList3.getSelectedIndex()].mpp+"\n");
}//GEN-LAST:event_jList3ValueChanged

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    if(jList2.getSelectedIndex()==-1)return;
    if(player.equipment[jList2.getSelectedIndex()].name.equals("空"))return;
    player.equipment[jList2.getSelectedIndex()].useEquipment(player,jList2.getSelectedIndex());
    statepanel.repaint();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    if(jList3.getSelectedIndex()==-1)return;
    player.skill[jList3.getSelectedIndex()].useSkill(new Monster(), player);
    statepanel.repaint();
}//GEN-LAST:event_jButton4ActionPerformed

public int getClose(){
    this.dispose();
    return close;
}
    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel statepanel;
    // End of variables declaration//GEN-END:variables

}