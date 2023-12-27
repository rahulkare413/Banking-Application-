package Operation;

import Connection.SessionFactoryHelper;
import Model.Bank;
import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeleteData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFac();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

//        Customer customer = session.get(Customer.class, 4003);
//
//
//        customer.setBankRefId(null);
//
//        session.delete(customer);
//
//        tx.commit();
//        session.close();
//        System.out.println("DATA DELETED SUCCESSFULLY");

        Customer c1 = session.get(Customer.class,2003);
        session.delete(c1);
        tx.commit();
        session.close();
        System.out.println("DATA DELETED SUCCESSFULLY");




    }
}
