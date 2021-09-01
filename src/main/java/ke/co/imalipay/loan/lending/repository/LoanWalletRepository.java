package ke.co.imalipay.loan.lending.repository;

import ke.co.imalipay.loan.lending.domain.LoaneeWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanWalletRepository extends JpaRepository<LoaneeWallet, Long> {
}
