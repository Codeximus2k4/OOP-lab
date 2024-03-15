import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[]  args){
        String strnum1, strnum2, strnum3;
        double result = 0;
        strnum1 = JOptionPane.showInputDialog(null, "Input the numbers and then the calculation you want. Input + for addition, - for subtraction, \\ for division, * for multiplication. \nPlease input the first number: ",
                "calculation"
                ,JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "Input the numbers and then the calculation you want. Input + for addition, - for subtraction, \\ for division, * for multiplication. \nPlease input the second number: ",
                "calculation"
                ,JOptionPane.INFORMATION_MESSAGE);
        strnum3 = JOptionPane.showInputDialog(null, "Input the numbers and then the calculation you want. Input + for addition, - for subtraction, \\ for division, * for multiplication. \nPlease input the calculation method: ",
                "calculation"
                ,JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);
        if (strnum3.equals("+"))
        {
            result = num1+ num2;
        } else if (strnum3.equals("-")) {
            result = num1 -num2;
        }
        else if (strnum3.equals("\\"))
        {
            result = num1/num2;
        }
        else if (strnum3.equals("*"))
        {
            result = num1*num2;
        }
        JOptionPane.showMessageDialog(null,"The result is "+ result);
    }
}
