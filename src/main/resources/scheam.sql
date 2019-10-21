CREATE DATABASE  IF NOT EXISTS `test`;
USE `test`;

DROP TABLE IF EXISTS `patientmemberrecord`;
DROP TABLE IF EXISTS `patient`;
DROP TABLE IF EXISTS `address`;
--
-- Table structure for table `patient`
--


CREATE TABLE `patient` (
`enterpriseid` int(11) unsigned NOT NULL AUTO_INCREMENT,
`enterprisename` varchar(255),
PRIMARY KEY (`enterpriseId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
`addressid` int(11) unsigned NOT NULL AUTO_INCREMENT,
`addressline1` varchar(255) DEFAULT NULL,
`addressline2` varchar(255) DEFAULT NULL,
`city` varchar(255) DEFAULT NULL,
`state` varchar(255) DEFAULT NULL,
`zipcode` varchar(255) DEFAULT NULL,
PRIMARY KEY (`addressid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Table structure for table `book`
--


CREATE TABLE `patientmemberrecord` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`source` varchar(255) DEFAULT NULL,
`medicalrecordnumber` varchar(255) DEFAULT NULL,
`firstname` varchar(255) DEFAULT NULL,
`lastname` varchar(255) DEFAULT NULL,
`socialsecuritynumber` varchar(255) DEFAULT NULL,
`pmr_patient_id` int(11) unsigned DEFAULT NULL,
`pmr_address_id` int(11) unsigned DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_pmr_patientid` (`pmr_patient_id`),
CONSTRAINT `fk_pmr_patientid` FOREIGN KEY (`pmr_patient_id`) REFERENCES `patient` (`enterpriseId`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `fk_pmr_addressid` (`pmr_address_id`),
CONSTRAINT `fk_pmr_addressid` FOREIGN KEY (`pmr_address_id`) REFERENCES `address` (`addressid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('1', 'Address 1', 'Address 1.2', 'City 1', 'State 1', 'zipcode 1');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('2', 'Address 2', 'Address 2.2', 'City 2', 'State 2', 'zipcode 2');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('3', 'Address 3', 'Address 3.2', 'City 3', 'State 3', 'zipcode 3');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('4', 'Address 4', 'Address 4.2', 'City 4', 'State 4', 'zipcode 4');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('5', 'Address 5', 'Address 5.2', 'City 5', 'State 5', 'zipcode 5');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('6', 'Address 6', 'Address 6.2', 'City 6', 'State 6', 'zipcode 6');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('7', 'Address 7', 'Address 7.2', 'City 7', 'State 7', 'zipcode 7');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('8', 'Address 8', 'Address 8.2', 'City 8', 'State 8', 'zipcode 8');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('9', 'Address 9', 'Address 9.2', 'City 9', 'State 9', 'zipcode 9');
INSERT INTO `test`.`address` (`addressid`, `addressline1`, `addressline2`, `city`, `state`, `zipcode`) VALUES ('10', 'Address 10', 'Address 10.2', 'City 10', 'State 10', 'zipcode 10');


INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('1', 'Enterprise 1');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('2', 'Enterprise 2');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('3', 'Enterprise 3');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('4', 'Enterprise 4');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('5', 'Enterprise 5');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('6', 'Enterprise 6');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('7', 'Enterprise 7');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('8', 'Enterprise 8');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('9', 'Enterprise 9');
INSERT INTO `test`.`patient` (`enterpriseid`, `enterprisename`) VALUES ('10', 'Enterprise 10');



INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('1', 'source1', 'record1', 'first1', 'last1', 'ssn1', '1', '1');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('2', 'source2', 'record2', 'first2', 'last2', 'ssn2', '2', '2');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('3', 'source3', 'record3', 'first3', 'last3', 'ssn3', '3', '3');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('4', 'source4', 'record4', 'first4', 'last4', 'ssn4', '4', '4');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('5', 'source5', 'record5', 'first5', 'last5', 'ssn5', '5', '5');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('6', 'source6', 'record6', 'first6', 'last6', 'ssn6', '6', '6');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('7', 'source7', 'record7', 'first7', 'last7', 'ssn7', '7', '7');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('8', 'source8', 'record8', 'first8', 'last8', 'ssn8', '8', '8');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('9', 'source9', 'record9', 'first9', 'last9', 'ssn9', '9', '9');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`, `pmr_address_id`) VALUES ('10', 'source10', 'record10', 'first10', 'last10', 'ssn10', '10', '10');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('11', 'source11', 'record11', 'first11', 'last11', 'ssn11', '1');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('12', 'source12', 'record12', 'first12', 'last12', 'ssn12', '2');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('13', 'source13', 'record13', 'first13', 'last13', 'ssn13', '3');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('14', 'source14', 'record14', 'first14', 'last14', 'ssn14', '4');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('15', 'source15', 'record15', 'first15', 'last15', 'ssn15', '5');
INSERT INTO `test`.`patientmemberrecord` (`id`, `source`, `medicalrecordnumber`, `firstname`, `lastname`, `socialsecuritynumber`, `pmr_patient_id`) VALUES ('16', 'source16', 'record16', 'first16', 'last16', 'ssn16', '6');

