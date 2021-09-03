package ke.co.imalipay.loan.lending.controller;

import ke.co.imalipay.loan.lending.domain.Loanee;
import ke.co.imalipay.loan.lending.service.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/loanee")
public class LoaneeController {

    private final LoanRequest loanRequest;

    @Autowired
    public LoaneeController(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }


    //@GetMapping("")
    public List<Loanee> listLoanees(){
        return loanRequest.getLoaneeRepository().findAll();
    }

    //@GetMapping("/{id}")
    public Map<String,Loanee> getLoaneeById(@PathVariable("id") String loaneeId){
        Loanee loanee = null;
        String message;
        try{
            loanee = loanRequest.getLoaneeRepository().findById(Long.getLong(loaneeId)).get();
            message = "Success";
        }catch (Exception e){
            message="Loanee does not exist";
        }
        return (Map<String, Loanee>) new HashMap<>().put(message,loanee);
    }
}
