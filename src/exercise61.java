import javax.swing.JOptionPane;
public class exercise61 {
    public static void main(String[] args){
        String[] options = {"I do","I don't"};
        int choice = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?","confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0] );
        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("User selected 'Yes'");
            // Do something if user selects 'Yes'
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("User selected 'No'");
            // Do something if user selects 'No'
        } else {
            System.out.println("User closed the dialog without making a choice");
            // Do something else if user closes the dialog without making a choice
        }
    System.exit(0);
    }
}
