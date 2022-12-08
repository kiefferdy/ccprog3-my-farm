package MyFarmView;
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

public class MainView {
    private JFrame main;                                                            // main frame 
    private JLabel name, coins, xp, rank, level;                                    // user stats
    private JButton tiles[];                                                        // farmland
    private JPanel upperPanel, farmland, lowerPanel, leftPanel, rightPanel;         // sections of the GUI
    private JButton registerRank, howToPlay, sleep, seedPrices, toolPrices;         // definitely useful buttons
    private JButton displayFarmStats, displayRanks, newGame, endGame;               // more definitely useful buttons
    private JButton plow, wateringCan, fertilizer, pickaxe, shovel;                 // tool buttons
    private JButton turnip, carrot, potato, rose, tulip, sunflower, mango, apple;   // seed buttons
    private JLabel seedText, toolText, tileName;                                    // text
    private TileStatusView tileStatus;                                              // Tile Status
    private JPanel statsPanel, optionsPanel;                                        // panels for the upperPanel
    private SystemLogsView systemLogs;                                              // system logs                            
    
    public MainView() {
        this.main = new JFrame("Farming Simulator Rip-Off"); // main GUI
        
        this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when program exits, GUI closes
        this.main.setLayout(new BorderLayout(15, 15)); // setting layout to BorderLayout so that components are easier to access
        this.main.setExtendedState(JFrame.MAXIMIZED_BOTH); // "fullscreen"
        
        // name of farmer
        this.name = new JLabel(); 
        this.name.setFont(new Font("Cambria", Font.PLAIN, 14));

        // coin count
        this.coins = new JLabel(); // coin count
        this.coins.setFont(new Font("Cambria", Font.PLAIN, 14));

        // xp count
        this.xp = new JLabel();
        this.xp.setFont(new Font("Cambria", Font.PLAIN, 14));

        // farmer rank
        this.rank = new JLabel();
        this.rank.setFont(new Font("Cambria", Font.PLAIN, 14));

        // farmer level
        this.level = new JLabel();
        this.level.setFont(new Font("Cambria", Font.PLAIN, 14));
        
        this.upperPanel = new JPanel(); // new panel for the upper part of the GUI
        this.upperPanel.setLayout(new BorderLayout(5, 5)); // setting layout of panel
        this.upperPanel.setPreferredSize(new Dimension(100, 100)); // preferred size of the panel

        this.statsPanel = new JPanel();
        this.statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));

        this.statsPanel.add(this.name); // adding JLabel name
        this.statsPanel.add(this.coins); // adding JLabel coins
        this.statsPanel.add(this.xp);  // adding JLabel xp
        this.statsPanel.add(this.rank); // adding JLabel rank
        this.statsPanel.add(this.level); // adding JLabel level
        
        this.farmland = new JPanel(); // farmland panel
        this.farmland.setPreferredSize(new Dimension(700, 700)); // size of panel
        this.farmland.setLayout(new GridLayout(10, 5, 10, 10));
        this.farmland.setBackground(Color.LIGHT_GRAY);

        this.tiles = new JButton[50];
        for(int i = 0; i < 50; i++) {
            this.tiles[i] = new JButton();
            this.tiles[i].setText("Tile "+ (i + 1));
            this.tiles[i].setName(Integer.toString(i));
            this.tiles[i].setBorder(BorderFactory.createEtchedBorder());
            this.tiles[i].setBackground(new Color(0x90EE90));
            this.tiles[i].addActionListener(null);
            this.tiles[i].setFocusable(false);
            this.tiles[i].setPreferredSize(new Dimension(50, 50));
            this.farmland.add(this.tiles[i]);
        }

        this.optionsPanel = new JPanel();
        this.optionsPanel.setLayout(new FlowLayout());

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

        // Button to display the farm's current stats
        this.displayFarmStats = new JButton();
        this.displayFarmStats.setText("Farm Stats");
        this.displayFarmStats.setPreferredSize(new Dimension(100, 35));
        this.displayFarmStats.setBorder(BorderFactory.createEtchedBorder());
        this.displayFarmStats.setFocusable(false);

        // Button to display the possible farmer ranks
        this.displayRanks = new JButton();
        this.displayRanks.setText("Rank List");
        this.displayRanks.setPreferredSize(new Dimension(100, 35));
        this.displayRanks.setBorder(BorderFactory.createEtchedBorder());
        this.displayRanks.setFocusable(false);

        // Button to start a new game
        this.newGame = new JButton();
        this.newGame.setText("New Game");
        this.newGame.setPreferredSize(new Dimension(100, 35));
        this.newGame.setBorder(BorderFactory.createEtchedBorder());
        this.newGame.setFocusable(false);

        // Button to end the game voluntarily
        this.endGame = new JButton();
        this.endGame.setText("End Game");
        this.endGame.setPreferredSize(new Dimension(100, 35));
        this.endGame.setBorder(BorderFactory.createEtchedBorder());
        this.endGame.setFocusable(false);

        // adding components to the upper panel
        this.optionsPanel.add(this.newGame);
        this.optionsPanel.add(this.howToPlay);
        this.optionsPanel.add(this.displayFarmStats);
        this.optionsPanel.add(this.displayRanks);
        this.optionsPanel.add(this.registerRank);
        this.optionsPanel.add(this.sleep);
        this.optionsPanel.add(this.endGame);

        // ------------------------------- TOOLS ----------------------------------- //
        this.rightPanel = new JPanel();
        this.rightPanel.setPreferredSize(new Dimension(150, 600));
        this.rightPanel.setLayout(new FlowLayout());

        this.toolText = new JLabel();
        this.toolText.setText("TOOLS");
        this.toolText.setHorizontalTextPosition(JLabel.CENTER);
        this.toolText.setFont(new Font("Cambria", Font.BOLD, 30));

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

        // ------------------------------- END OF TOOLS ----------------------------------- //

        // ------------------------------- SEEDS ----------------------------------- //
        // Label for Seeds
        this.seedText = new JLabel();
        this.seedText.setText("SEEDS");
        this.seedText.setHorizontalTextPosition(JLabel.CENTER);
        this.seedText.setFont(new Font("Cambria", Font.BOLD, 30));

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

        this.setSeedsVisibility(false);
        this.setToolsVisibility(false);

        // ------------------------------- END OF SEEDS ----------------------------------- //

        this.leftPanel = new JPanel(); // panel for tile descriptions
        this.leftPanel.setPreferredSize(new Dimension(150, 600)); // panel dimensions
        this.leftPanel.setLayout(new BorderLayout(10, 10));

        this.tileStatus = new TileStatusView();
        this.tileStatus.setVisible(false);

        this.tileName = new JLabel("TILE ");
        this.tileName.setFont(new Font("Cambria", Font.BOLD, 30));
        this.tileName.setHorizontalAlignment(JLabel.CENTER);
        this.tileName.setVisible(false);

        // Lower Part of the GUI
        this.lowerPanel = new JPanel();
        this.lowerPanel.setPreferredSize(new Dimension(150, 100));
        this.lowerPanel.setLayout(new FlowLayout());

        // System Logs to be placed at the bottom of the GUI
        this.systemLogs = new SystemLogsView();
        this.systemLogs.setPreferredSize(new Dimension(750, 90));

        // ---------------------- ADDING ALL COMPONENTS TO MAIN FRAME -------------------------- //

        // adding statsPanel and optionsPanel to upperPanel
        this.upperPanel.add(statsPanel, BorderLayout.WEST);
        this.upperPanel.add(this.optionsPanel, BorderLayout.CENTER);

        // adding tools and seeds to right panel
        this.rightPanel.add(toolText);
        this.rightPanel.add(plow);
        this.rightPanel.add(fertilizer);
        this.rightPanel.add(pickaxe);
        this.rightPanel.add(shovel);
        this.rightPanel.add(wateringCan);
        this.rightPanel.add(toolPrices);
        this.rightPanel.add(seedText);
        this.rightPanel.add(turnip);
        this.rightPanel.add(carrot);
        this.rightPanel.add(potato);
        this.rightPanel.add(rose);
        this.rightPanel.add(tulip);
        this.rightPanel.add(sunflower);
        this.rightPanel.add(mango);
        this.rightPanel.add(apple);
        this.rightPanel.add(seedPrices);

        // adding tileStatus to leftPanel
        this.leftPanel.add(tileName, BorderLayout.NORTH);
        this.leftPanel.add(tileStatus, BorderLayout.CENTER);

        // adding systemLogs to the lower panel
        this.lowerPanel.add(systemLogs);

        // adding all panels to the main frame
        this.main.add(this.upperPanel, BorderLayout.NORTH);
        this.main.add(this.farmland, BorderLayout.CENTER);
        this.main.add(this.lowerPanel, BorderLayout.SOUTH);
        this.main.add(this.rightPanel, BorderLayout.EAST);
        this.main.add(this.leftPanel, BorderLayout.WEST);
        
        // setting the frame to NOT be visible
        this.main.setVisible(false);
    }

    public void setSeedsVisibility(boolean text) {
        this.turnip.setVisible(text);
        this.carrot.setVisible(text);
        this.potato.setVisible(text);
        this.tulip.setVisible(text);
        this.rose.setVisible(text);
        this.sunflower.setVisible(text);
        this.apple.setVisible(text);
        this.mango.setVisible(text);
        this.seedPrices.setVisible(text);
        this.seedText.setVisible(text);
    }

    public void setToolsVisibility(boolean text) {
        this.plow.setVisible(text);
        this.wateringCan.setVisible(text);
        this.shovel.setVisible(text);
        this.pickaxe.setVisible(text);
        this.fertilizer.setVisible(text);
        this.toolPrices.setVisible(text);
        this.toolText.setVisible(text);
    }

    public void setTileNameVisibility(boolean text) {
        this.tileName.setVisible(text);
    }

    // sets the main frame to be visible
    public void showMainFrame() {
        this.main.setVisible(true);
    }

    // sets the visibility of TileStatus
    public void setTileStatusVisibility(boolean text) {
        this.tileStatus.setVisible(text);
    }

    // set text of JLabel name
    public void setNameText(String text) {
        this.name.setText(text);
    }

    // set text of JLabel coins
    public void setCoinsText(String text) {
        this.coins.setText(text);
    }

    // set text of JLabel rank
    public void setRankText(String text) {
        this.rank.setText(text);
    }

    public void setXPText(String text) {
        this.xp.setText(text);
    }

    public void setLevelText(String text) {
        this.level.setText(text);
    }

    public void setTileName(String text) {
        this.tileName.setText(text);
    }

    public JButton[] getTiles() {
        return this.tiles;
    }

    public String getTileName(int i) {
        return this.tiles[i].getName();
    }

    public TileStatusView getTileStatus() {
        return this.tileStatus;
    }

    public JButton getSleepButton() {
        return this.sleep;
    }

    public JButton getSeedPriceButton() {
        return this.seedPrices;
    }

    public JButton getTurnipButton() {
        return this.turnip;
    }

    public JButton getCarrotButton() {
        return this.carrot;
    }

    public JButton getPotatoButton() {
        return this.potato;
    }

    public JButton getTulipButton() {
        return this.tulip;
    }

    public JButton getRoseButton() {
        return this.rose;
    }

    public JButton getSunflowerButton() {
        return this.sunflower;
    }

    public JButton getAppleButton() {
        return this.apple;
    }

    public JButton getMangoButton() {
        return this.mango;
    }

    public JButton getToolPriceButton() {
        return this.toolPrices;
    }

    public JButton getPlowButton() {
        return this.plow;
    }

    public JButton getWateringCanButton() {
        return this.wateringCan;
    }

    public JButton getFertilizerButton() {
        return this.fertilizer;
    }

    public JButton getPickaxeButton() {
        return this.pickaxe;
    }

    public JButton getShovelButton() {
        return this.shovel;
    }

    public JButton getDisplayFarmStatsButton() {
        return this.displayFarmStats;
    }

    public JButton getHowToPlayButton() {
        return this.howToPlay;
    }

    public JButton getRankListButton() {
        return this.displayRanks;
    }

    public JButton getRankUpButton() {
        return this.registerRank;
    }

    public JButton getNewGameButton() {
        return this.newGame;
    }

    public JButton getEndGameButton() {
        return this.endGame;
    }

    public SystemLogsView getSystemLogs() {
        return this.systemLogs;
    }

    public JFrame getMainFrame() {
        return this.main;
    }
}

