create table user(
    id INT unsigned NOT NULL AUTO_INCREMENT,
    userName VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    roles VARCHAR(150) NOT NULL,
    active BOOLEAN,
    firstName VARCHAR(150) NOT NULL,
    lastName VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    gender VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
)