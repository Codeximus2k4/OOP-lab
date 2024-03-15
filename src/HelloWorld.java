public class HelloWorld {

    public void method1(FirstDialog arg1, FirstDialog arg2){
        FirstDialog temp = new FirstDialog();
        temp = arg1;
        arg1 = arg2;
        arg2 = temp;

    }
    public static void main(String args[]){
        System.out.println("Xin chao \n cac ban!");
        System.out.println("Hello \t world!");
        HelloWorld k1 =new HelloWorld();
        FirstDialog n1 = new FirstDialog();
        n1.a =30;
        FirstDialog n2 = new FirstDialog();n2.a=50;
        System.out.println(n1.a+ " "+ n2.a);
        k1.method1(n1,n2);
        System.out.println(n1.a+ " "+ n2.a);

    }
}
