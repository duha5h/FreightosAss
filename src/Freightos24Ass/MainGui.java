/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Freightos24Ass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dodu_
 */
public class MainGui extends javax.swing.JFrame {

    /**
     * Creates new form MainGui
     */
    JFileChooser file;
    BufferedReader in;
    
    public MainGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        open = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        test = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextPane();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        open.setText("Open File");
        open.setFocusable(false);
        open.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        open.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jToolBar1.add(open);
        jToolBar1.add(jLabel1);

        test.setText("Test");
        test.setFocusable(false);
        test.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        test.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        jToolBar1.add(test);

        result.setEditable(false);
        jScrollPane3.setViewportView(result);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        file = new JFileChooser();
        file.setDialogTitle("File in Computer");
        file.setAcceptAllFileFilterUsed(true);
        file.setCurrentDirectory(new File("C:\\Users\\soFTech\\Desktop"));
        open();
    }//GEN-LAST:event_openActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        // TODO add your handling code here:
        float min = Integer.MAX_VALUE, max = 0;
        for (Truck truck : trucks) {
            if(truck.getTotalWeight() > max){
                max = truck.getTotalWeight();
            }
            
            if(truck.getTotalWeight() < min){
                min = truck.getTotalWeight();
            }
            
            if(truck.getTotalVolume() > 100){
                 JOptionPane.showMessageDialog(this,
                         "The volume of truck must be less than 100, but it is " + truck.getTotalVolume(), 
                         "Problem",
                    0);
                 System.exit(0);
            }
        }
        
            JOptionPane.showMessageDialog(this,
                         "All trucks has a volume less than 100, good job", 
                         "",
                    1);
            
            for (Box box : boxes) {
            if(box.getTruck() == -1 || box.getTruck() >= 100){
                 JOptionPane.showMessageDialog(this,
                         "This box is assigned to invalid truck", 
                         "Problem",
                    0);
                 System.exit(0);
            }
        }
        
            JOptionPane.showMessageDialog(this,
                         "All the boxes are assigned to valid trucks, good job", 
                         "",
                    1);
            
    }//GEN-LAST:event_testActionPerformed

    private void open() {
        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            open(file.getSelectedFile());
        }
    }

    Box[] boxes;
    LinkedList[] ranges = new LinkedList[10];
    Truck[] trucks = new Truck[100];
    private void open(File file) {
        try {

            for (int i = 0; i < ranges.length; i++) {
                ranges[i] = new LinkedList();
            }
            
            for (int i = 0; i < trucks.length; i++) {
                trucks[i] = new Truck();
            }
            
            in = new BufferedReader(new FileReader(file));
            int boxCount;
            boxCount = Integer.parseInt(in.readLine());
            boxes = new Box[boxCount];
            String str = "";
            int i = 0;
            while ((str = in.readLine()) != null) {
                String[] temp = str.split(" ");
		boxes[i] = new Box(Float.parseFloat(temp[1]), Float.parseFloat(temp[0]));  
                i++;
            }
            
            for (int j = 0; j < boxes.length; j++) {
                if(boxes[j].getWeight()> 0 && boxes[j].getWeight() < 10){
                    ranges[0].add(j);
                }else if(boxes[j].getWeight()>= 10 && boxes[j].getWeight() < 20){
                    ranges[1].add(j);
                }else if(boxes[j].getWeight()>= 20 && boxes[j].getWeight() < 30){
                    ranges[2].add(j);
                }else if(boxes[j].getWeight()>= 30 && boxes[j].getWeight() < 40){
                    ranges[3].add(j);
                }else if(boxes[j].getWeight()>= 40 && boxes[j].getWeight() < 50){
                    ranges[4].add(j);
                }else if(boxes[j].getWeight()>= 50 && boxes[j].getWeight() <60){
                    ranges[5].add(j);
                }else if(boxes[j].getWeight()>= 60 && boxes[j].getWeight() < 70){
                    ranges[6].add(j);
                }else if(boxes[j].getWeight()>= 70 && boxes[j].getWeight() < 80){
                    ranges[7].add(j);
                }else if(boxes[j].getWeight()>= 80 && boxes[j].getWeight() < 90){
                    ranges[8].add(j);
                }else if(boxes[j].getWeight()>= 90 && boxes[j].getWeight() < 100){
                    ranges[9].add(j);
                }
            }
            
            int currTruck = 0;
            for (LinkedList range : ranges) {
                for (int j = 0; j < range.size(); j++) {
                    int tempIndex = (Integer) range.get(j);
                    while(true){
                    if((trucks[currTruck].getTotalVolume() + boxes[tempIndex].getVolume()) <= 100){
                        trucks[currTruck].getBoxes().add(boxes[tempIndex]);
                        trucks[currTruck].setTotalWeight((trucks[currTruck].getTotalWeight()
                                + boxes[tempIndex].getWeight()));
                        trucks[currTruck].setTotalVolume((trucks[currTruck].getTotalVolume()
                                + boxes[tempIndex].getVolume()));
                        boxes[tempIndex].setTruck(currTruck);
                        if(currTruck >= trucks.length - 1){
                            currTruck = 0;
                        } else{
                            currTruck++;
                        }                      
                        break;
                    } else{
                        if(currTruck >= trucks.length - 1){
                            currTruck = 0;
                        } else{
                            currTruck++;
                        }
                    }
                    }
                }
            }
            
            StringBuilder result = new StringBuilder();
            
            for (Box boxe : boxes) {
                result.append(boxe.getTruck()).append(" ");
            }
            
            this.result.setText(result.toString());
            
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot open file", "Problem",
                    0);

        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton open;
    private javax.swing.JTextPane result;
    private javax.swing.JButton test;
    // End of variables declaration//GEN-END:variables

}
