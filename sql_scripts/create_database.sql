CREATE DATABASE IF NOT EXISTS `web_customer_tracker`;

USE `web_customer_tracker`;

/* Table structure for `customer` */
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ;

/* LOCK TABLES `customer` */
LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES
(1, 'Stephane', 'Nganou Wafo', 'ste@gmail.com'),
(2, 'John', 'Doe', 'john@snw.com'),
(3, 'Ajay', 'Rao', 'ajay@snw.com'),
(4, 'Greatness', 'Infinity', 'greatness@snw.com'),
(5, 'Maxwell', 'Dixon', 'max@snw.com');

/* UNLOCK TABLES `customer` */
UNLOCK TABLES;