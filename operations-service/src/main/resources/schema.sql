CREATE TABLE IF NOT EXISTS account (
    id integer PRIMARY KEY,
    numberAccount VARCHAR(50),
    typeAccount VARCHAR(50),
    initialBalance DOUBLE PRECISION,
    status BOOLEAN,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS operations (
    id integer PRIMARY KEY,
    date DATE,
    typeOperation VARCHAR(50),
    amount DOUBLE PRECISION,
    balance DOUBLE PRECISION,
    account_id BIGINT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);