package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ToolPriceView extends JFrame {

    public ToolPriceView() {
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Tool Prices and Description");

        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 550));
        
        JLabel text = new JLabel();
        text.setText("Tool Prices and Descriptions");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        upper.add(text);

        JTextPane description = new JTextPane();
        description.setPreferredSize(new Dimension(350, 475));
        description.setText("PLOW\n- Cost: FREE\n- Plows a tile\n- Can only be used if the tile is empty\n\n");
        description.setText(description.getText() + "WATERING CAN\n- Cost: FREE\n- Waters a seed\n- Can only be used if the tile has a seed\n\n");
        description.setText(description.getText() + "FERTILIZER\n- Cost: 10 Object Coins\n- Ferilizes a seed\n- Can only be used if the tile has a seed\n\n");
        description.setText(description.getText() + "PICKAXE\n- Cost: 50 Object Coins\n- A tool used for breaking rocks\n- Can only be used to break... rocks (yeah pretty cool)\n\n");
        description.setText(description.getText() + "SHOVEL\n- Cost: 7 Object Coins\n- A tool used for moving materials\n- Can be used anytime (might have consquences though wink wink)");
        description.setFont(new Font("Cambria", Font.PLAIN, 14));
        description.setEditable(false);

        center.add(description);

        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }
}
