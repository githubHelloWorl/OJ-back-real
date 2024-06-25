-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aaa
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `tags` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签列表(json 数组)',
  `answer` text COLLATE utf8mb4_unicode_ci COMMENT '题目答案',
  `submitNum` int NOT NULL DEFAULT '0' COMMENT '题目提交数',
  `acceptedNum` int NOT NULL DEFAULT '0' COMMENT '题目通过数',
  `judgeCase` text COLLATE utf8mb4_unicode_ci COMMENT '判题用例(json 数组)',
  `judgeConfig` text COLLATE utf8mb4_unicode_ci COMMENT '判题配置(json 对象)',
  `thumbNum` int NOT NULL DEFAULT '0' COMMENT '点赞数',
  `favourNum` int NOT NULL DEFAULT '0' COMMENT '收藏数',
  `userId` bigint NOT NULL COMMENT '创建爱你用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1802909639906426882 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1770802440271073282,'A + B','title','[\"aaa\"]','fdsafdsa',0,0,'[{\"input\":\"1 2\",\"output\":\"3 4\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,1,'2024-03-21 21:19:36','2024-06-14 09:18:26',1),(1788496272265658370,'A + B','1 + 1 = ','[\"简单\",\"中等\",\"困难\"]','2',0,0,'[{\"input\":\"1 + 1 \",\"output\":\"2\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,1,'2024-05-09 17:08:34','2024-05-10 13:46:24',1),(1788800330633326593,'小学算术题','5的3次方是多少','[\"简单\"]','125',0,0,'[{\"input\":\"5*5*5\",\"output\":\"125\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-10 13:16:47','2024-06-07 21:19:13',1),(1788807916023721985,'A + B','fdsaf','[\"简单\"]','fdsaf',0,0,'[{\"input\":\"1 2\",\"output\":\"3 4\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-10 13:46:56','2024-05-10 13:47:21',1),(1788808893523046401,'fdsaf','fdsaf','[\"简单\",\"中等\",\"困难\"]','fdsaf',0,0,'[{\"input\":\"1 2\",\"output\":\"3 4\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-10 13:50:49','2024-05-10 13:50:54',1),(1788845408894607361,'fdsaf','fdsafdsa','[\"as\"]','fdsaf',0,0,'[{\"input\":\"aaa\",\"output\":\"sss\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-10 16:15:55','2024-06-14 09:18:28',1),(1789087179092287489,'无','aaa','[\"无\"]','aaa',0,0,'[{\"input\":\"\",\"output\":\"\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-11 08:16:37','2024-06-18 20:33:19',1),(1789088306709946369,'fdsaf','aaa','[\"a\",\"b\",\"c\"]','bbb',0,0,'[{\"input\":\"\",\"output\":\"\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-11 08:21:06','2024-06-18 20:33:20',1),(1789950138844835841,'sss','DROP DATABASE IF EXISTS `s002`;\nCREATE DATABASE IF NOT EXISTS `s002` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci */ /*!80016 DEFAULT ENCRYPTION=\'N\' */;\nUSE `s002`;\n\nDROP TABLE IF EXISTS `c`;\nCREATE TABLE IF NOT EXISTS `a_admin_asset` (\n  `id` varchar(255) COLLATE utf8mb3_croatian_ci NOT NULL,\n  `create_by` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `create_time` datetime(6) DEFAULT NULL,\n  `del_flag` int NOT NULL,\n  `update_by` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `update_time` datetime(6) DEFAULT NULL,\n  `code` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `color` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `gg` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `image_url` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `jldw` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `name` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `purpose` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `remark` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `status1` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `status2` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `type` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `type2` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `xh` varchar(255) COLLATE utf8mb3_croatian_ci DEFAULT NULL,\n  `xsj` decimal(38,2) DEFAULT NULL,\n  PRIMARY KEY (`id`)\n) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_croatian_ci;','[\"aaa\"]','afdsaf',0,0,'[{\"input\":\"\",\"output\":\"\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-13 17:25:43','2024-06-18 20:33:21',1),(1790216578076372994,'学习','System.out.println(\"hello world\");输出什么','[\"java\"]','hello world',0,0,'[{\"input\":\"h\",\"output\":\"h\"},{\"input\":\"s\",\"output\":\"s\"},{\"input\":\"a\",\"output\":\"a\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-05-14 11:04:27','2024-06-18 20:33:22',1),(1799107702887055361,'A + B','# 描述\n使用加法\n\n# 例子\n1 + 1 = 2\n1 + 2 = 3','[\"java\",\"加法\"]','1 3',0,0,'[{\"input\":\"1 2\",\"output\":\"3\"},{\"input\":\"5 6\",\"output\":\"11\"},{\"input\":\"7 2\",\"output\":\"9\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-06-07 23:54:36','2024-06-18 20:33:17',1),(1801424147335708674,'加法','输入两个数 x y，请输出x加入y的结果。\n\n## 示例1\n输入 2 3 <br/>\n输出 5\n\n## 示例\n输入 6 -5 <br/>\n输出 1\n\n## 说明\n* -2^30 <= x,y <= 2^30 ','[\"java\",\"数学\"]','aaa',4,2,'[{\"input\":\"1 2\",\"output\":\"3\"},{\"input\":\"8 9\",\"output\":\"17\"},{\"input\":\"-15 -100\",\"output\":\"-115\"},{\"input\":\"569 -569\",\"output\":\"0\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-06-14 09:19:20','2024-06-18 20:32:52',0),(1802336582548701186,'减法','输入两个数 x y，请输出x减去y的结果。\n\n## 示例1\n输入 2 3 <br/>\n输出 -1\n\n## 示例\n输入 6 -5 <br/>\n输出 11\n\n## 说明\n* -2^31 <= x,y <= 2^31 ','[\"java\",\"数学\"]','',3,1,'[{\"input\":\"4 5\",\"output\":\"-1\"},{\"input\":\"9 8\",\"output\":\"1\"},{\"input\":\"0 -7\",\"output\":\"7\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-06-16 21:45:01','2024-06-18 20:31:27',0),(1802909639906426881,'回文数','给你一个整数 x ，如果 x 是一个回文整数，输出 true ；否则，输出 false 。\n\n## 回文数\n是指正序（从左向右）和倒序（从右向左）读都是一样的整数。\n\n例如，121 是回文，而 123 不是。\n\n## 示例 1：\n\n输入：x = 121\n输出：true\n\n## 示例 2：\n\n输入：x = -121\n输出：false\n\n解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。\n\n## 示例 3：\n\n输入：x = 10\n输出：false\n解释：从右向左读, 为 01 。因此它不是一个回文数。\n\n## 提示：\n\n* -2^31 <= x <= 2^31 - 1\n* 请勿修改类名','[\"字符串\",\"数学\"]','```java\npublic class Main{\n    public static void main(String[] args){\n        String str = args[0];\n        int len = str.length();\n        String ans = \"true\";\n        for(int i=0;i<len/2;++i){\n            if(str.charAt(i) != str.charAt(len-i-1)){\n                ans = \"false\";\n                break;\n            }\n        }\n\n        System.out.println(ans);\n    }\n}\n```',4,1,'[{\"input\":\"12321\",\"output\":\"true\"},{\"input\":\"1235\",\"output\":\"false\"},{\"input\":\"15489652\",\"output\":\"false\"},{\"input\":\"780087\",\"output\":\"true\"},{\"input\":\"1234431\",\"output\":\"false\"},{\"input\":\"0\",\"output\":\"true\"}]','{\"timeLimit\":1000,\"memoryLimit\":1000,\"stackLimit\":1000}',0,0,2,'2024-06-18 11:42:09','2024-06-18 20:23:11',0);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-18 20:39:36
