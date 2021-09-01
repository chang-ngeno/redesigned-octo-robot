package ke.co.imalipay.loan.lending.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loan_issued")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class LoanIssued {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_issued_id", nullable = false)
    private Long id;

    private BigDecimal amount;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "loanee__dtls_id", nullable = false, updatable = false)
    private Loanee loanee;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_product_id", nullable = false, updatable = false)
    private LoanProduct loanProduct;

    @Override
    public String toString() {
        return "LoanIssued{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
