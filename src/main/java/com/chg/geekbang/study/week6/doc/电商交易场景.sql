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
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_order` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `goods_id` int(10) DEFAULT 0 COMMENT '商品ID',
    `goods_num` int(10) DEFAULT 0 COMMENT '商品数量',
    `income` int(10) DEFAULT '0' COMMENT '收入',
    `marriage` int(4) DEFAULT '0' COMMENT '婚姻状态',
    `residence_provinces` int(10) unsigned DEFAULT '0' COMMENT '居住省份',
    `residence_city` int(10) DEFAULT '0' COMMENT '居住城市',
    `residence_county` int(10) DEFAULT '0' COMMENT '居住区县',
    `residence_address` varchar(255) NOT NULL DEFAULT '' COMMENT '居住地址，加密存储',
    `company_name` varchar(100) NOT NULL DEFAULT '' COMMENT '公司名称',
    `company_province` int(10) NOT NULL DEFAULT '0' COMMENT '公司所在省份',
    `company_city` int(10) NOT NULL DEFAULT '0' COMMENT '公司城市',
    `company_county` int(10) NOT NULL DEFAULT '0' COMMENT '公司区县',
    `company_address` varchar(255) NOT NULL DEFAULT '' COMMENT '公司地址，加密存储',
    `company_mobile` varchar(62) NOT NULL DEFAULT '' COMMENT '单位电话',
    `contacts` text COMMENT '联系人 json对象存储',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `source` varchar(15) NOT NULL DEFAULT '' COMMENT '用户来源',
    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gt_cart` (
    `uid` int(10) unsigned NOT NULL DEFAULT '0',
    `phone` varchar(62) DEFAULT '' COMMENT '用户手机号，脱敏加密存储',
    `education` int(10) DEFAULT '0' COMMENT '学历',
    `industry` varchar(5) DEFAULT '' COMMENT '职业',
    `income` int(10) DEFAULT '0' COMMENT '收入',
    `marriage` int(4) DEFAULT '0' COMMENT '婚姻状态',
    `residence_provinces` int(10) unsigned DEFAULT '0' COMMENT '居住省份',
    `residence_city` int(10) DEFAULT '0' COMMENT '居住城市',
    `residence_county` int(10) DEFAULT '0' COMMENT '居住区县',
    `residence_address` varchar(255) NOT NULL DEFAULT '' COMMENT '居住地址，加密存储',
    `company_name` varchar(100) NOT NULL DEFAULT '' COMMENT '公司名称',
    `company_province` int(10) NOT NULL DEFAULT '0' COMMENT '公司所在省份',
    `company_city` int(10) NOT NULL DEFAULT '0' COMMENT '公司城市',
    `company_county` int(10) NOT NULL DEFAULT '0' COMMENT '公司区县',
    `company_address` varchar(255) NOT NULL DEFAULT '' COMMENT '公司地址，加密存储',
    `company_mobile` varchar(62) NOT NULL DEFAULT '' COMMENT '单位电话',
    `contacts` text COMMENT '联系人 json对象存储',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `source` varchar(15) NOT NULL DEFAULT '' COMMENT '用户来源',
    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
