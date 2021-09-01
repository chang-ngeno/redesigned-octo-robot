package ke.co.imalipay.loan.lending.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loanee_details")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Loanee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanee_details_id")
    private Long id;

    @NonNull
    private BigDecimal maxCredit;

    @Override
    public String toString() {
        return "Loanee{" +
                "id=" + id +
                ", maxCredit=" + maxCredit +
                '}';
    }
}
