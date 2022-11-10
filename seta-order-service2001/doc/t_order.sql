CREATE TABLE `t_order`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `user_id`    int(11) DEFAULT '0',
    `product_id` int(11) DEFAULT '0',
    `count`      int(11) DEFAULT '0',
    `money`      decimal(10, 2) DEFAULT '0.00',
    `status`     int(2) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;