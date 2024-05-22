import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //Register Section
        String RegisterAccount = null;
        int RegisterPass = 0;
        int RegisterDeposit = 0;
        //Login Section
        String Username = null;
        int Passcode = 0;
        //Misc Section
        int LoginAttemptCount = 0;
        int AccountBalance = 0;

            loop: while (LoginAttemptCount < 5) {
                //Banking Normal Login Screen
        System.out.print("\nWelcome to Atlas Banking! Please Login or Register \nType:" + "\n- Register (create a new account)" + "\n- Login (Enter an existing account)" + "\n");
        String registerprompt = input.readLine();
        switch(registerprompt) {
            case "Register", "register":
            System.out.print("\nType your Username: ");
            Username = input.readLine();
            System.out.print("\nType your Passcode: ");
            Passcode = Integer.parseInt(input.readLine());
            System.out.print("\nEnter an amount for initial deposit: ");
            RegisterDeposit = Integer.parseInt(input.readLine());
            System.out.print("Success, your account has been created! Your Account Details are:" + "\nUsername > " + Username + "\nPasscode > " + Passcode + "\nDeposit > " + RegisterDeposit);
            //Final Details After Registration
            RegisterAccount = Username;
            AccountBalance = RegisterDeposit;
            RegisterPass = Passcode;

            break;

            case "Login", "login":
            System.out.print("Username: ");
            RegisterAccount = input.readLine();
            System.out.print("Passcode: ");
            RegisterPass = Integer.parseInt(input.readLine());
            if(RegisterAccount == Username || RegisterPass == Passcode){
                System.out.println("Welcome to Atlas Banking! What would you like to do? \n =============");
                break loop;
            }
            else {
                System.out.println("Invalid Credentials! Please Try Again");
                LoginAttemptCount++;
            }
            }
            }
            
            //Bunch of Stuff
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String Options = null;
            //Account Expiry Date RNG
            int daymin = 1;
            int daymax = 30;
            int day = (int)Math.floor(Math.random()*(daymax-daymin+1)+daymin);
            int yearmin = 22;
            int yearmax = 29;
            int year = (int)Math.floor(Math.random()*(yearmax-yearmin+1)+yearmin);
            int monthmin = 1;
            int monthmax = 12;
            //Date RNG
            int month = (int)Math.floor(Math.random()*(monthmax-monthmin+1)+monthmin);
            //CVS RNG
            int CVS = (int)Math.floor(Math.random()*999);
            //Transaction ID RNG
            int TransactionID = (int)(Math.random()*9999999);
            //Account Number RNG
            int AccountNumber = (int)(Math.random()*1000000000);
            loop2: while(Options != "7"){
                System.out.println("1: Check Account Balance");
                System.out.println("2: Check Account Status");
                System.out.println("3: Withdraw");
                System.out.println("4: Deposit");
                System.out.println("5: Transfer Funds");
                System.out.println("6: Pay Bills Via AtlasPay");
                System.out.print("7: Logout \n");
                Options = input.readLine();
            switch(Options){

            //CHECK ACCOUNT BALANCE
            case "1":
                    System.out.println("CHECK ACCOUNT BALANCE");
                    System.out.println(AccountBalance);
                    break;

            //CHECK ACCOUNT STATUS
            case "2":
                    System.out.println("CHECK ACCOUNT STATUS");
                    System.out.println("Account Number: " + AccountNumber);
                    System.out.println("Expiry Date: " + day + "/" + month + "/" + year);
                    System.out.println("CVS: " + CVS);
                    break;

            //WITHDRAW
            case "3":
                System.out.println("WITHDRAW");
                System.out.println("Withdraw Amount: ");
                int withdraw = Integer.parseInt(input.readLine());
                if(withdraw > 50000){
                    System.out.println("You have reached the limit of allowed withdraw amount per transaction \n");
                }
                else if(AccountBalance < withdraw) {
                    System.out.println("Insufficient Balance \n");
                }
                else {
                    AccountBalance -= withdraw;
                    System.out.println("Transaction Record: \n");
                    System.out.println(dtf.format(now));
                    System.out.println("Transaction ID: \n" + TransactionID);
				System.out.println("Withdraw Ammount: " + withdraw);
				System.out.println("Withdraw Successfully!");
				System.out.println("\nRemaining Balance: " + AccountBalance);
                }
                break;

            //DEPOSIT
            case "4":
                System.out.println("DEPOSIT");
                System.out.println("Deposit Amount: ");
                int deposit = Integer.parseInt(input.readLine());
                AccountBalance += deposit;
                System.out.println("Transaction Record");
                System.out.println(dtf.format(now));
                System.out.println("Transaction ID: \n" + TransactionID);
                System.out.println("Your New Balance is: \n" + AccountBalance);
                break;

            //TRANSFER FUNDS
            case "5":
                System.out.println("Please Select A 10-Digit Account Number: \n");
                int transferaccnum = Integer.parseInt(input.readLine());
                System.out.println("Please Select The Amount Will Be Transferred to this Account: \n");
                int Transferee = Integer.parseInt(input.readLine());
                AccountBalance -= Transferee;
                    System.out.println("Transaction Record: \n");
                    System.out.println(dtf.format(now));
                    System.out.println("Transaction ID: \n" + TransactionID);
				System.out.println("Transfer Ammount: " + Transferee);
                System.out.println("Transferred to: \n" + transferaccnum);
				System.out.println("Transfer Successfully!");
				System.out.println("\nRemaining Balance: " + AccountBalance);
                break;

            //PAY BILLS
            case "6":
                System.out.println("PAY BILLS THROUGH ATLASPAY");
                System.out.println("Bill Type:\n");
                System.out.println("1: Loans");
                System.out.println("2: Services");
                String billtype = input.readLine();
                    switch(billtype){
                    case "1":
                        System.out.println("Enter The Loaning Company Name: ");
                        String LoanName = input.readLine();
                        System.out.println("Enter the Loan Amount: ");
                        int loan = Integer.parseInt(input.readLine());
                        if(AccountBalance >= loan) {
                            AccountBalance -= loan;
                            System.out.println("Transaction Record: \n");
                    System.out.println(dtf.format(now));
                    System.out.println("Transaction ID: \n" + TransactionID);
				    System.out.println("Loan Amount: " + loan);
                    System.out.println("Company Name: \n" + LoanName);
				    System.out.println("Transfer Successfully!");
				    System.out.println("\nRemaining Balance: " + AccountBalance);
                    break;
                        }
                        else {
                            System.out.println("Insufficient Balance \n");
                        }
                    case "2":
                    System.out.println("Enter The Service Name: ");
                    String ServiceName = input.readLine();
                    System.out.println("Enter the Service Fee: ");
                    int service = Integer.parseInt(input.readLine());
                    if(AccountBalance >= service) {
                        AccountBalance -= service;
                        System.out.println("Transaction Record: \n");
                        System.out.println(dtf.format(now));
                    System.out.println("Transaction ID: \n" + TransactionID);
				    System.out.println("Service Fee Amount: " + service);
                    System.out.println("Service Name: \n" + ServiceName);
				    System.out.println("Transfer Successfully!");
				    System.out.println("\nRemaining Balance: " + AccountBalance);
                    break;
                    }
                    else {
                        System.out.println("Insufficient Balance \n");
                    }
                    break;


            }

            case "7":
            System.out.println("\n[Logging Out] Have A Great Day, Thank you for Using Atlas Banking!");
            break loop2; 
            }
            }    
            

            } }
        
