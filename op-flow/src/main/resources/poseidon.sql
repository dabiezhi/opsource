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

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chain
-- ----------------------------
DROP TABLE IF EXISTS `chain`;
CREATE TABLE `chain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `application_name` varchar(32) NOT NULL COMMENT '应用名称',
  `chain_id` varchar(64) NOT NULL COMMENT '链路id',
  `chain_name` varchar(64) NOT NULL COMMENT '链路名称',
  `chain_desc` varchar(255) DEFAULT NULL COMMENT '链路描述',
  `el_data` text COMMENT '链路el数据',
  `front_json` text COMMENT '页面json',
  `env` varchar(8) DEFAULT 'dev' COMMENT '环境变量',
  `valid_status` tinyint(1) DEFAULT '0' COMMENT '有效状态: 1-有效,0-无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain
-- ----------------------------
INSERT INTO `chain` VALUES ('1', '2023-04-21 21:34:33', '2023-04-22 00:12:24', 'app', '02aa75b1-067c-4857-a96a-780b1f9096e1', '演示流程', '用于演示', 'THEN(StartComponent.tag(\"9aa6b260-6393-400d-9e7c-0c6eb68233cd\").data(cmpData1),AComponent.tag(\"b369ce3a-0281-4302-99db-7eea0e699748\").data(cmpData1),IF(IfComponent.tag(\"3f198029-187c-4c35-900e-b117b92f9103\").data(cmpData1),THEN(BComponent.tag(\"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\").data(cmpData1),CComponent.tag(\"cdd8e9da-056e-4909-b413-c05ebe711924\").data(cmpData1)),THEN(DComponent.tag(\"016cd44c-5710-4faf-97d2-c7251f06e635\").data(cmpData1))),EndComponent.tag(\"03b87cc4-ce81-46c7-83d2-30762784926e\").data(cmpData1))', '{\r\n	\"cells\": [\r\n		{\r\n			\"id\": \"89016916-f1e9-430e-8c30-e91f83f9d09a\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"9aa6b260-6393-400d-9e7c-0c6eb68233cd\",\r\n				\"port\": \"510701ff-15d6-485e-99bf-628379a09235\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n				\"port\": \"8d28bcd3-f39a-4c30-8e07-ced86e2ba9f9\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"9ddda26a-3bfd-456d-9f61-60bf02ae9578\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n				\"port\": \"ef00a253-8a52-4630-bad9-feac5ef27fb9\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"eba81bb0-0aad-4bcc-97e6-85b922a72340\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"da43c1e5-8257-4033-b2b5-bcc01b1494f5\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"cc715157-7197-4cb3-8b27-bc5c0e8e467b\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n				\"port\": \"a98e36ce-74cc-4c85-ae9a-b810417e28c8\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"1a446eb3-47be-4803-92eb-56d040cbec5d\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n				\"port\": \"e7f1a1cd-6d10-4a03-92fd-6c89bb16263e\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n				\"port\": \"9cb0a3c7-5dff-44bb-8ec2-768633e59869\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"2ea5ad9d-5528-45b5-b4f3-eb080adeb709\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n				\"port\": \"48e3ae63-bca3-43f7-adaf-225c71a26eaf\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n				\"port\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"55b73f3b-f180-4c0d-ae66-c0321398d3cb\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n				\"port\": \"4f4f4750-2ffd-42aa-85aa-28f13aa639ab\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n				\"port\": \"c1b64334-5247-444b-b4cc-8772d92a6a03\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"a59390c9-c543-466f-a233-4d59fbcef269\",\r\n			\"shape\": \"edge\",\r\n			\"source\": {\r\n				\"cell\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n				\"port\": \"9f51e204-fd49-41b6-a184-2c4bd980c78f\"\r\n			},\r\n			\"target\": {\r\n				\"cell\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n				\"port\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n			},\r\n			\"zIndex\": 0\r\n		},\r\n		{\r\n			\"id\": \"9aa6b260-6393-400d-9e7c-0c6eb68233cd\",\r\n			\"shape\": \"start\",\r\n			\"data\": {\r\n				\"name\": \"开始\",\r\n				\"compId\": \"StartComponent\",\r\n				\"params\": {\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 80,\r\n				\"y\": 160\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"510701ff-15d6-485e-99bf-628379a09235\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 1\r\n		},\r\n		{\r\n			\"id\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"组件A\",\r\n				\"description\": \"\",\r\n				\"compId\": \"AComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"10\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"10\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 278,\r\n				\"y\": 160\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"8d28bcd3-f39a-4c30-8e07-ced86e2ba9f9\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"ef00a253-8a52-4630-bad9-feac5ef27fb9\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 7\r\n		},\r\n		{\r\n			\"id\": \"3f198029-187c-4c35-900e-b117b92f9103\",\r\n			\"shape\": \"ifNode\",\r\n			\"data\": {\r\n				\"name\": \"条件\",\r\n				\"compId\": \"IfComponent\",\r\n				\"params\": {\r\n					\"data\": {\r\n						\"valueSrc\": \"customParam\",\r\n						\"value\": [\r\n							{\r\n								\"paramKind\": \"1\",\r\n								\"valueKind\": \"json\",\r\n								\"dispKind\": \"input\",\r\n								\"required\": true,\r\n								\"id\": \"a\",\r\n								\"name\": \"a\",\r\n								\"mode\": \"param\",\r\n								\"value\": \"b369ce3a-0281-4302-99db-7eea0e699748\",\r\n								\"valueSrc\": \"node\"\r\n							}\r\n						],\r\n						\"valueKind\": \"json\"\r\n					},\r\n					\"script\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"data.a==1\",\r\n						\"valueKind\": \"char\"\r\n					},\r\n					\"trueNode\": {\r\n						\"valueSrc\": \"nextNode\",\r\n						\"value\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n						\"valueKind\": \"char\"\r\n					},\r\n					\"falseNode\": {\r\n						\"valueSrc\": \"nextNode\",\r\n						\"value\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n						\"valueKind\": \"char\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 180,\r\n				\"y\": 290\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"eba81bb0-0aad-4bcc-97e6-85b922a72340\"\r\n					},\r\n					{\r\n						\"group\": \"bottomOut\",\r\n						\"id\": \"cc715157-7197-4cb3-8b27-bc5c0e8e467b\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"4f4f4750-2ffd-42aa-85aa-28f13aa639ab\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 8\r\n		},\r\n\r\n		{\r\n			\"id\": \"234f8bf3-e98f-4dc1-9a93-d8cf55bf25cc\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件成功B组件\",\r\n				\"description\": \"\",\r\n				\"compId\": \"BComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"20\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"5\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 30,\r\n				\"y\": 430\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"a98e36ce-74cc-4c85-ae9a-b810417e28c8\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"e7f1a1cd-6d10-4a03-92fd-6c89bb16263e\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 4\r\n		},\r\n		{\r\n			\"id\": \"cdd8e9da-056e-4909-b413-c05ebe711924\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件成功组件C\",\r\n				\"description\": \"\",\r\n				\"compId\": \"CComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"9\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"3\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 30,\r\n				\"y\": 580\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"9cb0a3c7-5dff-44bb-8ec2-768633e59869\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"48e3ae63-bca3-43f7-adaf-225c71a26eaf\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 9\r\n		},\r\n		{\r\n			\"id\": \"016cd44c-5710-4faf-97d2-c7251f06e635\",\r\n			\"shape\": \"compNode\",\r\n			\"data\": {\r\n				\"name\": \"条件失败组件D\",\r\n				\"description\": \"\",\r\n				\"compId\": \"DComponent\",\r\n				\"params\": {\r\n					\"p1\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"9\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"p2\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"6\",\r\n						\"valueKind\": \"number\"\r\n					},\r\n					\"digits\": {\r\n						\"valueSrc\": \"const\",\r\n						\"value\": \"2\",\r\n						\"valueKind\": \"integer\"\r\n					}\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 338,\r\n				\"y\": 470\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"c1b64334-5247-444b-b4cc-8772d92a6a03\"\r\n					},\r\n					{\r\n						\"group\": \"out\",\r\n						\"id\": \"9f51e204-fd49-41b6-a184-2c4bd980c78f\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 10\r\n		},\r\n		{\r\n			\"id\": \"03b87cc4-ce81-46c7-83d2-30762784926e\",\r\n			\"shape\": \"end\",\r\n			\"data\": {\r\n				\"name\": \"结束\",\r\n				\"compId\": \"EndComponent\",\r\n				\"params\": {\r\n					\"outKind\": \"node\",\r\n					\"outNodeId\": \"cdd8e9da-056e-4909-b413-c05ebe711924\"\r\n				}\r\n			},\r\n			\"position\": {\r\n				\"x\": 278,\r\n				\"y\": 670\r\n			},\r\n			\"ports\": {\r\n				\"items\": [\r\n					{\r\n						\"group\": \"in\",\r\n						\"id\": \"3dddb845-56da-4850-8337-1d628cb97beb\"\r\n					}\r\n				]\r\n			},\r\n			\"zIndex\": 2\r\n		}\r\n	]\r\n}', 'dev', '1');
INSERT INTO `chain` VALUES ('2', '2023-04-21 22:58:26', '2023-04-21 23:21:32', 'app', '72054e77-3b2e-4d84-9371-3a567c519718', '演示流程', '用于演示', '', '', 'dev', '0');
INSERT INTO `chain` VALUES ('3', '2023-04-21 22:59:22', '2023-04-21 23:21:35', 'app', 'b9ea33df-c670-4825-a680-4b03db6d1367', '演示流程', '用于演示', '', '', 'dev', '0');
INSERT INTO `chain` VALUES ('4', '2023-04-22 00:09:07', '2023-04-22 00:09:07', 'app', '26469c23-8c5e-4cf0-9844-7e33beff3cec', '演示流程', '用于演示', '', '', null, '0');

-- ----------------------------
-- Table structure for chain1
-- ----------------------------
DROP TABLE IF EXISTS `chain1`;
CREATE TABLE `chain1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(32) DEFAULT NULL,
  `chain_name` varchar(32) DEFAULT NULL,
  `chain_desc` varchar(64) DEFAULT NULL,
  `el_data` text,
  `create_time` datetime DEFAULT NULL,
  `is_deleted` int(11) DEFAULT NULL,
  `chain_id` varchar(255) DEFAULT NULL,
  `env` varchar(255) DEFAULT NULL,
  `front_json` varchar(255) DEFAULT NULL,
  `valid_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain1
-- ----------------------------
INSERT INTO `chain1` VALUES ('1', 'demo', 'chain1', '测试流程1', ' IF(d, THEN(a.tag(\"tag1\"), b, c, s4), e);', '2022-09-19 19:31:00', null, null, null, null, null);
INSERT INTO `chain1` VALUES ('2', 'demo', 'chain2', '测试流程2', ' IF(s3, b, c);', '2023-03-29 17:04:19', null, null, null, null, null);
INSERT INTO `chain1` VALUES ('3', 'demo', 'chain3', '测试流程3', ' IF(d, THEN(IF(f,g,THEN(IF(s3,g,h)))), g);', '2023-03-31 15:25:41', null, null, null, null, null);

-- ----------------------------
-- Table structure for chain_version
-- ----------------------------
DROP TABLE IF EXISTS `chain_version`;
CREATE TABLE `chain_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `chain_id` varchar(64) NOT NULL COMMENT '链路id',
  `front_json` text COMMENT '页面json',
  `version` varchar(64) DEFAULT NULL COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chain_version
-- ----------------------------

-- ----------------------------
-- Table structure for cmp
-- ----------------------------
DROP TABLE IF EXISTS `cmp`;
CREATE TABLE `cmp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `cmp_id` varchar(32) NOT NULL COMMENT '组件类型',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `shape` varchar(32) DEFAULT NULL COMMENT '形状',
  `menu` varchar(16) DEFAULT NULL COMMENT '节点菜单分类',
  `svg` varchar(64) DEFAULT NULL COMMENT '图标',
  `background` varchar(64) DEFAULT NULL COMMENT '背景色',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cmp
-- ----------------------------

-- ----------------------------
-- Table structure for cmp_param
-- ----------------------------
DROP TABLE IF EXISTS `cmp_param`;
CREATE TABLE `cmp_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `cmp_id` varchar(32) NOT NULL COMMENT '组件类型',
  `key` varchar(16) NOT NULL COMMENT '参数key',
  `name` varchar(16) DEFAULT NULL COMMENT '参数名称',
  `required` tinyint(1) DEFAULT '0' COMMENT '参数是否必填',
  `in_type` varchar(16) DEFAULT NULL COMMENT '参数输入类型',
  `option` varchar(255) DEFAULT NULL COMMENT '下拉选项内容，多个值以逗号分隔',
  `placeholder` varchar(255) DEFAULT NULL COMMENT '参数值提示性内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cmp_param
-- ----------------------------

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `node_id` varchar(64) NOT NULL COMMENT '节点id',
  `node_name` varchar(64) DEFAULT NULL COMMENT '节点名称',
  `cmp_id` varchar(32) DEFAULT NULL COMMENT '组件类型',
  `params` json DEFAULT NULL COMMENT '节点属性参数',
  `payload` json DEFAULT NULL COMMENT '自定义参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '2023-04-22 00:12:24', '2023-04-22 00:12:24', 'b369ce3a-0281-4302-99db-7eea0e699748', '组件A', 'AComponent', '{\"params\": {\"p1\": {\"value\": \"10\", \"valueSrc\": \"const\", \"valueKind\": \"number\"}, \"p2\": {\"value\": \"10\", \"valueSrc\": \"const\", \"valueKind\": \"number\"}, \"digits\": {\"value\": \"2\", \"valueSrc\": \"const\", \"valueKind\": \"integer\"}}}', '1212');

-- ----------------------------
-- Table structure for script1
-- ----------------------------
DROP TABLE IF EXISTS `script1`;
CREATE TABLE `script1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(32) DEFAULT NULL,
  `script_id` varchar(32) DEFAULT NULL,
  `script_name` varchar(64) DEFAULT NULL,
  `script_data` text,
  `script_type` varchar(16) DEFAULT NULL,
  `script_language` varchar(16) DEFAULT 'groovy',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of script1
-- ----------------------------
INSERT INTO `script1` VALUES ('1', 'demo', 's1', '脚本s1', 'import cn.hutool.core.date.DateUtil\n\ndef date = DateUtil.parse(\"2022-10-17 13:31:43\")\nprintln(date)\ndefaultContext.setData(\"demoDate\", date)\n\nclass Student {\n   int studentID\n   String studentName\n}\n\nStudent student = new Student()\nstudent.studentID = 100301\nstudent.studentName = \"张三\"\ndefaultContext.setData(\"student\",student)\n\ndef a=3\ndef b=2\ndefaultContext.setData(\"s1\",a*b)', 'script', 'groovy');
INSERT INTO `script1` VALUES ('2', 'demo', 's2', '脚本s2', 'defaultContext.setData(\"s2\",\"hello\")', 'script', 'groovy');
INSERT INTO `script1` VALUES ('3', 'demo', 's3', '条件脚本', 'return false || demo.getFlag()', 'if_script', 'groovy');
INSERT INTO `script1` VALUES ('4', 'demo', 's4', '脚本s4', 'defaultContext.setData(\"s1\",demo.getStr(_meta.requestData))', 'script', 'groovy');
