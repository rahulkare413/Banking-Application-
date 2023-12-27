package Operation;

import Connection.SessionFactoryHelper;
import Model.Bank;
import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InsertData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFac();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Bank sbh = new Bank();
        sbh.setBankName("SBH");
        sbh.setIfscCode("SBH121");
        sbh.setBankAddress("DELHI");

        Customer c1 = new Customer();
        c1.setCustomerName("SHIKHA");
        c1.setAadharCardId(789654);
        c1.setCustomerAddress("DELHI");
        c1.setBankRefId(sbh);

        Customer c2 = new Customer();
        c2.setCustomerName("JYOTI");
        c2.setAadharCardId(74103);
        c2.setCustomerAddress("DELHI");
        c2.setBankRefId(sbh);

        Customer c3 = new Customer();
        c3.setCustomerName("DISHA");
        c3.setAadharCardId(1239852);
        c3.setCustomerAddress("DELHI");
        c3.setBankRefId(sbh);

        sbh.addCustomer(c1);
        sbh.addCustomer(c2);
        sbh.addCustomer(c3);



        session.save(sbh);
        tx.commit();
        session.close();
        System.out.println("DATA ADDED SUCCESSFULLY ");

    }
}
