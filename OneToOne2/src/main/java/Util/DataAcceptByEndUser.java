package Util;

import Connection.SessionFactoryHelper;
import Model.Bank;
import Model.BankAccounts;
import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DataAcceptByEndUser {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFac();
        Session session = sessionFactory.openSession();

      Bank b1 =  acceptBankDetails();

        Transaction tx = session.beginTransaction();
        session.save(b1);
        tx.commit();
        session.close();
        System.out.println("DATA ADDED SUCCESSFULLY!");

    }
    private static Bank acceptBankDetails(){
        System.out.println("ENTER BANK NAME ");
        String bName = sc.next();
        System.out.println("ENTER BANK IFSC CODE ");
        String ifscCode = sc.next();
        sc.nextLine();
        System.out.println("ENTER BANK ADDRESS ");
        String address = sc.nextLine();

        Bank b = new Bank();
        b.setBankName(bName);
        b.setIfscCode(ifscCode);
        b.setBankAddress(address);

        System.out.println("HOW MANY CUSTOMER YOU WANT TO ADD ");
        int count = sc.nextInt();
        for (int i = 1 ; i<=count ; i++){
            Customer c1 = accCustomerDetails();
           b.addCustomer(c1);
        }

        return b;
    }

    private static Customer accCustomerDetails(){
        System.out.println("ENTER CUSTOMER NAME ");
        String name = sc.next();
        System.out.println("ENTER ADHAR CARD NUMBER ");
        long adhar = sc.nextLong();
        sc.nextLine();
        System.out.println("ENTER CUSTOMER ADDRESS ");
        String address = sc.nextLine();

        Customer c1 = new Customer();
        c1.setCustomerName(name);
        c1.setAadharCardId(adhar);
        c1.setCustomerAddress(address);

        System.out.println("How many account u want to add:- ");
        int count = sc.nextInt();


        for (int i = 0; i <count ; i++) {
            BankAccounts accounts =acceptAccountData();
            c1.addAccount(accounts);
        }

        return c1;

    }

    private static BankAccounts acceptAccountData(){
        System.out.println("ENTER ACCOUNT HOLDER NAME ");
        String name = sc.nextLine();
        System.out.println("ENTER ACCOUNT BALANCE ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("ENTER ACCOUNT TYPE ");
        String type = sc.nextLine();

        BankAccounts b4 = new BankAccounts();
        b4.setAccName(name);
        b4.setAccBalance(balance);
        b4.setAccType(type);

        return b4;
    }

}
