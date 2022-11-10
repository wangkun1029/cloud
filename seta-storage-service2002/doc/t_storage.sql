CREATE TABLE `t_storage`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `product_id` int(11) DEFAULT '0' COMMENT '产品id',
    `total`      int(15) DEFAULT '0' COMMENT '总库存',
    `used`       int(10) DEFAULT NULL COMMENT '已使用库存',
    `residue`    int(10) DEFAULT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `undo_log`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL DEFAULT '0',
    `xid`           varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
    `context`       varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
    `rollback_info` longblob                         NOT NULL,
    `log_status`    int(11) NOT NULL DEFAULT '0',
    `log_created`   datetime(6) DEFAULT NULL,
    `log_modified`  datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (6),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;