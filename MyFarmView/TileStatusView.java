package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TileStatusView extends JPanel {
    private JTextPane textPane;
    private JButton plant, useTool, harvest; 

    public TileStatusView() {
        this.textPane = new JTextPane();
        this.textPane.setEditable(false);
        this.textPane.setPreferredSize(new Dimension(135, 300));
        this.textPane.setFont(new Font("Cambria", Font.PLAIN, 12));

        this.plant = new JButton();
        this.plant.setText("Plant Seed");
        this.plant.setPreferredSize(new Dimension(135, 30));
        this.plant.setHorizontalTextPosition(JButton.CENTER);
        this.plant.setFocusable(false);
        this.plant.setBorder(BorderFactory.createEtchedBorder());

        this.useTool = new JButton();
        this.useTool.setText("Use Tool");
        this.useTool.setPreferredSize(new Dimension(135, 30));
        this.useTool.setHorizontalTextPosition(JButton.CENTER);
        this.useTool.setFocusable(false);
        this.useTool.setBorder(BorderFactory.createEtchedBorder());

        this.harvest = new JButton();
        this.harvest.setText("Harvest Crop");
        this.harvest.setPreferredSize(new Dimension(135, 30));
        this.harvest.setHorizontalTextPosition(JButton.CENTER);
        this.harvest.setFocusable(false);
        this.harvest.setBorder(BorderFactory.createEtchedBorder());

        this.add(textPane);
        this.add(plant);
        this.add(useTool);
        this.add(harvest);
    }

    public JButton getPlantButton() {
        return this.plant;
    }

    public JButton getUseToolButton() {
        return this.useTool;
    }
    
    public JButton getHarvestButton() {
        return this.harvest;
    }
    
    public JTextPane getTextPane() {
        return this.textPane;
    }

    public void setPlantVisibility(boolean text) {
        this.plant.setVisible(text);
    }
}
