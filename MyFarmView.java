import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.Color;

// MyFarmView is all about the GUI
public class MyFarmView {
   private JFrame main; 
   private JLabel name, coins, xp, rank, level;
   private JButton[][] tiles;
   private JPanel upperPanel, farmland;
   
  public MyFarmView() {
   this.main = new JFrame("Farming Simulator Rip-Off"); // main GUI
     
   this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when program exits, GUI closes
   this.main.setLayout(new BorderLayout(15, 15)); // setting layout to 
   this.main.setSize(1000, 1000); // adjust if needed 
   
   this.name = new JLabel("Name: "); // name of farmer
   this.coins = new JLabel("Coins: "); // coin count
   this.xp = new JLabel("XP: "): // xp count
   this.rank = new JLabel("Rank: "); // farmer rank
   this.level = new JLabel("Level: "); // farmer level
     
   this.upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT), BorderLayout.NORTH);
   this.upperPanel.setPreferredSize(150, 150);
   this.upperPanel.add(this.name);
   this.upperPanel.add(this.coins);
   this.upperPanel.add(this.xp);
   this.upperPanel.add(this.rank);
   this.upperPanel.add(this.level);
     
   this.farmland = new JPanel(new GridLayout(10, 5, 5, 5), BorderLayout.CENTER);
   this.farmland.setPreferredSize(700, 700);
   farmland.setBackground(Color.LIGHT_GRAY);
   // first 2 numbers in GridLayout is the grid itself, last 2 are the spacings between each grid
   int i, j;
   for(i = 0; i < 10; i++) {
      for(j = 0; j < 5; j++) {
         this.tiles[i][j] = new Button();
         this.tiles[i][j].setBackground(new Color(#90EE90));
         farmland.add(this.tiles[i][j]);
      }
   }
     
   this.main.add(upperPanel);
   this.main.add(farmland);
     
   this.main.setVisible(true);
  }
}

