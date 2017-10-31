CREATE TABLE `clients` (
  `idClients` int(11) NOT NULL,
  `Username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClients`),
  KEY `CliUsernameFor_idx` (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `company` (
  `idcomp` int(33) NOT NULL AUTO_INCREMENT,
  `customerPhone` varchar(33) NOT NULL,
  `fname` varchar(33) NOT NULL,
  `lastName` varchar(33) NOT NULL,
  `phone` varchar(33) NOT NULL,
  PRIMARY KEY (`idcomp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `currencies` (
  `iso_code` varchar(3) CHARACTER SET utf8 NOT NULL,
  `symbol` varchar(6) CHARACTER SET utf8 NOT NULL,
  `unicode` varchar(32) CHARACTER SET utf8 NOT NULL,
  `position` varchar(6) CHARACTER SET utf8 NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`iso_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer` (
  `idcustomer` int(33) NOT NULL AUTO_INCREMENT,
  `fname` varchar(33) NOT NULL,
  `lname` varchar(33) NOT NULL,
  `company` varchar(33) NOT NULL,
  `phone` varchar(33) NOT NULL,
  `str1` varchar(33) NOT NULL,
  `str2` varchar(33) NOT NULL,
  `city` varchar(33) NOT NULL,
  `state` varchar(33) NOT NULL,
  `zip` varchar(33) NOT NULL,
  `country` varchar(33) NOT NULL,
  `fax` varchar(33) NOT NULL,
  `type` varchar(33) NOT NULL,
  `picture` varchar(333) NOT NULL,
  PRIMARY KEY (`idcustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmployee`),
  KEY `Usernamefor_idx` (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `extra` (
  `idextra` int(33) NOT NULL AUTO_INCREMENT,
  `name` varchar(33) NOT NULL,
  `qty` int(33) NOT NULL,
  `price` decimal(33,0) NOT NULL,
  `description` varchar(33) NOT NULL,
  `date` varchar(33) NOT NULL,
  PRIMARY KEY (`idextra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `family` (
  `idfam` int(33) NOT NULL AUTO_INCREMENT,
  `customerPhone` varchar(33) NOT NULL,
  `fname` varchar(33) NOT NULL,
  `lastName` varchar(33) NOT NULL,
  `phone` varchar(33) NOT NULL,
  PRIMARY KEY (`idfam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `invoice` (
  `idpurchase` int(11) NOT NULL AUTO_INCREMENT,
  `invno` varchar(45) DEFAULT NULL,
  `custcode` varchar(45) DEFAULT NULL,
  `datevar` varchar(45) DEFAULT NULL,
  `item` varchar(45) DEFAULT NULL,
  `qty` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `curr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpurchase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `item_group` (
  `iditem_group` int(11) NOT NULL AUTO_INCREMENT,
  `GroupId` varchar(45) NOT NULL,
  `GroupDesc` varchar(300) DEFAULT NULL,
  `GroupType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iditem_group`,`GroupId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `items` (
  `iditems` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(45) DEFAULT NULL,
  `item_name` varchar(305) DEFAULT NULL,
  `item_barcode` varchar(45) DEFAULT NULL,
  `item_supp` varchar(45) DEFAULT NULL,
  `item_orig_price` float DEFAULT NULL,
  `item_qty` float DEFAULT NULL,
  `item_group` varchar(45) DEFAULT NULL,
  `Itemscol` varchar(45) DEFAULT NULL,
  `item_pic` varchar(305) DEFAULT NULL,
  `itemscateg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iditems`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `purchase` (
  `idpurchase` int(11) NOT NULL AUTO_INCREMENT,
  `pivno` varchar(45) DEFAULT NULL,
  `suppcode` varchar(45) DEFAULT NULL,
  `datevar` varchar(45) DEFAULT NULL,
  `item` varchar(45) DEFAULT NULL,
  `qty` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `curr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpurchase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rate` (
  `idrate` int(11) NOT NULL AUTO_INCREMENT,
  `fromCurr` varchar(45) DEFAULT NULL,
  `toCurr` varchar(45) DEFAULT NULL,
  `ratevalue` float DEFAULT NULL,
  `operation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `salesman` (
  `idsalesman` int(33) NOT NULL AUTO_INCREMENT,
  `fname` varchar(33) NOT NULL,
  `lname` varchar(33) NOT NULL,
  `company` varchar(33) NOT NULL,
  `phone` varchar(33) NOT NULL,
  `str1` varchar(33) NOT NULL,
  `str2` varchar(33) NOT NULL,
  `city` varchar(33) NOT NULL,
  `state` varchar(33) NOT NULL,
  `zip` varchar(33) NOT NULL,
  `country` varchar(33) NOT NULL,
  `fax` varchar(33) NOT NULL,
  `type` varchar(33) NOT NULL,
  `picture` varchar(333) NOT NULL,
  PRIMARY KEY (`idsalesman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `supplier` (
  `idssupp` int(33) NOT NULL AUTO_INCREMENT,
  `fname` varchar(33) NOT NULL,
  `lname` varchar(33) NOT NULL,
  `company` varchar(33) NOT NULL,
  `phone` varchar(33) NOT NULL,
  `str1` varchar(33) NOT NULL,
  `str2` varchar(33) NOT NULL,
  `city` varchar(33) NOT NULL,
  `state` varchar(33) NOT NULL,
  `zip` varchar(33) NOT NULL,
  `country` varchar(33) NOT NULL,
  `fax` varchar(33) NOT NULL,
  `type` varchar(33) NOT NULL,
  `picture` varchar(333) NOT NULL,
  PRIMARY KEY (`idssupp`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

CREATE TABLE `transaction` (
  `idtransaction` int(33) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(33) NOT NULL,
  `qty` int(33) NOT NULL,
  `price` decimal(33,0) NOT NULL,
  `date` varchar(33) NOT NULL,
  `time` varchar(33) NOT NULL,
  `invoiceNum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtransaction`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `idUsers` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(300) DEFAULT NULL,
  `Address` text,
  `Phone` varchar(45) DEFAULT NULL,
  `Mobile` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `login_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsers`,`Username`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
