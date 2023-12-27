package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
@Getter
@Setter
public class BankAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accNumGene")
    @SequenceGenerator(name = "accNumGene",initialValue = 100001,allocationSize = 1000)
    @Column(name = "acc_number")
    private long accNumber;

    @Column(name = "acc_name")
    private String accName;
    @Column(name = "acc_balance")
    private double accBalance;
    @Column(name = "acc_type")
    private String accType;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "cust_ref")
    private Customer customerRef;



}
