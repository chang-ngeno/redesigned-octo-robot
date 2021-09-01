package ke.co.imalipay.loan.lending.repository;

import ke.co.imalipay.loan.lending.domain.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct, Long> {
}
