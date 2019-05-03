-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 28, 2018 at 07:02 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `COMP3095`
--
DROP DATABASE IF EXISTS COMP3095;

CREATE DATABASE IF NOT EXISTS `COMP3095` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `COMP3095`;

grant all on COMP3095.* to 'admin'@'localhost' identified by 'admin'; 
-- --------------------------------------------------------

--
-- Table structure for table `ROLE`
--

DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `ROLE` (
  `role_id` int(11) NOT NULL,
  `role_name` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `USERROLE`
--

DROP TABLE IF EXISTS `USERROLE`;
CREATE TABLE `USERROLE` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USERS`
--

INSERT INTO `USERS` (`id`, `firstname`, `lastname`, `address`, `email`, `role`, `created`, `password`) VALUES
(1, 'Admin', NULL, '', 'admin@domain.ca', NULL, '2018-10-09 16:21:58', 'P@ssword1'),
(3, 'Maziar', 'Modarresi', '160 Kendale Ave E, Toronto', 'm.m@gmail.com', NULL, '2018-10-10 00:01:07', 'Test1'),
(13, 'Jeongah', 'Jin', '160 kendale Ave E, Toronto', 'j_j@gmail.com', NULL, '2018-10-10 01:05:01', 'Test1'),
(14, 'Admin', NULL, '', 'admin@isp.net', NULL, '2018-10-28 05:36:53', 'P@ssword1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ROLE`
--
ALTER TABLE `ROLE`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `USERS`
--
ALTER TABLE `USERS`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ROLE`
--
ALTER TABLE `ROLE`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `USERS`
--
ALTER TABLE `USERS`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
