-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2022 at 09:41 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotels`
--

-- --------------------------------------------------------

--
-- Table structure for table `myhotels`
--

CREATE TABLE `myhotels` (
  `hotel_id` int(255) NOT NULL,
  `hotel_name` varchar(500) CHARACTER SET utf8 NOT NULL,
  `hotel_address` varchar(500) CHARACTER SET utf8 NOT NULL,
  `hotel_evaluation` varchar(500) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `myhotels`
--

INSERT INTO `myhotels` (`hotel_id`, `hotel_name`, `hotel_address`, `hotel_evaluation`) VALUES
(1, 'Royal', 'Amman', 'Five Star'),
(2, 'Movenpick', 'Dead Sea', 'Five Star'),
(3, 'Four Season', 'Aqapa', 'Five Star');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(255) NOT NULL,
  `room_number` int(255) NOT NULL,
  `cost` int(255) NOT NULL,
  `status` varchar(400) CHARACTER SET utf8 NOT NULL,
  `hotel_name` varchar(500) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_number`, `cost`, `status`, `hotel_name`) VALUES
(1, 1, 150, 'reserved', 'Royal'),
(2, 2, 250, 'Avaliable', 'Movenpick'),
(4, 3, 250, 'Avaliable', 'Four Season'),
(6, 5, 250, 'ِAvaliable', 'Royal'),
(7, 20, 250, 'ِAvaliable', 'Royal'),
(8, 13, 250, 'ِAvaliable', 'Movenpick'),
(9, 30, 250, 'ِAvaliable', 'Movenpick'),
(10, 22, 250, 'ِAvaliable', 'Four Season'),
(11, 55, 250, 'ِAvaliable', 'Four Season');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(255) NOT NULL,
  `username` varchar(400) CHARACTER SET utf8 NOT NULL,
  `password` varchar(400) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 NOT NULL,
  `type` varchar(400) CHARACTER SET utf16 NOT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `phone`, `type`, `room_id`) VALUES
(1, 'omarjebarah', 'omar123', '0795240788', 'Admin', NULL),
(2, 'mohammad', 'mohammad123', '0795412358', 'Customer', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `myhotels`
--
ALTER TABLE `myhotels`
  ADD PRIMARY KEY (`hotel_id`),
  ADD UNIQUE KEY `hotel_name` (`hotel_name`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD UNIQUE KEY `room_number` (`room_number`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `FK_rooms` (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `myhotels`
--
ALTER TABLE `myhotels`
  MODIFY `hotel_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK_rooms` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
