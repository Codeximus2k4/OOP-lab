import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args){
        String  strnum1, strnum2;
        String strNotification = "You've just entered: ";
        strnum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: \n",
                "Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification +=strnum2;
        JOptionPane.showMessageDialog(null, strNotification,"show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
