-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_department_id` int(11) NOT NULL,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,2,'Football'),(2,2,'Soccer'),(3,2,'Baseball & Softball'),(4,2,'Basketball'),(5,2,'Lacrosse'),(6,2,'Tennis & Racquet'),(7,2,'Hockey'),(8,2,'More Sports'),(9,3,'Cardio Equipment'),(10,3,'Strength Training'),(11,3,'Fitness Accessories'),(12,3,'Boxing & MMA'),(13,3,'Electronics'),(14,3,'Yoga & Pilates'),(15,3,'Training by Sport'),(16,3,'As Seen on  TV!'),(17,4,'Cleats'),(18,4,'Men\'s Footwear'),(19,4,'Women\'s Footwear'),(20,4,'Kids\' Footwear'),(21,4,'Featured Shops'),(22,4,'Accessories'),(23,5,'Men\'s Apparel'),(24,5,'Women\'s Apparel'),(25,5,'Boys\' Apparel'),(26,5,'Girls\' Apparel'),(27,5,'Accessories'),(28,5,'Top Brands'),(29,5,'Shop By Sport'),(30,6,'Men\'s Golf Clubs'),(31,6,'Women\'s Golf Clubs'),(32,6,'Golf Apparel'),(33,6,'Golf Shoes'),(34,6,'Golf Bags & Carts'),(35,6,'Golf Gloves'),(36,6,'Golf Balls'),(37,6,'Electronics'),(38,6,'Kids\' Golf Clubs'),(39,6,'Team Shop'),(40,6,'Accessories'),(41,6,'Trade-In'),(42,7,'Bike & Skate Shop'),(43,7,'Camping & Hiking'),(44,7,'Hunting & Shooting'),(45,7,'Fishing'),(46,7,'Indoor/Outdoor Games'),(47,7,'Boating'),(48,7,'Water Sports'),(49,8,'MLB'),(50,8,'NFL'),(51,8,'NHL'),(52,8,'NBA'),(53,8,'NCAA'),(54,8,'MLS'),(55,8,'International Soccer'),(56,8,'World Cup Shop');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

