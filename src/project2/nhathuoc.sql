-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: nhathuoc
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hangsanxuat`
--

DROP TABLE IF EXISTS `hangsanxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hangsanxuat` (
  `maHangSanXuat` int NOT NULL,
  `tenHangSanXuat` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quocGia` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dienThoai` varchar(13) NOT NULL,
  PRIMARY KEY (`maHangSanXuat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangsanxuat`
--

LOCK TABLES `hangsanxuat` WRITE;
/*!40000 ALTER TABLE `hangsanxuat` DISABLE KEYS */;
INSERT INTO `hangsanxuat` VALUES (1,'Công ty cổ phần dược Hậu Giang','Việt Nam','07103895209'),(2,'Traphaco','Việt Nam','18006612'),(3,'MEKOPHAR','Việt Nam','038652478'),(4,'PYMEPHARCO','Việt Nam','01234546789'),(5,'Imexpharm','Việt Nam','0710383259'),(6,'HDPHARMA','Việt Nam','07121235209');
/*!40000 ALTER TABLE `hangsanxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonban`
--

DROP TABLE IF EXISTS `hoadonban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonban` (
  `maHoaDon` int NOT NULL,
  `maNhanVien` int NOT NULL,
  `maKhachHang` int NOT NULL,
  `ngayBan` datetime DEFAULT NULL,
  PRIMARY KEY (`maHoaDon`),
  KEY `hoadonban_nhanvien_fk` (`maNhanVien`),
  KEY `hoadonban_khachhang_fk` (`maKhachHang`),
  CONSTRAINT `hoadonban_khachhang_fk` FOREIGN KEY (`maKhachHang`) REFERENCES `khachhang` (`maKhachHang`),
  CONSTRAINT `hoadonban_nhanvien_fk` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonban`
--

LOCK TABLES `hoadonban` WRITE;
/*!40000 ALTER TABLE `hoadonban` DISABLE KEYS */;
INSERT INTO `hoadonban` VALUES (1,1,1,'2021-05-01 00:00:00'),(2,3,4,'2021-05-03 00:00:00'),(3,4,3,'2021-05-03 00:00:00'),(4,5,2,'2021-05-04 00:00:00'),(5,6,1,'2021-05-05 00:00:00'),(6,1,2,'2021-05-06 00:00:00'),(7,2,3,'2021-05-06 00:00:00'),(8,3,4,'2021-05-02 00:00:00'),(9,4,5,'2021-05-06 00:00:00'),(10,5,6,'2021-05-02 00:00:00'),(11,2,1,'2021-05-02 00:00:00');
/*!40000 ALTER TABLE `hoadonban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonbanchitiet`
--

DROP TABLE IF EXISTS `hoadonbanchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonbanchitiet` (
  `maHoaDon` int NOT NULL,
  `maThuoc` int NOT NULL,
  `soLuong` int NOT NULL,
  `gia` float NOT NULL,
  PRIMARY KEY (`maHoaDon`,`maThuoc`),
  KEY `hoadonbanchitiet_thuoc_fk` (`maThuoc`),
  CONSTRAINT `hoadonbanchitiet_hoadonban_fk` FOREIGN KEY (`maHoaDon`) REFERENCES `hoadonban` (`maHoaDon`),
  CONSTRAINT `hoadonbanchitiet_thuoc_fk` FOREIGN KEY (`maThuoc`) REFERENCES `thuoc` (`maThuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonbanchitiet`
--

LOCK TABLES `hoadonbanchitiet` WRITE;
/*!40000 ALTER TABLE `hoadonbanchitiet` DISABLE KEYS */;
INSERT INTO `hoadonbanchitiet` VALUES (1,2,100,35),(1,5,100,35),(2,3,600,35),(2,4,200,35),(3,5,300,35),(4,3,500,35),(5,5,100,35),(6,1,500,35);
/*!40000 ALTER TABLE `hoadonbanchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonnhap`
--

DROP TABLE IF EXISTS `hoadonnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonnhap` (
  `maHoaDon` int NOT NULL,
  `maNhanVien` int NOT NULL,
  `maNhaCungCap` int NOT NULL,
  `ngayNhap` datetime DEFAULT NULL,
  PRIMARY KEY (`maHoaDon`),
  KEY `hoadonnhap_nhanvien_fk` (`maNhanVien`),
  KEY `hoadonnhap_nhacungcap_fk` (`maNhaCungCap`),
  CONSTRAINT `hoadonnhap_nhacungcap_fk` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`),
  CONSTRAINT `hoadonnhap_nhanvien_fk` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonnhap`
--

LOCK TABLES `hoadonnhap` WRITE;
/*!40000 ALTER TABLE `hoadonnhap` DISABLE KEYS */;
INSERT INTO `hoadonnhap` VALUES (1,1,2,'2021-01-06 00:00:00'),(2,3,1,'2021-01-06 00:00:00'),(3,5,3,'2021-01-06 00:00:00'),(4,6,4,'2021-01-06 00:00:00'),(5,1,5,'2021-01-06 00:00:00'),(6,2,5,'2021-01-06 00:00:00'),(7,3,1,'2021-01-06 00:00:00'),(8,4,6,'2021-01-06 00:00:00'),(9,5,2,'2021-01-06 00:00:00'),(10,6,3,'2021-01-06 00:00:00');
/*!40000 ALTER TABLE `hoadonnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonnhapchitiet`
--

DROP TABLE IF EXISTS `hoadonnhapchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonnhapchitiet` (
  `maHoaDon` int NOT NULL,
  `maThuoc` int NOT NULL,
  `soLuong` int NOT NULL,
  `gia` float NOT NULL,
  PRIMARY KEY (`maHoaDon`,`maThuoc`),
  KEY `hoadonnhapchitiet_thuoc_fk` (`maThuoc`),
  CONSTRAINT `hoadonnhapchitiet_hoadonnhap_fk` FOREIGN KEY (`maHoaDon`) REFERENCES `hoadonnhap` (`maHoaDon`),
  CONSTRAINT `hoadonnhapchitiet_thuoc_fk` FOREIGN KEY (`maThuoc`) REFERENCES `thuoc` (`maThuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonnhapchitiet`
--

LOCK TABLES `hoadonnhapchitiet` WRITE;
/*!40000 ALTER TABLE `hoadonnhapchitiet` DISABLE KEYS */;
INSERT INTO `hoadonnhapchitiet` VALUES (1,1,50,10),(1,2,50,10),(2,2,50,11),(2,3,50,11),(3,5,50,12),(4,4,50,13),(5,6,50,14),(6,1,50,15);
/*!40000 ALTER TABLE `hoadonnhapchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKhachHang` int NOT NULL,
  `tenKhachHang` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dienThoai` varchar(13) NOT NULL,
  PRIMARY KEY (`maKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Mai Anh Tuấn','Hải Hậu','097215235'),(2,'Mai Tuấn Tú','Hải An','012315235'),(3,'Đỗ Tiến Sỹ','Hải Hậu','097215235'),(4,'Đỗ Đại Học','Hải Cường','097215125'),(5,'Mạc Văn Tài','Hải Tiến','097234235'),(6,'An Bình Tĩnh','Hải Châu','0974345335');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaithuoc`
--

DROP TABLE IF EXISTS `loaithuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaithuoc` (
  `maLoai` int NOT NULL,
  `tenLoai` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ghiChu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaithuoc`
--

LOCK TABLES `loaithuoc` WRITE;
/*!40000 ALTER TABLE `loaithuoc` DISABLE KEYS */;
INSERT INTO `loaithuoc` VALUES (1,'Thuốc kháng sinh','Không dùng cho phụ nữ mang thai'),(2,'Thuốc kháng viêm',NULL),(3,'Thuốc giảm đau',NULL),(4,'Thuốc dạ dầy',NULL),(5,'Thuốc bôi ngoài da',NULL),(6,'Thuốc trị tăng huyết áp',NULL);
/*!40000 ALTER TABLE `loaithuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `maNhaCungCap` int NOT NULL,
  `tenNhaCungCap` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diaChi` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dienThoai` varchar(13) NOT NULL,
  PRIMARY KEY (`maNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES (1,'Gà Lôi','Hoàng Mai','012345876'),(2,'Gà Gô','Hoàng Mai','012345876'),(3,'Gà Rừng','Hoàng Mai','012345876'),(4,'Gà Nhà','Hoàng Mai','012345876'),(5,'Gà Gỗ','Hoàng Mai','012345876'),(6,'Gà Đất','Hoàng Mai','012345876');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNhanVien` int NOT NULL,
  `tenNhanVien` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngaySinh` datetime NOT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soDienThoai` varchar(13) NOT NULL,
  `luong` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Trần Văn Độ','1995-04-02 00:00:00','Nam Định','0123548963',1000.00),(2,'Nguyễn Thái Hà','1997-01-01 00:00:00','Hải Phòng','0143548963',1200.00),(3,'Nguyễn Nguyên Bách','1997-01-01 00:00:00','Hải Phòng','0983548963',1100.00),(4,'Nguyễn Văn Thủy','1997-01-01 00:00:00','Hà Nội','0123546763',1100.00),(5,'Đặng Đình Tiệp','2000-01-01 00:00:00','Hà Nội','0123548963',1100.00),(6,'Trương Bá Chính','1997-04-02 00:00:00','Hà Nội','0133548963',1100.00);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoc`
--

DROP TABLE IF EXISTS `thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoc` (
  `maThuoc` int NOT NULL,
  `tenThuoc` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maNhaCungCap` int NOT NULL,
  `maHangSanXuat` int DEFAULT NULL,
  `congDung` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maLoai` int NOT NULL,
  `gia` float NOT NULL,
  `soLuongTon` int DEFAULT NULL,
  PRIMARY KEY (`maThuoc`),
  KEY `thuoc_hangsanxuat_fk` (`maHangSanXuat`),
  KEY `thuoc_nhacungcap_fk` (`maNhaCungCap`),
  KEY `thuoc_loai_fk` (`maLoai`),
  CONSTRAINT `thuoc_hangsanxuat_fk` FOREIGN KEY (`maHangSanXuat`) REFERENCES `hangsanxuat` (`maHangSanXuat`),
  CONSTRAINT `thuoc_loai_fk` FOREIGN KEY (`maLoai`) REFERENCES `loaithuoc` (`maLoai`),
  CONSTRAINT `thuoc_nhacungcap_fk` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoc`
--

LOCK TABLES `thuoc` WRITE;
/*!40000 ALTER TABLE `thuoc` DISABLE KEYS */;
INSERT INTO `thuoc` VALUES (1,'penicilin',2,3,'ức chế sự phát triển của các vi sinh vật',1,20,20),(2,'Amoxicillin',1,3,'ức chế sự phát triển của các vi sinh vật',1,22,22),(3,'Cephalexin',2,1,'ức chế sự phát triển của các vi sinh vật',3,20,20),(4,'Celecoxib',5,5,'ức chế sự phát triển của các vi sinh vật',2,21,21),(5,'Diclofenac diethylamin',1,1,'ức chế sự phát triển của các vi sinh vật',1,23,23),(6,'Diclofenac kali',2,5,'ức chế sự phát triển của các vi sinh vật',2,21,21),(7,'Flurbiprofen',2,4,'ức chế sự phát triển của các vi sinh vật',3,25,25),(8,'Ibuprofen',4,3,'ức chế sự phát triển của các vi sinh vật',4,24,24),(9,'Indomethacin',5,2,'ức chế sự phát triển của các vi sinh vật',5,26,26),(10,'Ketoprofen',6,1,'ức chế sự phát triển của các vi sinh vật',6,21,21);
/*!40000 ALTER TABLE `thuoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-11 11:14:29
