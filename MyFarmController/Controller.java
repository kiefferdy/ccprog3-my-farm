package MyFarmController;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MyFarmModel.Model;
import MyFarmView.EndgameStatsView;
import MyFarmView.FarmStatsView;
import MyFarmView.HowToPlayView;
import MyFarmView.MainView;
import MyFarmView.RankListView;
import MyFarmView.SeedPriceView;
import MyFarmView.ToolPriceView;
import MyFarmView.Username; 
import MyFarmModel.Tile;

// This is where all decision making is implemented
public class Controller {
    private MainView view;
    private Model model;
    private String name;
    private Username username;
    private Tile tile;

    // Where the whole game starts
    public Controller(MainView view, Model model) {
        this.view = view;
        this.model = model;
        this.username = new Username();

        setUsername();
        initializeListeners();
    }

    // Method where all listeners are placed
    public void initializeListeners() {
        // This adds a mouse listener to each tile
        for(var t : this.view.getTiles()) {
            t.addMouseListener(new MouseAdapter() {
                @Override
                // executes if a button is clicked
                public void mouseClicked(MouseEvent e) {
                    var l = (JButton) e.getSource(); // gets the source of the click
                    // executes if the button is disabled
                    if(!l.isEnabled()) {
                        return; // basically nothing happens
                    }
                    // executes if the button is enabled
                    else {
                        tileClicked(Integer.parseInt(l.getName()));
                    }
                }
            });
        }

        // This adds an action listener to the "Plant Seed" button
        this.view.getTileStatus().getPlantButton().addActionListener(a->{
            this.view.setSeedsVisibility(true);     // show seed options
            this.view.setToolsVisibility(false);    // not show tools options
        });

        // This adds an action listener to the "Use Tool" button
        this.view.getTileStatus().getUseToolButton().addActionListener(a->{
            this.view.setToolsVisibility(true);     // show tools options
            this.view.setSeedsVisibility(false);    // not show seed options
        });

        // This adds an action listener to the "Seed Price List" button
        this.view.getSeedPriceButton().addActionListener(b->{
            SeedPriceView seeds = new SeedPriceView(); // shows the seed price window

            // adding text to the description
            seeds.getDescription().setText(this.model.getCropList().get(0).displayCrop());
            for(int j = 1; j <= 7; j++) {
                seeds.getDescription().setText(seeds.getDescription().getText() + this.model.getCropList().get(j).displayCrop());
            }
            // setting the view of the description to the start
            seeds.getDescription().setCaretPosition(0);
        });

        // This adds an action listener to the "Turnip" button
        this.view.getTurnipButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(0), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(0).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(0).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(0).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });

        // This adds an action listener to the "Carrot" button
        this.view.getCarrotButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(1), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(1).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(1).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(1).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });

        // This adds an action listener to the "Potato" button
        this.view.getPotatoButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(2), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(2).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(2).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(2).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });

        // This adds an action listener to the "Tulip" button
        this.view.getTulipButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(3), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(3).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(3).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(3).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });
        
        // This adds an action listener to the "Rose" button
        this.view.getRoseButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(4), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(4).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(4).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(4).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });

        // This adds an action listener to the "Sunflower" button
        this.view.getSunflowerButton().addActionListener(b->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(5), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(5).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(5).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(5).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
        });

        // This adds an action listener to the "Mango" button
        this.view.getMangoButton().addActionListener(a->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(6), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(6).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(6).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(6).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if there is not enough space to plant the seed
                else if(!this.model.getMyFarm().checkTreeEligibility(tile.getTileNumber())) {
                    this.view.getSystemLogs().getLogs().setText("You may not plant a tree here!" +
                                                                "\nTo plant a tree, all adjacent tiles must be unoccupied!");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
            this.updateCollateral();
        });

        // This adds an action listener to the "Mango" button
        this.view.getAppleButton().addActionListener(a->{
            // @param result stores if planting the crop is successful or not
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(7), tile.getTileNumber());
            // this executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(7).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
                this.view.setTileGreen(tile.getTileNumber());
            }
            // this executes if unsuccessful
            else {
                // this executes if the farmer does not have enough objectcoins to plant the seed
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(7).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(7).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                // this executes if there is not enough space to plant the seed
                else if(!this.model.getMyFarm().checkTreeEligibility(tile.getTileNumber())) {
                    this.view.getSystemLogs().getLogs().setText("You may not plant a tree here!" +
                                                                "\nTo plant a tree, all adjacent tiles must be unoccupied!");
                }
                // this executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated coins

            this.view.setSeedsVisibility(false);        // not show seeds options
            this.view.setTileNameVisibility(false);     // not show tile name
            this.view.setTileStatusVisibility(false);   // not show tile status
            this.updateCollateral();
        });

        // This adds an action listener to the "Tool Price" button
        this.view.getToolPriceButton().addActionListener(b->{
            new ToolPriceView();    // shows the Tool Price window
        });

        // This adds an action listener to the "Plow" button
        this.view.getPlowButton().addActionListener(b->{
            // @param result stores if using the tool is successful or not
            boolean result = this.model.getFarmer().usePlow(tile.getTileNumber());
            // executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have plowed Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 0.5 experience.");
            }
            // executes if unsuccessful
            else {
                this.view.getSystemLogs().getLogs().setText("You cannot plow this tile!");
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());           // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            this.view.setTileStatusVisibility(false);                           // not show tile status
            this.view.setTileNameVisibility(false);                             // not show tile name
            this.view.setToolsVisibility(false);                                // not show tools options
        });

        // This adds an action listener to the "Watering Can" button
        this.view.getWateringCanButton().addActionListener(b->{
            // @param result stores if using the tool is successful or not
            boolean result = this.model.getFarmer().useWateringCan(tile.getTileNumber());
            // executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have watered Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 0.5 experience.");
            }
            // executes if unsuccessful
            else {
                // executes if tile has withered crop
                if(tile.getHasWitheredCrop())
                    this.view.getSystemLogs().getLogs().setText("You cannot water a withered crop!");
                // executes if tile does not meet other requirements
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot water this tile!");
                }
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());           // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            this.view.setTileStatusVisibility(false);                           // not show tile status
            this.view.setTileNameVisibility(false);                             // not show tile name
            this.view.setToolsVisibility(false);                                // not show tools options
        });

        // This adds an action listener to the "Fertilizer" button
        this.view.getFertilizerButton().addActionListener(b->{
            // @param result stores if using the tool is successful or not
            boolean result = this.model.getFarmer().useFertilizer(tile.getTileNumber());
            // executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have fertilized Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 4 experience.");
            }
            // executes if unsuccessful
            else {
                // executes if tile has withered crop
                if(tile.getHasWitheredCrop()) {
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize a withered crop!");
                }
                // executes if player does not have enough objectcoins to use the tool
                else if(this.model.getFarmer().getObjectcoins() < 10) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (10 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to fertilize your crop.!\n");
                }
                // executes if other requirements are not met
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated objectcoins
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());           // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            this.view.setTileStatusVisibility(false);                           // not show tile status
            this.view.setTileNameVisibility(false);                             // not show tile name
            this.view.setToolsVisibility(false);                                // not show tools options
        });

        // This adds an action listener to the "Pickaxe" button
        this.view.getPickaxeButton().addActionListener(b->{
            // @param result stores if using the tool is successful or not
            boolean result = this.model.getFarmer().usePickaxe(tile.getTileNumber());
            // executes if successful
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You removed the rock on Tile " + (tile.getTileNumber() + 1) + "!\nYou spent 50 Objectcoins and gained 15 experience.");
            }
            // executes if unsuccessful
            else {
                // executes if player does not have enough objectcoins to use the tool
                if(this.model.getFarmer().getObjectcoins() < 10) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (50 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to use the pickaxe.\n");
                }
                // executes if there's no rock on the tile
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot use your pickaxe on a tile that does not contain a rock!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated objectcoins
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());           // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            this.view.setTileStatusVisibility(false);                           // not show tile status
            this.view.setTileNameVisibility(false);                             // not show tile name
            this.view.setToolsVisibility(false);                                // not show tools options
        });

        // This adds an action listener to the "Shovel" button
        this.view.getShovelButton().addActionListener(b->{
            // @param result stores if using the tool is successful or not
            boolean result = this.model.getFarmer().useShovel(tile.getTileNumber());
            // executes if successful
            if(result) {
                // executes if there's a rock
                if(this.model.getMyFarm().getTile(tile.getTileNumber()).hasRock()) {
                    this.view.getSystemLogs().getLogs().setText("THE SHOVEL BROKE BECAUSE OF THE ROCK!\nYou spent 7 Objectcoins and gained 2 experience.");
                }
                // executes if there's no rock
                else {
                    this.view.getSystemLogs().getLogs().setText("Tile cleared!\nYou spent 7 Objectcoins and gained 2 experience.");
                    this.view.setTileOriginal(tile.getTileNumber());
                }
            }
            // executes if unsuccessful
            else {
                this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (7 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to use the shovel.\n");
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins()); // sets updated objectcoins
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());           // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            this.view.setTileStatusVisibility(false);                           // not show tile status
            this.view.setTileNameVisibility(false);                             // not show tile name
            this.view.setToolsVisibility(false);                                // not show tools options
        });

        // This adds an action listener to the "Sleep" button
        this.view.getSleepButton().addActionListener(a->{
            // executes if player meets the requirements to immediately end the game
            if(this.model.getFarmer().checkGameOver()) {
                endGame();
            }
            // executes if the game goes on
            else {
                String text = this.model.getMyFarm().nextDay();   // advances to next day
                this.view.getSystemLogs().getLogs().setText("You take a good rest in your shed.\nCurrent Day: " + this.model.getMyFarm().getDay());
                this.view.getSystemLogs().getLogs().setText(this.view.getSystemLogs().getLogs().getText() + text);

                boolean result = this.model.getMyFarm().storm();
                // executes if a storm arrived 
                if(result) {
                    this.view.getSystemLogs().getLogs().setText(this.view.getSystemLogs().getLogs().getText() + "\nA STORM BREWED WHILE YOU WERE SLEEPING! ALL CROPS WERE WASHED OUT OF THE FARM!");
                }

                // setting tile button colors
                for(int i = 0; i < 50; i++) {
                    if(!this.model.getMyFarm().getTile(i).isOccupied()) {
                        this.view.setTileOriginal(i);
                    }
                    else if(this.model.getMyFarm().getTile(i).getHasWitheredCrop()) {
                        this.view.setTileBrown(i);
                    }
                    else if(this.model.getMyFarm().getTile(i).getDaysToHarvest() == 0 && !this.model.getMyFarm().getTile(i).getHasWitheredCrop()) {
                        this.view.setTileGold(i);
                    }
                }
            }
            // removes displays on the left and right panels
            this.view.setTileNameVisibility(false);         
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setSeedsVisibility(false);
        });

        // This adds an action listener to the "Farm Stats" button
        this.view.getDisplayFarmStatsButton().addActionListener(a->{
            FarmStatsView farmStats = new FarmStatsView();  // show farm stats window

            // sets the text in the textpane in farm stats
            farmStats.getDescription().setText(this.model.getMyFarm().displayOverview());   
        });

        // This adds an action listener to the "How to Play" button
        this.view.getHowToPlayButton().addActionListener(a->{
            new HowToPlayView();    // show How to Play window
        });

        // This adds an action listener to the "Harvest Crop" button
        this.view.getTileStatus().getHarvestButton().addActionListener(a->{
            // @param harvestStatus stores the string outputted from the harvest method in Farmer
            String harvestStatus = this.model.getFarmer().harvest(tile.getTileNumber());

            // this sets the text in the system logs to what harvestStatus contains
            this.view.getSystemLogs().getLogs().setText(harvestStatus);

            // executes if harvest was successful
            if(harvestStatus.startsWith("Success!")) {
                this.view.setTileOriginal(tile.getTileNumber());    // changes tile to its original color
            }

            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());  // sets updated objectcoins
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());   // sets updated XP
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());  // sets updated level

            // removes displays on the left and right panels
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setSeedsVisibility(false);
        });

        // This adds an action listener to the "Rank List" button
        this.view.getRankListButton().addActionListener(a->{
            new RankListView(); // show Rank List window
        });

        // This adds an action listener to the "RANK UP!" button
        this.view.getRankUpButton().addActionListener(a->{
            // executes if the player's current rank is farmer
            if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("farmer")) {
                // @param result takes the boolean value of register from Farmer
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(1));
                // executes if register is successful
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                // executes if register is unsuccessful
                else {
                    // executes if player does not have enough objectcoins to register but reached the level required to register
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(1).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(1).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(1).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    // executes if player does not meet the required level to register
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(1).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }
            
            // executes if the player's current rank is registered farmer
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("registered farmer")) {
                // @param result takes the boolean value of register from Farmer
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(2));
                // executes if register is successful
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                // executes if register is unsuccessful
                else {
                    // executes if player does not have enough objectcoins to register but reached the level required to register
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(2).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(2).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(2).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    // executes if player does not meet the required level to register
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(2).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }

            // executes if the player's current rank is distinguished farmer
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("distinguished farmer")) {
                // @param result takes the boolean value of register from Farmer
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(3));
                // executes if register is successful
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                else {
                    // executes if player does not have enough objectcoins to register but reached the level required to register
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(3).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(3).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(3).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    // executes if player does not meet the required level to register
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(3).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }

            // executes if the player's current rank is legendary farmer
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("legendary farmer")){
                this.view.getSystemLogs().getLogs().setText("You have already reached the maximum farmer rank!");
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());  // sets updated objectcions
            this.view.setRankText("Rank: " + this.model.getFarmer().getRank().getRank());   // sets updated rank
        });

        // This adds an action listener to the "New Game" button
        this.view.getNewGameButton().addActionListener(a->{
            view.getMainFrame().dispose();  // disposes the current main window

            // restart everything
            username = new Username();
            view = new MainView();
            model = new Model();

            setUsername();
            initializeListeners();
        });

        // This adds an action listener to the "End Game" button
        this.view.getEndGameButton().addActionListener(a->{
            endGame();  // yep, literally end the game
        });
    }

    // This sets the username of the player and uses it to do various actions
    public void setUsername() {
        // This adds an action listener to the "Submit" button in username
        this.username.getButton().addActionListener(a-> {
            this.name = this.username.getTextfieldTxt();    // gets whats inside the textfield in username
            this.username.CloseWindow();                    // closes username
            this.view.showMainFrame();                      // shows the main game

            this.model.createFarmer(name);                  // creates a new farmer
            this.model.getMyFarm().createTiles();           // creates the tiles for the farm
    
            this.view.setNameText("Name: " + this.name);    // sets the name of the player
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());   // sets the starting objectcoins of the player
            this.view.setRankText("Rank: " + this.model.getFarmer().getRank().getRank());       // sets the starting rank of the player
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());                       // sets the starting xp of the player
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());              // sets the starting level of the player
        });
    }

    // This gets the tile clicked and sets it to tile
    public void tileClicked(int i) {
        tile = model.getMyFarm().getTile(i);    // setting the tile clicked to tile

        this.view.setTileName("TILE " + (i + 1));   // setting tile name

        this.view.getTileStatus().getTextPane().setText(tile.displayStatus());  // displays the status of the tile

        this.view.setTileNameVisibility(true);  // show tile name
        this.view.setTileStatusVisibility(true);    // show tile status
    }

    // This executes if the game has ended
    public void endGame() {
        EndgameStatsView endgame = new EndgameStatsView();  // show end game stats window
        endgame.getDescription().setText(this.model.getFarmer().displayStats());    // adds the farmer's stats to the end game stats
        // adds the farm's final stats to the game
        endgame.getDescription().setText(endgame.getDescription().getText() + this.model.getMyFarm().displayOverview());
        
        // basically removes all displays in left and right panel, disables all buttons except for "New Game"
        this.view.setCertainButtonsClickability(false);
        this.view.setSeedsVisibility(false);
        this.view.setToolsVisibility(false);
        this.view.setTileStatusVisibility(false);
        this.view.setTileNameVisibility(false);

        // sets game over text in system logs
        this.view.getSystemLogs().getLogs().setText("GAME OVER! Thanks for playing!\nIf you want to try again, click the \"New Game\" button!");
    }

    // insert comment here
    public void updateCollateral() {
        int i;
        for(i = 0; i < 50; i++) {
            if(this.model.getMyFarm().getTile(i).isCollateral()) {
                this.view.disableTileButton(i);
            }
            else {
                this.view.enableTileButton(i);
            }
        }
    }
}