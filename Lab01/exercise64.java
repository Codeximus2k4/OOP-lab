import java.util.Scanner;
public class exercise64 {
    public static void main(String args[]){
        String[] monthlist = {"January","February","March","April","May","June","July","August","September","October","November","December","Jan","Feb","Mar","Apr","May","Jun","Aug","Sep","Oct","Nov","Dec","Jan.","Feb"
        ,"Mar.","Apr.","May","June","July","Aug.","Sept","Oct.","Nov.","Dec."};
        int[] daynormalyear = {31,28,31,30, 31, 30, 31,31,30,31,30,31};
        int[] dayleapyear= {31,29,31,30, 31, 30, 31,31,30,31,30,31};
        Scanner keyboard = new Scanner(System.in);
        String month;
        boolean foundmonth = false;
        int count =0;
        while (!foundmonth)
        {
            System.out.println("Please input the month in the correct format");
            month =  keyboard.nextLine();
            count =-1;
            for (String element: monthlist)
            {
                count ++;
                if (month.equals(element))
                {
                    foundmonth = true;
                    break;
                }
            }
        }
        int year;
        boolean foundyear =  false;
        while (!foundyear){
            System.out.println("Please input the year in the correct format");
            year = keyboard.nextInt();
            if (year>0)
            {
                foundyear =true;
                if (year%4==0)
                {
                    if ((year %100==0) && (year%400!=0))
                    {
                        System.out.println("The day in that month is "+ daynormalyear[count%12]);

                    }
                    else{
                        System.out.println("The day in that month is "+ dayleapyear[count%12]);
                    }
                }
                else
                {
                    System.out.println("The day in that month is "+ daynormalyear[count%12]);
                }
            }
        }
    }
}
