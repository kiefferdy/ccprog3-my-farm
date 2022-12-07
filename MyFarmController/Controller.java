package MyFarmController;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MyFarmModel.Model;
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
            this.model.getFarmer().plant(this.model.getCropList().get(0), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getCarrotButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(1), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getPotatoButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(2), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getTulipButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(3), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });
        
        this.view.getRoseButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(4), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getSunflowerButton().addActionListener(b->{
            this.model.getFarmer().plant(this.model.getCropList().get(5), tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setSeedsVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setTileStatusVisibility(false);
        });

        this.view.getAppleButton().addActionListener(a->{

        });

        this.view.getMangoButton().addActionListener(a->{

        });

        this.view.getToolPriceButton().addActionListener(b->{
            new ToolPriceView();
        });

        this.view.getPlowButton().addActionListener(b->{
            boolean result = tile.setPlowed();
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have plowed Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                this.view.getSystemLogs().getLogs().setText("You cannot plow a tile that is already plowed!");
            }
            this.view.setTileStatusVisibility(false);
            this.view.setTileNameVisibility(false);
            this.view.setToolsVisibility(false);
        });

        this.view.getWateringCanButton().addActionListener(b->{
            boolean result = tile.water();
            this.view.getSystemLogs().clearLogs();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have watered Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(tile.getHasWitheredCrop())
                    this.view.getSystemLogs().getLogs().setText("You cannot water a withered crop!");
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot water an empty tile!");
                }
            }
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getFertilizerButton().addActionListener(b->{
            boolean result = tile.fertilize();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You have fertilized Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                if(tile.getHasWitheredCrop())
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize a withered crop!");
                else {
                    this.view.getSystemLogs().getLogs().setText("You cannot fertilize an empty tile!");
                }
            }
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getPickaxeButton().addActionListener(b->{
            boolean result = tile.usePickaxe();
            if(result) {
                this.view.getSystemLogs().getLogs().setText("You removed the rock on Tile " + (tile.getTileNumber() + 1) + "!");
            }
            else {
                this.view.getSystemLogs().getLogs().setText("You cannot use your pickaxe on a tile that does not contain a rock!");
            }
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getShovelButton().addActionListener(b->{
            tile.useShovel();
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
            this.view.setTileStatusVisibility(false);
            this.view.setToolsVisibility(false);
            this.view.setTileNameVisibility(false);
        });

        this.view.getSleepButton().addActionListener(a->{
            this.model.getMyFarm().nextDay();
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
            this.model.getFarmer().harvest(tile.getTileNumber());
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
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
    }

    public void setUsername() {
        this.username.getButton().addActionListener(a-> {
            this.name = this.username.getTextfieldTxt();
            this.username.CloseWindow();
            this.view.showMainFrame();

            this.model.createFarmer(name);
            this.model.getMyFarm().createTiles();
    
            this.view.setNameText("Name: " + this.name);
            this.view.setCoinsText("Coins: " + this.model.getFarmer().getObjectcoins());
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

