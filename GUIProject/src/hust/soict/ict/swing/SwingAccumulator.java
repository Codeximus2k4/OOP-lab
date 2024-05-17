package hust.soict.ict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {

    private JTextField tfInput;
    private JTextField tfOutput;                                                             // Accumulated sum, init to 0
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        add(tfInput);

        tfInput.addActionListener(new TFInputListener());

        add(new JLabel("The Accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);

        add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);

        setVisible(true);
    }

    // Inner class to handle input field events


    public static void main(String[] args) {
        new SwingAccumulator();
    }
    private class TFInputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {

            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");

        }
    }
}