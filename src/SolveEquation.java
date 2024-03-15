import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveEquation {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Solve Equation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the buttons
        JPanel panel = new JPanel();
        JLabel label =  new JLabel("Please choose your type of equation to solve:");

        // Create buttons
        JButton button1 = new JButton("First-degree equation with one variable");
        JButton button2 = new JButton("System of first-degree equations");
        JButton button3 = new JButton("Second-degree equation with one variable");
        JButton button4 = new JButton("Exit");

        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You have chosen to solve first degree equation with one variable");
                first_degree_equation_1_variable();
                // Add your code here to perform tasks when Button 1 is clicked
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You have chosen to solve a system of first degree equations");
                first_degree_equation_2_variable();// Add your code here to perform tasks when Button 2 is clicked
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You have chosen to solve the second degree equation ");
                second_degree_equation();
                // Add your code here to perform tasks when Button 3 is clicked
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting...");
                frame.dispose();
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        frame.add(panel);

        // Set frame size and make it visible
        frame.setSize(600, 400);
        frame.setVisible(true);

    }
    public static void first_degree_equation_1_variable(){
        String strnum1;
        String strnum2;
        strnum1 = JOptionPane.showInputDialog(null, "The equation has the form ax+b=0. Please input a",
                "First degree equation"
                ,JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "The equation has the form ax+b=0. Please input b",
                "First degree equation"
                ,JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);
        if (num1==0){
            if (num2==0)
            {
                JOptionPane.showMessageDialog(null,"Infinite solution");
            }
            else{
                JOptionPane.showMessageDialog(null,"No solution");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"The result is "+ -num2/num1);
        }
    }
    public static void first_degree_equation_2_variable(){
        String a11,a12,b1;
        String a21,a22,b2;
       a11 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input a11",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        a12 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input a12",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        b1 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input b1",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        a21 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input a21",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        a22 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input a22",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        b2 = JOptionPane.showInputDialog(null, "The equation has the form a11x+a12y= b1 & a21x+a22y=b2. Please input b2",
                "First degree system of equations"
                ,JOptionPane.INFORMATION_MESSAGE);
        double diff = Double.parseDouble(b1)*Double.parseDouble(a22) - Double.parseDouble(b2)*Double.parseDouble(a12);
        double xcoeff = Double.parseDouble(a11)*Double.parseDouble(a22) - Double.parseDouble(a21)*Double.parseDouble(a12);
        if (diff ==0){
            if (xcoeff==0){
                JOptionPane.showMessageDialog(null,"Infinite solution");
            }
            else {
                JOptionPane.showMessageDialog(null,"No solution");
            }
        }
        else{
            double x =  diff/xcoeff;
            double y =  (Double.parseDouble(b1)- x* Double.parseDouble(a11))/Double.parseDouble(a12);
            JOptionPane.showMessageDialog(null,"The solutions are x = "+ x+ " and y = "+y);
        }
    }
    public static void second_degree_equation(){
        String a,b,c;
        a = JOptionPane.showInputDialog(null, "The equation has the form ax^2+bx+c=0 Please input a",
                "Second degree equation"
                ,JOptionPane.INFORMATION_MESSAGE);
        b = JOptionPane.showInputDialog(null, "The equation has the form ax^2+bx+c=0 Please input b",
                "Second degree equation"
                ,JOptionPane.INFORMATION_MESSAGE);
        c = JOptionPane.showInputDialog(null, "The equation has the form ax^2+bx+c=0 Please input c",
                "Second degree equation"
                ,JOptionPane.INFORMATION_MESSAGE);
        double acoeff = Double.parseDouble(a);
        double bcoeff = Double.parseDouble(b);
        double ccoeff = Double.parseDouble(c);
        if (acoeff==0){
            if (bcoeff==0)
            {
                if (ccoeff==0){
                    JOptionPane.showMessageDialog(null,"Infinite solution");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No solution");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Only one solution x = "+ -ccoeff/bcoeff);
            }
        }
        else {
            double delta = bcoeff*bcoeff - 4*acoeff*ccoeff;
            if (delta<0)
            {
                JOptionPane.showMessageDialog(null,"No solution");
            } else {
                double x1= (-bcoeff + Math.sqrt(delta))/(2* acoeff);
                double x2= (-bcoeff - Math.sqrt(delta))/(2* acoeff);
                if (delta ==0)
                {
                    JOptionPane.showMessageDialog(null,"Only one unique solution x= "+x1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Two unique solution x1= "+x1+ " and x2= "+ x2);
                }
            }
        }
    }
}