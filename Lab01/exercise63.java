import java.util.Scanner;
public class exercise63 {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please input n");
        String padding;
        String charac="*";
        int n = keyboard.nextInt();
        for (int i =n-1;i>=0;i--)
        {
            padding="";
            for (int j=1;j<=i;j++)  padding =padding + " ";
            System.out.println(padding + charac+padding);
            charac= charac +"*" +"*";
        }
    }

}
