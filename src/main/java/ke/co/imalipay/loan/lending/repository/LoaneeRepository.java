package ke.co.imalipay.loan.lending.repository;

import ke.co.imalipay.loan.lending.domain.Loanee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaneeRepository extends JpaRepository<Loanee, Long> {
}
