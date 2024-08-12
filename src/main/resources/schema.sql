CREATE SCHEMA `spring`;
CREATE TABLE IF NOT EXISTS `spring`.`users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` varchar(45) not null,
    `enabled`  int         not null,
    primary key (`id`)
);


CREATE TABLE IF NOT EXISTS `spring`.`authorities`(
    `id` int not null auto_increment,
    `username` varchar(45) not null ,
    `authority` varchar(45) not null ,
    primary key (`id`)
);

insert into spring.authorities(username, authority) VALUES ('bartek', 'write');

insert into spring.users(username, password, enabled) VALUES ('bartek', 'test123', '1');