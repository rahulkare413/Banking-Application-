package Connection;

import Model.Bank;
import Model.BankAccounts;
import Model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {

  public static SessionFactory getSessionFac(){
      Configuration cfg = new Configuration().configure().addAnnotatedClass(Bank.class).addAnnotatedClass(Customer.class).addAnnotatedClass(BankAccounts.class);
      SessionFactory sessionFactory = cfg.buildSessionFactory();

      return sessionFactory;

    }
}
