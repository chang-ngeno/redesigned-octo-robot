package ke.co.imalipay.loan.lending.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loan_product")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class LoanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_product_id", nullable = false)
    private Long id;

    private String loanType;
    private BigDecimal tenure;
    private BigDecimal loanAmount;
    private Double interestRate;

    @Override
    public String toString() {
        return "LoanProduct{" +
                "id=" + id +
                ", loanType='" + loanType + '\'' +
                ", tenure=" + tenure +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                '}';
    }
}
