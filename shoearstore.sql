-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Haz 2018, 22:28:00
-- Sunucu sürümü: 5.6.24
-- PHP Sürümü: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `shoearstore`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `aboutus`
--

CREATE TABLE IF NOT EXISTS `aboutus` (
  `Id` int(11) NOT NULL,
  `Content` text NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `aboutus`
--

INSERT INTO `aboutus` (`Id`, `Content`, `Status`) VALUES
(1, '<h1 style="box-sizing: inherit; margin: 0px auto; border: 0px; font-variant-numeric: inherit; font-weight: 500; font-stretch: inherit; font-size: 20px; line-height: 1.2; font-family: AvenirNextLTPro, Helvetica, sans-serif; vertical-align: baseline; outline: 0px; color: rgb(242, 139, 0);">\n	T&uuml;rkiye&#39;nin en b&uuml;y&uuml;k ve en &ccedil;ok sevilen e-ticaret sitesine hoş geldiniz!</h1>\n<div style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-variant-numeric: inherit; font-stretch: inherit; font-size: 15px; line-height: inherit; font-family: AvenirNextLTPro, Helvetica, Arial, sans-serif; vertical-align: baseline; outline: 0px; width: 1041px; color: rgb(72, 72, 72);">\n	<img src="http://localhost/shoearstore/assets/images/hakkimizda_1.jpg" style="box-sizing: inherit; margin: 0px 0px 0px 15px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px; height: auto; display: block; max-width: 100%; float: left;" /><span style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px; color: rgb(242, 139, 0);">2001 yılından beri</span>&nbsp;T&uuml;rkiye&rsquo;de online alışverişin en g&uuml;&ccedil;l&uuml; ismiyiz. Kurduğumuz hayaller ve ulaştığımız hedeflerle bug&uuml;nlere ulaştık. Online alışverişi geliştirdik, hizmet anlayışımızla fark yarattık. Hem &ccedil;ok b&uuml;y&uuml;d&uuml;k hem &ccedil;ok sevildik!&nbsp;<br style="box-sizing: inherit;" />\n	<br style="box-sizing: inherit;" />\n	Bug&uuml;n T&uuml;rkiye&rsquo;de online alışverişin lideri olarak;<span style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px; color: rgb(242, 139, 0);">&nbsp;30 kategoride 12,7 milyonun &uuml;zerinde &uuml;r&uuml;n&uuml;m&uuml;zle</span>&nbsp;e-ticareti T&uuml;rk insanına sevdirmekle kalmadık, vazge&ccedil;ilmeze d&ouml;n&uuml;şt&uuml;rd&uuml;k.<br style="box-sizing: inherit;" />\n	<br style="box-sizing: inherit;" />\n	Yıllar i&ccedil;inde pek &ccedil;ok &ouml;d&uuml;le layık g&ouml;r&uuml;ld&uuml;k.&nbsp;<span style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px; color: rgb(242, 139, 0);">2011, 2012 ve 2013 yıllarında</span>&nbsp;T&uuml;rkiye&rsquo;nin en sevilen markası,&nbsp;<span style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: bold; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px; color: rgb(242, 139, 0);">2013 yılında</span>&nbsp;ise Yılın E-ticaret Sitesi se&ccedil;ildik.&nbsp;<br style="box-sizing: inherit;" />\n	<br style="box-sizing: inherit;" />\n	Bug&uuml;n T&uuml;rkiye&rsquo;de online alışverişin lideri olarak; &uuml;yelerimize nerede olurlarsa olsunlar, en iyi &uuml;r&uuml;n&uuml; en uygun fiyatla ulaştırmak i&ccedil;in &ccedil;alışıyoruz. B&uuml;y&uuml;meye ve e-ticareti b&uuml;y&uuml;tmeye devam ediyoruz.<br style="box-sizing: inherit;" />\n	<br style="box-sizing: inherit;" />\n	<span style="box-sizing: inherit; margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-weight: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline; outline: 0px;">Her zaman bizi tercih ettiğiniz i&ccedil;in teşekk&uuml;r ederiz, iyi alışverişler dileriz.</span></div>\n', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `brandimages`
--

CREATE TABLE IF NOT EXISTS `brandimages` (
  `Id` int(11) NOT NULL,
  `ImageName` varchar(255) NOT NULL,
  `ImagePath` varchar(255) NOT NULL,
  `Link` varchar(255) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `brandimages`
--

INSERT INTO `brandimages` (`Id`, `ImageName`, `ImagePath`, `Link`, `Status`) VALUES
(1, 'Adidas', 'assets\\images\\ayakkabimarkalari\\adidas.png', '', 1),
(2, 'Hummel', 'assets\\images\\ayakkabimarkalari\\hummel.png', '', 1),
(3, 'Kinetix', 'assets\\images\\ayakkabimarkalari\\kinetix.png', '', 1),
(4, 'Lescon', 'assets\\images\\ayakkabimarkalari\\lescon.png', '', 1),
(5, 'New Balance', 'assets\\images\\ayakkabimarkalari\\newbalance.png', '', 1),
(6, 'Nike', 'assets\\images\\ayakkabimarkalari\\nike.png', '', 1),
(7, 'Pierre Cardin', 'assets\\images\\ayakkabimarkalari\\pierrecardin.png', '', 1),
(10, 'Puma', 'assets/images/ayakkabimarkalari/4901_Pumapuma.png', '2', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `categorybanner`
--

CREATE TABLE IF NOT EXISTS `categorybanner` (
  `Id` int(11) NOT NULL,
  `ImageName` varchar(255) NOT NULL,
  `ImagePath` varchar(255) NOT NULL,
  `MainCategoryId` int(11) NOT NULL,
  `Link` varchar(255) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `categorybanner`
--

INSERT INTO `categorybanner` (`Id`, `ImageName`, `ImagePath`, `MainCategoryId`, `Link`, `Status`) VALUES
(1, 'Kadın Ayakkabıları\r\n', 'assets\\images\\ayakkabıbanner\\bayanayakkabibanner.jpg', 1, '', 1),
(2, 'Erkek Ayakkabıları', 'assets\\images\\ayakkabıbanner\\erkekayakkabıbanner.jpg', 2, '', 1),
(3, 'Çocuk Ayakkabıları', 'assets\\images\\ayakkabıbanner\\cocukayakkabibanner.jpeg', 3, '', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `Id` int(11) NOT NULL,
  `CommentatorMemberShipId` int(11) NOT NULL,
  `Review` text NOT NULL,
  `Points` float NOT NULL,
  `CommentDate` date NOT NULL,
  `ProductStockCode` varchar(255) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `comments`
--

INSERT INTO `comments` (`Id`, `CommentatorMemberShipId`, `Review`, `Points`, `CommentDate`, `ProductStockCode`, `Status`) VALUES
(1, 8, 'Güzel,şık ve rahat bir ayakkabı.', 4, '2017-10-18', '30000000001', 1),
(2, 9, 'Ürün fena durmuyor, su geçirir mi henüz söyleyemiyorum ancak ortapedik kısmının nasıl bir şey olduğunu anlayamadım. Benim bildiğim aya kısmında bir kabartı olur ancak ben öyle bir şey göremedim. Umarım ben yanılıyorumdur.', 3.5, '2017-10-31', '30000000001', 1),
(3, 8, 'Ürün çok güzel esime de aldim.Cok begendi hemen bana tesekkür etti.Bende ona tesekkür etti neyse size bunlari niye anlattim onu da bilmiyorum.Sonuc olarak guzel urun...', 4, '2018-01-18', '1020017587402', 1),
(4, 8, 'cok guzel!!!!', 5, '2018-01-18', '1020017351715', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `Id` int(11) NOT NULL,
  `Adress` varchar(255) NOT NULL,
  `Telephone` varchar(55) NOT NULL,
  `EMail` varchar(55) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `contact`
--

INSERT INTO `contact` (`Id`, `Adress`, `Telephone`, `EMail`, `Status`) VALUES
(1, 'Fevzi Çakmak Mah. Aykent Ayakkabıcılar Sitesi 10704 Sok. No:1 Karatay', '444 0 042', 'webbilgi@shoearstore.com.tr', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `maincategory`
--

CREATE TABLE IF NOT EXISTS `maincategory` (
  `Id` int(11) NOT NULL,
  `CategoryName` varchar(55) NOT NULL,
  `Status` tinyint(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `maincategory`
--

INSERT INTO `maincategory` (`Id`, `CategoryName`, `Status`) VALUES
(1, 'Kadın', 1),
(2, 'Erkek', 1),
(3, 'Çocuk', 1),
(6, 'Erkek Çocuk', 0),
(7, 'Deneme', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `managers`
--

CREATE TABLE IF NOT EXISTS `managers` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(55) NOT NULL,
  `LastName` varchar(55) NOT NULL,
  `EMail` varchar(55) NOT NULL,
  `Password` varchar(55) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `managers`
--

INSERT INTO `managers` (`Id`, `FirstName`, `LastName`, `EMail`, `Password`, `Status`) VALUES
(1, 'Zekeriya', 'Topaloğlu', 'zekomtr_42@hotmail.com', 'zekeriya0742', 6);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `membership`
--

CREATE TABLE IF NOT EXISTS `membership` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(55) NOT NULL,
  `LastName` varchar(55) NOT NULL,
  `EMail` varchar(55) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `membership`
--

INSERT INTO `membership` (`Id`, `FirstName`, `LastName`, `EMail`, `Password`, `Status`) VALUES
(8, 'Zekeriya', 'Topaloğlu', 'zekomtr_42@hotmail.com', 'zekeriya0742', 1),
(10, 'Deneme', 'denemwe', 'deneme@gmail.com', 'deneme', 1),
(11, 'Mustafa', 'Yanık', 'mustafayanik@gmail.com', 'mustafa42', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ordercompleted`
--

CREATE TABLE IF NOT EXISTS `ordercompleted` (
  `Id` int(11) NOT NULL,
  `OrderComplatedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MemberShipId` int(11) NOT NULL,
  `OrdersId` int(11) NOT NULL,
  `OrderNo` varchar(55) COLLATE utf8_turkish_ci NOT NULL,
  `Price` float NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ordercompleted`
--

INSERT INTO `ordercompleted` (`Id`, `OrderComplatedDate`, `MemberShipId`, `OrdersId`, `OrderNo`, `Price`, `Status`) VALUES
(3, '2017-12-23 21:58:17', 8, 7, '1234', 239.9, 3),
(4, '2017-12-23 21:58:17', 8, 12, '1234', 99.99, 3),
(5, '2017-12-23 21:58:17', 8, 13, '1234', 184.49, 3),
(6, '2017-12-23 21:58:17', 8, 14, '1234', 59, 3),
(7, '2017-12-24 18:15:33', 8, 16, '2485', 99.99, 2),
(8, '2017-12-24 18:15:33', 8, 17, '2485', 75, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `orderdetail`
--

CREATE TABLE IF NOT EXISTS `orderdetail` (
  `OrdersId` int(11) NOT NULL,
  `ProductStockCode` text NOT NULL,
  `ProductName` text NOT NULL,
  `ProductImagePath` text NOT NULL,
  `CurrnetPrice` float NOT NULL,
  `Color` varchar(255) NOT NULL,
  `Number` varchar(55) NOT NULL,
  `Piece` int(11) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `orderdetail`
--

INSERT INTO `orderdetail` (`OrdersId`, `ProductStockCode`, `ProductName`, `ProductImagePath`, `CurrnetPrice`, `Color`, `Number`, `Piece`, `Status`) VALUES
(7, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/5278_100292851_1.jpg', 239.9, '#ff0000', '42', 1, 1),
(12, '2022031183624', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/12_100198687_1_2.jpg', 99.99, '#8b4513', '42,5', 1, 1),
(13, '3025050443481', 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', 'assets/images/urunler/1538_9735768080434.jpg', 184.49, '#919191', '31,5', 1, 1),
(14, '1020020532837', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/1435_9610045554738.jpg', 59, '#f70000', '35', 1, 1),
(15, '1020020634979', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/8552_9610045685810.jpg', 59, '#030303', '34,5', 1, 1),
(16, '202403863598', 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', 'assets/images/urunler/2465_100232584_1.jpg', 99.99, '#ffffff', '45', 1, 1),
(17, '2022029511475', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/2525_9727124799538.jpg', 75, '#8b4513', '41', 1, 1),
(18, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/1835_9722792542258.jpg', 169.99, '#000000', '34', 1, 1),
(19, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/108_100263749_1.jpg', 239.99, '#000000', '43', 1, 1),
(20, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/8937_100231312_1.jpg', 59.99, '#000000', '26', 1, 1),
(21, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/5278_100292851_1.jpg', 239.9, '#ff0000', '42', 1, -1),
(22, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/5278_100292851_1.jpg', 239.9, '#ff0000', '42', 1, -1),
(25, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/1215_Divaresse_17987221.jpg', 69.9, '#f5f5dc', '38', 1, -1),
(26, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/6536_9487690858546.jpg', 99, '#000000', '38', 2, 1),
(27, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/108_100263749_1.jpg', 239.99, '#000000', '43', 1, 1),
(28, '2022029977662', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/8794_9727124799538.jpg', 75, '#27408b', '40', 2, 1),
(29, '2022029326141', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/3168_9727124340786.jpg', 75, '#000000', '42', 1, -1),
(30, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/1215_Divaresse_17987221.jpg', 69.9, '#f5f5dc', '37', 1, -1),
(31, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/6536_9487690858546.jpg', 99, '#000000', '37', 1, -1),
(32, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/1215_Divaresse_17987221.jpg', 69.9, '#f5f5dc', '39', 1, -1),
(33, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/8937_100231312_1.jpg', 59.99, '#000000', '30', 1, 1),
(34, '3025051635071', 'U.S. Polo Assn. A3353251 Kırmızı Unisex Çocuk Terlik', 'assets/images/urunler/6933_9626026082354.jpg', 9.99, '#ff0000', '28', 1, -1),
(35, '2024036744660', 'Nike TIEMPOX RIO IV TF Siyah Erkek Halı Saha Ayakkabısı', 'assets/images/urunler/9040_100293963_1.jpg', 209, '#000000', '44,5', 1, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `OrdersId` int(11) NOT NULL,
  `OrderDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MemberShipId` int(11) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `orders`
--

INSERT INTO `orders` (`OrdersId`, `OrderDate`, `MemberShipId`, `Status`) VALUES
(7, '2017-12-23 16:18:59', 8, 3),
(12, '2017-12-23 16:31:17', 8, 3),
(13, '2017-12-23 16:35:31', 8, 3),
(14, '2017-12-23 20:50:12', 8, 3),
(15, '2017-12-23 21:15:12', 10, 3),
(16, '2017-12-23 22:12:43', 8, 2),
(17, '2017-12-23 22:57:14', 8, 2),
(18, '2017-12-24 20:42:28', 8, 1),
(19, '2017-12-24 20:42:43', 8, 1),
(20, '2017-12-24 20:42:56', 8, 1),
(21, '2017-12-31 21:29:18', 8, -1),
(22, '2017-12-31 21:30:21', 11, -1),
(25, '2018-01-01 12:56:09', 11, -1),
(26, '2018-01-01 12:59:06', 11, 1),
(27, '2018-01-01 13:02:48', 8, 1),
(28, '2018-01-01 13:25:25', 11, 1),
(29, '2018-01-01 19:46:48', 11, -1),
(30, '2018-01-01 19:50:17', 11, -1),
(31, '2018-01-08 12:27:38', 10, -1),
(32, '2018-01-19 10:30:11', 10, -1),
(33, '2018-01-19 14:58:59', 10, 1),
(34, '2018-05-09 20:09:50', 8, -1),
(35, '2018-05-09 20:11:21', 8, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `paymentmethods`
--

CREATE TABLE IF NOT EXISTS `paymentmethods` (
  `Id` int(11) NOT NULL,
  `PaymentName` varchar(55) NOT NULL,
  `PaymentImagePath` varchar(255) NOT NULL,
  `PaymentLink` varchar(255) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `paymentmethods`
--

INSERT INTO `paymentmethods` (`Id`, `PaymentName`, `PaymentImagePath`, `PaymentLink`, `Status`) VALUES
(3, 'Card Finans', 'assets\\images\\bankalar\\cardFinans.png', '', 1),
(4, 'Halk Bank', 'assets\\images\\bankalar\\halkbank.png', '', 1),
(5, 'Kuveyt Türk', 'assets\\images\\bankalar\\kuveyttürk.png', '', 1),
(6, 'Master Card', 'assets\\images\\bankalar\\masterCard.png', '', 1),
(7, 'Maximum', 'assets\\images\\bankalar\\maximum.png', '', 1),
(8, 'Paraf', 'assets\\images\\bankalar\\paraf.png', '', 1),
(9, 'Visa', 'assets\\images\\bankalar\\visa.png', '', 1),
(10, 'World', 'assets\\images\\bankalar\\world.png', '', 1),
(11, 'Axess', 'assets/images/bankalar/9480_Axessaxess.png', '', 1),
(12, 'Advantage', 'assets/images/bankalar/4955_Advantageadvantage.png', '', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `Id` int(11) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `StockCode` text NOT NULL,
  `RegistrationDate` date NOT NULL,
  `Explanation` text NOT NULL,
  `Color` varchar(255) NOT NULL,
  `ProductOptions` text NOT NULL,
  `FirstPrice` float NOT NULL,
  `LastPrice` float NOT NULL,
  `MainCategoryId` int(11) NOT NULL,
  `SubCategoryId` int(11) NOT NULL,
  `SubSubCategoryId` int(11) NOT NULL,
  `DataMatrix` text NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`Id`, `ProductName`, `StockCode`, `RegistrationDate`, `Explanation`, `Color`, `ProductOptions`, `FirstPrice`, `LastPrice`, `MainCategoryId`, `SubCategoryId`, `SubSubCategoryId`, `DataMatrix`, `Status`) VALUES
(1, 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', '1020017351715', '0000-00-00', '<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Renk:Bej</div>\r\n<div>\r\n	Kalıp:Tam Numara</div>\r\n<div>\r\n	Materyal:Sentetik S&uuml;et</div>\r\n<div>\r\n	Topuk Boyu:10 cm</div>\r\n<div>\r\n	Taban:Jurdan - Pad &#39;&#39;li İ&ccedil; Taban</div>\r\n<div>\r\n	&Uuml;retim:Stok T&uuml;kense Dahi Tarafınıza &Ouml;zel &Uuml;retilerek 5-7 İşg&uuml;n&uuml; İ&ccedil;erisinde G&ouml;nderilir.&nbsp;</div>\r\n', '#f5f5dc', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=4/36_5Numara=0/37Numara=3/37_5Numara=0/38Numara=2/38_5Numara=0/39Numara=2/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 94.9, 69.9, 1, 20, 17, 'assets/images/urunler/karekod/1020017351715.png', 1),
(2, 'Elle Mayer Kadın Ayakkabı', '1020017587402', '0000-00-00', '2016-17 Sonbahar - Kış\r\n			', '#000000', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=1/36_5Numara=0/37Numara=1/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 449, 99, 1, 20, 17, 'assets/images/urunler/karekod/1020017587402.png', 1),
(3, 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', '2022029326141', '0000-00-00', '<div>\r\n	Ayakkabı numaraları tam kalıptır. Deparshoes marka polar eldiven (280gr).</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Taban malzeme kau&ccedil;uk kaymaz.</div>\r\n<div>\r\n	Garson boylar (36-40) unisex.</div>\r\n<div>\r\n	Dış meteryal greyzi-nubuk&nbsp;</div>\r\n<div>\r\n	Astar Malzemesi Termal Sezon Sonbahar - Kış Taban &Ccedil;eşidi Kau&ccedil;uk&nbsp;</div>\r\n<div>\r\n	Garanti S&uuml;resi (Ay) 3</div>\r\n<div>\r\n	Yurtdışına Satış Yok&nbsp;</div>\r\n', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=4/41_5Numara=0/42Numara=3/42_5Numara=0/43Numara=2/43_5Numara=0/44Numara=0/44_5Numara=5/45Numara=1/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 129, 75, 2, 22, 29, 'assets/images/urunler/karekod/2022029326141.png', 1),
(4, 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', '2022029511475', '0000-00-00', '<div>\r\n	Ayakkabı numaraları tam kalıptır. Deparshoes marka polar eldiven (280gr).</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Taban malzeme kau&ccedil;uk kaymaz.</div>\r\n<div>\r\n	Garson boylar (36-40) unisex.</div>\r\n<div>\r\n	Dış meteryal greyzi-nubuk&nbsp;</div>\r\n<div>\r\n	Astar Malzemesi Termal Sezon Sonbahar - Kış Taban &Ccedil;eşidi Kau&ccedil;uk&nbsp;</div>\r\n<div>\r\n	Garanti S&uuml;resi (Ay) 3</div>\r\n<div>\r\n	Yurtdışına Satış Yok&nbsp;</div>\r\n', '#8b4513', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=4/41_5Numara=0/42Numara=3/42_5Numara=1/43Numara=0/43_5Numara=1/44Numara=1/44_5Numara=5/45Numara=1/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 129, 75, 2, 22, 29, 'assets/images/urunler/karekod/2022029511475.png', 1),
(5, 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', '2022029977662', '0000-00-00', '<div>\r\n	Ayakkabı numaraları tam kalıptır. Deparshoes marka polar eldiven (280gr).</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Taban malzeme kau&ccedil;uk kaymaz.</div>\r\n<div>\r\n	Garson boylar (36-40) unisex.</div>\r\n<div>\r\n	Dış meteryal greyzi-nubuk&nbsp;</div>\r\n<div>\r\n	Astar Malzemesi Termal Sezon Sonbahar - Kış Taban &Ccedil;eşidi Kau&ccedil;uk&nbsp;</div>\r\n<div>\r\n	Garanti S&uuml;resi (Ay) 3</div>\r\n<div>\r\n	Yurtdışına Satış Yok&nbsp;</div>\r\n', '#27408b', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=4/40_5Numara=0/41Numara=4/41_5Numara=0/42Numara=3/42_5Numara=1/43Numara=2/43_5Numara=0/44Numara=1/44_5Numara=5/45Numara=1/45_5Numara=4/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 129, 75, 2, 22, 29, 'assets/images/urunler/karekod/2022029977662.png', 1),
(6, 'Garamond 1117-2 Siyah Erkek Deri City', '2022030363678', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Garamond</div>\r\n<div>\r\n	Model: 1117-2</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100288768<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Garamond 1117-2, Garamond 2513, Garamond Erkek 2513</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=1/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=5/45_5Numara=0/46Numara=4/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 149.99, 0, 2, 22, 30, 'assets/images/urunler/karekod/2022030363678.png', 1),
(7, 'Garamond 5610 Lacivert Erkek Deri City', '202203048736', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Lacivert</div>\r\n<div>\r\n	Marka: Garamond</div>\r\n<div>\r\n	Model: 5610</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100315107<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Garamond 5610, Garamond 2513, Garamond Erkek 2513</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=7/45_5Numara=0/46Numara=2/46_5Numara=1/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 129.99, 0, 2, 22, 30, 'assets/images/urunler/karekod/202203048736.png', 1),
(8, 'Dockers by Gerli A3365050 Lacivert Erkek Outdoor', '2022031464783', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Lacivert</div>\r\n<div>\r\n	Marka: Dockers by Gerli</div>\r\n<div>\r\n	Model: A3365050</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100226730<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Ekstra &Ouml;zellik: Waterproff</div>\r\n<div>\r\n	Etiketler: Dockers by Gerli A3365050, Dockers by Gerli 2305, Dockers by Gerli Erkek 2305</div>\r\n', '#000080', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=5/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=1/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 189.99, 0, 2, 22, 31, 'assets/images/urunler/karekod/2022031464783.png', 1),
(9, 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', '2022031183624', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Kahverengi</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: 1272192</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100198687<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix 1272192, Kinetix 2558, Kinetix Erkek 2558</div>', '#8b4513', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=2/43Numara=3/43_5Numara=4/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 22, 31, 'assets/images/urunler/karekod/2022031183624.png', 1),
(10, 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', '2022031942933', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Gri</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: 1272192</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100198684<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix 1272192, Kinetix 2558, Kinetix Erkek 2558</div>', '#808080', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=4/41_5Numara=0/42Numara=1/42_5Numara=2/43Numara=3/43_5Numara=4/44Numara=0/44_5Numara=2/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 22, 31, 'assets/images/urunler/karekod/2022031942933.png', 1),
(11, 'Lumberjack ULPIA Siyah Erkek Deri City', '2022032635834', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Lumberjack</div>\r\n<div>\r\n	Model: ULPIA</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100263749<span style="white-space:pre"> </span></div>\r\n<div>\r\n	&Uuml;retim: %100 Orijinal</div>\r\n<div>\r\n	Etiketler: Lumberjack ULPIA, Lumberjack 2513, Lumberjack Erkek 2513</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=5/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 239.99, 0, 2, 22, 32, 'assets/images/urunler/karekod/2022032635834.png', 1),
(12, 'Lumberjack ULPIA Siyah Erkek Deri City', '2022032652710', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Lumberjack</div>\r\n<div>\r\n	Model: ULPIA</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100263749<span style="white-space:pre"> </span></div>\r\n<div>\r\n	&Uuml;retim: %100 Orijinal</div>\r\n<div>\r\n	Etiketler: Lumberjack ULPIA, Lumberjack 2513, Lumberjack Erkek 2513</div>', '#8b4513', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=2/42_5Numara=0/43Numara=5/43_5Numara=0/44Numara=0/44_5Numara=3/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 239.99, 0, 2, 22, 32, 'assets/images/urunler/karekod/2022032652710.png', 1),
(13, 'Oxide 137 Taba Erkek Deri City', '2022032353088', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Taba</div>\r\n<div>\r\n	Marka: Oxide</div>\r\n<div>\r\n	Model: 137</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Deri</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100289254<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Oxide 137, Oxide 2513, Oxide Erkek 2513</div>', '#8b4513', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=1/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=4/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=2/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 139.99, 0, 2, 22, 32, 'assets/images/urunler/karekod/2022032353088.png', 1),
(14, 'Hummel HUMMEL COMET SS16 Siyah Beyaz Erkek Sneaker', '2024033842743', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Hummel</div>\r\n<div>\r\n	Model: HUMMEL COMET SS16</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100212342<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Hummel HUMMEL COMET SS16, Hummel 2299, Hummel Erkek 2299</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=4/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=2/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=1/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 159.95, 0, 2, 24, 33, 'assets/images/urunler/karekod/2024033842743.png', 1),
(15, 'Kinetix ALVEN MESH Siyah Erkek Sneaker', '202403324169', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: ALVEN MESH</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: İlkbahar</div>\r\n<div>\r\n	SKU: 100238308<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix ALVEN MESH, Kinetix 2299, Kinetix Erkek 2299</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=2/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=4/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 139.99, 0, 2, 24, 33, 'assets/images/urunler/karekod/202403324169.png', 1),
(16, 'Nike NIKE ZOOM WINFLO 3 SHIELD Sarı Yeşil Erkek Koşu Ayakkabısı', '2024034406097', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Sarı</div>\r\n<div>\r\n	Marka: Nike</div>\r\n<div>\r\n	Model: NIKE ZOOM WINFLO 3 SHIELD</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Kış</div>\r\n<div>\r\n	SKU: 100258850<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Taban Şekli: D&uuml;z</div>\r\n<div>\r\n	&Uuml;retim:<span style="white-space:pre"> </span>%100 Orijinal</div>\r\n<div>\r\n	Etiketler: Nike NIKE ZOOM WINFLO 3 SHIELD, Nike 2301, Nike Erkek 2301</div>', '#38cc04', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=2/41_5Numara=0/42Numara=0/42_5Numara=4/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 209.3, 0, 2, 24, 34, 'assets/images/urunler/karekod/2024034406097.png', 1),
(17, 'Kinetix DRAKE Lacivert Saks Beyaz Erkek Koşu Ayakkabısı', '2024034823212', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Lacivert</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: DRAKE</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi: Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100264939<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix DRAKE, Kinetix 2301, Kinetix Erkek 2301</div>\r\n', '#0066ff', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=3/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=4/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 129.99, 0, 2, 24, 34, 'assets/images/urunler/karekod/2024034823212.png', 1),
(18, 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', '2024035832764', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Petrol</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: VITORA</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100266706<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix VITORA, Kinetix 2300, Kinetix Erkek 2300</div>\r\n', '#36648b', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=3/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 24, 35, 'assets/images/urunler/karekod/2024035832764.png', 1),
(19, 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', '2024035162811', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: VITORA</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100266706<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix VITORA, Kinetix 2300, Kinetix Erkek 2300</div>\r\n', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=3/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 24, 35, 'assets/images/urunler/karekod/2024035162811.png', 1),
(20, 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', '202403548339', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Koyu Gri</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: VITORA</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100266706<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix VITORA, Kinetix 2300, Kinetix Erkek 2300</div>\r\n', '#636363', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=1/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=3/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 24, 35, 'assets/images/urunler/karekod/202403548339.png', 1),
(21, 'Nike MERCURIAL VORTEX III FG Kırmızı Beyaz Erkek Krampon', '2024036614716', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Kırmızı</div>\r\n<div>\r\n	Marka: Nike</div>\r\n<div>\r\n	Model: MERCURIAL VORTEX III FG</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100292854<span style="white-space:pre"> </span></div>\r\n<div>\r\n	&Uuml;retim:<span style="white-space:pre"> </span>%100 Orijinal</div>\r\n<div>\r\n	Etiketler: Nike MERCURIAL VORTEX III FG, Nike 2361, Nike Erkek 2361</div>', '#ff0000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=1/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=2/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 219.9, 0, 2, 24, 36, 'assets/images/urunler/karekod/2024036614716.png', 1),
(22, 'Nike TIEMPOX RIO IV TF Siyah Erkek Halı Saha Ayakkabısı', '2024036744660', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli: Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Nike</div>\r\n<div>\r\n	Model: TIEMPOX RIO IV TF</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100293963<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Taban Şekli: Halı Saha</div>\r\n<div>\r\n	&Uuml;retim:<span style="white-space:pre"> </span>%100 Orijinal</div>\r\n<div>\r\n	Etiketler: Nike TIEMPOX RIO IV TF, Nike 2303, Nike Erkek 2303</div>', '#000000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=1/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=3/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=4/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 209, 0, 2, 24, 36, 'assets/images/urunler/karekod/2024036744660.png', 1),
(23, 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', '202403863598', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Bağlama Şekli:<span style="white-space:pre"> </span>Bağcıklı</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Beyaz</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: KARON</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri / Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100232584<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix KARON, Kinetix 2306, Kinetix Erkek 2306</div>', '#ffffff', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=1/42_5Numara=3/43Numara=0/43_5Numara=0/44Numara=0/44_5Numara=0/45Numara=4/45_5Numara=0/46Numara=0/46_5Numara=0/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 99.99, 0, 2, 24, 38, 'assets/images/urunler/karekod/202403863598.png', 1),
(24, 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', '2024037308868', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek</div>\r\n<div>\r\n	Renk: Kırmızı</div>\r\n<div>\r\n	Marka: Nike</div>\r\n<div>\r\n	Model: NIKE AIR PRECISION</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Tekstil</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100292851<span style="white-space:pre"> </span></div>\r\n<div>\r\n	&Uuml;retim:<span style="white-space:pre"> </span>%100 Orijinal</div>\r\n<div>\r\n	Etiketler: Nike NIKE AIR PRECISION, Nike 2302, Nike Erkek 2302</div>', '#ff0000', '38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=1/42_5Numara=0/43Numara=0/43_5Numara=0/44Numara=3/44_5Numara=0/45Numara=0/45_5Numara=0/46Numara=0/46_5Numara=4/47Numara=0/47_5Numara=0/48Numara=0/48_5Numara=0/49Numara=0/49_5Numara=0', 239.9, 0, 2, 24, 37, 'assets/images/urunler/karekod/2024037308868.png', 1),
(25, 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', '3025046477936', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek &Ccedil;ocuk</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: I Cool</div>\r\n<div>\r\n	Model: 702-R2 GE</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100231312<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: I Cool 702-R2 GE, I Cool 2305, I Cool Erkek &Ccedil;ocuk 2305</div>', '#000000', '26Numara=1/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=0/29_5Numara=0/30Numara=3/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 79.99, 59.99, 3, 25, 46, 'assets/images/urunler/karekod/3025046477936.png', 1),
(26, 'Kinetix 1255196 Siyah Mavi Neon Yeşil Erkek Çocuk Outdoor', '3025046561005', '0000-00-00', '<div>\r\n	&Uuml;r&uuml;n Hakkında</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Cinsiyet: Erkek &Ccedil;ocuk</div>\r\n<div>\r\n	Renk: Siyah</div>\r\n<div>\r\n	Marka: Kinetix</div>\r\n<div>\r\n	Model: 1255196</div>\r\n<div>\r\n	&Uuml;r&uuml;n Malzemesi:<span style="white-space:pre"> </span>Suni Deri</div>\r\n<div>\r\n	Sezon Mevsim: Sonbahar</div>\r\n<div>\r\n	SKU: 100198666<span style="white-space:pre"> </span></div>\r\n<div>\r\n	Etiketler: Kinetix 1255196, Kinetix 2305, Kinetix Erkek &Ccedil;ocuk 2305</div>', '#000000', '26Numara=1/26_5Numara=0/27Numara=1/27_5Numara=1/28Numara=2/29_5Numara=0/30Numara=0/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 79.99, 0, 3, 25, 46, 'assets/images/urunler/karekod/3025046561005.png', 1),
(27, 'İ Cool Gizy Lacivert Mavi Erkek Çocuk Ayakkabı', '302504782824', '0000-00-00', '<div>\r\n	İ Cool Gizy Lacivert Mavi Erkek &Ccedil;ocuk Ayakkabı</div>', '#0030d9', '26Numara=0/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=1/29_5Numara=0/30Numara=0/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 29.99, 14.99, 3, 25, 47, 'assets/images/urunler/karekod/302504782824.png', 1),
(28, 'Nike Ayakkabı Revolution 3 (Gs) 819413-400', '3025047856659', '0000-00-00', '<div>\r\n	Nike Ayakkabı Revolution 3 (Gs) 819413-400</div>', '#0029ff', '26Numara=0/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=1/29_5Numara=0/30Numara=3/30_5Numara=4/31Numara=5/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 259.9, 179.9, 3, 25, 47, 'assets/images/urunler/karekod/3025047856659.png', 1),
(29, 'Gezer 2386 Ev Ve Kreş Erkek Çocuk Panduf', '302504846783', '0000-00-00', '<div>\r\n	&Uuml;retim: T&uuml;rkiye</div>\r\n<div>\r\n	Mevsim: Kışlık</div>\r\n<div>\r\n	Dış Materyal: Tesktil</div>\r\n<div>\r\n	İ&ccedil; Materyal: Tekstil</div>\r\n<div>\r\n	Taban Materyali: Poli&uuml;retan</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 2 Cm</div>\r\n<div>\r\n	Taban Y&uuml;ksekligi: 1 Cm</div>\r\n<div>\r\n	Agırlık: 113 Gr</div>\r\n<div>\r\n	Kalıp: Standart Ayak &Ouml;l&ccedil;&uuml;lerine G&ouml;re Tam Kalıp</div>\r\n', '#000000', '26Numara=1/26_5Numara=0/27Numara=1/27_5Numara=0/28Numara=1/29_5Numara=0/30Numara=1/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 24.9, 0, 3, 25, 48, 'assets/images/urunler/karekod/302504846783.png', 1),
(30, 'Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)', '3025048838135', '0000-00-00', '<div>\r\n	Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)</div>', '#e60000', '26Numara=1/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=3/29_5Numara=0/30Numara=5/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 29.99, 0, 3, 25, 48, 'assets/images/urunler/karekod/3025048838135.png', 1),
(31, 'DeFacto Erkek Çocuk Sandalet', '3025049345642', '0000-00-00', '<div>\r\n	Rahat kalıbı ve sıcak havalarda kullanışlı yapısıyla &ccedil;ocuğunuzun g&uuml;n boyu giyebileceği DeFacto erkek &ccedil;ocuk sandalet.</div>', '#f20000', '26Numara=1/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=1/29_5Numara=0/30Numara=1/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 29.99, 19.99, 3, 25, 49, 'assets/images/urunler/karekod/3025049345642.png', 1),
(32, 'Aydındaş 903 Günlük Filet Yürüyüş Erkek Çocuk Spor Sandalet Ayakkabı', '3025049232452', '0000-00-00', '<div>\r\n	Marka: Aydındaş</div>\r\n<div>\r\n	Mevsim: İlkbahar-Yaz</div>\r\n<div>\r\n	Dış Materyal: Mikrofiber&nbsp;</div>\r\n<div>\r\n	İ&ccedil; Materyal: Mikrofiber</div>\r\n<div>\r\n	Taban Materyali: Poli&uuml;retan</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 2,5 Cm</div>\r\n<div>\r\n	Taban Y&uuml;ksekligi: 2 Cm</div>\r\n<div>\r\n	Agırlık: 132 Gr</div>\r\n<div>\r\n	Kalıp: Standart Ayak &Ouml;l&ccedil;&uuml;lerine G&ouml;re Tam Kalıp</div>\r\n', '#000000', '26Numara=0/26_5Numara=0/27Numara=1/27_5Numara=0/28Numara=2/29_5Numara=0/30Numara=0/30_5Numara=0/31Numara=4/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 59.9, 0, 3, 25, 49, 'assets/images/urunler/karekod/3025049232452.png', 1),
(33, 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', '3025050443481', '0000-00-00', 'Lumberjack Flake G Gri Erkek &Ccedil;ocuk Ayakkabı', '#919191', '26Numara=0/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=0/29_5Numara=0/30Numara=0/30_5Numara=2/31Numara=0/31_5Numara=2/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 204.99, 184.49, 3, 25, 50, 'assets/images/urunler/karekod/3025050443481.png', 1),
(34, 'U.S. Polo Assn. Alone Lacivert Erkek Çocuk Çocuk Ayakkabı', '3025050921448', '0000-00-00', '<div>\r\n	U.S. Polo Assn. Alone Lacivert Erkek &Ccedil;ocuk &Ccedil;ocuk Ayakkabı</div>', '#000000', '26Numara=3/26_5Numara=0/27Numara=1/27_5Numara=0/28Numara=2/29_5Numara=0/30Numara=0/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 99.99, 89.99, 3, 25, 50, 'assets/images/urunler/karekod/3025050921448.png', 1),
(35, 'Crocs Crocband Kıds Çocuk Terlik 12837-42K', '3025051512665', '0000-00-00', '<div>\r\n	Crocs Crocband Kıds &Ccedil;ocuk Terlik 12837-42K</div>\r\n<div>\r\n	CROCS TERLİK</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* ERGONOMİK TASARIMI , OKSİJEN DOSTU YAPISI , SUYUN VE KİRLERİN AKMASINI SAĞLAR , AYAK UCU * HAVALANDIRMASIYLA KONFOR SUNAR.&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* SU DOSTUDUR , BATMAZ , HAFİFTİR.&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* Croslite&trade; MALZEMESİNDEN YAPILMIŞ TABAN HAFİF OLUŞUYLA RAHATLIK SAĞLAR .&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* AYAKKABININ AYAĞA SAĞLAM BİR ŞEKİLDE OTURMASI İ&Ccedil;İN Croslite&trade; MALZEMESİNDEN YAPILMIŞ TOPUK BANTI VARDIR.&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* TEMİZLENMESİ KOLAYDIR , HIZLI KURUR.&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* HAFİF VE İZ BIRAKMAYAN TABANLAR.&nbsp;</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	* STANDART - G&Uuml;VENLİ VE RAHAT GİYİM SUNAR.</div>\r\n', '#00074a', '26Numara=2/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=0/29_5Numara=0/30Numara=0/30_5Numara=1/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 179.99, 119.9, 3, 25, 51, 'assets/images/urunler/karekod/3025051512665.png', 1),
(36, 'U.S. Polo Assn. A3353251 Kırmızı Unisex Çocuk Terlik', '3025051635071', '0000-00-00', '<div>\r\n	U.S. Polo Assn. A3353251 Kırmızı Unisex &Ccedil;ocuk Terlik</div>', '#ff0000', '26Numara=2/26_5Numara=0/27Numara=0/27_5Numara=0/28Numara=3/29_5Numara=0/30Numara=0/30_5Numara=0/31Numara=0/31_5Numara=0/32Numara=0/32_5Numara=0/33Numara=0/33_5Numara=0/34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0', 19.99, 9.99, 3, 25, 51, 'assets/images/urunler/karekod/3025051635071.png', 1),
(37, 'Gön Deri Kadın Bot 59469', '1019022171356', '0000-00-00', '<div>\r\n	&nbsp;</div>\r\n<div>\r\n	1.Sınıf Hakiki Deri 11 Pont (7.3 Cm) G&ouml;n Deri Kadın Bot</div>\r\n', '#000000', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=5/36_5Numara=0/37Numara=8/37_5Numara=0/38Numara=20/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=40/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 499, 179.99, 1, 19, 22, 'assets/images/urunler/karekod/1019022171356.png', 1),
(38, 'Gön Deri Kadın Bot 59469', '1019022353149', '0000-00-00', '<div>\r\n	&nbsp;</div>\r\n<div>\r\n	1.Sınıf Hakiki Deri 11 Pont (7.3 Cm) G&ouml;n Deri Kadın Bot</div>\r\n', '#b59f2b', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=5/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=2/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=5/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 499, 170.99, 1, 19, 22, 'assets/images/urunler/karekod/1019022353149.png', 1),
(39, 'Derigo Kadın Postal Bot Siyah 22184', '1019023447113', '0000-00-00', '<div>\r\n	Termo Taban , Suni Deri</div>', '#000000', '34Numara=1/34_5Numara=0/35Numara=3/35_5Numara=0/36Numara=0/36_5Numara=2/37Numara=0/37_5Numara=0/38Numara=1/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 189.9, 79.9, 1, 19, 23, 'assets/images/urunler/karekod/1019023447113.png', 1),
(40, 'Marjin Ustica Kar Botu Siyah', '1019023487762', '0000-00-00', '<div>\r\n	Topuk Tipi : ORTA TOPUK</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği : 4cm</div>\r\n<div>\r\n	Platform En : 3cm</div>\r\n<div>\r\n	Metaryal : P U</div>\r\n', '#000000', '34Numara=1/34_5Numara=0/35Numara=3/35_5Numara=0/36Numara=1/36_5Numara=2/37Numara=0/37_5Numara=0/38Numara=1/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 399.99, 169.99, 1, 19, 23, 'assets/images/urunler/karekod/1019023487762.png', 1),
(41, 'Punto 020155-03 Kadın Günlük Deri Bot', '1019024640747', '0000-00-00', '<div>\r\n	Ergonomik Kalıp Dış Malzeme Deri İ&ccedil; Malzeme Antibakteriyel Tekstil Malzeme Taban Termo Taban</div>', '#704a00', '34Numara=0/34_5Numara=0/35Numara=5/35_5Numara=0/36Numara=2/36_5Numara=4/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=1/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 179.9, 0, 1, 19, 24, 'assets/images/urunler/karekod/1019024640747.png', 1),
(42, 'İnce Topuk Dolgu Topuk Bot Siyah', '1019024717926', '0000-00-00', '<div>\r\n	Suni Deri Ve S&uuml;et &Ouml;k&ccedil;e : 10 CM Platform : 5 CM İ&ccedil;ten Fermuarlı &Ouml;n Kısımdan kemerli ve trok Detaylı Olarak &Uuml;retilmiştir.</div>', '#000000', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=0/36_5Numara=4/37Numara=0/37_5Numara=2/38Numara=5/38_5Numara=0/39Numara=1/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 239, 130, 1, 19, 24, 'assets/images/urunler/karekod/1019024717926.png', 1),
(43, 'Pedro Camino Bayan Ayakkabı', '102001981543', '0000-00-00', '<div>\r\n	Pedro Camino Bayan Ayakkabı</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Astar Malzemesi: Deri</div>\r\n<div>\r\n	Malzeme: Deri</div>\r\n<div>\r\n	Taban &Ccedil;eşidi: K&ouml;sele</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Diğer</div>\r\n<div>\r\n	Yurtdışına Satış: Yok</div>\r\n', '#7a5202', '34Numara=0/34_5Numara=0/35Numara=1/35_5Numara=0/36Numara=3/36_5Numara=4/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=1/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 399, 39.9, 1, 20, 19, 'assets/images/urunler/karekod/102001981543.png', 1),
(44, 'Escarpine Fileli Lacivert Bayan Ayakkabı', '1020019121124', '0000-00-00', '<div>\r\n	Escarpine Fileli Lacivert Bayan Ayakkabısı</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	&Uuml;st bandı minik fiyonklu</div>\r\n<div>\r\n	Topuk Boyu:8,50 cm</div>\r\n<div>\r\n	Renk:Lacivert</div>\r\n<div>\r\n	&Ouml;n burnu a&ccedil;ık arkası kapalı, rahat ayakkabı.</div>', '#4457fc', '34Numara=4/34_5Numara=2/35Numara=0/35_5Numara=0/36Numara=1/36_5Numara=3/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=2/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 19, 0, 1, 20, 19, 'assets/images/urunler/karekod/1020019121124.png', 1),
(45, 'Pembe Potin Siyah Nubuk Ayakkabı', '1020021731323', '0000-00-00', '<div>\r\n	T&uuml;rkiye de &Uuml;retilmiştir Topuk Boyu 9 cm Suni Deri lastik Taban</div>\r\n', '#000000', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=3/36_5Numara=4/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=5/39Numara=0/39_5Numara=0/40Numara=6/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 119.99, 79.99, 1, 20, 21, 'assets/images/urunler/karekod/1020021731323.png', 1),
(46, 'Pembe Potin Bordo Ayakkabı', '102002196893', '0000-00-00', '<div>\r\n	T&uuml;rkiye de &Uuml;retilmiştir Topuk Boyu 6 cm Suni Deri lastik Taban</div>', '#94226d', '34Numara=0/34_5Numara=0/35Numara=0/35_5Numara=0/36Numara=5/36_5Numara=6/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=1/39Numara=2/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 199.99, 79.99, 1, 20, 21, 'assets/images/urunler/karekod/102002196893.png', 1),
(47, 'Pedro Camino Bayan Ayakkabı', '1020020433838', '0000-00-00', '<div>\r\n	Pedro Camino Bayan Ayakkabı</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Astar Malzemesi: Deri</div>\r\n<div>\r\n	Malzeme: Deri</div>\r\n<div>\r\n	Taban &Ccedil;eşidi: K&ouml;sele</div>\r\n', '#966a15', '34Numara=0/34_5Numara=1/35Numara=0/35_5Numara=0/36Numara=4/36_5Numara=6/37Numara=2/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 399, 39.9, 1, 20, 20, 'assets/images/urunler/karekod/1020020433838.png', 1),
(48, 'Tübu Kadın Topuklu Ayakkabı', '1020020532837', '0000-00-00', '<div>\r\n	Dış Materyal: Deri</div>\r\n<div>\r\n	Materyal &Ouml;zelliği: Suni Deri</div>\r\n<div>\r\n	İ&ccedil; Materyal: Deri</div>\r\n<div>\r\n	Taban Materyal: Neolit</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 10 cm</div>\r\n<div>\r\n	Detay: Şık ve zarif tasarımı ile kombinlerinizin tamamlayıcısı haline gelir.</div>\r\n<div>\r\n	Hafif yapısı sayesinde taşıma zorluğunu ortadan kaldırır.</div>\r\n', '#f70000', '34Numara=0/34_5Numara=0/35Numara=1/35_5Numara=0/36Numara=2/36_5Numara=3/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 59, 0, 1, 20, 20, 'assets/images/urunler/karekod/1020020532837.png', 1),
(49, 'Tübu Kadın Topuklu Ayakkabı', '1020020932404', '0000-00-00', '<div>\r\n	Dış Materyal: Deri</div>\r\n<div>\r\n	Materyal &Ouml;zelliği: Suni Deri</div>\r\n<div>\r\n	İ&ccedil; Materyal: Deri</div>\r\n<div>\r\n	Taban Materyal: Neolit</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 10 cm</div>\r\n<div>\r\n	Detay: Şık ve zarif tasarımı ile kombinlerinizin tamamlayıcısı haline gelir.</div>\r\n<div>\r\n	Hafif yapısı sayesinde taşıma zorluğunu ortadan kaldırır.</div>\r\n', '#6800ed', '34Numara=0/34_5Numara=0/35Numara=1/35_5Numara=0/36Numara=2/36_5Numara=3/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 59, 0, 1, 20, 20, 'assets/images/urunler/karekod/1020020932404.png', 1),
(50, 'Tübu Kadın Topuklu Ayakkabı', '1020020634979', '0000-00-00', '<div>\r\n	Dış Materyal: Deri</div>\r\n<div>\r\n	Materyal &Ouml;zelliği: Suni Deri</div>\r\n<div>\r\n	İ&ccedil; Materyal: Deri</div>\r\n<div>\r\n	Taban Materyal: Neolit</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 10 cm</div>\r\n<div>\r\n	Detay: Şık ve zarif tasarımı ile kombinlerinizin tamamlayıcısı haline gelir.</div>\r\n<div>\r\n	Hafif yapısı sayesinde taşıma zorluğunu ortadan kaldırır.</div>\r\n', '#030303', '34Numara=0/34_5Numara=2/35Numara=1/35_5Numara=0/36Numara=2/36_5Numara=3/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=3/39Numara=1/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 59, 0, 1, 20, 20, 'assets/images/urunler/karekod/1020020634979.png', 1),
(51, 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', '1020018859314', '0000-00-00', '<div>\r\n	Marka: Paddy</div>\r\n<div>\r\n	Mevsim: Mevsimlik</div>\r\n<div>\r\n	Dış Materyal: Suni deri</div>\r\n<div>\r\n	İ&ccedil; Materyal: Mikrofiber</div>\r\n<div>\r\n	Taban Materyali: Poli&uuml;retan</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 9 Cm</div>\r\n<div>\r\n	Taban Y&uuml;ksekligi: 0,5 Cm</div>\r\n<div>\r\n	Agırlık: 160 Gr</div>\r\n<div>\r\n	Kalıp: Standart Ayak &Ouml;l&ccedil;&uuml;lerine G&ouml;re Tam Kalıp</div>\r\n', '#000000', '34Numara=3/34_5Numara=0/35Numara=1/35_5Numara=0/36Numara=5/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=6/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 77.9, 49.9, 1, 20, 18, 'assets/images/urunler/karekod/1020018859314.png', 1),
(52, 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', '1020018844056', '0000-00-00', '<div>\r\n	Marka: Paddy</div>\r\n<div>\r\n	Mevsim: Mevsimlik</div>\r\n<div>\r\n	Dış Materyal: Suni deri</div>\r\n<div>\r\n	İ&ccedil; Materyal: Mikrofiber</div>\r\n<div>\r\n	Taban Materyali: Poli&uuml;retan</div>\r\n<div>\r\n	Topuk Y&uuml;ksekliği: 9 Cm</div>\r\n<div>\r\n	Taban Y&uuml;ksekligi: 0,5 Cm</div>\r\n<div>\r\n	Agırlık: 160 Gr</div>\r\n<div>\r\n	Kalıp: Standart Ayak &Ouml;l&ccedil;&uuml;lerine G&ouml;re Tam Kalıp</div>\r\n', '#594205', '34Numara=3/34_5Numara=0/35Numara=1/35_5Numara=0/36Numara=5/36_5Numara=0/37Numara=0/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=6/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 77.9, 49.9, 1, 20, 18, 'assets/images/urunler/karekod/1020018844056.png', 1),
(53, 'Pembe Potin Karemel Rugan Ayakkabı', '1020018655487', '0000-00-00', '<p>\r\n	T&uuml;rkiye de &Uuml;retilmiştir Topuk Boyu 11 cm Suni Deri Neolit Taban</p>\r\n', 'rgba(224,171,171,0.94)', '34Numara=0/34_5Numara=6/35Numara=0/35_5Numara=0/36Numara=5/36_5Numara=0/37Numara=2/37_5Numara=0/38Numara=0/38_5Numara=0/39Numara=0/39_5Numara=0/40Numara=0/40_5Numara=0/41Numara=0/41_5Numara=0/42Numara=0/42_5Numara=0/43Numara=0/43_5Numara=0', 199.99, 69.99, 1, 20, 18, 'assets/images/urunler/karekod/1020018655487.png', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `productsimages`
--

CREATE TABLE IF NOT EXISTS `productsimages` (
  `Id` int(11) NOT NULL,
  `ProductStokCode` text NOT NULL,
  `ImageName` varchar(255) NOT NULL,
  `ImagePath` text NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `productsimages`
--

INSERT INTO `productsimages` (`Id`, `ProductStokCode`, `ImageName`, `ImagePath`, `Status`) VALUES
(1, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/1215_Divaresse_17987221.jpg', 1),
(2, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/1602_Divaresse_17987223.jpg', 1),
(3, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/3157_Divaresse_17987222.jpg', 1),
(4, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/4465_Divaresse_17987224.jpg', 1),
(5, '1020017351715', 'Mecrea Exclusive Magnolia Bej Süet Dolgu Topuk Stiletto', 'assets/images/urunler/7606_Divaresse_17987220.jpg', 1),
(6, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/6536_9487690858546.jpg', 1),
(7, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/6030_9487690891314.jpg', 1),
(8, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/1314_9487690924082.jpg', 1),
(9, '1020017587402', 'Elle Mayer Kadın Ayakkabı', 'assets/images/urunler/8310_9487690956850.jpg', 1),
(10, '2022029326141', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/3168_9727124340786.jpg', 1),
(11, '2022029326141', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/2175_9727124373554.jpg', 1),
(12, '2022029326141', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/8744_9727124439090.jpg', 1),
(13, '2022029326141', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/2724_9727123652658.jpg', 1),
(14, '2022029511475', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/2525_9727124799538.jpg', 1),
(15, '2022029511475', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/2556_9727124832306.jpg', 1),
(16, '2022029511475', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/1384_9727123652658 (1).jpg', 1),
(17, '2022029977662', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/8794_9727124799538.jpg', 1),
(18, '2022029977662', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/1427_9727124832306.jpg', 1),
(19, '2022029977662', 'Conteyner 930 Kışlık Su Geçirmez Termal Erkek Bot', 'assets/images/urunler/1432_9727123652658.jpg', 1),
(20, '2022030363678', 'Garamond 1117-2 Siyah Erkek Deri City', 'assets/images/urunler/9396_100288768_1.jpg', 1),
(21, '2022030363678', 'Garamond 1117-2 Siyah Erkek Deri City', 'assets/images/urunler/26_100288768_2.jpg', 1),
(22, '2022030363678', 'Garamond 1117-2 Siyah Erkek Deri City', 'assets/images/urunler/2310_100288768_3.jpg', 1),
(23, '2022030363678', 'Garamond 1117-2 Siyah Erkek Deri City', 'assets/images/urunler/3011_100288768_4.jpg', 1),
(24, '202203048736', 'Garamond 5610 Lacivert Erkek Deri City', 'assets/images/urunler/8610_100315107_1.jpg', 1),
(25, '202203048736', 'Garamond 5610 Lacivert Erkek Deri City', 'assets/images/urunler/6837_100315107_2.jpg', 1),
(26, '202203048736', 'Garamond 5610 Lacivert Erkek Deri City', 'assets/images/urunler/7266_100315107_3.jpg', 1),
(27, '202203048736', 'Garamond 5610 Lacivert Erkek Deri City', 'assets/images/urunler/5721_100315107_4.jpg', 1),
(28, '2022031464783', 'Dockers by Gerli A3365050 Lacivert Erkek Outdoor', 'assets/images/urunler/8194_100226730_1_1.jpg', 1),
(29, '2022031464783', 'Dockers by Gerli A3365050 Lacivert Erkek Outdoor', 'assets/images/urunler/5717_100226730_2_1.jpg', 1),
(30, '2022031464783', 'Dockers by Gerli A3365050 Lacivert Erkek Outdoor', 'assets/images/urunler/4997_100226730_3_1.jpg', 1),
(31, '2022031464783', 'Dockers by Gerli A3365050 Lacivert Erkek Outdoor', 'assets/images/urunler/1371_100226730_4_1.jpg', 1),
(32, '2022031183624', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/12_100198687_1_2.jpg', 1),
(33, '2022031183624', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/6594_100198687_2.jpg', 1),
(34, '2022031183624', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/163_100198687_3.jpg', 1),
(35, '2022031183624', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/3339_100198687_4.jpg', 1),
(36, '2022031942933', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/6251_100198685_1.jpg', 1),
(37, '2022031942933', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/3399_100198685_2.jpg', 1),
(38, '2022031942933', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/4198_100198685_3.jpg', 1),
(39, '2022031942933', 'Kinetix 1272192 Kahverengi Erkek Outdoor Bot', 'assets/images/urunler/8594_100198685_4.jpg', 1),
(40, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/108_100263749_1.jpg', 1),
(41, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/477_100263749_2.jpg', 1),
(42, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/8037_100263749_3.jpg', 1),
(43, '2022032635834', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/2559_100263749_4.jpg', 1),
(44, '2022032652710', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/8347_100263748_1.jpg', 1),
(45, '2022032652710', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/1478_100263748_2.jpg', 1),
(46, '2022032652710', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/770_100263748_3.jpg', 1),
(47, '2022032652710', 'Lumberjack ULPIA Siyah Erkek Deri City', 'assets/images/urunler/2225_100263748_4.jpg', 1),
(48, '2022032353088', 'Oxide 137 Taba Erkek Deri City', 'assets/images/urunler/3322_100289254_1.jpg', 1),
(49, '2022032353088', 'Oxide 137 Taba Erkek Deri City', 'assets/images/urunler/4063_100289254_2.jpg', 1),
(50, '2022032353088', 'Oxide 137 Taba Erkek Deri City', 'assets/images/urunler/6580_100289254_3.jpg', 1),
(51, '2022032353088', 'Oxide 137 Taba Erkek Deri City', 'assets/images/urunler/8320_100289254_4.jpg', 1),
(52, '2024033842743', 'Hummel HUMMEL COMET SS16 Siyah Beyaz Erkek Sneaker', 'assets/images/urunler/1264_100212342_1_1.jpg', 1),
(53, '2024033842743', 'Hummel HUMMEL COMET SS16 Siyah Beyaz Erkek Sneaker', 'assets/images/urunler/9607_100212342_2.jpg', 1),
(54, '2024033842743', 'Hummel HUMMEL COMET SS16 Siyah Beyaz Erkek Sneaker', 'assets/images/urunler/3793_100212342_3.jpg', 1),
(55, '2024033842743', 'Hummel HUMMEL COMET SS16 Siyah Beyaz Erkek Sneaker', 'assets/images/urunler/8046_100212342_4.jpg', 1),
(56, '202403324169', 'Kinetix ALVEN MESH Siyah Erkek Sneaker', 'assets/images/urunler/6363_100238308_1.jpg', 1),
(57, '2024034406097', 'Nike NIKE ZOOM WINFLO 3 SHIELD Sarı Yeşil Erkek Koşu Ayakkabısı', 'assets/images/urunler/5945_100258850_1.jpg', 1),
(58, '2024034406097', 'Nike NIKE ZOOM WINFLO 3 SHIELD Sarı Yeşil Erkek Koşu Ayakkabısı', 'assets/images/urunler/8004_100258850_2.jpg', 1),
(59, '2024034406097', 'Nike NIKE ZOOM WINFLO 3 SHIELD Sarı Yeşil Erkek Koşu Ayakkabısı', 'assets/images/urunler/4714_100258850_3.jpg', 1),
(60, '2024034823212', 'Kinetix DRAKE Lacivert Saks Beyaz Erkek Koşu Ayakkabısı', 'assets/images/urunler/9975_100264939_1.jpg', 1),
(61, '2024034823212', 'Kinetix DRAKE Lacivert Saks Beyaz Erkek Koşu Ayakkabısı', 'assets/images/urunler/9099_100264939_2.jpg', 1),
(62, '2024034823212', 'Kinetix DRAKE Lacivert Saks Beyaz Erkek Koşu Ayakkabısı', 'assets/images/urunler/8441_100264939_3.jpg', 1),
(63, '2024034823212', 'Kinetix DRAKE Lacivert Saks Beyaz Erkek Koşu Ayakkabısı', 'assets/images/urunler/4726_100264939_4.jpg', 1),
(64, '2024035832764', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/7730_100266706_1.jpg', 1),
(65, '2024035832764', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/4910_100266706_2.jpg', 1),
(66, '2024035832764', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/2918_100266706_3.jpg', 1),
(67, '2024035832764', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/1896_100266706_4.jpg', 1),
(68, '2024035162811', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/1388_100239559_1.jpg', 1),
(69, '2024035162811', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/9428_100239559_2.jpg', 1),
(70, '2024035162811', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/5616_100239559_3.jpg', 1),
(71, '2024035162811', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/3082_100239559_4.jpg', 1),
(72, '202403548339', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/8958_100239556_1.jpg', 1),
(73, '202403548339', 'Kinetix VITORA Petrol Beyaz Erkek Fitness Ayakkabısı', 'assets/images/urunler/15_100239556_2.jpg', 1),
(74, '2024036614716', 'Nike MERCURIAL VORTEX III FG Kırmızı Beyaz Erkek Krampon', 'assets/images/urunler/214_100292854_1.jpg', 1),
(75, '2024036614716', 'Nike MERCURIAL VORTEX III FG Kırmızı Beyaz Erkek Krampon', 'assets/images/urunler/2678_100292854_2.jpg', 1),
(76, '2024036614716', 'Nike MERCURIAL VORTEX III FG Kırmızı Beyaz Erkek Krampon', 'assets/images/urunler/6063_100292854_3.jpg', 1),
(77, '2024036614716', 'Nike MERCURIAL VORTEX III FG Kırmızı Beyaz Erkek Krampon', 'assets/images/urunler/3031_100292854_4.jpg', 1),
(78, '2024036744660', 'Nike TIEMPOX RIO IV TF Siyah Erkek Halı Saha Ayakkabısı', 'assets/images/urunler/9040_100293963_1.jpg', 1),
(79, '202403863598', 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', 'assets/images/urunler/2465_100232584_1.jpg', 1),
(80, '202403863598', 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', 'assets/images/urunler/1661_100232584_2.jpg', 1),
(81, '202403863598', 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', 'assets/images/urunler/6979_100232584_3.jpg', 1),
(82, '202403863598', 'Kinetix KARON Beyaz Lacivert Erkek Tenis Ayakkabısı', 'assets/images/urunler/201_100232584_4.jpg', 1),
(83, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/5278_100292851_1.jpg', 1),
(84, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/4351_100292851_2.jpg', 1),
(85, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/4355_100292851_3.jpg', 1),
(86, '2024037308868', 'Nike NIKE AIR PRECISION Kırmızı Erkek Basketbol Ayakkabısı', 'assets/images/urunler/4006_100292851_4.jpg', 1),
(87, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/8937_100231312_1.jpg', 1),
(88, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/4997_100231312_2.jpg', 1),
(89, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/9117_100231312_3.jpg', 1),
(90, '3025046477936', 'I Cool 702-R2 GE Siyah Erkek Çocuk Outdoor', 'assets/images/urunler/9935_100231312_4.jpg', 1),
(91, '3025046561005', 'Kinetix 1255196 Siyah Mavi Neon Yeşil Erkek Çocuk Outdoor', 'assets/images/urunler/6669_100198666_1_4.jpg', 1),
(92, '3025046561005', 'Kinetix 1255196 Siyah Mavi Neon Yeşil Erkek Çocuk Outdoor', 'assets/images/urunler/1281_100198666_2.jpg', 1),
(93, '3025046561005', 'Kinetix 1255196 Siyah Mavi Neon Yeşil Erkek Çocuk Outdoor', 'assets/images/urunler/8846_100198666_3.jpg', 1),
(94, '3025046561005', 'Kinetix 1255196 Siyah Mavi Neon Yeşil Erkek Çocuk Outdoor', 'assets/images/urunler/1400_100198666_4.jpg', 1),
(95, '302504782824', 'İ Cool Gizy Lacivert Mavi Erkek Çocuk Ayakkabı', 'assets/images/urunler/2484_9719458693170.jpg', 1),
(96, '302504782824', 'İ Cool Gizy Lacivert Mavi Erkek Çocuk Ayakkabı', 'assets/images/urunler/1536_9719458725938.jpg', 1),
(97, '302504782824', 'İ Cool Gizy Lacivert Mavi Erkek Çocuk Ayakkabı', 'assets/images/urunler/4903_9719458758706.jpg', 1),
(98, '302504782824', 'İ Cool Gizy Lacivert Mavi Erkek Çocuk Ayakkabı', 'assets/images/urunler/4250_9719458791474.jpg', 1),
(99, '3025047856659', 'Nike Ayakkabı Revolution 3 (Gs) 819413-400', 'assets/images/urunler/5182_Divaresse_14326212.jpg', 1),
(100, '302504846783', 'Gezer 2386 Ev Ve Kreş Erkek Çocuk Panduf', 'assets/images/urunler/6481_9733964857394.jpg', 1),
(101, '302504846783', 'Gezer 2386 Ev Ve Kreş Erkek Çocuk Panduf', 'assets/images/urunler/4787_9733964890162.jpg', 1),
(102, '302504846783', 'Gezer 2386 Ev Ve Kreş Erkek Çocuk Panduf', 'assets/images/urunler/3731_9733964922930.jpg', 1),
(103, '302504846783', 'Gezer 2386 Ev Ve Kreş Erkek Çocuk Panduf', 'assets/images/urunler/389_9733964955698.jpg', 1),
(104, '3025048838135', 'Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)', 'assets/images/urunler/6085_9547208097842.jpg', 1),
(105, '3025048838135', 'Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)', 'assets/images/urunler/8049_9547208130610.jpg', 1),
(106, '3025048838135', 'Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)', 'assets/images/urunler/7639_9547208163378.jpg', 1),
(107, '3025048838135', 'Soobe Arabalı Peluş Panduf Kırmızı (22-33 Numara)', 'assets/images/urunler/9059_9547208196146.jpg', 1),
(108, '3025049345642', 'DeFacto Erkek Çocuk Sandalet', 'assets/images/urunler/8330_9585108189234.jpg', 1),
(109, '3025049345642', 'DeFacto Erkek Çocuk Sandalet', 'assets/images/urunler/619_9585108222002.jpg', 1),
(110, '3025049345642', 'DeFacto Erkek Çocuk Sandalet', 'assets/images/urunler/9353_9585108254770.jpg', 1),
(111, '3025049232452', 'Aydındaş 903 Günlük Filet Yürüyüş Erkek Çocuk Spor Sandalet Ayakkabı', 'assets/images/urunler/3235_9654732226610.jpg', 1),
(112, '3025049232452', 'Aydındaş 903 Günlük Filet Yürüyüş Erkek Çocuk Spor Sandalet Ayakkabı', 'assets/images/urunler/7864_9654732259378.jpg', 1),
(113, '3025049232452', 'Aydındaş 903 Günlük Filet Yürüyüş Erkek Çocuk Spor Sandalet Ayakkabı', 'assets/images/urunler/8542_9654732292146.jpg', 1),
(114, '3025050443481', 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', 'assets/images/urunler/1538_9735768080434.jpg', 1),
(115, '3025050443481', 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', 'assets/images/urunler/5538_9735768113202.jpg', 1),
(116, '3025050443481', 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', 'assets/images/urunler/4567_9735768145970.jpg', 1),
(117, '3025050443481', 'Lumberjack Flake G Gri Erkek Çocuk Ayakkabı', 'assets/images/urunler/2281_9735768178738.jpg', 1),
(118, '3025050921448', 'U.S. Polo Assn. Alone Lacivert Erkek Çocuk Çocuk Ayakkabı', 'assets/images/urunler/2833_9719494508594.jpg', 1),
(119, '3025050921448', 'U.S. Polo Assn. Alone Lacivert Erkek Çocuk Çocuk Ayakkabı', 'assets/images/urunler/840_9719494541362.jpg', 1),
(120, '3025050921448', 'U.S. Polo Assn. Alone Lacivert Erkek Çocuk Çocuk Ayakkabı', 'assets/images/urunler/5311_9719494574130.jpg', 1),
(121, '3025050921448', 'U.S. Polo Assn. Alone Lacivert Erkek Çocuk Çocuk Ayakkabı', 'assets/images/urunler/9941_9719494606898.jpg', 1),
(122, '3025051512665', 'Crocs Crocband Kıds Çocuk Terlik 12837-42K', 'assets/images/urunler/1479_Divaresse_13832881.jpg', 1),
(123, '3025051512665', 'Crocs Crocband Kıds Çocuk Terlik 12837-42K', 'assets/images/urunler/3024_Divaresse_13832882.jpg', 1),
(124, '3025051635071', 'U.S. Polo Assn. A3353251 Kırmızı Unisex Çocuk Terlik', 'assets/images/urunler/6933_9626026082354.jpg', 1),
(125, '1019022171356', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/6952_9711422341170.jpg', 1),
(126, '1019022171356', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/7150_9711422373938.jpg', 1),
(127, '1019022171356', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/3583_9711422406706.jpg', 1),
(128, '1019022353149', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/5576_9711422439474.jpg', 1),
(129, '1019022353149', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/8190_9711422472242.jpg', 1),
(130, '1019022353149', 'Gön Deri Kadın Bot 59469', 'assets/images/urunler/6066_9711422505010.jpg', 1),
(131, '1019023447113', 'Derigo Kadın Postal Bot Siyah 22184', 'assets/images/urunler/652_9524084637746.jpg', 1),
(132, '1019023447113', 'Derigo Kadın Postal Bot Siyah 22184', 'assets/images/urunler/1070_9524084670514.jpg', 1),
(133, '1019023447113', 'Derigo Kadın Postal Bot Siyah 22184', 'assets/images/urunler/8953_9524084703282.jpg', 1),
(134, '1019023447113', 'Derigo Kadın Postal Bot Siyah 22184', 'assets/images/urunler/3601_9524084736050.jpg', 1),
(135, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/1835_9722792542258.jpg', 1),
(136, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/9377_9722792575026.jpg', 1),
(137, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/6278_9722792607794.jpg', 1),
(138, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/6449_9722792640562.jpg', 1),
(139, '1019023487762', 'Marjin Ustica Kar Botu Siyah', 'assets/images/urunler/3704_9722792673330.jpg', 1),
(140, '1019024640747', 'Punto 020155-03 Kadın Günlük Deri Bot', 'assets/images/urunler/6557_9527486939186.jpg', 1),
(141, '1019024640747', 'Punto 020155-03 Kadın Günlük Deri Bot', 'assets/images/urunler/2667_9527486971954.jpg', 1),
(142, '1019024640747', 'Punto 020155-03 Kadın Günlük Deri Bot', 'assets/images/urunler/1618_9527487004722.jpg', 1),
(143, '1019024717926', 'İnce Topuk Dolgu Topuk Bot Siyah', 'assets/images/urunler/1776_9727450349618.jpg', 1),
(144, '1019024717926', 'İnce Topuk Dolgu Topuk Bot Siyah', 'assets/images/urunler/736_9727450382386.jpg', 1),
(145, '1019024717926', 'İnce Topuk Dolgu Topuk Bot Siyah', 'assets/images/urunler/5999_9727450415154.jpg', 1),
(146, '1019024717926', 'İnce Topuk Dolgu Topuk Bot Siyah', 'assets/images/urunler/6358_9727450447922.jpg', 1),
(147, '1019024717926', 'İnce Topuk Dolgu Topuk Bot Siyah', 'assets/images/urunler/7854_9727450480690.jpg', 1),
(148, '102001981543', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/5150_Divaresse_6916317.jpg', 1),
(149, '102001981543', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/4878_Divaresse_6916318.jpg', 1),
(150, '102001981543', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/5708_Divaresse_6916319.jpg', 1),
(151, '1020019121124', 'Escarpine Fileli Lacivert Bayan Ayakkabı', 'assets/images/urunler/1887_Divaresse_15860218.jpg', 1),
(152, '1020021731323', 'Pembe Potin Siyah Nubuk Ayakkabı', 'assets/images/urunler/1535_9736381595698.jpg', 1),
(153, '1020021731323', 'Pembe Potin Siyah Nubuk Ayakkabı', 'assets/images/urunler/6522_9736381628466.jpg', 1),
(154, '1020021731323', 'Pembe Potin Siyah Nubuk Ayakkabı', 'assets/images/urunler/8060_9736381661234.jpg', 1),
(155, '102002196893', 'Pembe Potin Bordo Ayakkabı', 'assets/images/urunler/7038_9736391622706.jpg', 1),
(156, '102002196893', 'Pembe Potin Bordo Ayakkabı', 'assets/images/urunler/2714_9736391655474.jpg', 1),
(157, '102002196893', 'Pembe Potin Bordo Ayakkabı', 'assets/images/urunler/1305_9736391688242.jpg', 1),
(158, '102002196893', 'Pembe Potin Bordo Ayakkabı', 'assets/images/urunler/626_9736391721010.jpg', 1),
(159, '1020020433838', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/5401_Divaresse_6916350.jpg', 1),
(160, '1020020433838', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/3537_Divaresse_6916351.jpg', 1),
(161, '1020020433838', 'Pedro Camino Bayan Ayakkabı', 'assets/images/urunler/5862_Divaresse_6916352.jpg', 1),
(162, '1020020532837', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/1435_9610045554738.jpg', 1),
(163, '1020020532837', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/6861_9610045587506.jpg', 1),
(164, '1020020532837', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/1300_9610045620274.jpg', 1),
(165, '1020020532837', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/8721_9610045653042.jpg', 1),
(166, '1020020932404', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/2432_9610048864306.jpg', 1),
(167, '1020020932404', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/1563_9610048897074.jpg', 1),
(168, '1020020932404', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/7953_9610048929842.jpg', 1),
(169, '1020020932404', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/3757_9610048962610.jpg', 1),
(170, '1020020634979', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/8552_9610045685810.jpg', 1),
(171, '1020020634979', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/2705_9610045718578.jpg', 1),
(172, '1020020634979', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/5240_9610045751346.jpg', 1),
(173, '1020020634979', 'Tübu Kadın Topuklu Ayakkabı', 'assets/images/urunler/4601_9610045784114.jpg', 1),
(174, '1020018859314', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/8233_9654770597938.jpg', 1),
(175, '1020018859314', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/9975_9654770630706.jpg', 1),
(176, '1020018859314', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/9099_9654770663474.jpg', 1),
(177, '1020018844056', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/4726_9654770696242.jpg', 1),
(178, '1020018844056', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/8328_9654770729010.jpg', 1),
(179, '1020018844056', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/7730_9654770761778.jpg', 1),
(180, '1020018844056', 'Paddy 2535 İnce Topuk Stiletto Bayan Ayakkabı', 'assets/images/urunler/4910_9654770794546.jpg', 1),
(181, '1020018655487', 'Pembe Potin Karemel Rugan Ayakkabı', 'assets/images/urunler/5905_9736377892914.jpg', 1),
(182, '1020018655487', 'Pembe Potin Karemel Rugan Ayakkabı', 'assets/images/urunler/9238_9736377925682.jpg', 1),
(183, '1020018655487', 'Pembe Potin Karemel Rugan Ayakkabı', 'assets/images/urunler/2360_9736377958450.jpg', 1),
(184, '1020018655487', 'Pembe Potin Karemel Rugan Ayakkabı', 'assets/images/urunler/5587_9736377991218.jpg', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `siteproperties`
--

CREATE TABLE IF NOT EXISTS `siteproperties` (
  `Id` int(11) NOT NULL,
  `SiteName` varchar(55) NOT NULL,
  `SiteLink` varchar(255) NOT NULL,
  `SiteIcon` varchar(255) NOT NULL,
  `Status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `siteproperties`
--

INSERT INTO `siteproperties` (`Id`, `SiteName`, `SiteLink`, `SiteIcon`, `Status`) VALUES
(1, 'Shoe Ar Store', 'http://localhost:8080/shoearstore/', 'http://localhost:8080/shoearstore/assets/images/fav.ico', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `slider`
--

CREATE TABLE IF NOT EXISTS `slider` (
  `Id` int(11) NOT NULL,
  `ImageName` varchar(255) NOT NULL,
  `ImagePath` varchar(255) NOT NULL,
  `Link` varchar(255) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `slider`
--

INSERT INTO `slider` (`Id`, `ImageName`, `ImagePath`, `Link`, `Status`) VALUES
(1, 'Deneme', 'assets\\images\\slider\\1.jpg', '1', 1),
(2, 'Bayan Ayakkıbılarında %50 İndirim', 'assets\\images\\slider\\2.jpg', '5', 1),
(3, 'Yeni Sezon Ayakkabıları', 'assets\\images\\slider\\3.jpg', '2', 1),
(4, 'Jump Kampanyası', 'assets\\images\\slider\\4.jpg', '3', 0),
(10, 'Kundura', 'assets/images/slider/3608_Kundura5.jpg', '4', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `socialmedias`
--

CREATE TABLE IF NOT EXISTS `socialmedias` (
  `Id` int(11) NOT NULL,
  `SocialMediaName` varchar(55) NOT NULL,
  `SocialMediaLink` varchar(255) NOT NULL,
  `SocialMediaImagePath` varchar(255) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `socialmedias`
--

INSERT INTO `socialmedias` (`Id`, `SocialMediaName`, `SocialMediaLink`, `SocialMediaImagePath`, `Status`) VALUES
(1, 'Facebook', 'https://tr-tr.facebook.com/shoearstore', 'assets\\images\\sosyalmedyalar\\Facebook-2-128.png', 1),
(2, 'Twitter', 'https://twitter.com/shoearstore', 'assets\\images\\sosyalmedyalar\\twitter-128.png', 1),
(3, 'Pinterest', 'https://tr.pinterest.com/shoearstore', 'assets\\images\\sosyalmedyalar\\pinterest-128.png', 1),
(4, 'Google Plus', 'https://plus.google.com/+shoearstore', 'assets\\images\\sosyalmedyalar\\google_-128.png', 1),
(6, 'İnstagram', 'https://instagram.com/shoearstore', 'assets\\images\\sosyalmedyalar\\instagram-3-12.png', 0),
(10, 'ggggg', 'SosyalMedyaLinki', 'assets/images/sosyalmedyalar/392_gginstagram.png', 0),
(11, 'deneme', 'deneme', 'assets/images/sosyalmedyalar/9352_denemegoogle_-128.png', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `stores`
--

CREATE TABLE IF NOT EXISTS `stores` (
  `StoreId` int(11) NOT NULL,
  `StoreName` text COLLATE utf8_turkish_ci NOT NULL,
  `StoreAdress` text COLLATE utf8_turkish_ci NOT NULL,
  `StoreTelephone` text COLLATE utf8_turkish_ci NOT NULL,
  `StoreMail` text COLLATE utf8_turkish_ci NOT NULL,
  `StoreCity` text COLLATE utf8_turkish_ci NOT NULL,
  `StoreLatitude` float NOT NULL,
  `StoreLongtitude` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `stores`
--

INSERT INTO `stores` (`StoreId`, `StoreName`, `StoreAdress`, `StoreTelephone`, `StoreMail`, `StoreCity`, `StoreLatitude`, `StoreLongtitude`) VALUES
(1, 'KuleSite ShoeARStore Mağazası', 'Musalla Bağları Mahallesi, Kule Cad. Kulesite AVM No:10, 42100 Selçuklu/Konya', '03322222222', 'kulesitemagaza@shoearstore.com', 'Konya', 37.8896, 32.4936),
(2, 'Kentplaza ShoeARStore Mağazası', 'Bedir Mahallesi Yeni İstanbul Cad. Kentplaza AVM No:7, 42100 Selçuklu/Konya', '03322222221', 'kentplazamagaza@shoearstore.com', 'Konya', 37.9049, 32.4939);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `subcategory`
--

CREATE TABLE IF NOT EXISTS `subcategory` (
  `Id` int(11) NOT NULL,
  `SubCategoryName` varchar(55) NOT NULL,
  `MainCategoryId` int(11) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `subcategory`
--

INSERT INTO `subcategory` (`Id`, `SubCategoryName`, `MainCategoryId`, `Status`) VALUES
(19, 'Bot', 1, 1),
(20, 'Topuklu Ayakkabı', 1, 1),
(21, 'Spor Ayakkabı', 1, 0),
(22, 'Bot & Çizme', 2, 1),
(24, 'Spor Ayakkabı', 2, 1),
(25, 'Erkek Çocuk', 3, 1),
(26, 'Kız Çocuk', 3, 1),
(27, 'Günlük', 1, 0),
(28, 'Deneme', 3, 0),
(29, 'ddee', 6, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `subsubcategory`
--

CREATE TABLE IF NOT EXISTS `subsubcategory` (
  `Id` int(11) NOT NULL,
  `SubSubCategoryName` varchar(55) NOT NULL,
  `SubCategoryId` int(11) NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `subsubcategory`
--

INSERT INTO `subsubcategory` (`Id`, `SubSubCategoryName`, `SubCategoryId`, `Status`) VALUES
(14, 'Günlük', 21, 1),
(15, 'Trekking', 21, 1),
(16, 'Yürüyüş - Koşu', 21, 1),
(17, 'Dolgu Topuk', 20, 1),
(18, 'Stiletto', 20, 1),
(19, 'Yüksek Topuklu', 20, 1),
(20, 'Platform Ayakkabı', 20, 1),
(21, 'Orta Boy Topuklu', 20, 1),
(22, 'Klasik Bot', 19, 1),
(23, 'Kar Botu', 19, 1),
(24, 'Dolgu Topuk', 19, 1),
(25, 'Espadril', 27, 1),
(26, 'Günlük Ayakkabı', 27, 1),
(27, 'Loafer', 27, 1),
(28, 'Oxford Kadın Ayakkabı', 27, 1),
(29, 'Günlük Bot', 22, 1),
(30, 'Klasik Bot', 22, 1),
(31, 'Outdoor Bot', 22, 1),
(32, 'Kar Botu', 22, 1),
(33, 'Sneaker', 24, 1),
(34, 'Koşu & Yürüyüş', 24, 1),
(35, 'Egzersiz & Fitness', 24, 1),
(36, 'Halı Saha', 24, 1),
(37, 'Basketbol', 24, 1),
(38, 'Tenis', 24, 1),
(39, 'Babet', 26, 1),
(40, 'Günlük Ayakkabı', 26, 1),
(41, 'Bot', 26, 1),
(42, 'Spor Ayakkabı', 26, 1),
(43, 'Terlik', 26, 1),
(44, 'Sandalet', 26, 1),
(45, 'Patik', 26, 1),
(46, 'Bot', 25, 1),
(47, 'Günlük Ayakkabı', 25, 1),
(48, 'Panduf', 25, 1),
(49, 'Sandalet', 25, 1),
(50, 'Spor Ayakkabı', 25, 1),
(51, 'Terlik', 25, 1),
(52, 'Alt Kategori Deneme', 28, 1),
(53, 'cccc', 29, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `termsofuse`
--

CREATE TABLE IF NOT EXISTS `termsofuse` (
  `Id` int(11) NOT NULL,
  `Conditions` longtext NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `termsofuse`
--

INSERT INTO `termsofuse` (`Id`, `Conditions`, `Status`) VALUES
(1, '<p>\r\n	<strong>ShoeARStore&rsquo;nın olağan ziyaret&ccedil;ileri i&ccedil;in bir gizlilik politikası bulunmamaktadır&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore.com&rsquo;un genel bir gizlilik politikası veya kullanım şartları bulunmamaktadır. Ancak siteye &uuml;ye olan kullanıcılar i&ccedil;in bir&nbsp;&ldquo;&Uuml;yelik S&ouml;zleşmesi&rdquo;&nbsp;vardır. Bu nedenle ShoeARStore&rsquo;ya &uuml;ye olan&nbsp;kullanıcılara ilişkin pratikler&nbsp;bu s&ouml;zleşmede a&ccedil;ıklansa da, &uuml;ye olmadan (dolayısıyla bu s&ouml;zleşmeyi kabul etmeden) ShoeARStore servislerinden faydalananlara ilişkin bir bilgi bulunmamaktadır.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore,&nbsp;IP adresiniz ve site i&ccedil;erisinde ziyaret ettiğiniz sayfalara ilişkin bilgilerinizi toplar&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore &ldquo;kullanıcılarına daha iyi bir hizmet sunabilmek i&ccedil;in&rdquo; kullanıcılarının &ouml;zel tercihlerine ve ilgi alanlarına y&ouml;nelik &ccedil;alışmalarda &uuml;yelerin kişisel bilgilerini kullanabilir. Bu &ccedil;er&ccedil;evede siteye erişmek i&ccedil;in kullanılan İnternet servis sağlayıcısının adı ve IP adresi, siteye erişilen tarih ve saat, sitede bulunulan sırada erişilen sayfalar ve siteye doğrudan bağlanılmasını sağlayan internet&nbsp;sitesinin adresi gibi birtakım bilgiler ShoeARStore tarafından&nbsp;toplanabilir.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore&nbsp;Gizlilik Politikası,&nbsp;&uuml;&ccedil;&uuml;nc&uuml; kişi &ccedil;erez kullanımı hakkında bilgi vermemektedir&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore, &uuml;&ccedil;&uuml;nc&uuml; kişi &ccedil;erez kullanımına ilişkin bilgi vermese de biz,&nbsp;<a href="https://disconnect.me/" target="_blank">Disconnect.me</a>&nbsp;ile yaptığımız denemede Google ve Yandex&rsquo;in internet sitesinde aktif halde olduğunu g&ouml;zlemledik.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore, kişisel ve alışveriş bilgilerinizi reklam ama&ccedil;lı kullanmakta ve iştiraki olan diğer şirketlerle de paylaşmaktadır&nbsp;</strong></p>\r\n<p>\r\n	&Uuml;yelik s&ouml;zleşmesinde kural olarak &ldquo;ShoeARStore t&uuml;keticiden elde ettiği kişisel bilgi ve verileri gizli bir şekilde tutup &uuml;&ccedil;&uuml;nc&uuml; kişiler ile paylaşmaz&rdquo; denmekte ve fakat devamında olduk&ccedil;a geniş bir liste yaparak bu durumlarda kişisel verilerinizin ShoeARStore ve&nbsp;<a href="http://www.dol.com.tr/index.html" target="_blank">Doğan Online (DOL)</a>&nbsp;iştiraki olan t&uuml;m şirketler tarafından&nbsp; kullanılmasına ve arşivlenmesine izin verdiğinizi s&ouml;ylemektedir.&nbsp;Aynı zamanda &uuml;yelerin, internet, telefon, SMS vb. iletişim kanalları aracılığıyla kendileriyle&nbsp;irtibata ge&ccedil;ilmesine izin verdiği kabul edilmektedir.</p>\r\n<p>\r\n	<strong>&nbsp;Verilerinin paylaşımını istemeyen ve reklam ama&ccedil;lı iletişime izin vermeyen &uuml;ye bu talebini m&uuml;şteri hizmetlerine iletebilmektedir&nbsp;</strong></p>\r\n<p>\r\n	&Uuml;yeler yukarıdaki s&ouml;zleme h&uuml;km&uuml;&nbsp;aksine bir bildirimde bulunabilirler. Eğer e-posta&nbsp;ve/veya SMS almaktan vazge&ccedil;mek isteniyorsa bunu site &uuml;zerindeki &uuml;ye sayfasından yapmak m&uuml;mk&uuml;nken, veri paylaşım tercihlerinin değiştirilebilmesi i&ccedil;in ShoeARStore&rsquo;nın m&uuml;şteri hizmetlerine ulaşılması ve talebin bu şekilde iletilmesi gerekmektedir.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore mahkeme kararına gerek kalmaksızın verilerinizi &uuml;&ccedil;&uuml;nc&uuml; şahıslarla paylaşabilir&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore yasal gereklere uygun hareket etmek i&ccedil;in kişisel verileri &nbsp;paylaşabileceğini&nbsp;belirtmektedir. Ayrıca ShoeARStore, &ccedil;alışanlarının ve y&ouml;neticilerinin haklarını korumak ve savunmak i&ccedil;in gerekli olduğuna iyi niyetle kanaat getirdiği hallerde de verilerinizi a&ccedil;ıklayabilir.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore kullanıcıları, &uuml;ye olurken verdikleri yanlış bilgilerden kaynaklanacak t&uuml;m zararlardan sorumludurlar&nbsp;</strong></p>\r\n<p>\r\n	Kullanıcılar internet sitesine &uuml;ye olurken verdikleri kişisel bilgilerin doğruluğunu taahh&uuml;t ederler ve bu bilgilerin ger&ccedil;eğe aykırılığı nedeniyle ShoeARStore&rsquo;nın uğrayacağı t&uuml;m zararları tazmin edeceklerini kabul ederler.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore, kullanıcı hesabınızı ve bilgilerinizi tek taraflı olarak silebilir&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore tek taraflı olarak &uuml;yenin &uuml;yeliğini silme, m&uuml;şteriye ait dosya, belge ve bilgileri silme hakkını saklı tutmaktadır.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore, s&ouml;zleşme&nbsp;değişiklikleri hakkında kullanıcılarını bilgilendirmemektedir&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore, &uuml;yelik s&ouml;zleşmesinin koşullarını &ldquo;hi&ccedil;bir şekil ve surette &ouml;n ihbara ve/veya ihtara gerek kalmaksızın&rdquo; her zaman tek taraflı olarak değiştirebileceğini belirtmektedir. S&ouml;zleşmede, değiştirilen h&uuml;k&uuml;mlerin yayın tarihinde t&uuml;m &uuml;yeler bakımından h&uuml;k&uuml;m ifade&nbsp;edeceği ifade edilmektedir.</p>\r\n<p>\r\n	<strong>&nbsp;ShoeARStore Android uygulaması kamera erişim izni istemektedir&nbsp;</strong></p>\r\n<p>\r\n	ShoeARStore Android uygulaması kurulabilmesi i&ccedil;in telefon kamerasına erişim izni istemektedir. Ancak g&uuml;ncel&nbsp;Android s&uuml;r&uuml;mleri, uygulama izinlerinin kullanıcı tarafından (uygulama taleplerinin aksine dahi olsa) değiştirilmesine imkan sağlamaktadır.</p>\r\n', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `useragreement`
--

CREATE TABLE IF NOT EXISTS `useragreement` (
  `Id` int(11) NOT NULL,
  `Agreement` longtext NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `useragreement`
--

INSERT INTO `useragreement` (`Id`, `Agreement`, `Status`) VALUES
(1, '<p>\r\n	<strong>&Uuml;YELİK S&Ouml;ZLEŞMESİ</strong></p>\r\n<p>\r\n	<strong>1. Taraflar</strong></p>\r\n<p>\r\n	<strong>a)</strong>&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesinin faaliyetlerini y&uuml;r&uuml;ten Kuştepe Mah. Mecidiyek&ouml;y Yolu Cad. Trump Towers Kule 2 Kat:2 No:12 34387 Şişli/İstanbul adresinde mukim D-Market Elektronik Hizmetler ve Ticaret A.Ş. (Bundan b&ouml;yle &ldquo;ShoeARStore&rdquo; olarak anılacaktır).</p>\r\n<p>\r\n	<strong>b)</strong>&nbsp;&nbsp;www.shoearstore.com&nbsp;&nbsp;&nbsp;internet sitesine &uuml;ye olan internet kullanıcısı (&quot;&Uuml;ye&quot;)</p>\r\n<p>\r\n	<strong>2. S&ouml;zleşmenin Konusu</strong></p>\r\n<p>\r\n	İşbu S&ouml;zleşme&rsquo;nin konusu ShoeARStore&rsquo;nın sahip olduğu internet sitesi&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&lsquo;dan &uuml;yenin faydalanma şartlarının belirlenmesidir.</p>\r\n<p>\r\n	<strong>3. Tarafların Hak ve Y&uuml;k&uuml;ml&uuml;l&uuml;kleri</strong></p>\r\n<p>\r\n	<strong>3.1.</strong>&nbsp;&nbsp;&Uuml;ye,&nbsp;&nbsp;www.shoearstore.com&nbsp;&nbsp;&nbsp;internet sitesine &uuml;ye olurken verdiği kişisel ve diğer sair bilgilerin kanunlar &ouml;n&uuml;nde doğru olduğunu, ShoeARStore&#39;nın bu bilgilerin ger&ccedil;eğe aykırılığı nedeniyle uğrayacağı t&uuml;m zararları aynen ve derhal tazmin edeceğini beyan ve taahh&uuml;t eder.</p>\r\n<p>\r\n	<strong>3.2.</strong>&nbsp;&nbsp;&Uuml;ye, ShoeARStore tarafından kendisine verilmiş olan şifreyi başka kişi ya da kuruluşlara veremez, &uuml;yenin s&ouml;zkonusu şifreyi kullanma hakkı bizzat kendisine aittir. Bu sebeple doğabilecek t&uuml;m sorumluluk ile &uuml;&ccedil;&uuml;nc&uuml; kişiler veya yetkili merciler tarafından ShoeARStore&#39;ya karşı ileri s&uuml;r&uuml;lebilecek t&uuml;m iddia ve taleplere karşı, ShoeARStore&#39;nın s&ouml;zkonusu izinsiz kullanımdan kaynaklanan her t&uuml;rl&uuml; tazminat ve sair talep hakkı saklıdır.</p>\r\n<p>\r\n	<strong>3.3.</strong>&nbsp;&nbsp;&Uuml;ye&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesini kullanırken yasal mevzuat h&uuml;k&uuml;mlerine riayet etmeyi ve bunları ihlal etmemeyi baştan kabul ve taahh&uuml;t eder. Aksi takdirde, doğacak t&uuml;m hukuki ve cezai y&uuml;k&uuml;ml&uuml;l&uuml;kler tamamen ve m&uuml;nhasıran &uuml;yeyi bağlayacaktır.</p>\r\n<p>\r\n	<strong>3.4.</strong>&nbsp;&nbsp;&Uuml;ye,&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesini hi&ccedil;bir şekilde kamu d&uuml;zenini bozucu, genel ahlaka aykırı, başkalarını rahatsız ve taciz edici şekilde, yasalara aykırı bir ama&ccedil; i&ccedil;in, başkalarının fikri ve telif haklarına tecav&uuml;z edecek şekilde kullanamaz. Ayrıca, &uuml;ye başkalarının hizmetleri kullanmasını &ouml;nleyici veya zorlaştırıcı faaliyet (spam, virus, truva atı, vb.) ve işlemlerde bulunamaz.</p>\r\n<p>\r\n	<strong>3.5.</strong>&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesinde &uuml;yeler tarafından beyan edilen, yazılan, kullanılan fikir ve d&uuml;ş&uuml;nceler, tamamen &uuml;yelerin kendi kişisel g&ouml;r&uuml;şleridir ve g&ouml;r&uuml;ş sahibini bağlar. Bu g&ouml;r&uuml;ş ve d&uuml;ş&uuml;ncelerin ShoeARStore&#39;yla hi&ccedil;bir ilgi ve bağlantısı yoktur. ShoeARStore&#39;nın &uuml;yenin beyan edeceği fikir ve g&ouml;r&uuml;şler nedeniyle &uuml;&ccedil;&uuml;nc&uuml; kişilerin uğrayabileceği zararlardan ve &uuml;&ccedil;&uuml;nc&uuml; kişilerin beyan edeceği fikir ve g&ouml;r&uuml;şler nedeniyle &uuml;yenin uğrayabileceği zararlardan dolayı herhangi bir sorumluluğu bulunmamaktadır.</p>\r\n<p>\r\n	<strong>3.6.</strong>&nbsp;&nbsp;ShoeARStore, &uuml;ye verilerinin yetkisiz kişilerce okunmasından ve &uuml;ye yazılım ve verilerine gelebilecek zararlardan dolayı sorumlu olmayacaktır. &Uuml;ye,&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesinin kullanılmasından dolayı uğrayabileceği herhangi bir zarar y&uuml;z&uuml;nden ShoeARStore&#39;dan tazminat talep etmemeyi peşinen kabul etmiştir.</p>\r\n<p>\r\n	<strong>3.7.</strong>&nbsp;&nbsp;&Uuml;ye, diğer internet kullanıcılarının yazılımlarına ve verilerine izinsiz olarak ulaşmamayı veya bunları kullanmamayı kabul etmiştir. Aksi takdirde, bundan doğacak hukuki ve cezai sorumluluklar tamamen &uuml;yeye aittir.</p>\r\n<p>\r\n	<strong>3.8.</strong>&nbsp;&nbsp;İşbu &uuml;yelik s&ouml;zleşmesi i&ccedil;erisinde sayılan maddelerden bir ya da birka&ccedil;ını ihlal eden &uuml;ye işbu ihlal nedeniyle cezai ve hukuki olarak şahsen sorumlu olup, ShoeARStore&rsquo;yı bu ihlallerin hukuki ve cezai sonu&ccedil;larından ari tutacaktır. Ayrıca; işbu ihlal nedeniyle, olayın hukuk alanına intikal ettirilmesi halinde, ShoeARStore&#39;nın &uuml;yeye karşı &uuml;yelik s&ouml;zleşmesinee uyulmamasından dolayı tazminat talebinde bulunma hakkı saklıdır.</p>\r\n<p>\r\n	<strong>3.9.</strong>&nbsp;&nbsp;ShoeARStore&#39;nın her zaman tek taraflı olarak gerektiğinde &uuml;yenin &uuml;yeliğini silme, m&uuml;şteriye ait dosya, belge ve bilgileri silme hakkı vardır. &Uuml;ye işbu tasarrufu &ouml;nceden kabul eder. Bu durumda, ShoeARStore&#39;nın hi&ccedil;bir sorumluluğu yoktur.</p>\r\n<p>\r\n	<strong>3.10.</strong>&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesi yazılım ve tasarımı ShoeARStore m&uuml;lkiyetinde olup, bunlara ilişkin telif hakkı ve/veya diğer fikri m&uuml;lkiyet hakları ilgili kanunlarca korunmakta olup, bunlar&nbsp;&nbsp;&uuml;ye tarafından izinsiz kullanılamaz, iktisap edilemez ve değiştirilemez. Bu web sitesinde adı ge&ccedil;en başkaca şirketler ve &uuml;r&uuml;nleri sahiplerinin ticari markalarıdır ve ayrıca fikri m&uuml;lkiyet hakları kapsamında korunmaktadır.</p>\r\n<p>\r\n	<strong>3.11.</strong>&nbsp;&nbsp;ShoeARStore tarafından&nbsp;&nbsp;<strong>www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesinin iyileştirilmesi, geliştirilmesine y&ouml;nelik olarak ve/veya yasal mevzuat &ccedil;er&ccedil;evesinde siteye erişmek i&ccedil;in kullanılan İnternet servis sağlayıcısının adı ve Internet Protokol (IP) adresi, Siteye erişilen tarih ve saat, sitede bulunulan sırada erişilen sayfalar ve siteye doğrudan bağlanılmasını sağlayan Web sitesinin Internet adresi gibi birtakım bilgiler toplanabilir.</p>\r\n<p>\r\n	<strong>3.12.</strong>&nbsp;&nbsp;ShoeARStore kullanıcılarına daha iyi hizmet sunmak, &uuml;r&uuml;nlerini ve hizmetlerini iyileştirmek, sitenin kullanımını kolaylaştırmak i&ccedil;in kullanımını kullanıcılarının &ouml;zel tercihlerine ve ilgi alanlarına y&ouml;nelik &ccedil;alışmalarda &uuml;yelerin kişisel bilgilerini kullanabilir. ShoeARStore, &uuml;yenin&nbsp;<strong>&nbsp;www.shoearstore.com</strong>&nbsp;&nbsp;&nbsp;internet sitesi &uuml;zerinde yaptığı hareketlerin kaydını bulundurma hakkını saklı tutar.</p>\r\n<p>\r\n	<strong>3.13.</strong>&nbsp;&nbsp;ShoeARStore&rsquo;ya&nbsp;&uuml;ye olan kişi, y&uuml;r&uuml;rl&uuml;kte bulunan ve/veya y&uuml;r&uuml;rl&uuml;ğe alınacak uygulamalar kapsamında ShoeARStore ve Doğan Online (DOL) iştiraki olan t&uuml;m şirketler tarafından&nbsp; kendisine &uuml;r&uuml;n ve hizmet tanıtımları, reklamlar, kampanyalar, avantajlar, anketler &nbsp;ve diğer m&uuml;şteri memnuniyeti uygulamaları sunulmasına izin verdiğini beyan ve kabul eder. &nbsp;&Uuml;ye, ShoeARStore&rsquo;ya &uuml;ye olurken ve/veya başka yollarla ge&ccedil;mişte vermiş olduğu ve/veya gelecekte vereceği kişisel ve alışveriş bilgilerinin ve alışveriş ve/veya t&uuml;ketici davranış bilgilerinin&nbsp; yukarıdaki ama&ccedil;larla toplanmasına, DOL &nbsp;iştiraki olan t&uuml;m şirketler ile paylaşılmasına, ShoeARStore ve DOL iştiraki olan t&uuml;m şirketler tarafından kullanılmasına ve arşivlenmesine izin verdiğini beyan ve kabul eder. &Uuml;ye aksini bildirmediği s&uuml;rece &nbsp;&uuml;yeliği sona erdiğinde de &nbsp;verilerin toplanmasına, DOL iştiraki olan t&uuml;m şirketler ile paylaşılmasına, ShoeARStore ve DOL iştiraki olan t&uuml;m şirketler tarafından kullanılmasına ve arşivlenmesine izin verdiğini beyan ve kabul eder. &Uuml;ye aksini bildirmediği &nbsp;s&uuml;rece ShoeARStore ve &nbsp;DOL iştiraki olan t&uuml;m şirketlerin&nbsp; kendisi ile &nbsp;internet, telefon, SMS, &nbsp;vb iletişim kanalları kullanarak irtibata ge&ccedil;mesine izin verdiğini beyan ve kabul eder. &Uuml;ye yukarıda bahsi ge&ccedil;en bilgilerin toplanması, &nbsp;paylaşılması, kullanılması, arşivlenmesi ve kendisine erişilmesi nedeniyle doğrudan ve/veya dolaylı maddi ve/veya manevi menfi ve/veya m&uuml;sbet, velhasıl herhangi bir zarara uğradığı konusunda talepte bulunmayacağını ve ShoeARStore ve DOL iştiraki olan şirketleri sorumlu tutmayacağını beyan ve kabul eder. &Uuml;ye veri paylaşım tercihlerini değiştirmek isterse, bu talebini ShoeARStore&rsquo;nın m&uuml;şteri hizmetleri &ccedil;ağrı merkezlerine &nbsp;iletebilir.</p>\r\n<p>\r\n	<strong>3.14.</strong>&nbsp;&nbsp;ShoeARStore, &uuml;yenin kişisel bilgilerini yasal bir zorunluluk olarak istendiğinde veya (a) yasal gereklere uygun hareket etmek veya ShoeARStore&rsquo;ya tebliğ edilen yasal işlemlere uymak; (b) ShoeARStore ve ShoeARStore web sitesi ailesinin haklarını ve m&uuml;lkiyetini korumak ve savunmak i&ccedil;in gerekli olduğuna iyi niyetle kanaat getirdiği hallerde a&ccedil;ıklayabilir.</p>\r\n<p>\r\n	<strong>3.15.</strong>&nbsp;&nbsp;ShoeARStore web sitesinin virus ve benzeri ama&ccedil;lı yazılımlardan arındırılmış olması i&ccedil;in mevcut imkanlar dahilinde tedbir alınmıştır. Bunun yanında nihai g&uuml;venliğin sağlanması i&ccedil;in kullanıcının, kendi virus koruma sistemini tedarik etmesi ve gerekli korunmayı sağlaması gerekmektedir. Bu bağlamda &uuml;ye ShoeARStore web sitesi&#39;ne girmesiyle, kendi yazılım ve işletim sistemlerinde oluşabilecek t&uuml;m hata ve bunların doğrudan ya da dolaylı sonu&ccedil;larından kendisinin sorumlu olduğunu kabul etmiş sayılır.</p>\r\n<p>\r\n	<strong>3.16.</strong>&nbsp;&nbsp;ShoeARStore, sitenin i&ccedil;eriğini dilediği zaman değiştirme, kullanıcılara sağlanan herhangi bir hizmeti değiştirme ya da sona erdirme veya ShoeARStore web sitesi&#39;nde kayıtlı kullanıcı bilgi ve verilerini silme hakkını saklı tutar.</p>\r\n<p>\r\n	<strong>3.17.</strong>&nbsp;&nbsp;ShoeARStore, &uuml;yelik s&ouml;zleşmesinin koşullarını hi&ccedil;bir şekil ve surette &ouml;n ihbara ve/veya ihtara gerek kalmaksızın her zaman değiştirebilir, g&uuml;ncelleyebilir veya iptal edebilir. Değiştirilen, g&uuml;ncellenen ya da y&uuml;r&uuml;rl&uuml;kten kaldırılan her h&uuml;k&uuml;m , yayın tarihinde t&uuml;m &uuml;yeler bakımından h&uuml;k&uuml;m ifade edecektir.</p>\r\n<p>\r\n	<strong>3.18.</strong>&nbsp;&nbsp;Taraflar, ShoeARStore&#39;ya ait t&uuml;m bilgisayar kayıtlarının tek ve ger&ccedil;ek m&uuml;nhasır delil olarak, HUMK madde 287&#39;ye uygun şekilde esas alınacağını ve s&ouml;z konusu kayıtların bir delil s&ouml;zleşmesi teşkil ettiği hususunu kabul ve beyan eder.</p>\r\n<p>\r\n	<strong>3.19.</strong>&nbsp;&nbsp;ShoeARStore, iş bu &uuml;yelik s&ouml;zleşmesi uyarınca, &uuml;yelerinin kendisinde kayıtlı elektronik posta adreslerine bilgilendirme mailleri ve cep telefonlarına bilgilendirme SMS&rsquo;leri g&ouml;nderme yetkisine sahip olmakla beraber, &uuml;ye işbu &uuml;yelik s&ouml;zleşmesini onaylamasıyla beraber bilgilendirme maillerinin elektronik posta adresine ve bilgilendirme SMS&rsquo;lerinin cep telefonuna g&ouml;nderilmesini kabul etmiş sayılacaktır. &Uuml;ye mail ve/veya SMS almaktan vazge&ccedil;mek istemesi durumunda &ldquo;Benim Sayfam&rdquo; b&ouml;l&uuml;m&uuml;ndeki &ldquo;Tercihlerim&rdquo; kısmından mail ve/veya SMS g&ouml;nderim iptal işlemini ger&ccedil;ekleştirebilecektir.</p>\r\n<p>\r\n	<strong>4. S&ouml;zleşmenin Feshi</strong></p>\r\n<p>\r\n	İşbu s&ouml;zleşme &uuml;yenin &uuml;yeliğini iptal etmesi veya ShoeARStore tarafından &uuml;yeliğinin iptal edilmesine kadar y&uuml;r&uuml;rl&uuml;kte kalacaktır. ShoeARStore &uuml;yenin &uuml;yelik s&ouml;zleşmesinin herhangi bir h&uuml;km&uuml;n&uuml; ihlal etmesi durumunda &uuml;yenin &uuml;yeliğini iptal ederek s&ouml;zleşmeyi tek taraflı olarak feshedebilecektir.</p>\r\n<p>\r\n	<strong>5. İhtilaflerin Halli</strong></p>\r\n<p>\r\n	İşbu s&ouml;zleşmeye ilişkin ihtilaflerde İstanbul Mahkemeleri ve İcra Daireleri yetkilidir.</p>\r\n<p>\r\n	<strong>6. Y&uuml;r&uuml;rl&uuml;k</strong></p>\r\n<p>\r\n	&Uuml;yenin, &uuml;yelik kaydı yapması &uuml;yenin &uuml;yelik s&ouml;zleşmesinde yer alan t&uuml;m maddeleri okuduğu ve &uuml;yelik s&ouml;zleşmesinde yer alan maddeleri kabul ettiği anlamına gelir. İşbu S&ouml;zleşme &uuml;yenin &uuml;ye olması anında akdedilmiş ve karşılıklı olarak y&uuml;r&uuml;rl&uuml;l&uuml;ğe girmiştir.</p>\r\n', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `userdeliveryadress`
--

CREATE TABLE IF NOT EXISTS `userdeliveryadress` (
  `Id` int(11) NOT NULL,
  `UserName` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `UserSurname` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `UserTelephone` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `AdressCountry` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `AdressCity` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `AdressDistrict` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `OpenAdress` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `AdressName` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `MemberShipId` int(11) NOT NULL,
  `Status` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `userdeliveryadress`
--

INSERT INTO `userdeliveryadress` (`Id`, `UserName`, `UserSurname`, `UserTelephone`, `AdressCountry`, `AdressCity`, `AdressDistrict`, `OpenAdress`, `AdressName`, `MemberShipId`, `Status`) VALUES
(1, 'Zekeriya', 'Topaloğlu', '05555555555', 'Türkiye', 'Konya', 'Karatay', 'Elpo Bilişim', 'İş', 8, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `userinvoiceadress`
--

CREATE TABLE IF NOT EXISTS `userinvoiceadress` (
  `Id` int(11) NOT NULL,
  `UserName` text COLLATE utf8_turkish_ci NOT NULL,
  `UserSurname` text COLLATE utf8_turkish_ci NOT NULL,
  `UserTelephone` text COLLATE utf8_turkish_ci NOT NULL,
  `AdressCountry` text COLLATE utf8_turkish_ci NOT NULL,
  `AdressCity` text COLLATE utf8_turkish_ci NOT NULL,
  `AdressDistrict` text COLLATE utf8_turkish_ci NOT NULL,
  `OpenAdress` text COLLATE utf8_turkish_ci NOT NULL,
  `AdressName` text COLLATE utf8_turkish_ci NOT NULL,
  `MemberShipId` int(11) NOT NULL,
  `CompanyName` text COLLATE utf8_turkish_ci,
  `CompanyTaxName` text COLLATE utf8_turkish_ci,
  `CompanyTaxNumber` text COLLATE utf8_turkish_ci,
  `Status` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `userinvoiceadress`
--

INSERT INTO `userinvoiceadress` (`Id`, `UserName`, `UserSurname`, `UserTelephone`, `AdressCountry`, `AdressCity`, `AdressDistrict`, `OpenAdress`, `AdressName`, `MemberShipId`, `CompanyName`, `CompanyTaxName`, `CompanyTaxNumber`, `Status`) VALUES
(3, 'Zeko', 'Topaloğlu', '0551112356', 'Türkiye', 'Konya', 'Selçuklu', 'Hacı Sadık Mah.', 'İş', 8, 'Elpo', 'Selçuk', '2564789', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `wishlist`
--

CREATE TABLE IF NOT EXISTS `wishlist` (
  `WishListId` int(11) NOT NULL,
  `MemberShipId` int(11) NOT NULL,
  `ProductStockCode` text COLLATE utf8_turkish_ci NOT NULL,
  `WishListStatus` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `wishlist`
--

INSERT INTO `wishlist` (`WishListId`, `MemberShipId`, `ProductStockCode`, `WishListStatus`) VALUES
(1, 8, '1020018655487', 1),
(2, 8, '2024036744660', 1),
(3, 8, '3025051635071', 1),
(4, 8, '2024037308868', -1),
(5, 10, '1020017587402', 1),
(6, 10, '1020017351715', -1),
(7, 11, '1020017587402', -1),
(8, 11, '1019022353149', -1),
(9, 11, '2022029326141', -1),
(10, 11, '2022029511475', 1),
(11, 11, '1019023447113', -1),
(12, 10, '3025046477936', -1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `aboutus`
--
ALTER TABLE `aboutus`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `brandimages`
--
ALTER TABLE `brandimages`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `categorybanner`
--
ALTER TABLE `categorybanner`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `maincategory`
--
ALTER TABLE `maincategory`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `ordercompleted`
--
ALTER TABLE `ordercompleted`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD UNIQUE KEY `OrdersId` (`OrdersId`);

--
-- Tablo için indeksler `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrdersId`);

--
-- Tablo için indeksler `paymentmethods`
--
ALTER TABLE `paymentmethods`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `productsimages`
--
ALTER TABLE `productsimages`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `siteproperties`
--
ALTER TABLE `siteproperties`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `slider`
--
ALTER TABLE `slider`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `socialmedias`
--
ALTER TABLE `socialmedias`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `stores`
--
ALTER TABLE `stores`
  ADD PRIMARY KEY (`StoreId`);

--
-- Tablo için indeksler `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `subsubcategory`
--
ALTER TABLE `subsubcategory`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `termsofuse`
--
ALTER TABLE `termsofuse`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `useragreement`
--
ALTER TABLE `useragreement`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `userdeliveryadress`
--
ALTER TABLE `userdeliveryadress`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `userinvoiceadress`
--
ALTER TABLE `userinvoiceadress`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`WishListId`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `aboutus`
--
ALTER TABLE `aboutus`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `brandimages`
--
ALTER TABLE `brandimages`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Tablo için AUTO_INCREMENT değeri `categorybanner`
--
ALTER TABLE `categorybanner`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Tablo için AUTO_INCREMENT değeri `comments`
--
ALTER TABLE `comments`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Tablo için AUTO_INCREMENT değeri `contact`
--
ALTER TABLE `contact`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `maincategory`
--
ALTER TABLE `maincategory`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Tablo için AUTO_INCREMENT değeri `managers`
--
ALTER TABLE `managers`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `membership`
--
ALTER TABLE `membership`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- Tablo için AUTO_INCREMENT değeri `ordercompleted`
--
ALTER TABLE `ordercompleted`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Tablo için AUTO_INCREMENT değeri `orders`
--
ALTER TABLE `orders`
  MODIFY `OrdersId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- Tablo için AUTO_INCREMENT değeri `paymentmethods`
--
ALTER TABLE `paymentmethods`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- Tablo için AUTO_INCREMENT değeri `productsimages`
--
ALTER TABLE `productsimages`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=185;
--
-- Tablo için AUTO_INCREMENT değeri `siteproperties`
--
ALTER TABLE `siteproperties`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `slider`
--
ALTER TABLE `slider`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Tablo için AUTO_INCREMENT değeri `socialmedias`
--
ALTER TABLE `socialmedias`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- Tablo için AUTO_INCREMENT değeri `stores`
--
ALTER TABLE `stores`
  MODIFY `StoreId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Tablo için AUTO_INCREMENT değeri `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- Tablo için AUTO_INCREMENT değeri `subsubcategory`
--
ALTER TABLE `subsubcategory`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- Tablo için AUTO_INCREMENT değeri `termsofuse`
--
ALTER TABLE `termsofuse`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `useragreement`
--
ALTER TABLE `useragreement`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `userdeliveryadress`
--
ALTER TABLE `userdeliveryadress`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `userinvoiceadress`
--
ALTER TABLE `userinvoiceadress`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Tablo için AUTO_INCREMENT değeri `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `WishListId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
