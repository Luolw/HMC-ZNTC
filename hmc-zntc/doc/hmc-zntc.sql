/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : hmc-zntc

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 07/01/2019 14:35:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'com.hmc.zntc.admin.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720037636F6D2E686D632E7A6E74632E61646D696E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', NULL, 'com.hmc.zntc.admin.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720037636F6D2E686D632E7A6E74632E61646D696E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'JC-0011546839699294', 1546842946185, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1546077600000, -1, 5, 'PAUSED', 'CRON', 1546076704000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720037636F6D2E686D632E7A6E74632E61646D696E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', NULL, 1546077600000, -1, 5, 'PAUSED', 'CRON', 1546076704000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720037636F6D2E686D632E7A6E74632E61646D696E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'test', 'renren', '0 0/30 * * * ?', 1, '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES (2, 'testTask', 'test2', NULL, '0 0/30 * * * ?', 1, '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'test', 'renren', 1, 'java.util.concurrent.ExecutionException: com.hmc.zntc.admin.exception.RRException: 执行定时任务失败', 1100, '2019-01-03 11:00:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('216c4046-4186-4d95-863b-a30c41b57999', 'danbp', '2018-11-23 11:39:40');
INSERT INTO `sys_captcha` VALUES ('39f3c342-d088-413a-8acb-1ec5b20ff659', 'ca4nx', '2019-01-07 13:55:02');
INSERT INTO `sys_captcha` VALUES ('6b322cfb-0ed4-4f1d-8371-e263200fe700', 'c5456', '2018-11-23 16:02:27');
INSERT INTO `sys_captcha` VALUES ('6b81f428-0fae-4c62-8919-29268e12719f', 'pm26e', '2019-01-03 14:53:56');
INSERT INTO `sys_captcha` VALUES ('bd5e43e7-4b95-47e6-8d8c-1e61027b8668', '4npym', '2018-11-23 15:42:18');
INSERT INTO `sys_captcha` VALUES ('d75c6798-9376-40d7-8246-8f5199530d96', 'n2y3m', '2018-11-23 15:58:52');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '榴莲集团', 0, 0);
INSERT INTO `sys_dept` VALUES (2, 1, '长沙分公司', 1, 0);
INSERT INTO `sys_dept` VALUES (3, 1, '上海分公司', 2, 0);
INSERT INTO `sys_dept` VALUES (4, 3, '技术部', 0, 0);
INSERT INTO `sys_dept` VALUES (5, 3, '销售部', 1, 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典码',
  `value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type`(`type`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '性别', 'sex', '0', '女', 0, NULL, 0);
INSERT INTO `sys_dict` VALUES (2, '性别', 'sex', '1', '男', 1, NULL, 0);
INSERT INTO `sys_dict` VALUES (3, '性别', 'sex', '2', '未知', 3, NULL, 0);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '立即执行任务', 'ScheduleJobController.run()', '[2]', 306, '0:0:0:0:0:0:0:1', '2018-11-23 12:05:05');
INSERT INTO `sys_log` VALUES (2, 'admin', '修改用户', 'SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"18501115509\",\"status\":1,\"roleIdList\":[],\"createUserId\":1}', 388, '0:0:0:0:0:0:0:1', '2018-11-23 14:22:25');
INSERT INTO `sys_log` VALUES (3, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"name\":\"SQL监控\",\"url\":\"http://localhost:8083/wrzn-security/druid/sql.html\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}', 77, '0:0:0:0:0:0:0:1', '2018-11-23 14:59:31');
INSERT INTO `sys_log` VALUES (4, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"name\":\"SQL监控\",\"url\":\"http://127.0.0.1:8083/wrzn-admin/druid/sql.html\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}', 65, '0:0:0:0:0:0:0:1', '2018-11-23 15:00:58');
INSERT INTO `sys_log` VALUES (5, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"name\":\"SQL监控\",\"url\":\"/druid/sql.html\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}', 57, '0:0:0:0:0:0:0:1', '2018-11-23 15:01:31');
INSERT INTO `sys_log` VALUES (6, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}', 56, '0:0:0:0:0:0:0:1', '2018-11-23 15:01:41');
INSERT INTO `sys_log` VALUES (7, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"name\":\"SQL监控\",\"url\":\"http://127.0.0.1:8083/wrzn-admin/druid/sql.html\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}', 41, '0:0:0:0:0:0:0:1', '2018-11-23 15:02:40');
INSERT INTO `sys_log` VALUES (8, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":31,\"parentId\":1,\"name\":\"app用户表\",\"url\":\"app/user.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 42, '0:0:0:0:0:0:0:1', '2018-11-23 15:04:47');
INSERT INTO `sys_log` VALUES (9, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":36,\"parentId\":1,\"name\":\"用户钱包\",\"url\":\"app/wallet.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 84, '0:0:0:0:0:0:0:1', '2018-11-23 15:04:57');
INSERT INTO `sys_log` VALUES (10, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"name\":\"app用户表\",\"url\":\"app/user\",\"type\":1,\"icon\":\"role\",\"orderNum\":6}', 37, '0:0:0:0:0:0:0:1', '2018-11-23 15:34:14');
INSERT INTO `sys_log` VALUES (11, 'admin', '保存菜单', 'SysMenuController.save()', '{\"menuId\":51,\"parentId\":0,\"name\":\"用户管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"role\",\"orderNum\":3}', 107, '0:0:0:0:0:0:0:1', '2018-11-23 15:35:10');
INSERT INTO `sys_log` VALUES (12, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":41,\"parentId\":51,\"name\":\"app用户表\",\"url\":\"app/user\",\"type\":1,\"icon\":\"role\",\"orderNum\":6}', 39, '0:0:0:0:0:0:0:1', '2018-11-23 15:35:37');
INSERT INTO `sys_log` VALUES (13, 'admin', '修改菜单', 'SysMenuController.update()', '{\"menuId\":46,\"parentId\":51,\"name\":\"用户钱包\",\"url\":\"app/wallet\",\"type\":1,\"icon\":\"config\",\"orderNum\":6}', 26, '0:0:0:0:0:0:0:1', '2018-11-23 15:35:48');
INSERT INTO `sys_log` VALUES (14, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '50', 66, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:22');
INSERT INTO `sys_log` VALUES (15, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '49', 37, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:30');
INSERT INTO `sys_log` VALUES (16, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '48', 37, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:36');
INSERT INTO `sys_log` VALUES (17, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '47', 55, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:42');
INSERT INTO `sys_log` VALUES (18, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '46', 31, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:47');
INSERT INTO `sys_log` VALUES (19, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '45', 40, '0:0:0:0:0:0:0:1', '2019-01-03 11:06:55');
INSERT INTO `sys_log` VALUES (20, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '41', 1, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:02');
INSERT INTO `sys_log` VALUES (21, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '44', 42, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:05');
INSERT INTO `sys_log` VALUES (22, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '43', 33, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:11');
INSERT INTO `sys_log` VALUES (23, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '42', 35, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:17');
INSERT INTO `sys_log` VALUES (24, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '41', 32, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:23');
INSERT INTO `sys_log` VALUES (25, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '51', 32, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:27');
INSERT INTO `sys_log` VALUES (26, 'admin', '暂停定时任务', 'com.hmc.zntc.admin.modules.job.controller.ScheduleJobController.pause()', '[1]', 61, '0:0:0:0:0:0:0:1', '2019-01-03 11:07:50');
INSERT INTO `sys_log` VALUES (27, 'admin', '保存角色', 'com.hmc.zntc.admin.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"admin\",\"remark\":\"admin\",\"createUserId\":1,\"menuIdList\":[2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,6,7,8,9,10,11,12,13,14,27,29,30,52,53,54,55,56,-666666,1],\"createTime\":\"Jan 3, 2019 11:28:20 AM\"}', 206, '0:0:0:0:0:0:0:1', '2019-01-03 11:28:20');
INSERT INTO `sys_log` VALUES (28, 'admin', '修改用户', 'com.hmc.zntc.admin.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"18501115509\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1}', 102, '0:0:0:0:0:0:0:1', '2019-01-03 11:28:27');
INSERT INTO `sys_log` VALUES (29, 'admin', '修改角色', 'com.hmc.zntc.admin.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"admin\",\"remark\":\"admin\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,52,53,54,55,56,-666666]}', 61, '0:0:0:0:0:0:0:1', '2019-01-03 11:30:11');
INSERT INTO `sys_log` VALUES (30, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '56', 65, '0:0:0:0:0:0:0:1', '2019-01-03 11:45:44');
INSERT INTO `sys_log` VALUES (31, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '55', 52, '0:0:0:0:0:0:0:1', '2019-01-03 11:45:48');
INSERT INTO `sys_log` VALUES (32, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '54', 52, '0:0:0:0:0:0:0:1', '2019-01-03 11:45:56');
INSERT INTO `sys_log` VALUES (33, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '53', 75, '0:0:0:0:0:0:0:1', '2019-01-03 11:45:58');
INSERT INTO `sys_log` VALUES (34, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '52', 51, '0:0:0:0:0:0:0:1', '2019-01-03 11:46:03');
INSERT INTO `sys_log` VALUES (35, 'admin', '修改用户', 'com.hmc.zntc.admin.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"18501115509\",\"status\":1,\"roleIdList\":[],\"createUserId\":1}', 173, '0:0:0:0:0:0:0:1', '2019-01-03 14:38:41');
INSERT INTO `sys_log` VALUES (36, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":62,\"parentId\":0,\"name\":\"停车管理\",\"type\":0,\"icon\":\"daohang\",\"orderNum\":1}', 51, '0:0:0:0:0:0:0:1', '2019-01-07 13:58:13');
INSERT INTO `sys_log` VALUES (37, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":63,\"parentId\":0,\"name\":\"停车收费\",\"url\":\"/car/car1\",\"type\":1,\"icon\":\"log\",\"orderNum\":1}', 47, '0:0:0:0:0:0:0:1', '2019-01-07 14:00:09');
INSERT INTO `sys_log` VALUES (38, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '63', 98, '0:0:0:0:0:0:0:1', '2019-01-07 14:00:48');
INSERT INTO `sys_log` VALUES (39, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":64,\"parentId\":0,\"name\":\"t\",\"url\":\"/car\",\"type\":1,\"icon\":\"daohang\",\"orderNum\":1}', 42, '0:0:0:0:0:0:0:1', '2019-01-07 14:01:11');
INSERT INTO `sys_log` VALUES (40, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":64,\"parentId\":62,\"name\":\"t\",\"url\":\"/car\",\"type\":1,\"icon\":\"daohang\",\"orderNum\":1}', 43, '0:0:0:0:0:0:0:1', '2019-01-07 14:01:27');
INSERT INTO `sys_log` VALUES (41, 'admin', '删除菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.delete()', '64', 44, '0:0:0:0:0:0:0:1', '2019-01-07 14:01:44');
INSERT INTO `sys_log` VALUES (42, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":0,\"name\":\"用户管理\",\"type\":0,\"icon\":\"admin\",\"orderNum\":1}', 42, '0:0:0:0:0:0:0:1', '2019-01-07 14:04:16');
INSERT INTO `sys_log` VALUES (43, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":65,\"parentId\":62,\"name\":\"用户列表\",\"url\":\"/\",\"type\":1,\"icon\":\"daohang\",\"orderNum\":1}', 48, '0:0:0:0:0:0:0:1', '2019-01-07 14:05:12');
INSERT INTO `sys_log` VALUES (44, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":65,\"parentId\":62,\"name\":\"用户列表\",\"url\":\"/\",\"type\":1,\"icon\":\"geren\",\"orderNum\":1}', 33, '0:0:0:0:0:0:0:1', '2019-01-07 14:05:44');
INSERT INTO `sys_log` VALUES (45, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":65,\"parentId\":62,\"name\":\"用户列表\",\"url\":\"/\",\"type\":1,\"icon\":\"geren\",\"orderNum\":0}', 50, '0:0:0:0:0:0:0:1', '2019-01-07 14:06:15');
INSERT INTO `sys_log` VALUES (46, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":66,\"parentId\":1,\"name\":\"黑名单管理\",\"url\":\"/\",\"type\":1,\"icon\":\"role\",\"orderNum\":1}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:08:10');
INSERT INTO `sys_log` VALUES (47, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":66,\"parentId\":62,\"name\":\"黑名单管理\",\"url\":\"/\",\"type\":1,\"icon\":\"role\",\"orderNum\":1}', 29, '0:0:0:0:0:0:0:1', '2019-01-07 14:08:25');
INSERT INTO `sys_log` VALUES (48, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":67,\"parentId\":62,\"name\":\"用户详情\",\"url\":\"/\",\"type\":1,\"icon\":\"log\",\"orderNum\":2}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:09:24');
INSERT INTO `sys_log` VALUES (49, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":68,\"parentId\":0,\"name\":\"车位管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"mudedi\",\"orderNum\":2}', 48, '0:0:0:0:0:0:0:1', '2019-01-07 14:10:29');
INSERT INTO `sys_log` VALUES (50, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":69,\"parentId\":68,\"name\":\"车位列表\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"menu\",\"orderNum\":0}', 36, '0:0:0:0:0:0:0:1', '2019-01-07 14:10:59');
INSERT INTO `sys_log` VALUES (51, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":70,\"parentId\":68,\"name\":\"故障车位\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"menu\",\"orderNum\":1}', 38, '0:0:0:0:0:0:0:1', '2019-01-07 14:11:38');
INSERT INTO `sys_log` VALUES (52, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":71,\"parentId\":68,\"name\":\"异常车位\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"menu\",\"orderNum\":2}', 33, '0:0:0:0:0:0:0:1', '2019-01-07 14:12:09');
INSERT INTO `sys_log` VALUES (53, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":72,\"parentId\":68,\"name\":\"收费设置\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"config\",\"orderNum\":3}', 32, '0:0:0:0:0:0:0:1', '2019-01-07 14:12:36');
INSERT INTO `sys_log` VALUES (54, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":73,\"parentId\":68,\"name\":\"运维人员管理\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":4}', 32, '0:0:0:0:0:0:0:1', '2019-01-07 14:13:07');
INSERT INTO `sys_log` VALUES (55, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":74,\"parentId\":0,\"name\":\"充电管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"oss\",\"orderNum\":3}', 29, '0:0:0:0:0:0:0:1', '2019-01-07 14:13:49');
INSERT INTO `sys_log` VALUES (56, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":75,\"parentId\":74,\"name\":\"电桩列表\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":4}', 28, '0:0:0:0:0:0:0:1', '2019-01-07 14:14:29');
INSERT INTO `sys_log` VALUES (57, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":76,\"parentId\":74,\"name\":\"故障电桩\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}', 57, '0:0:0:0:0:0:0:1', '2019-01-07 14:15:06');
INSERT INTO `sys_log` VALUES (58, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":75,\"parentId\":74,\"name\":\"电桩列表\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:15:14');
INSERT INTO `sys_log` VALUES (59, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":77,\"parentId\":74,\"name\":\"收费设置\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"system\",\"orderNum\":2}', 30, '0:0:0:0:0:0:0:1', '2019-01-07 14:15:38');
INSERT INTO `sys_log` VALUES (60, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":78,\"parentId\":74,\"name\":\"广告管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"shoucangfill\",\"orderNum\":4}', 30, '0:0:0:0:0:0:0:1', '2019-01-07 14:16:14');
INSERT INTO `sys_log` VALUES (61, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":78,\"parentId\":0,\"name\":\"广告管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"shoucangfill\",\"orderNum\":4}', 34, '0:0:0:0:0:0:0:1', '2019-01-07 14:16:23');
INSERT INTO `sys_log` VALUES (62, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":79,\"parentId\":78,\"name\":\"广告设置\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"system\",\"orderNum\":0}', 28, '0:0:0:0:0:0:0:1', '2019-01-07 14:16:48');
INSERT INTO `sys_log` VALUES (63, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":80,\"parentId\":78,\"name\":\"广告投放\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"duanxin\",\"orderNum\":1}', 30, '0:0:0:0:0:0:0:1', '2019-01-07 14:17:05');
INSERT INTO `sys_log` VALUES (64, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":81,\"parentId\":0,\"name\":\"订单管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":5}', 31, '0:0:0:0:0:0:0:1', '2019-01-07 14:17:33');
INSERT INTO `sys_log` VALUES (65, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":82,\"parentId\":81,\"name\":\"停车订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 30, '0:0:0:0:0:0:0:1', '2019-01-07 14:18:18');
INSERT INTO `sys_log` VALUES (66, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":83,\"parentId\":81,\"name\":\"充电订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}', 60, '0:0:0:0:0:0:0:1', '2019-01-07 14:18:34');
INSERT INTO `sys_log` VALUES (67, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":84,\"parentId\":81,\"name\":\"订单列表\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 31, '0:0:0:0:0:0:0:1', '2019-01-07 14:19:05');
INSERT INTO `sys_log` VALUES (68, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":84,\"parentId\":81,\"name\":\"订单列表\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"zhedie\",\"orderNum\":0}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:19:35');
INSERT INTO `sys_log` VALUES (69, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":82,\"parentId\":84,\"name\":\"停车订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:19:50');
INSERT INTO `sys_log` VALUES (70, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":83,\"parentId\":84,\"name\":\"充电订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}', 27, '0:0:0:0:0:0:0:1', '2019-01-07 14:20:04');
INSERT INTO `sys_log` VALUES (71, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":85,\"parentId\":84,\"name\":\"未缴费订单\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":1}', 37, '0:0:0:0:0:0:0:1', '2019-01-07 14:20:40');
INSERT INTO `sys_log` VALUES (72, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":85,\"parentId\":81,\"name\":\"未缴费订单\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":1}', 40, '0:0:0:0:0:0:0:1', '2019-01-07 14:20:52');
INSERT INTO `sys_log` VALUES (73, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":86,\"parentId\":85,\"name\":\"未缴费停车订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 34, '0:0:0:0:0:0:0:1', '2019-01-07 14:21:20');
INSERT INTO `sys_log` VALUES (74, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":87,\"parentId\":85,\"name\":\"未缴费充电订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}', 31, '0:0:0:0:0:0:0:1', '2019-01-07 14:21:33');
INSERT INTO `sys_log` VALUES (75, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":88,\"parentId\":81,\"name\":\"异常订单\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":2}', 42, '0:0:0:0:0:0:0:1', '2019-01-07 14:22:07');
INSERT INTO `sys_log` VALUES (76, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":89,\"parentId\":88,\"name\":\"异常停车订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}', 31, '0:0:0:0:0:0:0:1', '2019-01-07 14:22:42');
INSERT INTO `sys_log` VALUES (77, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":90,\"parentId\":88,\"name\":\"异常充电订单\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}', 30, '0:0:0:0:0:0:0:1', '2019-01-07 14:22:53');
INSERT INTO `sys_log` VALUES (78, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":91,\"parentId\":81,\"name\":\"订单详情\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":3}', 59, '0:0:0:0:0:0:0:1', '2019-01-07 14:24:25');
INSERT INTO `sys_log` VALUES (79, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":84,\"parentId\":81,\"name\":\"订单列表\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":0}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:24:39');
INSERT INTO `sys_log` VALUES (80, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":91,\"parentId\":81,\"name\":\"订单详情\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":3}', 52, '0:0:0:0:0:0:0:1', '2019-01-07 14:24:49');
INSERT INTO `sys_log` VALUES (81, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":92,\"parentId\":0,\"name\":\"商家管理\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":6}', 34, '0:0:0:0:0:0:0:1', '2019-01-07 14:26:08');
INSERT INTO `sys_log` VALUES (82, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":92,\"parentId\":0,\"name\":\"商家管理\",\"url\":\"/\",\"perms\":\"\",\"type\":0,\"icon\":\"admin\",\"orderNum\":6}', 43, '0:0:0:0:0:0:0:1', '2019-01-07 14:26:46');
INSERT INTO `sys_log` VALUES (83, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":93,\"parentId\":92,\"name\":\"商家列表\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":0}', 29, '0:0:0:0:0:0:0:1', '2019-01-07 14:27:04');
INSERT INTO `sys_log` VALUES (84, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":94,\"parentId\":92,\"name\":\"商家详情\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":1}', 29, '0:0:0:0:0:0:0:1', '2019-01-07 14:27:50');
INSERT INTO `sys_log` VALUES (85, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":95,\"parentId\":0,\"name\":\"财务管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":7}', 46, '0:0:0:0:0:0:0:1', '2019-01-07 14:28:53');
INSERT INTO `sys_log` VALUES (86, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":92,\"parentId\":0,\"name\":\"商家管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"admin\",\"orderNum\":6}', 35, '0:0:0:0:0:0:0:1', '2019-01-07 14:29:08');
INSERT INTO `sys_log` VALUES (87, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":96,\"parentId\":95,\"name\":\"对账单\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"log\",\"orderNum\":0}', 33, '0:0:0:0:0:0:0:1', '2019-01-07 14:30:07');
INSERT INTO `sys_log` VALUES (88, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":97,\"parentId\":96,\"name\":\"日汇总\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":0}', 34, '0:0:0:0:0:0:0:1', '2019-01-07 14:30:36');
INSERT INTO `sys_log` VALUES (89, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":98,\"parentId\":96,\"name\":\"账单明细\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":1}', 36, '0:0:0:0:0:0:0:1', '2019-01-07 14:31:06');
INSERT INTO `sys_log` VALUES (90, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":99,\"parentId\":95,\"name\":\"收款管理\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":1}', 36, '0:0:0:0:0:0:0:1', '2019-01-07 14:31:37');
INSERT INTO `sys_log` VALUES (91, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":100,\"parentId\":95,\"name\":\"财务审核\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"log\",\"orderNum\":2}', 38, '0:0:0:0:0:0:0:1', '2019-01-07 14:32:08');
INSERT INTO `sys_log` VALUES (92, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":101,\"parentId\":0,\"name\":\"风控管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"config\",\"orderNum\":8}', 29, '0:0:0:0:0:0:0:1', '2019-01-07 14:32:56');
INSERT INTO `sys_log` VALUES (93, 'admin', '保存菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.save()', '{\"menuId\":102,\"parentId\":101,\"name\":\"场景策略配置\",\"url\":\"/\",\"perms\":\"\",\"type\":1,\"icon\":\"system\",\"orderNum\":0}', 28, '0:0:0:0:0:0:0:1', '2019-01-07 14:34:04');
INSERT INTO `sys_log` VALUES (94, 'admin', '修改菜单', 'com.hmc.zntc.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":1,\"parentId\":0,\"name\":\"系统管理\",\"type\":0,\"icon\":\"system\",\"orderNum\":9}', 34, '0:0:0:0:0:0:0:1', '2019-01-07 14:34:43');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 9);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://127.0.0.1:8083/wrzn-admin/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO `sys_menu` VALUES (57, 1, '用户', 'app/user', NULL, 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (58, 57, '查看', NULL, 'app:user:list,app:user:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (59, 57, '新增', NULL, 'app:user:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (60, 57, '修改', NULL, 'app:user:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (61, 57, '删除', NULL, 'app:user:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (62, 0, '用户管理', NULL, NULL, 0, 'admin', 1);
INSERT INTO `sys_menu` VALUES (65, 62, '用户列表', '/', NULL, 1, 'geren', 0);
INSERT INTO `sys_menu` VALUES (66, 62, '黑名单管理', '/', NULL, 1, 'role', 1);
INSERT INTO `sys_menu` VALUES (67, 62, '用户详情', '/', NULL, 1, 'log', 2);
INSERT INTO `sys_menu` VALUES (68, 0, '车位管理', '', '', 0, 'mudedi', 2);
INSERT INTO `sys_menu` VALUES (69, 68, '车位列表', '/', '', 1, 'menu', 0);
INSERT INTO `sys_menu` VALUES (70, 68, '故障车位', '/', '', 1, 'menu', 1);
INSERT INTO `sys_menu` VALUES (71, 68, '异常车位', '/', '', 1, 'menu', 2);
INSERT INTO `sys_menu` VALUES (72, 68, '收费设置', '/', '', 1, 'config', 3);
INSERT INTO `sys_menu` VALUES (73, 68, '运维人员管理', '/', '', 1, 'admin', 4);
INSERT INTO `sys_menu` VALUES (74, 0, '充电管理', '', '', 0, 'oss', 3);
INSERT INTO `sys_menu` VALUES (75, 74, '电桩列表', '/', '', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (76, 74, '故障电桩', '/', '', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (77, 74, '收费设置', '/', '', 1, 'system', 2);
INSERT INTO `sys_menu` VALUES (78, 0, '广告管理', '', '', 0, 'shoucangfill', 4);
INSERT INTO `sys_menu` VALUES (79, 78, '广告设置', '/', '', 1, 'system', 0);
INSERT INTO `sys_menu` VALUES (80, 78, '广告投放', '/', '', 1, 'duanxin', 1);
INSERT INTO `sys_menu` VALUES (81, 0, '订单管理', '', '', 0, 'log', 5);
INSERT INTO `sys_menu` VALUES (82, 84, '停车订单', '/', '', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (83, 84, '充电订单', '/', '', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (84, 81, '订单列表', '/', '', 0, 'log', 0);
INSERT INTO `sys_menu` VALUES (85, 81, '未缴费订单', '/', '', 0, 'log', 1);
INSERT INTO `sys_menu` VALUES (86, 85, '未缴费停车订单', '/', '', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (87, 85, '未缴费充电订单', '/', '', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (88, 81, '异常订单', '/', '', 0, 'log', 2);
INSERT INTO `sys_menu` VALUES (89, 88, '异常停车订单', '/', '', 1, 'zhedie', 0);
INSERT INTO `sys_menu` VALUES (90, 88, '异常充电订单', '/', '', 1, 'zhedie', 1);
INSERT INTO `sys_menu` VALUES (91, 81, '订单详情', '/', '', 1, 'log', 3);
INSERT INTO `sys_menu` VALUES (92, 0, '商家管理', '', '', 0, 'admin', 6);
INSERT INTO `sys_menu` VALUES (93, 92, '商家列表', '/', '', 1, 'log', 0);
INSERT INTO `sys_menu` VALUES (94, 92, '商家详情', '/', '', 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (95, 0, '财务管理', '', '', 0, 'log', 7);
INSERT INTO `sys_menu` VALUES (96, 95, '对账单', '', '', 0, 'log', 0);
INSERT INTO `sys_menu` VALUES (97, 96, '日汇总', '/', '', 1, 'log', 0);
INSERT INTO `sys_menu` VALUES (98, 96, '账单明细', '/', '', 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (99, 95, '收款管理', '/', '', 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (100, 95, '财务审核', '/', '', 1, 'log', 2);
INSERT INTO `sys_menu` VALUES (101, 0, '风控管理', '', '', 0, 'config', 8);
INSERT INTO `sys_menu` VALUES (102, 101, '场景策略配置', '/', '', 1, 'system', 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', 'admin', 1, '2019-01-03 11:28:20');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (35, 1, 1);
INSERT INTO `sys_role_menu` VALUES (36, 1, 2);
INSERT INTO `sys_role_menu` VALUES (37, 1, 15);
INSERT INTO `sys_role_menu` VALUES (38, 1, 16);
INSERT INTO `sys_role_menu` VALUES (39, 1, 17);
INSERT INTO `sys_role_menu` VALUES (40, 1, 18);
INSERT INTO `sys_role_menu` VALUES (41, 1, 3);
INSERT INTO `sys_role_menu` VALUES (42, 1, 19);
INSERT INTO `sys_role_menu` VALUES (43, 1, 20);
INSERT INTO `sys_role_menu` VALUES (44, 1, 21);
INSERT INTO `sys_role_menu` VALUES (45, 1, 22);
INSERT INTO `sys_role_menu` VALUES (46, 1, 4);
INSERT INTO `sys_role_menu` VALUES (47, 1, 23);
INSERT INTO `sys_role_menu` VALUES (48, 1, 24);
INSERT INTO `sys_role_menu` VALUES (49, 1, 25);
INSERT INTO `sys_role_menu` VALUES (50, 1, 26);
INSERT INTO `sys_role_menu` VALUES (51, 1, 5);
INSERT INTO `sys_role_menu` VALUES (52, 1, 6);
INSERT INTO `sys_role_menu` VALUES (53, 1, 7);
INSERT INTO `sys_role_menu` VALUES (54, 1, 8);
INSERT INTO `sys_role_menu` VALUES (55, 1, 9);
INSERT INTO `sys_role_menu` VALUES (56, 1, 10);
INSERT INTO `sys_role_menu` VALUES (57, 1, 11);
INSERT INTO `sys_role_menu` VALUES (58, 1, 12);
INSERT INTO `sys_role_menu` VALUES (59, 1, 13);
INSERT INTO `sys_role_menu` VALUES (60, 1, 14);
INSERT INTO `sys_role_menu` VALUES (61, 1, 27);
INSERT INTO `sys_role_menu` VALUES (62, 1, 29);
INSERT INTO `sys_role_menu` VALUES (63, 1, 30);
INSERT INTO `sys_role_menu` VALUES (69, 1, -666666);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '18501115509', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '989b5506f8c60fbbdecd7760a016464a', '2019-01-08 01:51:01', '2019-01-07 13:51:01');

-- ----------------------------
-- Table structure for tb_advert
-- ----------------------------
DROP TABLE IF EXISTS `tb_advert`;
CREATE TABLE `tb_advert`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1禁止 0正常 ',
  `orgin` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '广告来源',
  `start_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '结束时间',
  `count` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '一体机数量',
  `play_times` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '曝光次数',
  `play_speed` decimal(10, 6) UNSIGNED NULL DEFAULT NULL COMMENT '轮播速度',
  `color` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '颜色',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告设置' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_car`;
CREATE TABLE `tb_car`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1无效 0有效 ',
  `car_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位编号如GD-SZ-BT-00001',
  `fault` tinyint(1) NULL DEFAULT NULL COMMENT '-1故障 0无故障',
  `break` tinyint(1) NULL DEFAULT NULL COMMENT '-1断电 0无断电',
  `charging` int(10) NULL DEFAULT NULL COMMENT '电桩id',
  `fault_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '故障开始时间',
  `break_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '断电开始时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块：车位 \r\n作用：车位表，存储每个车位信息，唯一设备编号，属于那个位置等，要与一体机一对一关联起来。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_car_maintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_maintain`;
CREATE TABLE `tb_car_maintain`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1无效 0有效 ',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运维人员姓名',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运维人员电话',
  `count` int(3) NULL DEFAULT NULL COMMENT '负责设备数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块：车位 \r\n作用：运维人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_charges
-- ----------------------------
DROP TABLE IF EXISTS `tb_charges`;
CREATE TABLE `tb_charges`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '收费名称',
  `amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '单价',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1禁止 0正常 ',
  `type` tinyint(1) NULL DEFAULT 0 COMMENT '0停车收费 1充电收费 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收费方案' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_charging
-- ----------------------------
DROP TABLE IF EXISTS `tb_charging`;
CREATE TABLE `tb_charging`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `is_power` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '是否断电：0正常-1断电',
  `run_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '运行时间',
  `trouble_time` timestamp(0) NULL DEFAULT NULL COMMENT '故障时间',
  `car_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '车位id',
  `operations_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '运维人员id',
  `charges_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '收费方案id',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1禁止 0正常 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电桩' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id主键',
  `uuid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `photo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sex` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '0男1女',
  `salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额',
  `status` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(1正常 -1禁用)',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '新建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1,'109128631e9849de8e00c86f902ab358', NULL, 'D58135BDFC0B3726F8A66A323076D9AA', '15768892428', NULL, NULL, NULL, NULL, 'fLOhK2uyVCBaQO2VDKox', NULL, NULL, '2018-11-20 14:08:37', '2018-11-20 14:08:37');
INSERT INTO `tb_user` VALUES (2,'1dd604eb2266432aab22e853ea453146', '瓦利机器人', '11C3A6B6DB348F33F7F8282B80A11A46', '12312312', NULL, NULL, '瓦利机器人', NULL, NULL, NULL, NULL, '2018-11-19 16:10:03', '2018-11-19 16:10:03');
INSERT INTO `tb_user` VALUES (3,'36ca9900ed114441bb94a1acf17d3a44', '阿尔法狗2号', '3A87FCE0F1F345FDE221833F67E989D2', '1231231230', NULL, NULL, NULL, NULL, NULL, NULL, '1', '2018-11-19 16:11:33', '2018-11-19 16:11:33');
INSERT INTO `tb_user` VALUES (4,'393d93a1b23d4dd29db1814d5f2d9978', '张三', 'B479CC9C2472AC01934E4E0E8B8A0717', '18501115509', NULL, NULL, NULL, NULL, 'vkwCmCWFxxg9tSIlzfsC', NULL, NULL, '2018-11-15 16:01:18', '2018-11-15 16:01:18');
INSERT INTO `tb_user` VALUES (5,'54a493ee2346496b8df6e07dbf531510', '阿尔法狗', 'CAFBAA8BE91FC2C7431E6C89E3158147', '1231231231', NULL, NULL, '阿尔法狗', NULL, NULL, NULL, '1', '2018-11-19 16:10:45', '2018-11-19 16:10:45');
INSERT INTO `tb_user` VALUES (6,'6120791488d04e9d98c1b38917cd60fc', '阿尔法狗3号', '9379C91052053CCCD43A5FBD4923F47A', '1231231232', NULL, NULL, NULL, NULL, NULL, NULL, '1', '2018-11-19 16:13:30', '2018-11-19 16:13:30');
INSERT INTO `tb_user` VALUES (7,'7292a6816f2e41db8a615672d25f126b', '阿尔法狗4号', '7E40522E4B66223D9265A28719CC59E0', '1231231240', NULL, NULL, NULL, NULL, NULL, NULL, '1', '2018-11-19 16:14:20', '2018-11-19 16:14:20');
INSERT INTO `tb_user` VALUES (8,'8357982d5d2a46f9bc5728a981019ab0', '测试机器人', '5FA46752EEE6F744D0D9FD962DB13DBD', '15501115506', '', '123456@qq.com', '测试机器人', NULL, NULL, NULL, NULL, '2018-11-19 15:47:06', '2019-01-03 11:44:12');
INSERT INTO `tb_user` VALUES (9,'e25b2509d2594b6ebddc8d3b02181119', '星河一号', 'B5BF2EBC16308E5D5C7FE42875E3FEF7', '1231231321', NULL, NULL, NULL, NULL, NULL, NULL, '1', '2018-11-19 16:11:59', '2018-11-19 16:11:59');
INSERT INTO `tb_user` VALUES (10,'e4b6401c4b4e4ba1a344a6d2edb6fa7e', NULL, 'DB12F9FA0443669649FBD231092FD0AD', '18500260251', NULL, NULL, NULL, NULL, 't5SzJ5WfJ4Utje9lshEq', NULL, NULL, '2018-11-19 15:10:50', '2018-11-19 15:10:50');

-- ----------------------------
-- Table structure for tb_user_black
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_black`;
CREATE TABLE `tb_user_black`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '是否黑名单 -1否 0是 ',
  `blacklist_time` datetime(0) NULL DEFAULT NULL COMMENT '添加黑名单时间',
  `user_id` int(10) NULL DEFAULT NULL COMMENT 'tb_user_user表id，关联外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块：用户 \r\n作用：用户黑名单表，存储黑名单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user_sms
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_sms`;
CREATE TABLE `tb_user_sms`  (
  `id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id主键',
  `uuid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一id',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `busic_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信类型',
  `verify_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '到期时间',
  `valid_minus` datetime(0) NULL DEFAULT NULL COMMENT '有效时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态(1正常 -1禁用)',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '新建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_sms
-- ----------------------------
INSERT INTO `tb_user_sms` VALUES ('109128631e9849de8e00c86f902ab358', NULL, NULL, NULL, '15768892428', NULL, NULL, NULL, NULL, '2018-11-20 14:08:37', '2018-11-20 14:08:37');
INSERT INTO `tb_user_sms` VALUES ('1dd604eb2266432aab22e853ea453146', NULL, '瓦利机器人', NULL, '12312312', NULL, NULL, NULL, NULL, '2018-11-19 16:10:03', '2018-11-19 16:10:03');
INSERT INTO `tb_user_sms` VALUES ('36ca9900ed114441bb94a1acf17d3a44', NULL, '阿尔法狗2号', NULL, '1231231230', NULL, NULL, NULL, 1, '2018-11-19 16:11:33', '2018-11-19 16:11:33');
INSERT INTO `tb_user_sms` VALUES ('393d93a1b23d4dd29db1814d5f2d9978', NULL, '张三', NULL, '18501115509', NULL, NULL, NULL, NULL, '2018-11-15 16:01:18', '2018-11-15 16:01:18');
INSERT INTO `tb_user_sms` VALUES ('54a493ee2346496b8df6e07dbf531510', NULL, '阿尔法狗', NULL, '1231231231', NULL, NULL, NULL, 1, '2018-11-19 16:10:45', '2018-11-19 16:10:45');
INSERT INTO `tb_user_sms` VALUES ('6120791488d04e9d98c1b38917cd60fc', NULL, '阿尔法狗3号', NULL, '1231231232', NULL, NULL, NULL, 1, '2018-11-19 16:13:30', '2018-11-19 16:13:30');
INSERT INTO `tb_user_sms` VALUES ('7292a6816f2e41db8a615672d25f126b', NULL, '阿尔法狗4号', NULL, '1231231240', NULL, NULL, NULL, 1, '2018-11-19 16:14:20', '2018-11-19 16:14:20');
INSERT INTO `tb_user_sms` VALUES ('8357982d5d2a46f9bc5728a981019ab0', NULL, '测试机器人', NULL, '15501115506', NULL, NULL, NULL, NULL, '2018-11-19 15:47:06', '2019-01-03 11:44:12');
INSERT INTO `tb_user_sms` VALUES ('e25b2509d2594b6ebddc8d3b02181119', NULL, '星河一号', NULL, '1231231321', NULL, NULL, NULL, 1, '2018-11-19 16:11:59', '2018-11-19 16:11:59');
INSERT INTO `tb_user_sms` VALUES ('e4b6401c4b4e4ba1a344a6d2edb6fa7e', NULL, NULL, NULL, '18500260251', NULL, NULL, NULL, NULL, '2018-11-19 15:10:50', '2018-11-19 15:10:50');

-- ----------------------------
-- Table structure for tb_user_vehicle_number
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_vehicle_number`;
CREATE TABLE `tb_user_vehicle_number`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '资源ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '-1无效 0有效 ',
  `vehicle_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号码',
  `user_id` int(10) NULL DEFAULT NULL COMMENT 'tb_user_user表id，关联外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块：用户 \r\n作用：用户车牌表，一个用户最多有3个车牌' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
