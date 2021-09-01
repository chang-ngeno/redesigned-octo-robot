package ke.co.imalipay.loan.lending.repository;

import ke.co.imalipay.loan.lending.domain.LoanIssued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanIssuedRepository extends JpaRepository<LoanIssued, Long> {
}
