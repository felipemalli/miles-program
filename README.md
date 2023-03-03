# Miles Program

This project is a API REST for handling miles with Quarkus.

This was a challenge of Java bootcamp that I did. In a project in the middle stage of development, I had to implement several functionalities for the project work.

<br>

## Description

Company customers can receive miles, transfer them to another person or redeem them for a product or service.

The system has 5 tables that are available in a H2 memory bank with application:
- Pessoa
- Lancamento
- TipoLancamento
- Produto
- Parceiro

There are three system usage roles: admin, user person and public.

The admin role is used by another system to communicate with yours. Admin endpoints include listing domains, checking all balances for all users, redeeming points with variable value and crediting points. Admin endpoints have a query parameter called "token", whose value must be **always** `4dmt0k3n!`.

The user role gives access to the management endpoints of your own account: after using the login endpoint to create a personal token, you can transfer points to another account, redeem points when purchasing products or services, check balance, statement and close account. This role only allows changes to the account that was logged in!

In public mode, only the endpoint/echo that responds `Hello!` is used to ensure that the application is working.

OBS: The `openapi-programa-milhas.txt` file in the root of the project is the complete Open API specification for the system.

---
<BR>

## Requirements of the challenge

1- Endpoint echo returns 'Hello' with status 200;

2- Person creation endpoint must successfully insert a Person;

3- Delete person endpoint works successfully;

4- Endpoint '/domain/tipolancamento' works successfully;

5- Endpoint '/domain/partner' works successfully;

6- Endpoint '/domain/product' works successfully;

7- Balance, transfer, redemption and extract operations work successfully;

8- Authentication works successfully for a user;

9- Authentication fails when credentials do not match.

And there are more details:
- Attempting to access closed endpoints with the missing or invalid token should result in a 500 error with the message "Acesso não autorizado".
- Attempting to login with any incorrect information should result in a 500 error with the message "Autenticacão inválida".
- Attempting to withdraw from an account with a lower balance than the withdrawal should result in a 500 error with the message "Saldo insuficiente".