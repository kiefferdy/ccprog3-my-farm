package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

// Panel where the status of a tile, the option to plant a seed or use a tool, and the harvest button
// will be placed
public class TileStatusView extends JPanel {
    private JTextPane textPane;
    private JButton plant, useTool, harvest; 

    public TileStatusView() {
        // Sets specifications for the textpane where the status of the tile will be displayed
        this.textPane = new JTextPane();
        this.textPane.setEditable(false);
        this.textPane.setPreferredSize(new Dimension(135, 300));
        this.textPane.setFont(new Font("Cambria", Font.PLAIN, 12));

        // Sets specifications for the "Plant Seed" button
        this.plant = new JButton();
        this.plant.setText("Plant Seed");
        this.plant.setPreferredSize(new Dimension(135, 30));
        this.plant.setHorizontalTextPosition(JButton.CENTER);
        this.plant.setFocusable(false);
        this.plant.setBorder(BorderFactory.createEtchedBorder());

        // Sets specifications for the "Use Tool" button
        this.useTool = new JButton();
        this.useTool.setText("Use Tool");
        this.useTool.setPreferredSize(new Dimension(135, 30));
        this.useTool.setHorizontalTextPosition(JButton.CENTER);
        this.useTool.setFocusable(false);
        this.useTool.setBorder(BorderFactory.createEtchedBorder());

        // Sets specifications for "harvest Crop" button
        this.harvest = new JButton();
        this.harvest.setText("Harvest Crop");
        this.harvest.setPreferredSize(new Dimension(135, 30));
        this.harvest.setHorizontalTextPosition(JButton.CENTER);
        this.harvest.setFocusable(false);
        this.harvest.setBorder(BorderFactory.createEtchedBorder());

        // adding all components to the panel
        this.add(textPane);
        this.add(plant);
        this.add(useTool);
        this.add(harvest);
    }

    // Gets the "Plant Seed" button
    public JButton getPlantButton() {
        return this.plant;
    }

    // Gets the "Use Tool" button
    public JButton getUseToolButton() {
        return this.useTool;
    }
    
    // Gets the "Harvest Crop" button
    public JButton getHarvestButton() {
        return this.harvest;
    }
    
    // Gets the textpane of the tile status
    public JTextPane getTextPane() {
        return this.textPane;
    }

    public void setPlantVisibility(boolean text) {
        this.plant.setVisible(text);
    }
}
