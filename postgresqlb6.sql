-- File name: D:\RISKA\APAP\FINAL PROJECT\SIPERPUS\BACKEND\postgresqlb6.sql
-- Created by DMSoft Technologies 


--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `id_jenis_buku` INT(11) NOT NULL,
  `judul` VARCHAR(200) NOT NULL,
  `jumlah` INT(11) NOT NULL,
  `penerbit` VARCHAR(200) NOT NULL,
  `pengarang` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Table structure for table `jenis_buku`
--

CREATE TABLE `jenis_buku` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `jenis_buku` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Table structure for table `peminjaman_buku`
--

CREATE TABLE `peminjaman_buku` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `denda` INT(11) NOT NULL,
  `id_buku` INT(11) NOT NULL,
  `jumlah_hari` INT(11) NOT NULL,
  `nama_buku` VARCHAR(200) NOT NULL,
  `status` INT(11) NOT NULL,
  `tanggal_peminjaman` DATE NOT NULL,
  `tanggal_pengembalian` DATE NOT NULL,
  `uuid_user` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Table structure for table `pengadaan_buku`
--

CREATE TABLE `pengadaan_buku` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `harga` INT(11) NOT NULL,
  `judul` VARCHAR(200) NOT NULL,
  `jumlah` INT(11) NOT NULL,
  `penerbit` VARCHAR(200) NOT NULL,
  `pengarang` VARCHAR(200) NOT NULL,
  `status` INT(11) NOT NULL,
  `uuid_user` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `alamat` VARCHAR(200) NOT NULL,
  `id_role` INT(11) NOT NULL,
  `nama` VARCHAR(200) NOT NULL,
  `nip` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `tanggal_lahir` DATE NOT NULL,
  `telepon` VARCHAR(200) NOT NULL,
  `tempat_lahir` VARCHAR(200) NOT NULL,
  `username` VARCHAR(200) NOT NULL,
  `uuid` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC),
  UNIQUE KEY `UK_86qo9wgo7dttnc5okf9t5ocpu` (`nip` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `nama` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id` ASC)
) DEFAULT CHARSET=utf8 ENGINE=InnoDB;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`,`id_jenis_buku`,`judul`,`jumlah`,`penerbit`,`pengarang`) VALUES (1,1,'Judul 1',0,'PT. XXXX','Ambar'),(2,2,'Judul 2',10,'PT. YYY','Ambar');

--
-- Dumping data for table `jenis_buku`
--

INSERT INTO `jenis_buku` (`id`,`jenis_buku`) VALUES (1,'Karya Tulis'),(2,'Majalah/Koran'),(3,'Cerita/Novel'),(4,'Buku Ajar'),(5,'Lainnya');

--
-- Dumping data for table `peminjaman_buku`
--

INSERT INTO `peminjaman_buku` (`id`,`denda`,`id_buku`,`jumlah_hari`,`nama_buku`,`status`,`tanggal_peminjaman`,`tanggal_pengembalian`,`uuid_user`) VALUES (1,0,1,0,'Judul 1',0,'2020-05-04','2020-05-11','1'),(2,10000,1,10,'Buku 1',5,'2020-04-17','2020-04-24','1');

--
-- Dumping data for table `pengadaan_buku`
--

INSERT INTO `pengadaan_buku` (`id`,`harga`,`judul`,`jumlah`,`penerbit`,`pengarang`,`status`,`uuid_user`) VALUES (1,200000,'Pengadaan 1',13,'PT XXXX','Ambar',0,'1'),(2,12000000,'Pengadaan 2',4,'PT VVVV','Fira',0,'1'),(3,3,'qqq',3,'qqq','qqq',0,'1'),(4,222,'WWW',3333,'WW','WWW',0,'1'),(5,222,'EEE',33,'EEE','EEE',0,'1'),(6,3333,'RRR',5,'RRR','RRR',0,'1'),(7,444,'TTT',5,'TTTT','TTT',0,'1'),(8,6666,'YYY',66,'YYY','YYY',0,'1'),(9,66,'UUU',666,'UUU','UUU',0,'1'),(10,555,'III',777,'III7','III',0,'1'),(11,77,'OOO',777,'OOO','OOO',0,'1');

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`,`alamat`,`id_role`,`nama`,`nip`,`password`,`tanggal_lahir`,`telepon`,`tempat_lahir`,`username`,`uuid`) VALUES (1,'Jalan ABC',5,'Ambar','12345','123','2020-05-13','0856','Bogor','dwi','1');

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`,`nama`) VALUES (1,'Kepala Sekolah'),(2,'Admin TU'),(3,'Guru'),(4,'Siswa'),(5,'Pustakawan'),(6,'Pengurus Koperasi'),(7,'Anggota Koperasi');
