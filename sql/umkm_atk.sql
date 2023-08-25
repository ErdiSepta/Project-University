-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2022 at 02:26 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `umkm_atk`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_logprodukkeluar`
--

CREATE TABLE `detail_logprodukkeluar` (
  `Id_Logkeluar` varchar(20) NOT NULL,
  `Id_Produk` varchar(20) NOT NULL,
  `Nama_Produk` varchar(50) NOT NULL,
  `jumlah` int(50) NOT NULL,
  `Harga_Jual` int(50) NOT NULL,
  `total` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_logprodukkeluar`
--

INSERT INTO `detail_logprodukkeluar` (`Id_Logkeluar`, `Id_Produk`, `Nama_Produk`, `jumlah`, `Harga_Jual`, `total`) VALUES
('LOG0001', 'STT0001', 'Bolpoin Snowman Hitam', 1, 3500, 3500),
('LOG0001', 'STT0002', 'Tipe - X Joyco 18ml', 1, 4000, 4000),
('LOG0001', 'STT0003', 'Buku tulis sidu 36 lmbr', 2, 4000, 8000),
('LOG0002', 'STT0006', 'Gantungan Kunci kecil - kecil', 1, 2000, 2000),
('LOG0002', 'STT0007', 'Bolpoin Pilot Hitam', 1, 3000, 3000),
('LOG0002', 'STT0005', 'Kertas Karton Tebal 1 x 1 M', 1, 4500, 4500),
('LOG0003', 'STT0014', 'Stabillo Warna ', 1, 4500, 4500),
('LOG0003', 'STT0012', 'Penghapus Kenko kecil', 1, 1000, 1000),
('LOG0003', 'STT0014', 'Stabillo Warna ', 1, 4500, 4500),
('LOG0004', 'STT0017', 'Krayon Diabol 12 Warna Kecil', 2, 10000, 20000),
('LOG0005', 'STT0012', 'Penghapus Kenko kecil', 1, 1000, 1000),
('LOG0005', 'STT0015', 'Gantungan Kunci Gaul', 1, 3500, 3500),
('LOG0005', 'STT0018', 'Kertas Karton Kecil 500 x 500 mm', 1, 3000, 3000),
('LOG0005', 'STT0011', 'Buku Tulis Kiky isi 32 Lmbr', 1, 2500, 2500),
('LOG0005', 'STT0014', 'Stabillo Warna ', 1, 4500, 4500);

--
-- Triggers `detail_logprodukkeluar`
--
DELIMITER $$
CREATE TRIGGER `stok_produkKeluar` AFTER INSERT ON `detail_logprodukkeluar` FOR EACH ROW BEGIN
UPDATE produk SET jumlah=jumlah-new.jumlah WHERE Id_Produk=new.Id_Produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_logprodukmasuk`
--

CREATE TABLE `detail_logprodukmasuk` (
  `Id_Logmasuk` varchar(20) NOT NULL,
  `Id_Supplier` varchar(20) NOT NULL,
  `Nama_Supplier` varchar(50) NOT NULL,
  `Id_Produk` varchar(20) NOT NULL,
  `Nama_Produk` varchar(50) NOT NULL,
  `jumlah` int(50) NOT NULL,
  `Harga_Beli` int(50) NOT NULL,
  `total` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_logprodukmasuk`
--

INSERT INTO `detail_logprodukmasuk` (`Id_Logmasuk`, `Id_Supplier`, `Nama_Supplier`, `Id_Produk`, `Nama_Produk`, `jumlah`, `Harga_Beli`, `total`) VALUES
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0001', 'Bolpoin Snowman Hitam', 12, 3500, 42000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0002', 'Tipe - X Joyco 18ml', 12, 4000, 48000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0003', 'Buku tulis sidu 36 lmbr', 24, 4000, 96000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0007', 'Bolpoin Pilot Hitam', 12, 3000, 36000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0008', 'Kertas Hvs / Lmbr', 500, 500, 250000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0009', 'Kertas Origami / Pack isi 12', 12, 5000, 60000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0012', 'Penghapus Kenko kecil', 12, 1000, 12000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0013', 'Penghapus Joyco Besar', 12, 2000, 24000),
('LOGM0001', 'SUP0001', 'Toko Pintar Alat tulisku', 'STT0014', 'Stabillo Warna ', 12, 4500, 54000),
('LOGM0002', 'SUP0002', 'Toko Nuryati Wahyuni', 'STT0004', 'Kertas Bufallo Berwarna / lmbr', 24, 1500, 36000),
('LOGM0002', 'SUP0002', 'Toko Nuryati Wahyuni', 'STT0011', 'Buku Tulis Kiky isi 32 Lmbr', 24, 2500, 60000),
('LOGM0002', 'SUP0002', 'Toko Nuryati Wahyuni', 'STT0010', 'Buku Tulis Big Boss 36 Lmbr', 24, 3500, 84000),
('LOGM0002', 'SUP0002', 'Toko Nuryati Wahyuni', 'STT0018', 'Kertas Karton Kecil 500 x 500 mm', 24, 3000, 72000),
('LOGM0002', 'SUP0002', 'Toko Nuryati Wahyuni', 'STT0005', 'Kertas Karton Tebal 1 x 1 M', 24, 4500, 108000),
('LOGM0003', 'SUP0003', 'Grosir Serba Ada', 'STT0016', 'Krayon Mecha - mecha 12 warna', 12, 12000, 144000),
('LOGM0003', 'SUP0003', 'Grosir Serba Ada', 'STT0017', 'Krayon Diabol 12 Warna Kecil', 12, 10000, 120000),
('LOGM0003', 'SUP0003', 'Grosir Serba Ada', 'STT0015', 'Gantungan Kunci Gaul', 10, 3500, 35000),
('LOGM0003', 'SUP0003', 'Grosir Serba Ada', 'STT0006', 'Gantungan Kunci kecil - kecil', 10, 2000, 20000);

--
-- Triggers `detail_logprodukmasuk`
--
DELIMITER $$
CREATE TRIGGER `stok_produkMasuk` AFTER INSERT ON `detail_logprodukmasuk` FOR EACH ROW BEGIN
UPDATE produk SET jumlah=jumlah+new.jumlah WHERE Id_Produk=new.Id_Produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `log_produkkeluar`
--

CREATE TABLE `log_produkkeluar` (
  `Tanggal` date NOT NULL,
  `Id_Logkeluar` varchar(20) NOT NULL,
  `Total_HargaSeluruh` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log_produkkeluar`
--

INSERT INTO `log_produkkeluar` (`Tanggal`, `Id_Logkeluar`, `Total_HargaSeluruh`) VALUES
('2022-12-27', 'LOG0001', 15500),
('2022-12-27', 'LOG0002', 9500),
('2022-12-27', 'LOG0003', 10000),
('2022-12-27', 'LOG0004', 20000),
('2022-12-27', 'LOG0005', 14500);

-- --------------------------------------------------------

--
-- Table structure for table `log_produkmasuk`
--

CREATE TABLE `log_produkmasuk` (
  `Tanggal` date NOT NULL,
  `Id_Logmasuk` varchar(20) NOT NULL,
  `Total_HargaSeluruh` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log_produkmasuk`
--

INSERT INTO `log_produkmasuk` (`Tanggal`, `Id_Logmasuk`, `Total_HargaSeluruh`) VALUES
('2022-12-27', 'LOGM0001', 622000),
('2022-12-27', 'LOGM0002', 360000),
('2022-12-27', 'LOGM0003', 319000);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `Tanggal` date NOT NULL,
  `Id_Produk` varchar(20) NOT NULL,
  `Nama_Produk` varchar(50) NOT NULL,
  `Kategori` varchar(20) NOT NULL,
  `jumlah` char(4) NOT NULL,
  `Harga_Jual` int(50) NOT NULL,
  `Harga_Beli` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`Tanggal`, `Id_Produk`, `Nama_Produk`, `Kategori`, `jumlah`, `Harga_Jual`, `Harga_Beli`) VALUES
('2022-12-27', 'STT0001', 'Bolpoin Snowman Hitam', 'Alat Tulis', '11', 3500, 2500),
('2022-12-27', 'STT0002', 'Tipe - X Joyco 18ml', 'Alat Tulis', '11', 4000, 3000),
('2022-12-27', 'STT0003', 'Buku tulis sidu 36 lmbr', 'Buku', '22', 4000, 3000),
('2022-12-27', 'STT0004', 'Kertas Bufallo Berwarna / lmbr', 'Kertas', '24', 1500, 500),
('2022-12-27', 'STT0005', 'Kertas Karton Tebal 1 x 1 M', 'Kertas', '23', 4500, 3500),
('2022-12-27', 'STT0006', 'Gantungan Kunci kecil - kecil', 'Aksesoris', '9', 2000, 1000),
('2022-12-27', 'STT0007', 'Bolpoin Pilot Hitam', 'Alat Tulis', '11', 3000, 2000),
('2022-12-27', 'STT0008', 'Kertas Hvs / Lmbr', 'Kertas', '500', 500, 200),
('2022-12-27', 'STT0009', 'Kertas Origami / Pack isi 12', 'Kertas', '12', 5000, 4000),
('2022-12-27', 'STT0010', 'Buku Tulis Big Boss 36 Lmbr', 'Buku', '24', 3500, 2500),
('2022-12-27', 'STT0011', 'Buku Tulis Kiky isi 32 Lmbr', 'Buku', '23', 2500, 1500),
('2022-12-27', 'STT0012', 'Penghapus Kenko kecil', 'Alat Tulis', '10', 1000, 500),
('2022-12-27', 'STT0013', 'Penghapus Joyco Besar', 'Alat Tulis', '12', 2000, 1500),
('2022-12-27', 'STT0014', 'Stabillo Warna ', 'Alat Tulis', '9', 4500, 3500),
('2022-12-27', 'STT0015', 'Gantungan Kunci Gaul', 'Aksesoris', '9', 3500, 2000),
('2022-12-27', 'STT0016', 'Krayon Mecha - mecha 12 warna', 'Cat Tulis', '12', 12000, 10000),
('2022-12-27', 'STT0017', 'Krayon Diabol 12 Warna Kecil', 'Cat Tulis', '10', 10000, 9000),
('2022-12-27', 'STT0018', 'Kertas Karton Kecil 500 x 500 mm', 'Kertas', '23', 3000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Id_Supplier` varchar(20) NOT NULL,
  `Nama_Supplier` varchar(50) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `No_Kontak` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Id_Supplier`, `Nama_Supplier`, `Alamat`, `No_Kontak`) VALUES
('SUP0001', 'Toko Pintar Alat tulisku', 'Mojoroto, Kediri', '089433210988'),
('SUP0002', 'Toko Nuryati Wahyuni', 'Joho, Nganjuk', '081223906774'),
('SUP0003', 'Grosir Serba Ada', 'Pace, Nganjuk', '0836376376476');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Nama_Panjang` varchar(50) NOT NULL,
  `nama_panggilan` varchar(50) NOT NULL,
  `Username` varchar(11) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Jenis_Kelamin` varchar(50) NOT NULL,
  `Tgl_Lahir` varchar(50) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_Kontak` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Nama_Panjang`, `nama_panggilan`, `Username`, `Password`, `Jenis_Kelamin`, `Tgl_Lahir`, `Alamat`, `No_Kontak`) VALUES
('Auliya Santi Susila', 'Auliya', 'auliya123', 'Sept202003', 'Laki - Laki', '02-12-2000', 'Ngadiluwih, Kediri', '0822334781010');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_logprodukkeluar`
--
ALTER TABLE `detail_logprodukkeluar`
  ADD KEY `Id_Logkeluar` (`Id_Logkeluar`),
  ADD KEY `Id_Produk` (`Id_Produk`);

--
-- Indexes for table `detail_logprodukmasuk`
--
ALTER TABLE `detail_logprodukmasuk`
  ADD KEY `Id_Produk` (`Id_Produk`),
  ADD KEY `fk_supplier` (`Id_Supplier`),
  ADD KEY `Id_Logmasuk` (`Id_Logmasuk`);

--
-- Indexes for table `log_produkkeluar`
--
ALTER TABLE `log_produkkeluar`
  ADD PRIMARY KEY (`Id_Logkeluar`);

--
-- Indexes for table `log_produkmasuk`
--
ALTER TABLE `log_produkmasuk`
  ADD PRIMARY KEY (`Id_Logmasuk`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`Id_Produk`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Id_Supplier`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_logprodukkeluar`
--
ALTER TABLE `detail_logprodukkeluar`
  ADD CONSTRAINT `fk_logkeluar` FOREIGN KEY (`Id_Logkeluar`) REFERENCES `log_produkkeluar` (`Id_Logkeluar`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produk1` FOREIGN KEY (`Id_Produk`) REFERENCES `produk` (`Id_Produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_logprodukmasuk`
--
ALTER TABLE `detail_logprodukmasuk`
  ADD CONSTRAINT `fk_logmasuk` FOREIGN KEY (`Id_Logmasuk`) REFERENCES `log_produkmasuk` (`Id_Logmasuk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produk` FOREIGN KEY (`Id_Produk`) REFERENCES `produk` (`Id_Produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_supplier` FOREIGN KEY (`Id_Supplier`) REFERENCES `supplier` (`Id_Supplier`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
