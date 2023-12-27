package Operation;

import Connection.SessionFactoryHelper;
import Model.Bank;
import Model.BankAccounts;
import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class UpdateData {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFac();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

      BankAccounts b1 =  session.get(BankAccounts.class,101005l);
      b1.setAccName("RAHUL");

      session.update(b1);
      tx.commit();
        System.out.println("DATA UPDATED SUCCESSFULLY ");
      session.close();








    }
}
