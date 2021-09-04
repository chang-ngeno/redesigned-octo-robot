# ImaliPay Lending App - Test

Through this web service one can request a loan offer and he/she is presented with one or
more loan offers based on the customer loan maximum qualification. From the offers
presented, a customer can choose and accept one of the offers. When a customer accepts
an offer then we will credit his mobile wallet.

## API documentation
The endpoints documentation are available on:
> http://{host:port}/swagger-ui.html

## Assumptions

1. Users/clients and loan products already exist.
2. End points for modifications of the users/clients and the loan products already exist.
3. The mobile wallet utility is a fully functional microservice.


http://localhost:8080/api/loan/1/request


