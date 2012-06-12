CREATE DATABASE Stock;

use Stock;

CREATE TABLE Stocks(
	StockCode varchar(15),
	CompanyName varchar(100),
	CurrentPrice varchar(25),
	TargetPrice varchar(25));


INSERT INTO Stocks VALUES("BANIND", "Bank Of India", "132", "388");
INSERT INTO Stocks VALUES("CADHEA", "Cadila Healthcare Limited", "412", "270");
INSERT INTO Stocks VALUES("CADIND", "Cadbury India Ltd.", "100", "88");
INSERT INTO Stocks VALUES("GRACOM", "SAREGAMA India Limited", "359", "170");
INSERT INTO Stocks VALUES("IFC", "IFCI Ltd.", "88", "150");
INSERT INTO Stocks VALUES("KEMIND", "Kemrock Industries and Exports Limited", "500", "1000");
INSERT INTO Stocks VALUES("POWGRI", "Power Grid Corporation Of India Ltd.", "100", "200");
INSERT INTO Stocks VALUES("RELNAT", "Reliance Natural Resources Limited", "100", "300");
INSERT INTO Stocks VALUES("RELPET", "Reliance Petroleum Ltd.", "100", "500");
INSERT INTO Stocks VALUES("SUZENE", "Suzlon Energy Limited", "1200", "2000");