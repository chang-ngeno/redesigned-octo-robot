package ke.co.imalipay.loan.lending.service;

import ke.co.imalipay.loan.lending.domain.LoanProduct;
import ke.co.imalipay.loan.lending.domain.Loanee;
import ke.co.imalipay.loan.lending.repository.LoanIssuedRepository;
import ke.co.imalipay.loan.lending.repository.LoanProductRepository;
import ke.co.imalipay.loan.lending.repository.LoanWalletRepository;
import ke.co.imalipay.loan.lending.repository.LoaneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanRequest {

    private LoaneeRepository loaneeRepository;
    private LoanProductRepository loanProductRepository;
    private LoanWalletRepository loanWalletRepository;
    private LoanIssuedRepository loanIssuedRepository;

    @Autowired
    public LoanRequest(LoanProductRepository loanProductRepository, LoaneeRepository loaneeRepository,
                       LoanWalletRepository loanWalletRepository, LoanIssuedRepository loanIssuedRepository) {
        this.loanProductRepository = loanProductRepository;
        this.loaneeRepository = loaneeRepository;
        this.loanIssuedRepository = loanIssuedRepository;
        this.loanWalletRepository = loanWalletRepository;
    }

    // Loan offer: One or more loan products that the customer can qualify to borrow.
    // An offer should include, loan amount, fixed percentage interest, loan tenure
    public List<LoanProduct> getLoanOffer(Long loaneeDtlsId) {
        Loanee loanee;
        List<LoanProduct> loanProducts = loanProductList();
        List<LoanProduct> loanProductsQualified = new ArrayList<>();
        BigDecimal maxLoanAmt;

        // TODO: fix the algorithm for small products
        if (loaneeDtlsId.longValue() != 0L) {
            loanee = loaneeRepository.findById(loaneeDtlsId).get();
            if (loanee != null) {
                maxLoanAmt = loanee.getMaxCredit();
                for (int i = 0; i < loanProducts.size(); i++) {
                    if (maxLoanAmt.compareTo(loanProducts.get(i).getLoanAmount()) < 0) {
                        loanProducts.get(i).setLoanAmount(maxLoanAmt);
                        loanProductsQualified.add(loanProducts.get(i));
                    }else {
                        loanProductsQualified.add(loanProducts.get(i));
                    }
                }
                loanProducts = loanProductsQualified;
            } else
                loanProducts = null;
        } else {
            loanProducts = null;
        }

        return loanProducts;
    }

    public List<LoanProduct> loanProductList() {
        return loanProductRepository.findAll();
    }

}
