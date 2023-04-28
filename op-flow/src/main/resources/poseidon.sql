/*
Navicat MySQL Data Transfer

Source Server         : bloom
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : poseidon

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2023-04-22 23:09:14
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chain
-- ----------------------------
DROP TABLE IF EXISTS `chain`;
CREATE TABLE `chain`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `application_name` varchar(32) NOT NULL COMMENT '应用名称',
    `chain_id`         varchar(64) NOT NULL COMMENT '链路id',
    `chain_name`       varchar(64) NOT NULL COMMENT '链路名称',
    `chain_desc`       varchar(255)         DEFAULT NULL COMMENT '链路描述',
    `el_data`          text COMMENT '链路el数据',
    `front_json`       text COMMENT '页面json',
    `env`              varchar(8)           DEFAULT 'dev' COMMENT '环境变量',
    `valid_status`     tinyint(1) DEFAULT '0' COMMENT '有效状态: 1-有效,0-无效',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain
-- ----------------------------
INSERT INTO `chain`
VALUES ('1', '2023-04-21 21:34:33', '2023-04-22 00:12:24', 'app', '02aa75b1-067c-4857-a96a-780b1f9096e1', '演示流程',
        '用于演示',
        'THEN(StartComponent.tag(\"9aa6b260-6393-400d-9e7c-0c6eb68233cd\").data(cmpData1),AComponent.tag(\"b369ce3a-0281-4302-99db-7eea0e699748\").data(cmpData1),IF(IfComponent.tag(\"3f198029-187c-4c35-900e-b117b92f9103\").data(cmpData1),THEN(BComponent.tag(\"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\").data(cmpData1),CComponent.tag(\"cdd8e9da-056e-4909-b413-c05ebe711924\").data(cmpData1)),THEN(DComponent.tag(\"016cd44c-5710-4faf-97d2-c7251f06e635\").data(cmpData1))),EndComponent.tag(\"03b87cc4-ce81-46c7-83d2-30762784926e\").data(cmpData1))',
        '{\r\n	\"cells\": [\r\n		{\r\n			\"id\": \"89016916-f1e9-430e-8c30-e91f83f9d09a\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"9aa6b260-6393-400d-9e7c-0c6eb68233cd\",\r\n				\"port\": \"510701ff-15d6-485e-99bf-628379a09235\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n				\"port\": \"8d28bcd3-f39a-4c30-8e07-ced86e2ba9f9\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"9ddda26a-3bfd-456d-9f61-60bf02ae9578\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n				\"port\": \"ef00a253-8a52-4630-bad9-feac5ef27fb9\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"eba81bb0-0aad-4bcc-97e6-85b922a72340\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"da43c1e5-8257-4033-b2b5-bcc01b1494f5\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"cc715157-7197-4cb3-8b27-bc5c0e8e467b\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n				\"port\": \"a98e36ce-74cc-4c85-ae9a-b810417e28c8\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"1a446eb3-47be-4803-92eb-56d040cbec5d\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n				\"port\": \"e7f1a1cd-6d10-4a03-92fd-6c89bb16263e\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n				\"port\": \"9cb0a3c7-5dff-44bb-8ec2-768633e59869\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"2ea5ad9d-5528-45b5-b4f3-eb080adeb709\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n				\"port\": \"48e3ae63-bca3-43f7-adaf-225c71a26eaf\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n				\"port\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"55b73f3b-f180-4c0d-ae66-c0321398d3cb\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"4f4f4750-2ffd-42aa-85aa-28f13aa639ab\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n				\"port\": \"c1b64334-5247-444b-b4cc-8772d92a6a03\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"a59390c9-c543-466f-a233-4d59fbcef269\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n				\"port\": \"9f51e204-fd49-41b6-a184-2c4bd980c78f\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n				\"port\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"9aa6b260-6393-400d-9e7c-0c6eb68233cd\",\r\n			\"shape\": \"start\",\r\n			\"data\": {\r\n				\"name\": \"开始\",\r\n				\"compId\": \"StartComponent\",\r\n				\"params\": {\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 80,\r\n				\"y\": 160\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"510701ff-15d6-485e-99bf-628379a09235\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 1\r\n		},\r\n		{\r\n			\"id\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"组件A\",\r\n				\"description\": \"\",\r\n				\"compId\": \"AComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"10\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"10\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 278,\r\n				\"y\": 160\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"8d28bcd3-f39a-4c30-8e07-ced86e2ba9f9\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"ef00a253-8a52-4630-bad9-feac5ef27fb9\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 7\r\n		},\r\n		{\r\n			\"id\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n			\"shape\": \"ifNode\",\r\n			\"data\": {\r\n				\"name\": \"条件\",\r\n				\"compId\": \"IfComponent\",\r\n				\"params\": {\r\n					\"data\": {\r\n						\"valueSrc\": \"customParam\",\r\n						\"value\": [\r\n							{\r\n								\"paramKind\": \"1\",\r\n								\"valueKind\": \"json\",\r\n								\"dispKind\": \"input\",\r\n								\"required\": true,\r\n								\"id\": \"a\",\r\n								\"name\": \"a\",\r\n								\"mode\": \"param\",\r\n								\"value\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n								\"valueSrc\": \"node\"\r\n							}\r\n						],\r\n						\"valueKind\": \"json\"\r\n					},\r\n					\"script\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"data.a==1\",\r\n						\"valueKind\": \"char\"\r\n					},\r\n					\"trueNode\": {\r\n						\"valueSrc\": \"nextNode\",\r\n						\"value\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n						\"valueKind\": \"char\"\r\n					},\r\n					\"falseNode\": {\r\n						\"valueSrc\": \"nextNode\",\r\n						\"value\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n						\"valueKind\": \"char\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 180,\r\n				\"y\": 290\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"eba81bb0-0aad-4bcc-97e6-85b922a72340\"\r\n					},\r\n					{\r\n						\"group\": \"bottomOut\",\r\n						\"id\": \"cc715157-7197-4cb3-8b27-bc5c0e8e467b\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"4f4f4750-2ffd-42aa-85aa-28f13aa639ab\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 8\r\n		},\r\n\r\n		{\r\n			\"id\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件成功B组件\",\r\n				\"description\": \"\",\r\n				\"compId\": \"BComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"20\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"5\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 30,\r\n				\"y\": 430\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"a98e36ce-74cc-4c85-ae9a-b810417e28c8\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"e7f1a1cd-6d10-4a03-92fd-6c89bb16263e\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 4\r\n		},\r\n		{\r\n			\"id\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件成功组件C\",\r\n				\"description\": \"\",\r\n				\"compId\": \"CComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"9\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"3\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 30,\r\n				\"y\": 580\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"9cb0a3c7-5dff-44bb-8ec2-768633e59869\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"48e3ae63-bca3-43f7-adaf-225c71a26eaf\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 9\r\n		},\r\n		{\r\n			\"id\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件失败组件D\",\r\n				\"description\": \"\",\r\n				\"compId\": \"DComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"9\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"6\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 338,\r\n				\"y\": 470\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"c1b64334-5247-444b-b4cc-8772d92a6a03\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"9f51e204-fd49-41b6-a184-2c4bd980c78f\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 10\r\n		},\r\n		{\r\n			\"id\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n			\"shape\": \"end\",\r\n			\"data\": {\r\n				\"name\": \"结束\",\r\n				\"compId\": \"EndComponent\",\r\n				\"params\": {\r\n					\"outKind\": \"node\",\r\n					\"outNodeId\": \"cdd8e9da-056e-4909-b413-c05ebe711924\"\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 278,\r\n				\"y\": 670\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 2\r\n		}\r\n	]\r\n}',
        'dev', '1');
INSERT INTO `chain`
VALUES ('2', '2023-04-21 22:58:26', '2023-04-21 23:21:32', 'app', '72054e77-3b2e-4d84-9371-3a567c519718', '演示流程',
        '用于演示', '', '', 'dev', '0');
INSERT INTO `chain`
VALUES ('3', '2023-04-21 22:59:22', '2023-04-21 23:21:35', 'app', 'b9ea33df-c670-4825-a680-4b03db6d1367', '演示流程',
        '用于演示', '', '', 'dev', '0');
INSERT INTO `chain`
VALUES ('4', '2023-04-22 00:09:07', '2023-04-22 00:09:07', 'app', '26469c23-8c5e-4cf0-9844-7e33beff3cec', '演示流程',
        '用于演示', '', '', null, '0');

-- ----------------------------
-- Table structure for chain1
-- ----------------------------
DROP TABLE IF EXISTS `chain1`;
CREATE TABLE `chain1`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT,
    `application_name` varchar(32)  DEFAULT NULL,
    `chain_name`       varchar(32)  DEFAULT NULL,
    `chain_desc`       varchar(64)  DEFAULT NULL,
    `el_data`          text,
    `create_time`      datetime     DEFAULT NULL,
    `is_deleted`       int(11) DEFAULT NULL,
    `chain_id`         varchar(255) DEFAULT NULL,
    `env`              varchar(255) DEFAULT NULL,
    `front_json`       varchar(255) DEFAULT NULL,
    `valid_status`     int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain1
-- ----------------------------
INSERT INTO `chain1`
VALUES ('1', 'demo', 'chain1', '测试流程1', ' IF(d, THEN(a.tag(\"tag1\"), b, c, s4), e);', '2022-09-19 19:31:00', null,
        null, null, null, null);
INSERT INTO `chain1`
VALUES ('2', 'demo', 'chain2', '测试流程2', ' IF(s3, b, c);', '2023-03-29 17:04:19', null, null, null, null, null);
INSERT INTO `chain1`
VALUES ('3', 'demo', 'chain3', '测试流程3', ' IF(d, THEN(IF(f,g,THEN(IF(s3,g,h)))), g);', '2023-03-31 15:25:41', null,
        null, null, null, null);

-- ----------------------------
-- Table structure for chain_version
-- ----------------------------
DROP TABLE IF EXISTS `chain_version`;
CREATE TABLE `chain_version`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `chain_id`   varchar(64) NOT NULL COMMENT '链路id',
    `front_json` text COMMENT '页面json',
    `version`    varchar(64)          DEFAULT NULL COMMENT '数据版本',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain_version
-- ----------------------------

-- ----------------------------
-- Table structure for cmp
-- ----------------------------
DROP TABLE IF EXISTS `cmp`;
CREATE TABLE `cmp`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `createdAt`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updatedAt`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `cmp_id`     varchar(32) NOT NULL COMMENT '组件类型',
    `name`       varchar(64)          DEFAULT NULL COMMENT '名称',
    `shape`      varchar(32)          DEFAULT NULL COMMENT '形状',
    `menu`       varchar(16)          DEFAULT NULL COMMENT '节点菜单分类',
    `svg`        varchar(64)          DEFAULT NULL COMMENT '图标',
    `background` varchar(64)          DEFAULT NULL COMMENT '背景色',
    `desc`       varchar(255)         DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cmp
-- ----------------------------

-- ----------------------------
-- Table structure for cmp_param
-- ----------------------------
DROP TABLE IF EXISTS `cmp_param`;
CREATE TABLE `cmp_param`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `cmp_id`      varchar(32) NOT NULL COMMENT '组件类型',
    `key`         varchar(16) NOT NULL COMMENT '参数key',
    `name`        varchar(16)          DEFAULT NULL COMMENT '参数名称',
    `required`    tinyint(1) DEFAULT '0' COMMENT '参数是否必填',
    `in_type`     varchar(16)          DEFAULT NULL COMMENT '参数输入类型',
    `option`      varchar(255)         DEFAULT NULL COMMENT '下拉选项内容，多个值以逗号分隔',
    `placeholder` varchar(255)         DEFAULT NULL COMMENT '参数值提示性内容',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cmp_param
-- ----------------------------

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `node_id`    varchar(64) NOT NULL COMMENT '节点id',
    `node_name`  varchar(64)          DEFAULT NULL COMMENT '节点名称',
    `cmp_id`     varchar(32)          DEFAULT NULL COMMENT '组件类型',
    `params`     json                 DEFAULT NULL COMMENT '节点属性参数',
    `payload`    json                 DEFAULT NULL COMMENT '自定义参数',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node`
VALUES ('1', '2023-04-22 00:12:24', '2023-04-22 00:12:24', 'b369ce3a-0281-4302-99db-7eea0e699748', '组件A',
        'AComponent', '{
    \"params\": {\"p1\": {\"value\": \"10\", \"valueSrc\": \"const\", \"valueKind\": \"number\"}, \"p2\": {\"value\": \"10\", \"valueSrc\": \"const\", \"valueKind\": \"number\"}, \"digits\": {\"value\": \"2\", \"valueSrc\": \"const\", \"valueKind\": \"integer\"}}}',
        '1212');

-- ----------------------------
-- Table structure for script1
-- ----------------------------
DROP TABLE IF EXISTS `script1`;
CREATE TABLE `script1`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT,
    `application_name` varchar(32) DEFAULT NULL,
    `script_id`        varchar(32) DEFAULT NULL,
    `script_name`      varchar(64) DEFAULT NULL,
    `script_data`      text,
    `script_type`      varchar(16) DEFAULT NULL,
    `script_language`  varchar(16) DEFAULT 'groovy',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of script1
-- ----------------------------
INSERT INTO `script1`
VALUES ('1', 'demo', 's1', '脚本s1',
        'import cn.hutool.core.date.DateUtil\n\ndef date = DateUtil.parse(\"2022-10-17 13:31:43\")\nprintln(date)\ndefaultContext.setData(\"demoDate\", date)\n\nclass Student {\n   int studentID\n   String studentName\n}\n\nStudent student = new Student()\nstudent.studentID = 100301\nstudent.studentName = \"张三\"\ndefaultContext.setData(\"student\",student)\n\ndef a=3\ndef b=2\ndefaultContext.setData(\"s1\",a*b)',
        'script', 'groovy');
INSERT INTO `script1`
VALUES ('2', 'demo', 's2', '脚本s2', 'defaultContext.setData(\"s2\",\"hello\")', 'script', 'groovy');
INSERT INTO `script1`
VALUES ('3', 'demo', 's3', '条件脚本', 'return false || demo.getFlag()', 'if_script', 'groovy');
INSERT INTO `script1`
VALUES ('4', 'demo', 's4', '脚本s4', 'defaultContext.setData(\"s1\",demo.getStr(_meta.requestData))', 'script',
        'groovy');



INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (1, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'start', '开始', 'node', '基础', '/svg/start.svg',
        'rgb(0 128 0 / 20%)', '在一个流程中，开始节点是触发流程执行的起始节点');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (2, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'timer', '定时器', 'node', '基础', '/svg/timer.svg',
        'rgb(0 128 88 / 25%)',
        '可作为起始节点，用于定时触发流程周期性执行，可指定执行次数，可输出指定格式的时间戳；亦可作为非起始节点，由上游节点触发执行。');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (3, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'delay', '延时器', 'node', '基础', '/svg/delay.svg',
        'rgb(8 155 16 / 25%)', '延时节点，可设定延迟时间，用于延迟其下游节点的运行');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (4, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'output', '输出', 'node', '基础', '/svg/output.svg',
        'rgb(145 188 130 / 75%)', '输出节点，可展示其上游节点的输出参数信息');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (5, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'condition', '条件', 'node', '运算', '/svg/condition.svg',
        'rgb(220 200 80 / 60%)',
        '条件节点，用于判断条件是否满足，可使用多个此节点组成与或等逻辑通路，条件满足后会继续向下游节点执行输出');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (6, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'sequence', '序列', 'node', '运算', '/svg/sequence.svg',
        'rgb(170 150 50 / 40%)', '序列节点，可按自定义间隔大小进行递增或递减，依次输出整数序列');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (7, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'splice', '拼接', 'node', '运算', '/svg/splice.svg',
        'rgb(200 180 75 / 60%)', '拼接节点，在一定时间内持续接收上游节点的输出参数，对指定字段的值进行拼接并输出');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (8, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'split', '分割', 'node', '运算', '/svg/split.svg',
        'rgb(180 150 20 / 50%)', '分割节点，对指定字段的值进行分割后输出，可指定输出方式');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (9, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'valve', '阀门', 'node', '运算', '/svg/valve.svg',
        'rgb(230 210 70 / 70%)',
        '阀门节点，可用于多条支路汇总时，限制某一段时间周期内，通过此节点的次数。默认100毫秒内仅允许通过一次');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (21, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'json_parser', 'JSON解析', 'node', '解析',
        '/svg/json_parser.svg', 'rgb(180 197 125 / 60%)',
        '用于解析json格式的内容，可解析上游节点的输出参数，获取用户需要的参数信息');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (22, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'html_parser', 'HTML解析', 'node', '解析',
        '/svg/html_parser.svg', 'rgb(180 197 125 / 60%)',
        '用于解析html格式的文本内容，可指定css选择器解析出目标元素，输出html内容或文本内容');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (23, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'xml_parser', 'XML解析', 'node', '解析',
        '/svg/xml_parser.svg', 'rgb(180 197 125 / 60%)', '用于解析xml格式的文本内容，可转化为json格式的参数信息输出');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (31, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'http_request', 'HTTP请求', 'node', '网络',
        '/svg/http_request.svg', 'rgb(235 186 73 / 75%)',
        '可以发起HTTP请求，支持所有的请求类型，支持携带各种请求参数信息以及token等请求头信息');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (32, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'http_receive', 'HTTP接收', 'node', '网络',
        '/svg/http_receive.svg', 'rgb(235 186 73 / 75%)',
        '可创建HTTP服务，用于接收HTTP请求，解析出请求参数，向下游输出。可根据请求参数处理业务逻辑，与HTTP响应节点搭配使用');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (33, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'http_response', 'HTTP响应', 'node', '网络',
        '/svg/http_response.svg', 'rgb(200 195 60 / 70%)',
        '可响应HTTP请求，与HTTP接收节点搭配使用，在处理完业务逻辑后，响应请求并返回数据，可根据上游节点的输出结果动态响应数据');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (34, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'ws_server', 'WS服务端', 'node', '网络', '/svg/ws_server.svg',
        'rgb(220 160 25 / 75%)',
        'WebSocket服务端节点，可自定义路径创建websocket服务，自定义发送消息内容和发送时机，可广播发送上游节点的输出参数，收到客户端消息后亦会向下游输出。本节点为阻塞节点，运行后需要手动停止');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (35, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'ws_client', 'WS客户端', 'node', '网络', '/svg/ws_client.svg',
        'rgb(215 140 40 / 50%)',
        'WebSocket客户端节点，可连接指定路径的websocket服务，自定义发送消息内容和发送时机，收到服务端消息后会立即向下游输出');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (37, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'mqtt_sub', 'MQTT订阅', 'node', '网络', '/svg/mqtt_sub.svg',
        'rgb(140 180 40 / 50%)',
        'MQTT订阅节点，可订阅指定topic中的消息，接收到消息后会向下游输出。本节点为阻塞节点，运行后需要手动停止');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (38, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'mqtt_pub', 'MQTT发布', 'node', '网络', '/svg/mqtt_pub.svg',
        'rgb(130 160 50 / 60%)', 'MQTT发布节点，可向指定topic中发送MQTT消息，发送的消息内容会向下游节点输出');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (39, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'email', '发送邮件', 'node', '网络', '/svg/email.svg',
        'rgb(220 190 110 / 80%)', '可以发送电子邮件，支持抄送、密送，支持发送html格式的邮件');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (51, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'mysql', 'Mysql', 'node', '数据库', '/svg/mysql.svg',
        'rgb(220 180 50 / 50%)',
        'Mysql节点，可连接mysql数据库，执行自定义sql语句，支持任意类型的多条sql语句，输出每条语句的执行结果和内容');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (52, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'mongodb', 'MongoDB', 'node', '数据库', '/svg/mongodb.svg',
        'rgb(230 170 60 / 70%)', 'MongoDB节点，可连接MongoDB数据库，执行自定义命令语句，输出执行结果和内容');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (53, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'redis', 'Redis', 'node', '数据库', '/svg/redis.svg',
        'rgb(235 180 10 / 50%)', 'Redis节点，可连接redis服务器，执行自定义操作，输出执行结果和内容');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (54, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'postgresql', 'PostgreSQL', 'node', '数据库',
        '/svg/postgresql.svg', 'rgb(220 180 50 / 50%)',
        'PostgreSQL节点，可连接PostgreSQL数据库，执行自定义sql语句，支持任意类型的多条sql语句，输出每条语句的执行结果和内容');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (100, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'subflow', '子流程', 'node', '子流程', '/svg/subflow.svg',
        'rgb(200 70 180 / 62%)',
        '子流程节点，可选择其他流程作为子流程来执行，本节点的输入参数可传递至子流程中的[子输入节点]，子流程中的[子输出节点]可将输出参数返回至本节点作为输出参数');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (101, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'sub_input', '子输入', 'node', '子流程',
        '/svg/sub_input.svg', 'rgb(190 70 50 / 42%)', '子流程输入节点，用于子流程中，可接收关联的[子流程节点]的输入参数');
INSERT INTO `poseidon`.`cmp`(`id`, `createdAt`, `updatedAt`, `cmp_id`, `name`, `shape`, `menu`, `svg`, `background`,
                             `desc`)
VALUES (102, '2023-04-24 10:40:43', '2023-04-24 10:42:34', 'sub_output', '子输出', 'node', '子流程',
        '/svg/sub_output.svg', 'rgb(120 150 90 / 42%)',
        '子流程输出节点，用于子流程中，可将本节点的输出参数传递给关联的[子流程节点]作为输出参数');


CREATE TABLE `chain_el`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `application_name` varchar(32) NOT NULL COMMENT '应用名称',
    `chain_id`         varchar(64) NOT NULL COMMENT '流程id',
    `el_data`          text COMMENT '链路el数据',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

