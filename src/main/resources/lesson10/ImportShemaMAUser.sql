--------------------------------------------------------
--  File created - �����������-������-13-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOYS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."BOYS" 
   (	"NM" NUMBER(*,0), 
	"NAME" VARCHAR2(20 BYTE), 
	"CITY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table COLORIS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."COLORIS" 
   (	"NM" VARCHAR2(50 BYTE), 
	"HAIR" VARCHAR2(50 BYTE), 
	"EYES" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CUSTOMERS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."CUSTOMERS" 
   (	"CUST_NUM" NUMBER(*,0), 
	"COMPANY" VARCHAR2(40 BYTE), 
	"CUST_REP" NUMBER(*,0), 
	"CREDIT_LIMIT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GIRLS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."GIRLS" 
   (	"NM" NUMBER(*,0), 
	"NAME" VARCHAR2(20 BYTE), 
	"CITY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OFFICES
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."OFFICES" 
   (	"OFFICE" NUMBER(*,0), 
	"CITY" VARCHAR2(40 BYTE), 
	"REGION" VARCHAR2(30 BYTE), 
	"MGR" NUMBER(*,0), 
	"TARGET" NUMBER, 
	"SALES" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."ORDERS" 
   (	"ORDER_NUM" NUMBER(*,0), 
	"ORDER_DATE" DATE, 
	"CUST" NUMBER(*,0), 
	"REP" NUMBER(*,0), 
	"MFR" VARCHAR2(3 BYTE), 
	"PRODUCT" VARCHAR2(5 BYTE), 
	"QTY" NUMBER(*,0), 
	"AMOUNT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCTS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."PRODUCTS" 
   (	"MFR_ID" VARCHAR2(3 BYTE), 
	"PRODUCT_ID" VARCHAR2(5 BYTE), 
	"DESCRIPTION" VARCHAR2(50 BYTE), 
	"PRICE" NUMBER, 
	"QTY_ON_HAND" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SALESREPS
--------------------------------------------------------

  CREATE TABLE "MA_STUDENT"."SALESREPS" 
   (	"EMPL_NUM" NUMBER(*,0), 
	"NAME" VARCHAR2(30 BYTE), 
	"AGE" NUMBER(*,0), 
	"REP_OFFICE" NUMBER(*,0), 
	"TITLE" VARCHAR2(40 BYTE), 
	"HIRE_DATE" DATE, 
	"MANAGER" NUMBER(*,0), 
	"QUOTA" NUMBER, 
	"SALES" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into MA_STUDENT.BOYS
SET DEFINE OFF;
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('1','John','Boston');
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('2','Henry','Boston');
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('3','George',null);
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('4','Sam','Chicago');
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('5','James','Dallas');
Insert into MA_STUDENT.BOYS (NM,NAME,CITY) values ('6','Bob','Seatle');
REM INSERTING into MA_STUDENT.COLORIS
SET DEFINE OFF;
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Samantha',null,null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Joanne',null,null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('George','Brown',null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Mary','Brown',null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Paula','Brown',null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Kevin','Brown',null);
Insert into MA_STUDENT.COLORIS (NM,HAIR,EYES) values ('Joel','Brown','Brown');
REM INSERTING into MA_STUDENT.CUSTOMERS
SET DEFINE OFF;
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2111','���� � ������','103','50,765');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2102','������� ���','101','65,345');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2103','������� �����������','105','50,455');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2123','������� ���','102','40,927');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2107','������� �����','110','35,645');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2115','��������� �������','101','20,988');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2101','�������� ����','106','65,887');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2112','��������','108','50,834');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2121','������','103','45,124');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2114','����������� �������','102','20,765');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2124','������ �������','107','40,855');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2108','��������� ������','109','55,323');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2117','��������� �����','106','35,324');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2122','����������','105','30,213');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2120','����������','102','50,126');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2106','������� �����������','102','65,902');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2119','������� ��������','109','25,356');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2118','������ �������','108','60,653');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2113','������� �����������','104','20,923');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2109','�������� ��������','103','25,634');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2105','������ �������','101','45,865');
Insert into MA_STUDENT.CUSTOMERS (CUST_NUM,COMPANY,CUST_REP,CREDIT_LIMIT) values ('2199','����� ����','120','150,876');
REM INSERTING into MA_STUDENT.GIRLS
SET DEFINE OFF;
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('2','Nancy',null);
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('3','Susan','Chicago');
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('4','Betty','Chicago');
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('5','Anne','Denver');
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('1','Mary','Boston');
Insert into MA_STUDENT.GIRLS (NM,NAME,CITY) values ('6','Sarah','Seatle');
REM INSERTING into MA_STUDENT.OFFICES
SET DEFINE OFF;
Insert into MA_STUDENT.OFFICES (OFFICE,CITY,REGION,MGR,TARGET,SALES) values ('22','�������������','�����','108','300','186,042');
Insert into MA_STUDENT.OFFICES (OFFICE,CITY,REGION,MGR,TARGET,SALES) values ('11','������� ��������','������','106','575','692,637');
Insert into MA_STUDENT.OFFICES (OFFICE,CITY,REGION,MGR,TARGET,SALES) values ('12','��������','������','104','800','735,044');
Insert into MA_STUDENT.OFFICES (OFFICE,CITY,REGION,MGR,TARGET,SALES) values ('13','��������','������','105','350','367,911');
Insert into MA_STUDENT.OFFICES (OFFICE,CITY,REGION,MGR,TARGET,SALES) values ('21','����������','�����','108','725','835,915');
REM INSERTING into MA_STUDENT.ORDERS
SET DEFINE OFF;
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112961',to_date('17.12.89','DD.MM.RR'),'2117','106','REI','2A44L','7','31,5');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113012',to_date('11.06.90','DD.MM.RR'),'2111','105','ACI','41003','35','3,745');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112989',to_date('03.06.90','DD.MM.RR'),'2101','106','FEA','114','6','1,458');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113051',to_date('10.02.90','DD.MM.RR'),'2118','108','QSA','XK47','4','1,42');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112968',to_date('12.10.89','DD.MM.RR'),'2102','101','ACI','41004','34','3,978');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113036',to_date('30.06.90','DD.MM.RR'),'2107','110','ACI','4100Z','9','22,5');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113045',to_date('02.02.90','DD.MM.RR'),'2112','108','REI','2A44R','10','45');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112963',to_date('17.12.89','DD.MM.RR'),'2103','105','ACI','41004','28','3,276');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113013',to_date('14.06.90','DD.MM.RR'),'2118','108','BIC','41003','1','652');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113058',to_date('23.02.90','DD.MM.RR'),'2108','109','FEA','112','10','1,478');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112997',to_date('08.06.90','DD.MM.RR'),'2124','107','BIC','41003','1','652');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112983',to_date('27.12.89','DD.MM.RR'),'2103','105','ACI','41004','6','702');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113024',to_date('20.06.90','DD.MM.RR'),'2114','108','QSA','XK47','20','7,1');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113062',to_date('24.02.90','DD.MM.RR'),'2124','107','FEA','114','10','2,43');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112979',to_date('12.10.89','DD.MM.RR'),'2114','102','ACI','4100Z','6','15');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113027',to_date('22.06.90','DD.MM.RR'),'2103','105','ACI','41002','54','4,104');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113007',to_date('08.06.90','DD.MM.RR'),'2112','108','IMM','773C','3','2,925');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113069',to_date('02.03.90','DD.MM.RR'),'2109','107','IMM','775C','22','31,35');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113034',to_date('29.06.90','DD.MM.RR'),'2107','110','REI','2A45C','8','632');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112922',to_date('04.11.89','DD.MM.RR'),'2118','108','ACI','41002','10','760');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112975',to_date('12.10.89','DD.MM.RR'),'2111','103','REI','2A44G','6','2,1');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113055',to_date('15.02.90','DD.MM.RR'),'2108','101','ACI','4100X','6','150');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113048',to_date('10.02.90','DD.MM.RR'),'2120','102','IMM','779C','2','3,75');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112993',to_date('04.06.89','DD.MM.RR'),'2106','102','REI','2A45C','24','1,896');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113065',to_date('27.02.89','DD.MM.RR'),'2106','102','QSA','XK47','6','2,13');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113003',to_date('25.06.90','DD.MM.RR'),'2108','109','IMM','779C','3','5,625');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113049',to_date('10.02.90','DD.MM.RR'),'2118','108','QSA','XK47','2','710');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('112987',to_date('31.12.89','DD.MM.RR'),'2103','105','ACI','4100Y','11','27,5');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113057',to_date('18.02.90','DD.MM.RR'),'2111','103','ACI','4100X','24','600,34');
Insert into MA_STUDENT.ORDERS (ORDER_NUM,ORDER_DATE,CUST,REP,MFR,PRODUCT,QTY,AMOUNT) values ('113042',to_date('02.02.90','DD.MM.RR'),'2113','101','REI','2A44R','5','22,5');
REM INSERTING into MA_STUDENT.PRODUCTS
SET DEFINE OFF;
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('REI','2A45C','����� �������������','79','210');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','4100Y','������� ���������','2,75','25');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('QSA','XK47','����� �����������','355','38');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('BIC','41672','������� ����������','180','0');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','779C','������� �����������','1875','9');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','41003','����� ����������','107','207');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','41004','����� �������������','117','139');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('BIC','41006','���������� ������','652','3');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','887P','�������� ������','250','24');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('QSA','XK48','����� �������','134','203');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('REI','2A44L','����� ����������','4500','12');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('FEA','112','���� ��������','148','115');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','887H','�������� ������������','54','223');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('BIC','41089','������ ��������','225','78');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','41001','����� ����������','55','277');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','775C','���������� �������','1425','5');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','4100Z','������� LG','2500','28');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('QSA','XK48A','������� ������','177','37');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','41002','����� ������','76','167');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('REI','2A44R','��������� SAMSUNG','4500','12');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','773C','�������� SONY','975','28');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('ACI','4100X','�������� �������','25','37');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('FEA','114','����������������','243','15');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('IMM','887X','��� �����������','475','32');
Insert into MA_STUDENT.PRODUCTS (MFR_ID,PRODUCT_ID,DESCRIPTION,PRICE,QTY_ON_HAND) values ('REI','2A44G','����� �������������','350','14');
REM INSERTING into MA_STUDENT.SALESREPS
SET DEFINE OFF;
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('105','���� ������','37','13','������ �������',to_date('12.02.88','DD.MM.RR'),'104','350','367,911');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('109','���� ���������','31','11','������ �������',to_date('12.10.89','DD.MM.RR'),'106','300','392,725');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('102','����� ��������','48','21','������ �������',to_date('10.12.86','DD.MM.RR'),'108','350','474,05');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('106','����� ������','52','11','����� ������',to_date('14.06.88','DD.MM.RR'),'108','275','299,912');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('104','������ ��������','33','12','������ �����',to_date('19.05.87','DD.MM.RR'),'106','200','142,594');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('101','����� ��������','45','12','������ �������',to_date('20.10.86','DD.MM.RR'),'104','300','305,673');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('110','���� ������','41','13','������ �������',to_date('13.05.90','DD.MM.RR'),'101','400','75,985');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('108','����� ������','62','21','������ �������',to_date('12.10.89','DD.MM.RR'),'106','350','361,865');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('103','���� �������','29','12','������ �������',to_date('01.03.87','DD.MM.RR'),'104','275','286,775');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('107','���� ��������','49','22','������� ���',to_date('14.11.88','DD.MM.RR'),'108','300','186,042');
Insert into MA_STUDENT.SALESREPS (EMPL_NUM,NAME,AGE,REP_OFFICE,TITLE,HIRE_DATE,MANAGER,QUOTA,SALES) values ('120','������ ������','37','12','������� ���',to_date('12.10.89','DD.MM.RR'),'108','400','386,042');
--------------------------------------------------------
--  DDL for Index PR_PRODUCTS
--------------------------------------------------------

  CREATE UNIQUE INDEX "MA_STUDENT"."PR_PRODUCTS" ON "MA_STUDENT"."PRODUCTS" ("PRODUCT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BOYS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."BOYS" ADD PRIMARY KEY ("NM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OFFICES
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."OFFICES" ADD PRIMARY KEY ("OFFICE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MA_STUDENT"."OFFICES" MODIFY ("SALES" NOT NULL ENABLE);
  ALTER TABLE "MA_STUDENT"."OFFICES" MODIFY ("REGION" NOT NULL ENABLE);
  ALTER TABLE "MA_STUDENT"."OFFICES" MODIFY ("CITY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."PRODUCTS" ADD CONSTRAINT "PR_PRODUCTS" PRIMARY KEY ("PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."ORDERS" ADD PRIMARY KEY ("ORDER_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SALESREPS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."SALESREPS" ADD PRIMARY KEY ("EMPL_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MA_STUDENT"."SALESREPS" MODIFY ("HIRE_DATE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."CUSTOMERS" ADD PRIMARY KEY ("CUST_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GIRLS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."GIRLS" ADD PRIMARY KEY ("NM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 81920 NEXT 57344 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."CUSTOMERS" ADD CONSTRAINT "CUSTOMERS_SALEREPS" FOREIGN KEY ("CUST_REP")
	  REFERENCES "MA_STUDENT"."SALESREPS" ("EMPL_NUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OFFICES
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."OFFICES" ADD CONSTRAINT "OFFICES_SALEREPS" FOREIGN KEY ("MGR")
	  REFERENCES "MA_STUDENT"."SALESREPS" ("EMPL_NUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."ORDERS" ADD CONSTRAINT "ORDERS_CUSTOMERS" FOREIGN KEY ("CUST")
	  REFERENCES "MA_STUDENT"."CUSTOMERS" ("CUST_NUM") ENABLE;
  ALTER TABLE "MA_STUDENT"."ORDERS" ADD CONSTRAINT "ORDERS_SALEREPS" FOREIGN KEY ("REP")
	  REFERENCES "MA_STUDENT"."SALESREPS" ("EMPL_NUM") ENABLE;
  ALTER TABLE "MA_STUDENT"."ORDERS" ADD CONSTRAINT "ORDER_PRODUCT" FOREIGN KEY ("PRODUCT")
	  REFERENCES "MA_STUDENT"."PRODUCTS" ("PRODUCT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SALESREPS
--------------------------------------------------------

  ALTER TABLE "MA_STUDENT"."SALESREPS" ADD CONSTRAINT "SALAREPS_OFFICES" FOREIGN KEY ("REP_OFFICE")
	  REFERENCES "MA_STUDENT"."OFFICES" ("OFFICE") ENABLE;
  ALTER TABLE "MA_STUDENT"."SALESREPS" ADD CONSTRAINT "SR_SR" FOREIGN KEY ("MANAGER")
	  REFERENCES "MA_STUDENT"."SALESREPS" ("EMPL_NUM") ENABLE;
