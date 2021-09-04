package ke.co.imalipay.loan.lending;

import ke.co.imalipay.loan.lending.domain.LoanProduct;
import ke.co.imalipay.loan.lending.domain.Loanee;
import ke.co.imalipay.loan.lending.repository.LoanProductRepository;
import ke.co.imalipay.loan.lending.repository.LoaneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeding implements CommandLineRunner {

    private final LoaneeRepository loaneeRepository;
    private final LoanProductRepository loanProductRepository;

    @Autowired
    public DataSeeding(LoaneeRepository loaneeRepository, LoanProductRepository loanProductRepository){
        this.loaneeRepository=loaneeRepository;
        this.loanProductRepository=loanProductRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // init loanees
        List<Loanee> loanees = new ArrayList<>();
        loanees.add(new Loanee(BigDecimal.valueOf(15000)));
        loanees.add(new Loanee(BigDecimal.valueOf(30000)));
        loanees.add(new Loanee(BigDecimal.valueOf(25000)));
        loanees.add(new Loanee(BigDecimal.valueOf(5000)));
        loanees.add(new Loanee(BigDecimal.valueOf(10000)));
        loanees.add(new Loanee(BigDecimal.valueOf(16000)));
        loaneeRepository.saveAll(loanees);

        // init Loan Products
        List<LoanProduct> loanProducts = new ArrayList<>();
        loanProducts.add(new LoanProduct("Product A",15,BigDecimal.valueOf(10000), 10.0));
        loanProducts.add(new LoanProduct("Product B",30,BigDecimal.valueOf(25000), 12.5));
        loanProductRepository.saveAll(loanProducts);
    }
}