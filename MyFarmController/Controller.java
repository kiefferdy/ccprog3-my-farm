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

public class Controller {
    private MainView view;
    private Model model;
    private String name;
    private Username username;
    private Tile tile;

    public Controller(MainView view, Model model) {
        this.view = view;
        this.model = model;
        this.username = new Username();

        setUsername();
        initializeListeners();
    }

    public void initializeListeners() {
        for(var t : this.view.getTiles()) {
            t.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    var l = (JButton) e.getSource();
                    tileClicked(Integer.parseInt(l.getName()));
                }
            });
        }

        this.view.getTileStatus().getPlantButton().addActionListener(a->{
            this.view.setSeedsVisibility(true);
            this.view.setToolsVisibility(false);
        });

        this.view.getTileStatus().getUseToolButton().addActionListener(a->{
            this.view.setToolsVisibility(true);
            this.view.setSeedsVisibility(false);
        });

        this.view.getSeedPriceButton().addActionListener(b->{
            SeedPriceView seeds = new SeedPriceView();

            seeds.getDescription().setText(this.model.getCropList().get(0).displayCrop());
            for(int j = 1; j <= 7; j++) {
                seeds.getDescription().setText(seeds.getDescription().getText() + this.model.getCropList().get(j).displayCrop());
            }
            seeds.getDescription().setCaretPosition(0);
        });

        this.view.getTurnipButton().addActionListener(b->{
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(0), tile.getTileNumber());
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(0).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(0).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(0).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getCarrotButton().addActionListener(b->{
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(1), tile.getTileNumber());
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(1).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(1).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(1).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getPotatoButton().addActionListener(b->{
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(2), tile.getTileNumber());
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(2).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(2).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(2).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getTulipButton().addActionListener(b->{
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(3), tile.getTileNumber());
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(3).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(3).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(3).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });
        
        this.view.getRoseButton().addActionListener(b->{
            boolean result = this.model.getFarmer().plant(this.model.getCropList().get(4), tile.getTileNumber());
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have successfully planted a " + this.model.getCropList().get(4).getName() + " on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < this.model.getCropList().get(4).getSeedCost()) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds! You need " + ((double) this.model.getCropList().get(4).getSeedCost() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to plant this crop.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You may not plant on this tile!");
                }
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getSunflowerButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(5), tile.getTileNumber());
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getAppleButton().addActionListener(a->{
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getMangoButton().addActionListener(a->{
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getToolPriceButton().addActionListener(b->{
            new ToolPriceView();
        });

        this.view.getPlowButton().addActionListener(b->{
            boolean result = this.model.getFarmer().usePlow(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have plowed Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 0.5 experience.");
            }
            else {
                this.view.getSystemLogs().getLogs().setText("You cannot plow a tile that is already plowed!");
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());

            this.view.setTileStatusVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setToolsVisibility(false);
        });

        this.view.getWateringCanButton().addActionListener(b->{
            boolean result = this.model.getFarmer().useWateringCan(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have watered Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 0.5 experience.");
            }
            else {
                if(tile.getHasWitheredCrop())
                    this.view.getSystemLogs().getLogs().setText("You cannot water a withered crop!");
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot water an empty tile!");
                }
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());

            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getFertilizerButton().addActionListener(b->{
            boolean result = this.model.getFarmer().useFertilizer(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have fertilized Tile " + (tile.getTileNumber() + 1) + "!\nYou gained 4 experience.");
            }
            else {
                if(tile.getHasWitheredCrop()) {
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize a withered crop!");
                }
                else if(this.model.getFarmer().getObjectcoins() < 10) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (10 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to fertilize your crop.!\n");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize an empty tile!");
                }
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getPickaxeButton().addActionListener(b->{
            boolean result = this.model.getFarmer().usePickaxe(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You removed the rock on Tile " + (tile.getTileNumber() + 1) + "!\nYou spent 50 Objectcoins and gained 15 experience.");
            }
            else {
                if(this.model.getFarmer().getObjectcoins() < 10) {
                    this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (50 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to use the pickaxe.\n");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot use your pickaxe on a tile that does not contain a rock!");
                }
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getShovelButton().addActionListener(b->{
            boolean result = this.model.getFarmer().useShovel(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                if(this.model.getMyFarm().getTile(tile.getTileNumber()).hasRock()) {
                    this.view.getSystemLogs().getLogs().setText("THE SHOVEL BROKE BECAUSE OF THE ROCK!\nYou spent 7 Objectcoins and gained 2 experience.");
                }
                else {
                    this.view.getSystemLogs().getLogs().setText("Tile cleared!\nYou spent 7 Objectcoins and gained 2 experience.");
                }
            }
            else {
                this.view.getSystemLogs().getLogs().setText("Insufficient funds!\n You need " + (7 - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to use the shovel.\n");
            }
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());

            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getSleepButton().addActionListener(a->{
            this.model.getMyFarm().nextDay();
            this.view.getSystemLogs().clearLogs();
            this.view.getSystemLogs().getLogs().setText("You take a good rest in your shed.\nCurrent Day: " + this.model.getMyFarm().getDay());

            boolean result = this.model.getMyFarm().storm();
            if(result) {
                this.view.getSystemLogs().getLogs().setText(this.view.getSystemLogs().getLogs().getText() + "\nA STORM BREWED WHILE YOU WERE SLEEPING! ALL CROPS HAVE WASHED OUT OF THE FARM!");
            }

            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setSeedsVisibility(false);
        });

        this.view.getDisplayFarmStatsButton().addActionListener(a->{
            FarmStatsView farmStats = new FarmStatsView();

            farmStats.getDescription().setText(this.model.getMyFarm().displayOverview());
        });

        this.view.getHowToPlayButton().addActionListener(a->{
            new HowToPlayView();
        });

        this.view.getTileStatus().getHarvestButton().addActionListener(a->{
            boolean result = this.model.getFarmer().harvest(tile.getTileNumber());
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("Success! Your crop produced %d products. You earned %f Objectcoins and gained %f experience.");
            }
            
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setSeedsVisibility(false);
        });

        this.view.getRankListButton().addActionListener(a->{
            new RankListView();
        });

        this.view.getRankUpButton().addActionListener(a->{
            this.view.getSystemLogs().clearLogs();
            if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("farmer")) {
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(1));
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                else {
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(1).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(1).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(1).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(1).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("registered farmer")) {
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(2));
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                else {
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(2).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(2).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(2).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(2).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("distinguished farmer")) {
                boolean result = this.model.getFarmer().register(this.model.getRankList().get(3));
                if(result) {
                    this.view.getSystemLogs().getLogs().setText("Registration success! You are now a " + this.model.getFarmer().getRank().getRank() + ".");
                }
                else {
                    if((this.model.getFarmer().getObjectcoins() < this.model.getRankList().get(3).getRegistrationFee()) && 
                        (this.model.getFarmer().getLevel() == this.model.getRankList().get(3).getLevelRequirements())) {
                        this.view.getSystemLogs().getLogs().setText("You have met the level requirement but you need " + (this.model.getRankList().get(3).getRegistrationFee() - this.model.getFarmer().getObjectcoins()) + " more Objectcoins to cover the registration fee!");
                    }
                    else {
                        this.view.getSystemLogs().getLogs().setText("You need to level up "+ (this.model.getRankList().get(3).getLevelRequirements() - this.model.getFarmer().getLevel()) +" more times to be eligible for the next rank!");
                    }
                }
            }
            else if(this.model.getFarmer().getRank().getRank().equalsIgnoreCase("legendary farmer")){
                this.view.getSystemLogs().getLogs().setText("You have already reached the maximum farmer rank!");
            }
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());
            this.view.setRankText("Rank: " + this.model.getFarmer().getRank().getRank());
        });

        this.view.getNewGameButton().addActionListener(a->{
            //view.getMainFrame().dispose();
            //username = new Username();
            //new MainView();
            //model = new Model();
        });

        this.view.getEndGameButton().addActionListener(a->{
            EndgameStatsView endgame = new EndgameStatsView();

            endgame.getDescription().setText(this.model.getFarmer().displayStats());
            endgame.getDescription().setText(endgame.getDescription().getText() + this.model.getMyFarm().displayOverview());

            
        });
    }

    public void setUsername() {
        this.username.getButton().addActionListener(a-> {
            this.name = this.username.getTextfieldTxt();
            this.username.CloseWindow();
            this.view.showMainFrame();

            this.model.createFarmer(name);
            this.model.getMyFarm().createTiles();
    
            this.view.setNameText("Name: " + this.name);
            this.view.setCoinsText("Objectcoins: " + this.model.getFarmer().getObjectcoins());
            this.view.setRankText("Rank: " + this.model.getFarmer().getRank().getRank());
            this.view.setXPText("XP: " + this.model.getFarmer().getXP());
            this.view.setLevelText("Level: " + this.model.getFarmer().getLevel());
        });
    }

    public void tileClicked(int i) {
        tile = model.getMyFarm().getTile(i);

        this.view.setTileName("TILE " + (i + 1));

        this.view.getTileStatus().getTextPane().setText(tile.displayStatus());

        this.view.setTileNameVisibility(true);
        this.view.setTileStatusVisibility(true);
    }
}
