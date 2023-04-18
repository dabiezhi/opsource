CREATE TABLE `chain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除 0-未删 ,1-已删',
  `application_name` varchar(32) NOT NULL COMMENT '应用名称',
  `chain_id` varchar(64) NOT NULL COMMENT '链路id',
  `chain_name` varchar(64) NOT NULL COMMENT '链路名称',
  `chain_desc` varchar(255) DEFAULT NULL COMMENT '链路描述',
  `el_data` text DEFAULT NULL COMMENT '链路el数据',
  `front_json` text DEFAULT NULL COMMENT '页面json',
  `env` varchar(8)  DEFAULT 'dev' COMMENT '环境变量',
  `valid_status` tinyint(1)  DEFAULT 0 COMMENT '有效状态: 1-有效,0-无效',
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `node_id` varchar(64) NOT NULL COMMENT '节点id',
  `node_name` varchar(64)  DEFAULT NULL COMMENT '节点名称',
  `cmp_type` varchar(32) DEFAULT NULL COMMENT '组件类型',
  `params` json DEFAULT NULL COMMENT '节点属性参数',
  `payload` json DEFAULT NULL COMMENT '自定义参数',
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `chain_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `chain_id` varchar(64) NOT NULL COMMENT '链路id',
  `front_json` text DEFAULT NULL COMMENT '页面json',
  `version` varchar(64)  DEFAULT NULL COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `cmp_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` varchar(32)  NOT NULL COMMENT '组件类型',
  `name` varchar(64)  DEFAULT NULL COMMENT '名称',
  `shape` varchar(32)  DEFAULT NULL COMMENT '形状',
  `cmp` varchar(16)  NOT NULL COMMENT '组件名',
  `menu` varchar(16)  DEFAULT NULL COMMENT '节点菜单分类',
  `svg` varchar(64)  DEFAULT NULL COMMENT '图标',
  `background` varchar(64)  DEFAULT NULL COMMENT '背景色',
  `desc` varchar(255)  DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `cmp_param` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `cmp_type` varchar(32) NOT NULL COMMENT '组件类型',
  `key` varchar(16)  NOT NULL COMMENT '参数key',
  `name` varchar(16) DEFAULT NULL COMMENT '参数名称',
  `required` tinyint(1) DEFAULT '0' COMMENT '参数是否必填',
  `in_type` varchar(16)  DEFAULT NULL COMMENT '参数输入类型',
  `option` varchar(255)  DEFAULT NULL COMMENT '下拉选项内容，多个值以逗号分隔',
  `placeholder` varchar(255)  DEFAULT NULL COMMENT '参数值提示性内容',
  PRIMARY KEY (`id`) USING BTREE
);