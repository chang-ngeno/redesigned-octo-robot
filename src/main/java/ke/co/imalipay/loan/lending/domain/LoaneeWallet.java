package ke.co.imalipay.loan.lending.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "loanee_wallet")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class LoaneeWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanee_wallet_id", nullable = false)
    private Long id;

    private BigDecimal amount;
    private Character transactionType;
    private Date transactionDate;
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(name = "loanee_dtls_id", updatable = false, nullable = false)
    private Loanee loanee;

    @Override
    public String toString() {
        return "LoaneeWallet{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
