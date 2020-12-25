/**Creating database and tables that are useful in implementing an online store**/
create database online_store; 

/**Tables**/
create table suppliers 
(
	SupplierId INT IDENTITY, 
	CompanyName varchar (30) Not null, 
	phone varchar (10) Not Null, 
	Address varchar (100) Not null, 

	Primary key (SupplierId)
);

create table Product 
(
	ProductId int Identity,
	ProductName nvarchar(50),
	SupplierId int, 
	basePrice decimal(12,2), 
	unitsInStock int, 

	Primary key (ProductId), 
	Foreign Key (SupplierId) References suppliers(SupplierId)
); 

create table app_user  
(
	userId int Identity, 
	Firstname nvarchar(40), 
	Lastname nvarchar(40), 
	Email	nvarchar(50), 
	Address nvarchar(50), 
	City	nvarchar(50), 
	Country nvarchar(50), 
	Phone	varchar(50), 
	Role	varchar(50), 
	username char(60), 
	password char(60), 

	Primary key (userId)
); 

create table tbl_Order 
(
	OrderId int Identity, 
	OrderNumber nvarchar(10), 
	userId int, 
	OrderDate datetime, 
	TotalAmount decimal (12,2), 
	Discount varchar(50), 

	Primary key (OrderId), 
	Foreign key (userId) References app_user(userId)
);

create table OderItem 
(
	OrderId int, 
	ProductId int, 

	UnitPrice decimal (12,2), 
	Quantity int, 

	CONSTRAINT [PK_OrderItem] PRIMARY KEY CLUSTERED ([OrderId] ASC, [ProductId] ASC),
	FOREIGN KEY (OrderId) References tbl_Order(OrderId), 
	FOREIGN KEY (ProductId) References Product(ProductId)
); 