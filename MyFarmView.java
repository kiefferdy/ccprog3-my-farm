import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MyFarmView is all about the GUI
public class MyFarmView {
   private JFrame main;                                                             // main frame 
   private JLabel name, coins, xp, rank, level;                                     // user stats
   private JButton tiles[][];                                                       // farmland
   private JPanel upperPanel, farmland, lowerPanel, leftPanel, rightPanel;          // sections of the GUI
   private JButton registerRank, howToPlay, sleep, seedPrices, toolPrices;          // definitely useful buttons
   private JButton plow, wateringCan, fertilizer, pickaxe, shovel;                  // tool buttons
   private JButton turnip, carrot, potato, rose, tulip, sunflower, mango, apple;    // seed buttons
   
   public MyFarmView() {
      this.main = new JFrame("Farming Simulator Rip-Off"); // main GUI
      
      this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when program exits, GUI closes
      this.main.setLayout(new BorderLayout(15, 15)); // setting layout to BorderLayout so that components are easier to access
      this.main.setExtendedState(JFrame.MAXIMIZED_BOTH); // "fullscreen"
      
      // name of farmer
      this.name = new JLabel("   Name: "); 
      this.name.setFont(new Font("Cambria", Font.PLAIN, 14));

      // coin count
      this.coins = new JLabel("   Coins: "); // coin count
      this.coins.setFont(new Font("Cambria", Font.PLAIN, 14));

      // xp count
      this.xp = new JLabel("   XP: ");
      this.xp.setFont(new Font("Cambria", Font.PLAIN, 14));

      // farmer rank
      this.rank = new JLabel("   Rank: ");
      this.rank.setFont(new Font("Cambria", Font.PLAIN, 14));

      // farmer level
      this.level = new JLabel("   Level: ");
      this.level.setFont(new Font("Cambria", Font.PLAIN, 14));
      
      this.upperPanel = new JPanel(); // new panel for the upper part of the GUI
      this.upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS)); // setting layout of panel
      this.upperPanel.setPreferredSize(new Dimension(100, 100)); // preferred size of the panel
      this.upperPanel.add(this.name); // adding JLabel name
      this.upperPanel.add(this.coins); // adding JLabel coins
      this.upperPanel.add(this.xp);  // adding JLabel xp
      this.upperPanel.add(this.rank); // adding JLabel rank
      this.upperPanel.add(this.level); // adding JLabel level
      
      this.farmland = new JPanel(); // farmland panel
      this.farmland.setPreferredSize(new Dimension(700, 700)); // size of panel
      this.farmland.setLayout(new GridLayout(10, 5, 10, 10));
      this.farmland.setBackground(Color.LIGHT_GRAY);

      this.tiles = new JButton[10][5];
      for(int i = 0; i < 10; i++) {
         for(int j = 0; j < 5; j++) {
            this.tiles[i][j] = new JButton();
            this.tiles[i][j].setText("Tile");
            this.tiles[i][j].setBorder(BorderFactory.createEtchedBorder());
            this.tiles[i][j].setBackground(new Color(0x90EE90));
            this.tiles[i][j].addActionListener(null);
            this.tiles[i][j].setFocusable(false);
            this.tiles[i][j].setPreferredSize(new Dimension(50, 50));
            this.farmland.add(this.tiles[i][j]);
         }
      }
      
      // Lower Part of the GUI
      this.lowerPanel = new JPanel();
      this.lowerPanel.setPreferredSize(new Dimension(150, 100));
      this.lowerPanel.setLayout(new FlowLayout());

      // Button to Register for Rank
      this.registerRank = new JButton();
      this.registerRank.setText("RANK UP!");
      this.registerRank.setPreferredSize(new Dimension(100, 35));
      this.registerRank.setBorder(BorderFactory.createEtchedBorder());
      this.registerRank.setFocusable(false);

      // Button to see How To Play
      this.howToPlay = new JButton();
      this.howToPlay.setText("How To Play");
      this.howToPlay.setPreferredSize(new Dimension(100, 35));
      this.howToPlay.setBorder(BorderFactory.createEtchedBorder());
      this.howToPlay.setFocusable(false);

      // Button to sleep (advance to next day)
      this.sleep = new JButton();
      this.sleep.setText("Sleep");
      this.sleep.setPreferredSize(new Dimension(100, 35));
      this.sleep.setBorder(BorderFactory.createEtchedBorder());
      this.sleep.setFocusable(false);

      // adding components to the lower panel
      this.lowerPanel.add(this.howToPlay);
      this.lowerPanel.add(this.registerRank);
      this.lowerPanel.add(this.sleep);

      // ------------------------------- TOOLS ----------------------------------- //
      this.rightPanel = new JPanel();
      this.rightPanel.setPreferredSize(new Dimension(150, 600));
      this.rightPanel.setLayout(new FlowLayout());

      JLabel toolText = new JLabel();
      toolText.setText("TOOLS");
      toolText.setHorizontalTextPosition(JLabel.CENTER);
      toolText.setFont(new Font("Cambria", Font.BOLD, 30));

      // Plow
      this.plow = new JButton();
      this.plow.setText("Plow");
      this.plow.setPreferredSize(new Dimension(65, 60));
      this.plow.setIconTextGap(-3);
      this.plow.setVerticalTextPosition(JButton.BOTTOM);
      this.plow.setHorizontalTextPosition(JButton.CENTER);
      this.plow.setFocusable(false);
      this.plow.setBorder(BorderFactory.createEtchedBorder());
      this.plow.setIcon(new ImageIcon("Icons/Plow.png"));

      // Watering Can
      this.wateringCan = new JButton();
      this.wateringCan.setText("Watering Can");
      this.wateringCan.setPreferredSize(new Dimension(135, 60));
      this.wateringCan.setIconTextGap(-3);
      this.wateringCan.setVerticalTextPosition(JButton.BOTTOM);
      this.wateringCan.setHorizontalTextPosition(JButton.CENTER);
      this.wateringCan.setFocusable(false);
      this.wateringCan.setBorder(BorderFactory.createEtchedBorder());
      this.wateringCan.setIcon(new ImageIcon("Icons/WateringCan.png"));
      
      // Fertilizer
      this.fertilizer = new JButton();
      this.fertilizer.setText("Fertilizer");
      this.fertilizer.setPreferredSize(new Dimension(65, 60));
      this.fertilizer.setIconTextGap(-3);
      this.fertilizer.setVerticalTextPosition(JButton.BOTTOM);
      this.fertilizer.setHorizontalTextPosition(JButton.CENTER);
      this.fertilizer.setFocusable(false);
      this.fertilizer.setBorder(BorderFactory.createEtchedBorder());
      this.fertilizer.setIcon(new ImageIcon("Icons/Fertilizer.png"));

      // Pickaxe
      this.pickaxe = new JButton();
      this.pickaxe.setText("Pickaxe");
      this.pickaxe.setPreferredSize(new Dimension(65, 60));
      this.pickaxe.setIconTextGap(-3);
      this.pickaxe.setVerticalTextPosition(JButton.BOTTOM);
      this.pickaxe.setHorizontalTextPosition(JButton.CENTER);
      this.pickaxe.setFocusable(false);
      this.pickaxe.setBorder(BorderFactory.createEtchedBorder());
      this.pickaxe.setIcon(new ImageIcon("Icons/Pickaxe.png"));

      // Shovel
      this.shovel = new JButton();
      this.shovel.setText("Shovel");
      this.shovel.setPreferredSize(new Dimension(65, 60));
      this.shovel.setIconTextGap(-3);
      this.shovel.setVerticalTextPosition(JButton.BOTTOM);
      this.shovel.setHorizontalTextPosition(JButton.CENTER);
      this.shovel.setFocusable(false);
      this.shovel.setBorder(BorderFactory.createEtchedBorder());
      this.shovel.setIcon(new ImageIcon("Icons/Shovel.png"));

      this.toolPrices = new JButton();
      this.toolPrices.setText("Tool Price List");
      this.toolPrices.setPreferredSize(new Dimension(135, 60));
      this.toolPrices.setHorizontalTextPosition(JButton.CENTER);
      this.toolPrices.setFocusable(false);
      this.toolPrices.setBorder(BorderFactory.createEtchedBorder());

      // Adding components above to main panel
      this.rightPanel.add(toolText);
      this.rightPanel.add(plow);
      this.rightPanel.add(fertilizer);
      this.rightPanel.add(pickaxe);
      this.rightPanel.add(shovel);
      this.rightPanel.add(wateringCan);
      this.rightPanel.add(toolPrices);

      // ------------------------------- END OF TOOLS ----------------------------------- //

      // ------------------------------- SEEDS ----------------------------------- //
      this.leftPanel = new JPanel(); // panel for seeds
      this.leftPanel.setPreferredSize(new Dimension(150, 600)); //
      this.leftPanel.setLayout(new FlowLayout()); // set layout
      
      // Label for Seeds
      JLabel seedText = new JLabel();
      seedText.setText("SEEDS");
      seedText.setHorizontalTextPosition(JLabel.CENTER);
      seedText.setFont(new Font("Cambria", Font.BOLD, 30));

      // Turnip
      this.turnip = new JButton();
      this.turnip.setText("Turnip");
      this.turnip.setPreferredSize(new Dimension(65, 60));
      this.turnip.setIconTextGap(-3);
      this.turnip.setVerticalTextPosition(JButton.BOTTOM);
      this.turnip.setHorizontalTextPosition(JButton.CENTER);
      this.turnip.setFocusable(false);
      this.turnip.setBorder(BorderFactory.createEtchedBorder());
      this.turnip.setIcon(new ImageIcon("Icons/Turnip.png"));

      // Carrot
      this.carrot = new JButton();
      this.carrot.setText("Carrot");
      this.carrot.setPreferredSize(new Dimension(65, 60));
      this.carrot.setIconTextGap(-3);
      this.carrot.setVerticalTextPosition(JButton.BOTTOM);
      this.carrot.setHorizontalTextPosition(JButton.CENTER);
      this.carrot.setFocusable(false);
      this.carrot.setBorder(BorderFactory.createEtchedBorder());
      this.carrot.setIcon(new ImageIcon("Icons/Carrot.png"));

      // Potato
      this.potato = new JButton();
      this.potato.setText("Potato");
      this.potato.setPreferredSize(new Dimension(65, 60));
      this.potato.setIconTextGap(-3);
      this.potato.setVerticalTextPosition(JButton.BOTTOM);
      this.potato.setHorizontalTextPosition(JButton.CENTER);
      this.potato.setFocusable(false);
      this.potato.setBorder(BorderFactory.createEtchedBorder());
      this.potato.setIcon(new ImageIcon("Icons/Potato.png"));

      // Rose
      this.rose = new JButton();
      this.rose.setText("Rose");
      this.rose.setPreferredSize(new Dimension(65, 60));
      this.rose.setIconTextGap(-3);
      this.rose.setVerticalTextPosition(JButton.BOTTOM);
      this.rose.setHorizontalTextPosition(JButton.CENTER);
      this.rose.setFocusable(false);
      this.rose.setBorder(BorderFactory.createEtchedBorder());
      this.rose.setIcon(new ImageIcon("Icons/Rose.png"));

      // Tulip
      this.tulip = new JButton();
      this.tulip.setText("Tulip");
      this.tulip.setPreferredSize(new Dimension(65, 60));
      this.tulip.setIconTextGap(-3);
      this.tulip.setVerticalTextPosition(JButton.BOTTOM);
      this.tulip.setHorizontalTextPosition(JButton.CENTER);
      this.tulip.setFocusable(false);
      this.tulip.setBorder(BorderFactory.createEtchedBorder());
      this.tulip.setIcon(new ImageIcon("Icons/Tulip.png"));

      // Sunflower
      this.sunflower = new JButton();
      this.sunflower.setText("Sunflower");
      this.sunflower.setPreferredSize(new Dimension(65, 60));
      this.sunflower.setIconTextGap(-3);
      this.sunflower.setVerticalTextPosition(JButton.BOTTOM);
      this.sunflower.setHorizontalTextPosition(JButton.CENTER);
      this.sunflower.setFocusable(false);
      this.sunflower.setBorder(BorderFactory.createEtchedBorder());
      this.sunflower.setIcon(new ImageIcon("Icons/Sunflower.png"));

      // Mango
      this.mango = new JButton();
      this.mango.setText("Mango");
      this.mango.setPreferredSize(new Dimension(65, 60));
      this.mango.setIconTextGap(-3);
      this.mango.setVerticalTextPosition(JButton.BOTTOM);
      this.mango.setHorizontalTextPosition(JButton.CENTER);
      this.mango.setFocusable(false);
      this.mango.setBorder(BorderFactory.createEtchedBorder());
      this.mango.setIcon(new ImageIcon("Icons/Mango.png"));

      // Apple
      this.apple = new JButton();
      this.apple.setText("Apple");
      this.apple.setPreferredSize(new Dimension(65, 60));
      this.apple.setIconTextGap(-3);
      this.apple.setVerticalTextPosition(JButton.BOTTOM);
      this.apple.setHorizontalTextPosition(JButton.CENTER);
      this.apple.setFocusable(false);
      this.apple.setBorder(BorderFactory.createEtchedBorder());
      this.apple.setIcon(new ImageIcon("Icons/Apple.png"));

      // Seed Price List
      this.seedPrices = new JButton();
      this.seedPrices.setText("Seed Price List");
      this.seedPrices.setPreferredSize(new Dimension(135, 60));
      this.seedPrices.setHorizontalTextPosition(JButton.CENTER);
      this.seedPrices.setFocusable(false);
      this.seedPrices.setBorder(BorderFactory.createEtchedBorder());

      // adding components above (buttons, label) to the left panel
      this.leftPanel.add(seedText);
      this.leftPanel.add(turnip);
      this.leftPanel.add(carrot);
      this.leftPanel.add(potato);
      this.leftPanel.add(rose);
      this.leftPanel.add(tulip);
      this.leftPanel.add(sunflower);
      this.leftPanel.add(mango);
      this.leftPanel.add(apple);
      this.leftPanel.add(seedPrices);

      // ------------------------------- END OF SEEDS ----------------------------------- //

      // adding all components to the main
      this.main.add(this.upperPanel, BorderLayout.NORTH);
      this.main.add(this.farmland, BorderLayout.CENTER);
      this.main.add(this.lowerPanel, BorderLayout.SOUTH);
      this.main.add(this.rightPanel, BorderLayout.EAST);
      this.main.add(this.leftPanel, BorderLayout.WEST);
      
      // setting the frame to be true
      this.main.setVisible(true);
   }

   public void setTileActionListener(ActionListener actionListener) {
      for(int i = 0; i < 10; i++) {
         for(int j = 0; j < 5; j++) {
            this.tiles[i][j].addActionListener(actionListener);
         }
      }
   }

   public void setRegisterRankActionListener(ActionListener actionListener) {
      this.registerRank.addActionListener(actionListener);
   }

   public void setHowToPlayActionListener(ActionListener actionListener) {
      this.howToPlay.addActionListener(actionListener);
   }

   public void setSleepActionListener(ActionListener actionListener) {
      this.sleep.addActionListener(actionListener);
   }

   // set text of JLabel name
   public void setNameText(String text) {
      this.name.setText(text);
   }

   // set text of JLabel coins
   public void setCoinsText(String text) {
      this.coins.setText(text);
   }

   public void setRankText(String text) {
      this.rank.setText(text);
   }

   public void setXPText(String text) {
      this.xp.setText(text);
   }
}

