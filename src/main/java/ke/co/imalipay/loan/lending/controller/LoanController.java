package ke.co.imalipay.loan.lending.controller;

import ke.co.imalipay.loan.lending.domain.LoanProduct;
import ke.co.imalipay.loan.lending.service.LoanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/loan",produces = {"application/json"}, consumes = {"application/json"})
public class LoanController {

    Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    private final LoanRequest loanRequest;

    @Autowired
    public LoanController(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    @GetMapping(path = "/loan-products")
    public List<LoanProduct> testEndPoint(){
        return loanRequest.loanProductList();
    }

    @GetMapping("/{id}/request")
    public List<LoanProduct> requestLoan(@PathVariable("id") String loaneeDtlsId){
        LOGGER.info("Entry :: Loan Controller :: requestLoan() ;; loaneeDtlsId="+loaneeDtlsId);
        List<LoanProduct> loanProducts = null;
        long loaneeId = Long.valueOf(loaneeDtlsId);
        try{
            loanProducts = loanRequest.getLoanOffer(loaneeId);
        }catch (Exception e){
            LOGGER.error("Error occurred ;; user given is "+ e.getMessage());
        }
        LOGGER.info("Exit :: Loan Controller :: requestLoan() :: Not Null");
        return loanProducts;
    }
}
