package ke.co.imalipay.loan.lending.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loan_product")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class LoanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_product_id", nullable = false)
    private Long id;

    @NonNull
    private String loanType;

    @NonNull
    private double tenure;

    @NonNull
    private BigDecimal loanAmount;

    @NonNull
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
