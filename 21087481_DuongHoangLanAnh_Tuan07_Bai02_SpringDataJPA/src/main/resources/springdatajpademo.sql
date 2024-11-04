-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for springdatajpademo
CREATE DATABASE IF NOT EXISTS `springdatajpademo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `springdatajpademo`;

-- Dumping structure for table springdatajpademo.department
CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(150) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `UKsithc0jis4uq50eg8g3efs5gp` (`dept_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table springdatajpademo.department: ~4 rows (approximately)
INSERT INTO `department` (`dept_id`, `dept_name`) VALUES
	(3, 'HR'),
	(4, 'IT'),
	(2, 'Marketing'),
	(1, 'Sales');

-- Dumping structure for table springdatajpademo.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `dept_id` bigint(20) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(150) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FKaqchbcb8i6nvtl9g6c72yba0p` (`dept_id`),
  CONSTRAINT `FKaqchbcb8i6nvtl9g6c72yba0p` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table springdatajpademo.employee: ~4 rows (approximately)
INSERT INTO `employee` (`dept_id`, `dob`, `emp_id`, `emp_name`) VALUES
	(1, '1990-05-15 00:00:00.000000', 1, 'John Doe'),
	(2, '1992-11-20 00:00:00.000000', 2, 'Jane Doe'),
	(3, '1992-03-03 00:00:00.000000', 3, 'Alice'),
	(4, '1993-04-04 00:00:00.000000', 4, 'Bob');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
