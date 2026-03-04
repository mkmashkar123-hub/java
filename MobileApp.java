class MobileConnection {
    String mobileNumber;
    String customerName;
    double balance;

    static double minimumBalace;
    static int totalConnection;

    public MobileConnection(String mobileNumber,String customerName,double balance) {
        this.mobileNumber = mobileNumber;
        this.customerName = customerName;
        this.balance = balance;

        totalConnection++;
    }

    public void recharge(double amount){
        if(amount >0){    
            this.balance += amount;
            System.out.println("Your New  Blance : "+this.balance);
        } else {
            System.out.println("invalid Recharge Amount : ");
        }
    }

    public boolean makeCall(double cost){
        if((this.balance-cost) >= minimumBalace){
            this.balance -= cost;
            System.out.println("Call Succsessful Remail Balance " +balance);
            return true;
        }
        else {
            System.out.println("Call Failed Low Balance "+minimumBalace);
            return false;
        }
    }
    public double getBalance(){
        return balance;
    }
    public static void minimumbalance(double min){
        if(min>=0){
            minimumBalace=min;
            System.out.println("Minibalance Update : "+minimumBalace);
        }
        else{
            System.out.println("Minubalance Negative : ");
        }
        
    }
    public static void displayTotalconnection(){
        System.out.println("Total mobile connection created : "+totalConnection);
    }

}
public class MobileApp {

    static void transferBalance(MobileConnection from,MobileConnection to,double amount) {
            if(amount <= 0){
                System.out.println("Transfer amount must be positive ...");
                return;
            }
            
            System.out.println("Attempting to transfer amount "+amount+"...");

            boolean success= from.makeCall(amount);
            if(success){
                to.recharge(amount);
                System.out.println("Balance transfer successsful");
            } else {
                System.out.println("Balance transfer failed");
            }
            System.out.println(".............");
    }

    public static void main(String [] args){
        MobileConnection.minimumbalance(20.0);

        MobileConnection con1 = new MobileConnection("0740156164", "Ashkar",150.0 );
        MobileConnection con2 = new MobileConnection("0783787179", "Ashu", 45.0);

        System.out.println();

        System.out.println("Recharge Ashkar with 100...");
        con1.recharge(100.0);
        System.out.println();

        System.out.println("Ashkar call with 60..");
        System.out.println((con1.makeCall(60) ? "Success" : "Fail"));

        System.out.println();

        System.out.println("Ashu call with 30..");
        System.out.println((con2.makeCall(30) ? "Success" : "Fail"));

        System.out.println();

        System.out.println("Current Balance - Ashkar : "+con1.getBalance());
        System.out.println("Current Blance - Ashu : "+con2.getBalance());
        
        System.out.println();

        MobileConnection.displayTotalconnection();
        
        System.out.println();


        System.out.println("===Balance Transfer ===");

        System.out.println("Transfer 50 Ashkar to Ash : ");
        transferBalance(con1,con2,50.0);

        System.out.println();

        System.out.println("After successful Transfer: ");
        System.out.println("Ashkar : "+ con1.getBalance());
        System.out.println("Ash : "+ con2.getBalance());

        System.out.println();

        System.out.println("Trying large transfer :\n\n");
        transferBalance(con1,con2,120.0);
    }

}
