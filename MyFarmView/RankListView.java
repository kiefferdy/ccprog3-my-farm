package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

// Window where all the farmer ranks and their descriptions will be displayed
public class RankListView extends JFrame{
    public RankListView() {
        // Sets specifications of the window
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Ranks");

        // Sets specifications of the upper panel of the window
        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the left panel of the window
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the right panel of the window
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the center panel of the window
        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 475));
        
        // Title text of the descriptions
        JLabel text = new JLabel();
        text.setText("Ranks");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        // Textpane where the ranks and their descriptions will be placed
        JTextPane description = new JTextPane();
        description.setPreferredSize(new Dimension(300, 475));
        description.setFont(new Font("Cambria", Font.PLAIN, 14));
        description.setEditable(false);

        // Setting all the text in description
        description.setText("Ranks are beneficial for a farmer's growth, as they give you bonuses in the long run.\n");
        description.setText(description.getText() + "You gain ranks by registering for them using the \"RANK UP!\" button.\n\n");
        description.setText(description.getText() + "Pressing the button will immediately rank you up IF you meet the required level and have enough Objectcoins to pay for the fee.\n\n");
        description.setText(description.getText() + "You start as rank \"Farmer\", which does not give any bonuses. \n");
        description.setText(description.getText() + "However, once you increase your rank, you get various bonuses, which will be listed down below.\n\n");
        description.setText(description.getText() + "Rank Farmer\n- No Bonuses\n- Your Starting Rank\n\n");
        description.setText(description.getText() + "Rank Registered Farmer\n- Level Requirement: 5\n- Bonus Earnings Per Produce: +1\n- Seed Cost Reduction: -1\n- Registration Fee: 200 Objectcoins\n\n");
        description.setText(description.getText() + "Rank Distinguised Farmer\n- Level Requirement: 10\n- Bonus Earnings Per Produce: +2\n- Seed Cost Reduction: -2\n- Water Bonus Limit Increase: +1\n- Registration Fee: 300 Objectcoins\n\n");
        description.setText(description.getText() + "Rank Legendary Farmer\n- Level Requirement: 15\n- Bonus Earnings Per Produce: +4\n- Seed Cost Reduction: -3\n- Water Bonus Limit Increase: +2\n- Fertilizer Bonus Limit Increase: +1\n- Registration Fee: 400 Objectcoins");
        description.setCaretPosition(0);

        // Scroll pane to scroll up and down the descriptions
        JScrollPane scroll = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(300, 475));

        // adding title text to the upper panel; adding scroll pane to the center panel
        upper.add(text);
        center.add(scroll);

        // adding panels to the main window
        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }
}
