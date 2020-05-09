-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 10:06 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `finalproject_b6`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `id_jenis_buku` int(11) NOT NULL,
  `judul` varchar(200) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `penerbit` varchar(200) NOT NULL,
  `pengarang` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `id_jenis_buku`, `judul`, `jumlah`, `penerbit`, `pengarang`) VALUES
(1, 1, 'Judul 1', 0, 'PT. XXXX', 'Ambar'),
(2, 2, 'Judul 2', 10, 'PT. YYY', 'Ambar');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_buku`
--

CREATE TABLE `jenis_buku` (
  `id` int(11) NOT NULL,
  `jenis_buku` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `jenis_buku`
--

INSERT INTO `jenis_buku` (`id`, `jenis_buku`) VALUES
(1, 'Karya Tulis'),
(2, 'Majalah/Koran'),
(3, 'Cerita/Novel'),
(4, 'Buku Ajar'),
(5, 'Lainnya');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_buku`
--

CREATE TABLE `peminjaman_buku` (
  `id` int(11) NOT NULL,
  `denda` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `jumlah_hari` int(11) NOT NULL,
  `nama_buku` varchar(200) NOT NULL,
  `status` int(11) NOT NULL,
  `tanggal_peminjaman` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `uuid_user` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman_buku`
--

INSERT INTO `peminjaman_buku` (`id`, `denda`, `id_buku`, `jumlah_hari`, `nama_buku`, `status`, `tanggal_peminjaman`, `tanggal_pengembalian`, `uuid_user`) VALUES
(1, 0, 1, 0, 'Judul 1', 0, '2020-05-04', '2020-05-11', '1'),
(2, 10000, 1, 10, 'Buku 1', 5, '2020-04-17', '2020-04-24', '1');

-- --------------------------------------------------------

--
-- Table structure for table `pengadaan_buku`
--

CREATE TABLE `pengadaan_buku` (
  `id` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `judul` varchar(200) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `penerbit` varchar(200) NOT NULL,
  `pengarang` varchar(200) NOT NULL,
  `status` int(11) NOT NULL,
  `uuid_user` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengadaan_buku`
--

INSERT INTO `pengadaan_buku` (`id`, `harga`, `judul`, `jumlah`, `penerbit`, `pengarang`, `status`, `uuid_user`) VALUES
(1, 200000, 'Pengadaan 1', 13, 'PT XXXX', 'Ambar', 0, '1'),
(2, 12000000, 'Pengadaan 2', 4, 'PT VVVV', 'Fira', 0, '1'),
(3, 3, 'qqq', 3, 'qqq', 'qqq', 0, '1'),
(4, 222, 'WWW', 3333, 'WW', 'WWW', 0, '1'),
(5, 222, 'EEE', 33, 'EEE', 'EEE', 0, '1'),
(6, 3333, 'RRR', 5, 'RRR', 'RRR', 0, '1'),
(7, 444, 'TTT', 5, 'TTTT', 'TTT', 0, '1'),
(8, 6666, 'YYY', 66, 'YYY', 'YYY', 0, '1'),
(9, 66, 'UUU', 666, 'UUU', 'UUU', 0, '1'),
(10, 555, 'III', 777, 'III7', 'III', 0, '1'),
(11, 77, 'OOO', 777, 'OOO', 'OOO', 0, '1');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `id_role` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `nip` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `telepon` varchar(200) NOT NULL,
  `tempat_lahir` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `uuid` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `alamat`, `id_role`, `nama`, `nip`, `password`, `tanggal_lahir`, `telepon`, `tempat_lahir`, `username`, `uuid`) VALUES
(1, 'Jalan ABC', 5, 'Ambar', '12345', '123', '2020-05-13', '0856', 'Bogor', 'dwi', '1');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `nama`) VALUES
(1, 'Kepala Sekolah'),
(2, 'Admin TU'),
(3, 'Guru'),
(4, 'Siswa'),
(5, 'Pustakawan'),
(6, 'Pengurus Koperasi'),
(7, 'Anggota Koperasi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman_buku`
--
ALTER TABLE `peminjaman_buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengadaan_buku`
--
ALTER TABLE `pengadaan_buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_86qo9wgo7dttnc5okf9t5ocpu` (`nip`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `peminjaman_buku`
--
ALTER TABLE `peminjaman_buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pengadaan_buku`
--
ALTER TABLE `pengadaan_buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
