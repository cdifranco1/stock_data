DELETE FROM users;
DELETE FROM companies;

INSERT INTO users (userid, username, password)
VALUES  (1, 'cdifranco', 'hello'),
        (2, 'cdifranco2', 'hello'),
        (3, 'cdifranco3', 'hello');

INSERT INTO companies (companyid, companyname, symbol, userid)
VALUES (1, 'twitter', 'twtr', 1),
        (2, 'facebook', 'fb', 1),
        (3, 'peloton', 'pton', 1);



alter sequence hibernate_sequence restart with 5;