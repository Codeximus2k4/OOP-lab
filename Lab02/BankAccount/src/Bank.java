public class Bank {
    public static void main(String args[]){
        NormalAccount A =  new NormalAccount("Catherine Johnson",1234214299,60000);
        A.deposit_normal(12000);
        A.withdraw_normal(2000);
        A.get_info();

    }
}
class Account{
    private String owner_name;
    private int  account_num;
    private float balance;
    public Account(String owner_name, int account_num, float balance){
        this.owner_name = owner_name;
        this.account_num = account_num;
        if ( balance< 50000)
        {
            System.out.println("The initial balance must be at least 50000");
        }
        else
        {
            this.balance = balance;
        }
    }
    public float getBalance(){
        return this.balance;
    }
    public Account(String owner_name, int account_num)
    {
        this.account_num = account_num;
        this.owner_name = owner_name;
        this.balance = 50000;
    }
    public void get_info(){
        System.out.println("The account is of Mr/Mrs "+ this.owner_name);
        System.out.println("The account number is "+ this.account_num);
        System.out.println("The account balance is "+this.balance);
    }
    public void set_balance(int amount){
        this.balance += amount;
    }
    public Account(){
    this.account_num = 123456789;
    this.owner_name  = "Unknown";
    this.balance = 50000;
    }
}
class NormalAccount extends Account{

    public NormalAccount(String owner_name, int account_num, float balance){
        super(owner_name,account_num,balance);
    }
    public NormalAccount(String owner_name, int account_num){
        super(owner_name,account_num);
    }
    public void deposit_normal(int amount){
        if (amount>0) this.set_balance(amount);
    }
    public void normal_account_info(){
        get_info();
    }
    public void withdraw_normal(int amount){
        if (amount>0) this.set_balance(-amount);
    }
}
class SavingAccount extends Account{

    public SavingAccount(String owner_name, int account_num, float balance){
        super(owner_name,account_num,balance);
    }
    public SavingAccount(String owner_name, int account_num){
        super(owner_name,account_num);
    }
    private float annual_interest_rate = 0.05F;
    public float get_interest_rate(){
        return annual_interest_rate;
    }
    public float get_monthly_interest(){
        return this.getBalance()*this.get_interest_rate()/12;
    }
    public void deposit_saving(int amount){
        if (amount>0) this.set_balance(amount);
    }
}
