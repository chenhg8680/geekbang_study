CREATE DATABASE `gt_shop` DEFAULT CHARACTER SET utf8;

use gt_shop;

CREATE TABLE `gt_user` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `name` varchar(62) DEFAULT '' COMMENT '用户姓名',
    `nickname` varchar(62) DEFAULT '' COMMENT '用户昵称',
    `password` varchar(32) DEFAULT '' COMMENT '用户密码',
    `id_card` varchar(20) DEFAULT '' COMMENT '身份证号',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_goods` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `name` varchar(62) DEFAULT '' COMMENT '商品名称',
    `status` tinyint(4) DEFAULT 1 COMMENT '状态1上架 2下架',
    `price` decimal(2) DEFAULT 0.00 COMMENT '价格',
    `weight` decimal(2) DEFAULT 0.00 COMMENT '重量',
    `sku_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '商品sku',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_sku` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'SKU_ID',
    `parent_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '父skuID',
    `name` varchar(62) DEFAULT '' COMMENT 'sku名称',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `source` varchar(15) NOT NULL DEFAULT '' COMMENT '用户来源',
    PRIMARY KEY (`id`),
    KEY idx_parent_id(parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_order` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `user_id` int(10) DEFAULT 0 COMMENT '用户ID',
    `goods_id` int(10) DEFAULT 0 COMMENT '商品ID',
    `goods_num` int(10) DEFAULT 0 COMMENT '商品数量',
    `amount` decimal(2) DEFAULT '0' COMMENT '订单金额',
    `status` int(4) DEFAULT 1 COMMENT '订单状态：-1支付失败，1待支付，2支付中，3支付成功，4已退款',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `source` varchar(15) NOT NULL DEFAULT '' COMMENT '用户来源',
    PRIMARY KEY (`id`),
    KEY idx_user_id(user_id),
    KEY idx_goods_id(goods_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_cart` (
    `id` int(10) unsigned NOT NULL DEFAULT '0',
    `goods_id` varchar(62) DEFAULT '' COMMENT '用户手机号，脱敏加密存储',
    `goods_num` int(10) DEFAULT '0' COMMENT '学历',
    `user_id` varchar(5) DEFAULT '' COMMENT '职业',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `source` varchar(15) NOT NULL DEFAULT '' COMMENT '用户来源',
    PRIMARY KEY (`id`),
    KEY idx_user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
