package Operation;

import Connection.SessionFactoryHelper;
import Model.Bank;
import Model.BankAccounts;
import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.Scanner;

public class DisplayData {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFac();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER IFSC CODE ");
        String ifsc = sc.next();

        Query query = session.createQuery("from Bank b where b.ifscCode='"+ifsc+"'");
        List<Bank> bankList = query.getResultList();

        for (Bank b : bankList){
            System.out.println("BANK ID "+b.getBankId());
            System.out.println("BANK NAME "+b.getBankName());
            System.out.println("BANK IFSC CODE "+b.getIfscCode());
            System.out.println("BANK ADDRESS "+b.getBankAddress());
            List<Customer> customerList = b.getCustomerList();
            System.out.println("-----------------------------------------");
            for (Customer c : customerList){
                System.out.println("CUSTOMER ID "+c.getCustomerId());
                System.out.println("CUSTMORE NAME "+c.getCustomerName());
                System.out.println("CUSTOMER ADDRESS "+c.getCustomerAddress());
                System.out.println("ADHAR ID "+c.getAadharCardId());
                List<BankAccounts> bankAccountsList = c.getBankAccountsList();
                System.out.println("-----------------------------------------");
                for (BankAccounts ba:bankAccountsList){
                    System.out.println("BANK ACCOUNT NUMBER "+ba.getAccNumber());
                    System.out.println("BANK ACCOUNT NAME "+ba.getAccName());

                }
            }
        }

        session.close();
    }




}
