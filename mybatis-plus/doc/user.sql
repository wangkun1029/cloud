CREATE TABLE `user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
    `age`         int(11) DEFAULT NULL,
    `email`       varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
    `create_time` datetime                        DEFAULT NULL,
    `update_time` datetime                        DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `version`     int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;