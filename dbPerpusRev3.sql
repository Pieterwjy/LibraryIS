CREATE DATABASE dbPerpusRev3;
USE dbPerpusRev3;

CREATE TABLE tblAdmin(
	IdAdmin			INT				PRIMARY KEY		IDENTITY(1,1)	NOT NULL,
	NamaAdmin		VARCHAR(50)		NOT NULL,
	Password		VARCHAR(250)		NOT NULL,
	AlamatAdmin		VARCHAR(50)		NOT NULL,
	EmailAdmin		VARCHAR(50)		NOT NULL,
	TeleponAdmin	VARCHAR(50)		NOT NULL,
	Status			INT				DEFAULT(1)
);

CREATE TABLE tblPenyewa(
	IdPenyewa		INT			PRIMARY KEY		IDENTITY(1,1)	NOT NULL,
	NamaPenyewa		VARCHAR(50)	NOT NULL,
	AlamatPenyewa	VARCHAR(50)	NOT NULL,
	EmailPenyewa	VARCHAR(50)	NOT NULL,
	TeleponPenyewa	VARCHAR(50) NOT NULL,
	Status			INT			DEFAULT(1)
);

CREATE TABLE tblBuku(
	IdBuku			INT			PRIMARY KEY		IDENTITY(1,1)	NOT NULL,
	ISBN			VARCHAR(50)	NOT NULL,
	Judul			VARCHAR(50)	NOT NULL,
	Barcode			VARCHAR(50) NOT NULL,
	JumlahStok		INT			DEFAULT(0),
	Status			INT			DEFAULT(1)
);

CREATE TABLE tblSewa(
	IdSewa				INT		PRIMARY KEY				IDENTITY(1,1)						NOT NULL,
	IdAdmin				INT		FOREIGN KEY(IdAdmin)	REFERENCES tblAdmin(IdAdmin),
	IdPenyewa			INT		FOREIGN KEY(IdPenyewa)	REFERENCES tblPenyewa(IdPenyewa),
	TanggalSewa			DATE	NOT NULL,
	TanggalJatuhTempo	DATE	NOT NULL,
	IdBuku				INT		FOREIGN KEY(IdBuku)		REFERENCES tblBuku(IdBuku),
	Status				INT		DEFAULT(1)
);

--Trigger Pengurangan Stok Setelah Insert Record TblSewa
CREATE TRIGGER tblSewaInsert
ON tblSewa
AFTER INSERT
AS
UPDATE tblBuku
SET JumlahStok = (JumlahStok - 1)
FROM tblBuku,inserted
WHERE tblBuku.IdBuku = inserted.IdBuku;

--Trigger Penambahan Stok Setelah Status 0(Dikembalikan)
CREATE TRIGGER tblSewaUpdateIfStatus0
ON tblSewa
AFTER UPDATE
AS
UPDATE tblBuku
SET JumlahStok = (JumlahStok + 1)
FROM tblBuku,inserted
WHERE inserted.Status = 0 AND tblBuku.IdBuku = inserted.IdBuku;

--Trigger Pengurangan Stok Setelah Status 1(Ongoing)
CREATE TRIGGER tblSewaUpdateIfStatus1
ON tblSewa
AFTER UPDATE
AS
UPDATE tblBuku
SET JumlahStok = (JumlahStok - 1)
FROM tblBuku,inserted
WHERE inserted.Status = 1 AND tblBuku.IdBuku = inserted.IdBuku;


--Insert Initial Admin
INSERT INTO tblAdmin(NamaAdmin,Password,AlamatAdmin,EmailAdmin,TeleponAdmin)
VALUES('pieterwjy','$2y$12$ji3oj7LO9lQ1xXy6W1IdwOEeivw6I6HytX3UhAFxRddckiL1e8gdi','Manyar','pieterwjy@gmail.com','081357344611');

INSERT INTO tblSewa(IdAdmin,IdPenyewa,TanggalSewa,TanggalJatuhTempo,IdBuku)
VALUES(1,1,'20210115','20210116',1);

--Table
SELECT * FROM tblAdmin;
SELECT * FROM tblPenyewa;
SELECT * FROM tblBuku;
SELECT * FROM tblSewa;