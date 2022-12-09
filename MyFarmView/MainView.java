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
        // main GUI
        this.main = new JFrame("Farming Simulator Rip-Off");
        this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.main.setLayout(new BorderLayout(15, 15)); 
        this.main.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        // ------------------------------- STATS PANEL --------------------------- //
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
        
        // new panel for the upper part of the GUI
        this.upperPanel = new JPanel(); 
        this.upperPanel.setLayout(new BorderLayout(5, 5)); 
        this.upperPanel.setPreferredSize(new Dimension(100, 100)); 

        // Sets the specifications of the statsPanel
        // Statspanel is where the player can see their stats
        this.statsPanel = new JPanel();
        this.statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));

        // adding name, coins, xp, rank, and level to the statsPanel
        this.statsPanel.add(this.name); 
        this.statsPanel.add(this.coins); 
        this.statsPanel.add(this.xp);  
        this.statsPanel.add(this.rank); 
        this.statsPanel.add(this.level); 
        // ------------------------------- END OF STATS PANEL--------------------------- //
        
        // ------------------------------- FARMLAND PANEL --------------------------- //
        // Sets the specifications of the Farmland (center) panel
        // Farmland is where the tiles will be placed
        this.farmland = new JPanel(); 
        this.farmland.setPreferredSize(new Dimension(700, 700)); // size of panel
        this.farmland.setLayout(new GridLayout(10, 5, 10, 10));
        this.farmland.setBackground(Color.LIGHT_GRAY);

        // Sets the specifications of the tiles in the farm
        this.tiles = new JButton[50];
        for(int i = 0; i < 50; i++) {
            this.tiles[i] = new JButton();
            this.tiles[i].setText("Tile "+ (i + 1));
            this.tiles[i].setName(Integer.toString(i));
            this.tiles[i].setBorder(BorderFactory.createEtchedBorder());
            this.tiles[i].setBackground(new Color(0xd4f5bf));
            this.tiles[i].addActionListener(null);
            this.tiles[i].setFocusable(false);
            this.tiles[i].setPreferredSize(new Dimension(50, 50));
            this.farmland.add(this.tiles[i]);
        }
        // ------------------------------- END OF FARMLAND PANEL --------------------------- //

        // ------------------------------- OPTIONS PANEL --------------------------- //
        // Sets the specifications for the optionsPanel
        // OptionsPanel is where options like "Rank Up", "How to Play", etc. will be placed
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
        // ------------------------------- END OF OPTIONS PANEL --------------------------- //

        // ------------------------------- TOOLS  ----------------------------------- //
        // Sets the specifications of the for the Right Panel
        // The Right Panel is where the seed and tool options will be displayed
        this.rightPanel = new JPanel();
        this.rightPanel.setPreferredSize(new Dimension(150, 600));
        this.rightPanel.setLayout(new FlowLayout());

        // Title text for the tools
        this.toolText = new JLabel();
        this.toolText.setText("TOOLS");
        this.toolText.setHorizontalTextPosition(JLabel.CENTER);
        this.toolText.setFont(new Font("Cambria", Font.BOLD, 30));

        // Plow Button
        this.plow = new JButton();
        this.plow.setText("Plow");
        this.plow.setPreferredSize(new Dimension(65, 60));
        this.plow.setIconTextGap(-3);
        this.plow.setVerticalTextPosition(JButton.BOTTOM);
        this.plow.setHorizontalTextPosition(JButton.CENTER);
        this.plow.setFocusable(false);
        this.plow.setBorder(BorderFactory.createEtchedBorder());
        this.plow.setIcon(new ImageIcon("Icons/Plow.png"));

        // Watering Can Button
        this.wateringCan = new JButton();
        this.wateringCan.setText("Watering Can");
        this.wateringCan.setPreferredSize(new Dimension(135, 60));
        this.wateringCan.setIconTextGap(-3);
        this.wateringCan.setVerticalTextPosition(JButton.BOTTOM);
        this.wateringCan.setHorizontalTextPosition(JButton.CENTER);
        this.wateringCan.setFocusable(false);
        this.wateringCan.setBorder(BorderFactory.createEtchedBorder());
        this.wateringCan.setIcon(new ImageIcon("Icons/WateringCan.png"));
        
        // Fertilizer Button
        this.fertilizer = new JButton();
        this.fertilizer.setText("Fertilizer");
        this.fertilizer.setPreferredSize(new Dimension(65, 60));
        this.fertilizer.setIconTextGap(-3);
        this.fertilizer.setVerticalTextPosition(JButton.BOTTOM);
        this.fertilizer.setHorizontalTextPosition(JButton.CENTER);
        this.fertilizer.setFocusable(false);
        this.fertilizer.setBorder(BorderFactory.createEtchedBorder());
        this.fertilizer.setIcon(new ImageIcon("Icons/Fertilizer.png"));

        // Pickaxe Button
        this.pickaxe = new JButton();
        this.pickaxe.setText("Pickaxe");
        this.pickaxe.setPreferredSize(new Dimension(65, 60));
        this.pickaxe.setIconTextGap(-3);
        this.pickaxe.setVerticalTextPosition(JButton.BOTTOM);
        this.pickaxe.setHorizontalTextPosition(JButton.CENTER);
        this.pickaxe.setFocusable(false);
        this.pickaxe.setBorder(BorderFactory.createEtchedBorder());
        this.pickaxe.setIcon(new ImageIcon("Icons/Pickaxe.png"));

        // Shovel Button
        this.shovel = new JButton();
        this.shovel.setText("Shovel");
        this.shovel.setPreferredSize(new Dimension(65, 60));
        this.shovel.setIconTextGap(-3);
        this.shovel.setVerticalTextPosition(JButton.BOTTOM);
        this.shovel.setHorizontalTextPosition(JButton.CENTER);
        this.shovel.setFocusable(false);
        this.shovel.setBorder(BorderFactory.createEtchedBorder());
        this.shovel.setIcon(new ImageIcon("Icons/Shovel.png"));

        // Tool Prices and Descriptions Button
        this.toolPrices = new JButton();
        this.toolPrices.setText("Tool Price List");
        this.toolPrices.setPreferredSize(new Dimension(135, 60));
        this.toolPrices.setHorizontalTextPosition(JButton.CENTER);
        this.toolPrices.setFocusable(false);
        this.toolPrices.setBorder(BorderFactory.createEtchedBorder());

        // ------------------------------- END OF TOOLS ----------------------------------- //

        // ------------------------------- SEEDS ----------------------------------- //
        // Title Text for Seeds
        this.seedText = new JLabel();
        this.seedText.setText("SEEDS");
        this.seedText.setHorizontalTextPosition(JLabel.CENTER);
        this.seedText.setFont(new Font("Cambria", Font.BOLD, 30));

        // Turnip Button
        this.turnip = new JButton();
        this.turnip.setText("Turnip");
        this.turnip.setPreferredSize(new Dimension(65, 60));
        this.turnip.setIconTextGap(-3);
        this.turnip.setVerticalTextPosition(JButton.BOTTOM);
        this.turnip.setHorizontalTextPosition(JButton.CENTER);
        this.turnip.setFocusable(false);
        this.turnip.setBorder(BorderFactory.createEtchedBorder());
        this.turnip.setIcon(new ImageIcon("Icons/Turnip.png"));

        // Carrot Button
        this.carrot = new JButton();
        this.carrot.setText("Carrot");
        this.carrot.setPreferredSize(new Dimension(65, 60));
        this.carrot.setIconTextGap(-3);
        this.carrot.setVerticalTextPosition(JButton.BOTTOM);
        this.carrot.setHorizontalTextPosition(JButton.CENTER);
        this.carrot.setFocusable(false);
        this.carrot.setBorder(BorderFactory.createEtchedBorder());
        this.carrot.setIcon(new ImageIcon("Icons/Carrot.png"));

        // Potato Button
        this.potato = new JButton();
        this.potato.setText("Potato");
        this.potato.setPreferredSize(new Dimension(65, 60));
        this.potato.setIconTextGap(-3);
        this.potato.setVerticalTextPosition(JButton.BOTTOM);
        this.potato.setHorizontalTextPosition(JButton.CENTER);
        this.potato.setFocusable(false);
        this.potato.setBorder(BorderFactory.createEtchedBorder());
        this.potato.setIcon(new ImageIcon("Icons/Potato.png"));

        // Rose Button
        this.rose = new JButton();
        this.rose.setText("Rose");
        this.rose.setPreferredSize(new Dimension(65, 60));
        this.rose.setIconTextGap(-3);
        this.rose.setVerticalTextPosition(JButton.BOTTOM);
        this.rose.setHorizontalTextPosition(JButton.CENTER);
        this.rose.setFocusable(false);
        this.rose.setBorder(BorderFactory.createEtchedBorder());
        this.rose.setIcon(new ImageIcon("Icons/Rose.png"));

        // Tulip Button
        this.tulip = new JButton();
        this.tulip.setText("Tulip");
        this.tulip.setPreferredSize(new Dimension(65, 60));
        this.tulip.setIconTextGap(-3);
        this.tulip.setVerticalTextPosition(JButton.BOTTOM);
        this.tulip.setHorizontalTextPosition(JButton.CENTER);
        this.tulip.setFocusable(false);
        this.tulip.setBorder(BorderFactory.createEtchedBorder());
        this.tulip.setIcon(new ImageIcon("Icons/Tulip.png"));

        // Sunflower Button
        this.sunflower = new JButton();
        this.sunflower.setText("Sunflower");
        this.sunflower.setPreferredSize(new Dimension(65, 60));
        this.sunflower.setIconTextGap(-3);
        this.sunflower.setVerticalTextPosition(JButton.BOTTOM);
        this.sunflower.setHorizontalTextPosition(JButton.CENTER);
        this.sunflower.setFocusable(false);
        this.sunflower.setBorder(BorderFactory.createEtchedBorder());
        this.sunflower.setIcon(new ImageIcon("Icons/Sunflower.png"));

        // Mango Button
        this.mango = new JButton();
        this.mango.setText("Mango");
        this.mango.setPreferredSize(new Dimension(65, 60));
        this.mango.setIconTextGap(-3);
        this.mango.setVerticalTextPosition(JButton.BOTTOM);
        this.mango.setHorizontalTextPosition(JButton.CENTER);
        this.mango.setFocusable(false);
        this.mango.setBorder(BorderFactory.createEtchedBorder());
        this.mango.setIcon(new ImageIcon("Icons/Mango.png"));

        // Apple Button
        this.apple = new JButton();
        this.apple.setText("Apple");
        this.apple.setPreferredSize(new Dimension(65, 60));
        this.apple.setIconTextGap(-3);
        this.apple.setVerticalTextPosition(JButton.BOTTOM);
        this.apple.setHorizontalTextPosition(JButton.CENTER);
        this.apple.setFocusable(false);
        this.apple.setBorder(BorderFactory.createEtchedBorder());
        this.apple.setIcon(new ImageIcon("Icons/Apple.png"));

        // Seed Price List Button
        this.seedPrices = new JButton();
        this.seedPrices.setText("Seed Price List");
        this.seedPrices.setPreferredSize(new Dimension(135, 60));
        this.seedPrices.setHorizontalTextPosition(JButton.CENTER);
        this.seedPrices.setFocusable(false);
        this.seedPrices.setBorder(BorderFactory.createEtchedBorder());

        this.setSeedsVisibility(false);
        this.setToolsVisibility(false);

        // ------------------------------- END OF SEEDS ----------------------------------- //

        // ------------------------------- LEFT PANEL ------------------------------------- //
        // Left Panel of the window
        // This panel is where the status of a tile, the option to plant a seed, use a tool, and the
        // option to harvest a crop will be placed
        this.leftPanel = new JPanel(); 
        this.leftPanel.setPreferredSize(new Dimension(150, 600)); 
        this.leftPanel.setLayout(new BorderLayout(10, 10));

        // Tile Status 
        this.tileStatus = new TileStatusView();
        this.tileStatus.setVisible(false);

        // Tile Name
        this.tileName = new JLabel("TILE ");
        this.tileName.setFont(new Font("Cambria", Font.BOLD, 30));
        this.tileName.setHorizontalAlignment(JLabel.CENTER);
        this.tileName.setVisible(false);

        // ------------------------------- END OF LEFT PANEL ------------------------------------- //

        // ------------------------------- LOWER PANEL ------------------------------------- //
        // Lower Panel of the GUI
        // This is where the system logs will be placed
        this.lowerPanel = new JPanel();
        this.lowerPanel.setPreferredSize(new Dimension(150, 100));
        this.lowerPanel.setLayout(new FlowLayout());

        // System Logs
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

    // sets the visibility of the seed buttons
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

    // sets the visibility of the tools buttons
    public void setToolsVisibility(boolean text) {
        this.plow.setVisible(text);
        this.wateringCan.setVisible(text);
        this.shovel.setVisible(text);
        this.pickaxe.setVisible(text);
        this.fertilizer.setVisible(text);
        this.toolPrices.setVisible(text);
        this.toolText.setVisible(text);
    }

    // sets the visibility of the tile name
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

    // sets the text of JLabel xp
    public void setXPText(String text) {
        this.xp.setText(text);
    }

    // sets the text of JLabel level
    public void setLevelText(String text) {
        this.level.setText(text);
    }

    // sets the text of the tile name
    public void setTileName(String text) {
        this.tileName.setText(text);
    }

    // gets all the tiles in the farm
    public JButton[] getTiles() {
        return this.tiles;
    }

    // gets the tile name of a specific tile
    public String getTileName(int i) {
        return this.tiles[i].getName();
    }

    // gets the tile status portion of the GUI
    public TileStatusView getTileStatus() {
        return this.tileStatus;
    }

    // gets the sleep button
    public JButton getSleepButton() {
        return this.sleep;
    }

    // gets the seedPrice button
    public JButton getSeedPriceButton() {
        return this.seedPrices;
    }

    // gets the turnip button
    public JButton getTurnipButton() {
        return this.turnip;
    }

    // gets the carrot button
    public JButton getCarrotButton() {
        return this.carrot;
    }

    // gets the potato button
    public JButton getPotatoButton() {
        return this.potato;
    }

    // gets the tulip button
    public JButton getTulipButton() {
        return this.tulip;
    }

    // gets the rose button
    public JButton getRoseButton() {
        return this.rose;
    }

    // gets the sunflower button
    public JButton getSunflowerButton() {
        return this.sunflower;
    }

    // gets the apple button
    public JButton getAppleButton() {
        return this.apple;
    }

    // gets the mango button
    public JButton getMangoButton() {
        return this.mango;
    }

    // gets the toolPrices button
    public JButton getToolPriceButton() {
        return this.toolPrices;
    }

    // gets the plow button
    public JButton getPlowButton() {
        return this.plow;
    }

    // gets the wateringCan button
    public JButton getWateringCanButton() {
        return this.wateringCan;
    }

    // gets the ferilizer button
    public JButton getFertilizerButton() {
        return this.fertilizer;
    }

    // gets the pickaxe button
    public JButton getPickaxeButton() {
        return this.pickaxe;
    }

    // gets the shovel button
    public JButton getShovelButton() {
        return this.shovel;
    }

    // gets the displayFarmStats button
    public JButton getDisplayFarmStatsButton() {
        return this.displayFarmStats;
    }

    // gets the howToPlay button
    public JButton getHowToPlayButton() {
        return this.howToPlay;
    }

    // gets the rankList button
    public JButton getRankListButton() {
        return this.displayRanks;
    }

    // gets the registerRank (rank up) button
    public JButton getRankUpButton() {
        return this.registerRank;
    }

    // gets the newGame button
    public JButton getNewGameButton() {
        return this.newGame;
    }

    // gets the endGame button
    public JButton getEndGameButton() {
        return this.endGame;
    }

    // gets the systemLogs
    public SystemLogsView getSystemLogs() {
        return this.systemLogs;
    }

    // gets the main frame
    public JFrame getMainFrame() {
        return this.main;
    }

    // sets the clickability of certain buttons
    public void setCertainButtonsClickability(boolean text) {
        this.howToPlay.setEnabled(text);
        this.displayFarmStats.setEnabled(text);
        this.displayRanks.setEnabled(text);
        this.registerRank.setEnabled(text);
        this.sleep.setEnabled(text);
        this.endGame.setEnabled(text);
        for(int i = 0; i < 50; i++) {
            this.tiles[i].setEnabled(text);
        }
    }

    // enables a certain tile to be clickable
    public void enableTileButton(int tileNumber) {
        this.tiles[tileNumber].setEnabled(true);
    }

    // disables a certain tile to be unclickable
    public void disableTileButton(int tileNumber) {
        this.tiles[tileNumber].setEnabled(false);
    }

    // sets color of tile to its original color (no crop)
    public void setTileOriginal(int tileNumber) {
        this.tiles[tileNumber].setBackground(new Color(0xd4f5bf));
    }

    // sets color of tile to green (crop is growing)
    public void setTileGreen(int tileNumber) {
        this.tiles[tileNumber].setBackground(new Color(0x74ed28));
    }

    // sets color of tile to brown (withered crop present)
    public void setTileBrown(int tileNumber) {
        this.tiles[tileNumber].setBackground(new Color(0xb89c69));
    }

    // sets color of tile to gold (crop is harvestable)
    public void setTileGold(int tileNumber) {
        this.tiles[tileNumber].setBackground(new Color(0xf7cf1b));
    }
}