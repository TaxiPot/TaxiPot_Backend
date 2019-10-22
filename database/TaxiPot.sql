-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.4.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- taxipot 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `taxipot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taxipot`;

-- 테이블 taxipot.bugreport 구조 내보내기
CREATE TABLE IF NOT EXISTS `bugreport` (
  `content` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `bug_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bug_id`),
  KEY `bug_id` (`bug_id`),
  KEY `to_user_id` (`user_id`),
  CONSTRAINT `to_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 taxipot.history 구조 내보내기
CREATE TABLE IF NOT EXISTS `history` (
  `user_id` varchar(50) NOT NULL DEFAULT '',
  `room_id` int(11) NOT NULL,
  `first_seat` varchar(50) DEFAULT NULL,
  `second_seat` varchar(50) DEFAULT NULL,
  `third_seat` varchar(50) DEFAULT NULL,
  `fourth_seat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`room_id`),
  KEY `history_room_fk_taxipot_room` (`room_id`),
  CONSTRAINT `history_room_fk_taxipot_room` FOREIGN KEY (`room_id`) REFERENCES `taxipot` (`room_id`),
  CONSTRAINT `history_user_fk_user_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 taxipot.report 구조 내보내기
CREATE TABLE IF NOT EXISTS `report` (
  `report_user_id` varchar(50) NOT NULL DEFAULT '',
  `reported_user_id` varchar(50) NOT NULL DEFAULT '',
  `reason_num` int(11) NOT NULL,
  PRIMARY KEY (`report_user_id`,`reported_user_id`),
  KEY `인덱스 2` (`reported_user_id`),
  CONSTRAINT `report_user_fk_user` FOREIGN KEY (`report_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `reported_user_fk_user` FOREIGN KEY (`reported_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 taxipot.taxipot 구조 내보내기
CREATE TABLE IF NOT EXISTS `taxipot` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_longtitude` float NOT NULL,
  `start_latitude` float NOT NULL,
  `end_longtitude` float NOT NULL,
  `end_latitude` float NOT NULL,
  `depart_time` bigint(20) NOT NULL DEFAULT 0,
  `gender_man` tinyint(1) DEFAULT NULL,
  `gender_woman` tinyint(1) DEFAULT NULL,
  `start_age` int(11) NOT NULL DEFAULT 0,
  `end_age` int(11) NOT NULL DEFAULT 100,
  `first_seat` varchar(50) DEFAULT NULL,
  `second_seat` varchar(50) DEFAULT NULL,
  `third_seat` varchar(50) DEFAULT NULL,
  `fourth_seat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `first_seat_to_user_id` (`first_seat`),
  KEY `second_seat_to_user_id` (`second_seat`),
  KEY `third_seat_to_user_id` (`third_seat`),
  KEY `fourth_seat_to_user_id` (`fourth_seat`),
  CONSTRAINT `first_seat_to_user_id` FOREIGN KEY (`first_seat`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fourth_seat_to_user_id` FOREIGN KEY (`fourth_seat`) REFERENCES `user` (`user_id`),
  CONSTRAINT `second_seat_to_user_id` FOREIGN KEY (`second_seat`) REFERENCES `user` (`user_id`),
  CONSTRAINT `third_seat_to_user_id` FOREIGN KEY (`third_seat`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 taxipot.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT 0,
  `trust_point` int(11) NOT NULL DEFAULT 5,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
