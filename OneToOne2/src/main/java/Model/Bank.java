package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "ifsc_code")
    private String ifscCode;
    @Column(name = "bank_address")
    private String bankAddress;

    @OneToMany(mappedBy = "bankRefId", cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public void addCustomer(Customer customer){
        if (customerList==null){
            customerList=new LinkedList<>();
        }
        customerList.add(customer);
        customer.setBankRefId(this);

    }
}
