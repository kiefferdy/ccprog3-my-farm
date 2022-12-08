package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class HowToPlayView extends JFrame{
    public HowToPlayView() {
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("How To Play");

        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 475));
        
        JLabel text = new JLabel();
        text.setText("How To Play");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        JTextPane description = new JTextPane();
        description.setPreferredSize(new Dimension(300, 475));
        description.setFont(new Font("Cambria", Font.PLAIN, 14));
        description.setEditable(false);

        description.setText("Welcome to the Farming Simulator Rip-Off!\n\n");
        description.setText(description.getText() + "Your goal is to get rich by planting all sorts of crops.\n");
        description.setText(description.getText() + "Don't forget to water and harvest your crops to prevent them from withering!\n\n");
        description.setText(description.getText() + "Tile\n- A place where you can do your farming\n\n");
        description.setText(description.getText() + "Seeds\n- ...seeds that you can plant on a tile\n- For more information about seeds, check the seed list\n\n");
        description.setText(description.getText() + "Tools\n- ...tools used on tiles/seeds/crops\n- For more information about tools, check the tools list\n\n");
        description.setText(description.getText() + "Crop\n- A fully grown seed\n\n");
        description.setText(description.getText() + "Objectcoins\n- Your currency to use tools and plant seeds\n- Gained by harvesting crops\n\n");
        description.setText(description.getText() + "XP\n- Your experience points\n- Gained through doing certain actions\n\n");
        description.setText(description.getText() + "Level\n- Your farmer level\n\n");
        description.setText(description.getText() + "How to Plant a Seed\n");
        description.setText(description.getText() + "1.Plow the Tile\n2, Choose the Seed you want to plant\n3. If requirements are met (ex: enough money, enough space, etc), seed will be planted.\n\n");
        description.setText(description.getText() + "How to Harvest a Crop\n");
        description.setText(description.getText() + "1. After Planting a seed, give the seed its water and fertilizer needs.\n2. Advance the day until the crop is harvestable.\n3. Press the harvest button to harvest the crop!\n\n");
        description.setText(description.getText() + "Sleep\n- Advances to the next day\n\n");
        description.setText(description.getText() + "Rank\n- Your Farmer Rank\n- Check the Rank List for more details\n\n");
        description.setText(description.getText() + "Withered Crop\n- A Crop that has not been taken care of or was not harvested on the day of harvest\n- Can only be removed using a shovel\n\n");
        description.setText(description.getText() + "Rock\n- Something that blocks you from doing things on a tile\n- Can only be removed using a pickaxe\n\n");
        description.setText(description.getText() + "Water and Fertilizer Bonus Limit Increase\n- When you \"over-water\" or \"over-fertilize\" a seed, you can earn more Objectcoins when you successfully harvest the crop\n\n");
        description.setText(description.getText() + "Storm\nThe weather's good most of the time in the farm, but there's a 2% chance that a Storm can happen every time you sleep, washing ALL crops away (yes, even withered crops). This can either be a tragedy, or a blessing...\n\n");
        description.setText(description.getText() + "New Game\n- Starts a new game\n- Can be clicked the game is over to start a new game\n\n");
        description.setText(description.getText() + "End Game\n- Ends the current game");
        description.setCaretPosition(0);

        JScrollPane scroll = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(300, 475));

        upper.add(text);
        center.add(scroll);

        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }

}
