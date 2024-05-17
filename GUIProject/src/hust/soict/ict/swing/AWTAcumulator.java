package hust.soict.ict.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAcumulator extends Frame {

    private TextField tfInput;
    private TextField tfOutput;                                                             // Accumulated sum, init to 0
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public AWTAcumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);

        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);

        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);

        setVisible(true);
    }

    // Inner class to handle input field event

    public static void main(String[] args) {
        new AWTAcumulator();
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