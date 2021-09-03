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
import java.util.List;

@Service
public class LoanRequest {

    private LoaneeRepository loaneeRepository;
    private LoanProductRepository loanProductRepository;
    private LoanWalletRepository loanWalletRepository;
    private LoanIssuedRepository loanIssuedRepository;

    @Autowired
    public LoanProductRepository getLoanProductRepository() {
        return loanProductRepository;
    }

    @Autowired
    public LoaneeRepository getLoaneeRepository() {
        return loaneeRepository;
    }

    @Autowired
    public LoanWalletRepository getLoanWalletRepository() {
        return loanWalletRepository;
    }

    @Autowired
    public LoanIssuedRepository getLoanIssuedRepository() {
        return loanIssuedRepository;
    }

    // Loan offer: One or more loan products that the customer can qualify to borrow.
    // An offer should include, loan amount, fixed percentage interest, loan tenure
    public List<LoanProduct> getLoanOffer(Long loaneeDtlsId) {
        Loanee loanee;
        List<LoanProduct> loanProducts = loanProductRepository.findAll();
        List<LoanProduct> loanProductsQualified = null;
        BigDecimal maxLoanAmt;

        // TODO: fix the algorithm for small products
        if (loaneeDtlsId.longValue() != 0L) {
            loanee = loaneeRepository.findById(loaneeDtlsId).get();
            if (loanee != null) {
                maxLoanAmt = loanee.getMaxCredit();
                for (int i = 0; i < loanProducts.size(); i++) {
                    if(maxLoanAmt.compareTo(loanProducts.get(i).getLoanAmount())<0){
                        loanProductsQualified.add(loanProducts.get(i));
                    }
                }
                loanProducts = loanProductsQualified;
            }else
                loanProducts=null;
        }else{
            loanProducts = null;
        }

        return loanProducts;
    }

}
