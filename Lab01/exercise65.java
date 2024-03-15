import java.util.Scanner;
import java.util.Arrays;
public class exercise65 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please input the number of elements in the array");
        int n = keyboard.nextInt();
        System.out.println("Please input each number of the arrays");
        int[] array = new int[n];
        double sum =0;
        for (int i=0;i<=n-1;i++)
        {
            int element = keyboard.nextInt();
            array[i]= element;
            sum += element;
        }
        for (int i=0; i<= n-1;i++)
        {
            int min = i;
            for (int j=i;j<=n-1;j++)
            {
                if (array[j]<array[min]) min =j;
            }
            int temp = array[i];
            array[i]= array[min];
            array[min]= temp;
        }
        System.out.println("the array is "+Arrays.toString(array)+ " and the average value is "+sum/n);
    }
}
