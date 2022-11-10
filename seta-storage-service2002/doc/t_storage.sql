CREATE TABLE `t_storage`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `product_id` int(11) DEFAULT '0' COMMENT '产品id',
    `total`      int(15) DEFAULT '0' COMMENT '总库存',
    `used`       int(10) DEFAULT NULL COMMENT '已使用库存',
    `residue`    int(10) DEFAULT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;