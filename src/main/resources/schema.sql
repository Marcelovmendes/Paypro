CREATE TABLE IF NOT EXISTS "wallets"(
    ID SERIAL PRIMARY KEY, "fullname" VARCHAR(100) NOT NULL,
    "cpf" BIGINT NOT NULL, "email" VARCHAR(100) NOT NULL, 
    "password" VARCHAR(100) NOT NULL,"type" INT ,
    "balance" DECIMAL(10,2)
);
CREATE UNIQUE INDEX IF NOT EXISTS 'cpf_unique' ON 'wallets'('cpf');
CREATE UNIQUE INDEX IF NOT EXISTS 'email_unique' ON 'wallets'('email');

CREATE TABLE IF NOT EXISTS "transactions"(
    ID SERIAL PRIMARY KEY, "payer" INT, "payee" INT, 
    "value" DECIMAL(10,2), "createdAt" TIMESTAMP,
    FOREIGN KEY (payer) REFERENCES wallets(id),
    FOREIGN KEY (payee) REFERENCES wallets(id)  
)