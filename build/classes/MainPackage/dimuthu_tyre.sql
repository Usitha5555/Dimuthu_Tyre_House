-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 22, 2021 at 12:34 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dimuthu_tyre`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `email` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `region` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`email`, `fname`, `lname`, `region`, `pwd`) VALUES
('demo12', 'Adithya', 'Rathnayake', 'KANDY', 'demo12');

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE IF NOT EXISTS `login_info` (
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `size` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `buying_price` double NOT NULL,
  `selling_price` double NOT NULL,
  `selling_discount` double NOT NULL,
  `quantity` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `brand`, `size`, `category`, `buying_price`, `selling_price`, `selling_discount`, `quantity`) VALUES
(1, 'Ceat', '123z', 'alloy wheel', 100, 110, 0, 45),
(2, 'Dunlop', '135x', 'alloy wheel', 1500, 1550, 0, 10),
(3, 'drd', '213ws', 'bike', 12, 14, 0, 1),
(4, 'ghy', '56t', 'tyre', 25.5, 30, 0, 20),
(5, 'ceat', '456', 'tyre', 90, 100, 0, 1),
(6, 'lotus', '678', 'alloy Wheel', 5, 10, 0, 5),
(7, 'qwe', '098', 'Alloy Wheels', 10, 15, 0, 12),
(8, 'qaz', '567', 'Alloy Wheel', 10, 12, 0, 24),
(9, 'lk', '657', 'Tyre', 10, 14, 0, 10),
(10, 'we', '234', 'Alloy Wheel', 10, 15, 0, 10),
(11, 'we', '23', 'Alloy Wheel', 10.15, 15, 0, 3),
(12, 'we2', '12', 'Tyre', 12, 12.56, 0, 10),
(13, 'er3', '345', 'Alloy Wheel', 25.56, 27.56, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE IF NOT EXISTS `purchase` (
  `Purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `P_Date` date NOT NULL,
  `Total_cost` double NOT NULL,
  PRIMARY KEY (`Purchase_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`Purchase_id`, `P_Date`, `Total_cost`) VALUES
(3, '2021-07-04', 12),
(2, '2021-07-03', 16000),
(4, '2021-07-04', 1255),
(5, '2021-07-04', 2255),
(6, '2021-07-04', 90),
(7, '2021-07-10', 25),
(8, '2021-07-11', 100),
(9, '2021-07-11', 100),
(10, '2021-07-11', 100),
(11, '2021-07-11', 100),
(12, '2021-07-11', 200),
(13, '2021-07-11', 10),
(14, '2021-07-12', 10),
(15, '2021-07-12', 20.75),
(16, '2021-07-12', 20.75),
(17, '2021-07-12', 100),
(18, '2021-07-12', 10.15),
(19, '2021-07-12', 35.9),
(20, '2021-07-12', 155.9),
(21, '2021-07-12', 25.56),
(22, '2021-07-19', 1200);

-- --------------------------------------------------------

--
-- Table structure for table `purchase_item`
--

DROP TABLE IF EXISTS `purchase_item`;
CREATE TABLE IF NOT EXISTS `purchase_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Purchase_id` int(11) NOT NULL,
  `Received_Date` date NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `Size` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Buying_Price` double NOT NULL,
  `Selling_Price` double NOT NULL,
  `Discount` double NOT NULL,
  `Quantity` double NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase_item`
--

INSERT INTO `purchase_item` (`ID`, `Purchase_id`, `Received_Date`, `Brand`, `Size`, `Category`, `Buying_Price`, `Selling_Price`, `Discount`, `Quantity`, `Total`) VALUES
(6, 4, '2021-07-04', '123z', 'Ceat', 'Bike', 100, 110, 0, 10, 1000),
(5, 3, '2021-07-04', '213ws', 'drd', 'BIKE', 12, 14, 0, 1, 12),
(3, 2, '2021-07-03', '123z', 'Ceat', 'Bike', 100, 110, 0, 10, 1000),
(4, 2, '2021-07-03', '135x', 'Dunlop', 'Car', 1500, 1550, 0, 10, 15000),
(7, 4, '2021-07-04', '56t', 'ghy', 'catee', 25.5, 30, 0, 10, 255),
(8, 5, '2021-07-04', '123z', 'Ceat', 'Bike', 100, 110, 0, 10, 1000),
(9, 5, '2021-07-04', '56t', 'ghy', 'catee', 25.5, 30, 0, 10, 255),
(10, 5, '2021-07-04', '123z', 'Ceat', 'Bike', 1000, 110, 0, 1, 1000),
(11, 6, '2021-07-04', '456', 'ceat', 'bIke', 90, 100, 0, 1, 90),
(12, 7, '2021-07-10', '678', 'lotus', 'alloy', 5, 10, 0, 5, 25),
(13, 8, '2021-07-11', '123z', 'Ceat', 'alloy', 100, 110, 0, 1, 100),
(14, 9, '2021-07-11', '123z', 'Ceat', 'alloy wheel', 100, 110, 0, 1, 100),
(15, 10, '2021-07-11', '098', 'qwe', 'Alloy Wheels', 10, 15, 0, 10, 100),
(16, 11, '2021-07-11', '567', 'qaz', 'Alloy Wheel', 10, 12, 0, 10, 100),
(17, 12, '2021-07-11', '567', 'qaz', 'Alloy Wheel', 10, 12, 0, 10, 100),
(18, 12, '2021-07-11', '657', 'lk', 'Tyre', 10, 14, 0, 10, 100),
(19, 13, '2021-07-11', '567', 'qaz', 'Alloy Wheel', 10, 12, 0, 1, 10),
(20, 14, '2021-07-12', '567', 'qaz', 'Alloy Wheel', 10, 12, 0, 1, 10),
(21, 15, '2021-07-12', '098', 'jkl', 'Alloy Wheel', 20.75, 30.25, 0, 1, 20.75),
(22, 16, '2021-07-12', '098', 'jkl', 'Alloy Wheel', 20.75, 30.25, 0, 1, 20.75),
(23, 17, '2021-07-12', '234', 'we', 'Alloy Wheel', 10, 15, 0, 10, 100),
(24, 18, '2021-07-12', '23', 'we', 'Alloy Wheel', 10.15, 15, 0, 1, 10.15),
(25, 19, '2021-07-12', '23', 'we', 'Alloy Wheel', 10.15, 15, 0, 1, 10.15),
(26, 19, '2021-07-12', '567', 'qe', 'Tyre', 25.75, 30.8, 0, 1, 25.75),
(27, 20, '2021-07-12', '23', 'we', 'Alloy Wheel', 10.15, 15, 0, 1, 10.15),
(28, 20, '2021-07-12', '567', 'qe', 'Tyre', 25.75, 30.8, 0, 1, 25.75),
(29, 20, '2021-07-12', '12', 'we2', 'Tyre', 12, 12.56, 0, 10, 120),
(30, 21, '2021-07-12', '345', 'er3', 'Alloy Wheel', 25.56, 27.56, 0, 1, 25.56),
(31, 22, '2021-07-19', '123z', 'Ceat', 'Tyre', 100, 110, 0, 12, 1200);

-- --------------------------------------------------------

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
CREATE TABLE IF NOT EXISTS `story` (
  `StoryID` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `StoryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`StoryID`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `story`
--

INSERT INTO `story` (`StoryID`, `StoryName`) VALUES
(1, '123z'),
(2, '213ws'),
(15, 'Ceat'),
(16, 'we'),
(11, '456'),
(17, '23'),
(14, '12');

-- --------------------------------------------------------

--
-- Table structure for table `tyre_products`
--

DROP TABLE IF EXISTS `tyre_products`;
CREATE TABLE IF NOT EXISTS `tyre_products` (
  `size` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `pr` varchar(30) NOT NULL,
  `pattern` varchar(50) NOT NULL,
  `net_price_without_vat` varchar(5000) NOT NULL,
  `net_price_with_vat` varchar(5000) NOT NULL,
  `retail_price` varchar(5000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tyre_products`
--

INSERT INTO `tyre_products` (`size`, `brand`, `pr`, `pattern`, `net_price_without_vat`, `net_price_with_vat`, `retail_price`) VALUES
('7.50-20', 'CEAT ', '12', 'FM SLEEK', '26960.69', '29117.55', '41596.00'),
('9.00-20', 'CEAT ', '14', 'RIB XL', '33085.96 ', '35732.84', '51047.00'),
('8.25-20', 'CEAT ', '14', 'XL SUPER', '31063.87 ', '33548.98 ', '47927.00'),
('9.00-20', 'CEAT ', '16', 'XL SUPER', '38246.87 ', '41306.62 ', '59009.00'),
(' 10.00-20 ', 'CEAT ', '16', 'XL SUPER', '44306.20 ', '47850.70 ', '68358.00'),
('10.00-20 ', 'CEAT ', '18', 'RIB XL PREMIUM', '48887.51', '52798.51 ', '75426.00'),
('10.00-20 ', 'CEAT ', '18', 'CT TROLLA', '45789.02', '49452.14 ', '70646.00'),
('10.00-20 ', 'CEAT ', '18', 'MILE XL', '51152.82 ', '55245.05', '78921.00'),
('10.00-20 ', 'CEAT ', '18', 'MILE XL PREMIUM', '46508.29', '50228.95 ', '71756.00'),
('10.00-20 ', 'CEAT ', '18', 'LYFMAX', '45865.38 ', '49534.61 ', '70764.00'),
('10.00-20 ', 'CEAT ', '18', 'LOAD MAX', '47616.64', '51425.97', '73466.00'),
('11.00-20', 'CEAT ', '18', 'MILE XL', '52078.98', '56245.30', '80350.00'),
('12.00-20', 'CEAT ', '18', 'FM', '53758.63', '58059.32', '82942.00'),
('12.00-20 ', 'CEAT ', '18', 'HCL SUPER', '54665.48 ', '59038.72 ', '84341.00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
