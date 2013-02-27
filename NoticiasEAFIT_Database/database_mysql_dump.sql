-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.24-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-02-21 22:39:19
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table noticias_eafit.comment
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_news` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_news_id_idx` (`id_news`),
  KEY `fk_comment_user_id_idx` (`id_user`),
  CONSTRAINT `fk_comment_news_id` FOREIGN KEY (`id_news`) REFERENCES `news` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user_id` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table noticias_eafit.comment: ~1 rows (approximately)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `id_news`, `id_user`, `date`, `comment`) VALUES
	(1, 1, 1, '2013-02-21 22:37:58', 'Eh.. he visto mejores aplicaciones...'),
	(2, 2, 1, '2013-02-21 22:38:46', 'Jajajaja! Se lo merecia!!');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- Dumping structure for table noticias_eafit.news
DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `brief` varchar(100) NOT NULL,
  `content` varchar(500) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table noticias_eafit.news: ~2 rows (approximately)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `title`, `brief`, `content`, `date`) VALUES
	(1, 'Nueva Aplicacion de Noticias en EAFIT!', 'Estudiantes crean una nueva apliacion de noticias en EAFIT.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sit amet nulla nisi. Mauris eu augue in massa vulputate porta euismod id dui. Quisque sed sem at velit fringilla euismod ut ac velit. Nunc diam elit, viverra vel porttitor sed, commodo eu erat. Nunc tortor diam, tincidunt non laoreet sed, ullamcorper et urna. Fusce malesuada augue a dolor vestibulum tempor. Sed auctor viverra placerat. In magna nunc, ornare vitae aliquet quis, consectetur id nisi.', '2013-02-21 22:32:32'),
	(2, 'Un estudiante fue atacado por un oso', 'El oso yogi escapo de su jaula sin comer en la mañana y ataco a un pobre estudiante.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sit amet nulla nisi. Mauris eu augue in massa vulputate porta euismod id dui. Quisque sed sem at velit fringilla euismod ut ac velit. Nunc diam elit, viverra vel porttitor sed, commodo eu erat. Nunc tortor diam, tincidunt non laoreet sed, ullamcorper et urna. Fusce malesuada augue a dolor vestibulum tempor. Sed auctor viverra placerat. In magna nunc, ornare vitae aliquet quis, consectetur id nisi.', '2013-02-21 22:34:21');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- Dumping structure for table noticias_eafit.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table noticias_eafit.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`) VALUES
	(1, 'anonymous', '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
