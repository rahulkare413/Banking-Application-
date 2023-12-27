package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter

public class Customer {

@Id
@Column(name = "customer_id")
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerIdGenerator")
@SequenceGenerator(name = "customerIdGenerator",initialValue = 1001 , allocationSize = 1000)
    private int customerId;
@Column(name = "customer_name")
    private String customerName;

@Column(name = "aadhar_card_id")
    private long aadharCardId;

@Column(name = "customer_address")
    private String customerAddress;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
   @JoinColumn(name = "bank_ref_id")
    private Bank bankRefId;
    @OneToMany(mappedBy = "customerRef",cascade = CascadeType.ALL)
    private List<BankAccounts> bankAccountsList ;

    public void addAccount(BankAccounts bankAccounts){
        if (bankAccountsList==null){
            bankAccountsList= new LinkedList<>();

        }
        bankAccountsList.add(bankAccounts);
        bankAccounts.setCustomerRef(this);


    }
}
