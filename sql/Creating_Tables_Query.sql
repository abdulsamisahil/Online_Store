Use Application_3_onlinestore
Create table Customer 
( 
	Customer_Id bigint, 
	Firstname nvarchar(50) NOT Null, 
	Lastname nvarchar (50) NOT Null, 
	Email nvarchar (50) NOT NULL, 
	Phone decimal (10,0), 
	Country char (30),
	City char (30), 
	Street varchar(60),

	Primary key (Customer_Id)
); 

Create table Orders 
(
	Order_Id bigint, 
	Customer_Id bigint, 
	Confirmed char (10), 
	Date Date, 
	Time Time, 

	Primary key (Order_Id), 
	Foreign key (Customer_Id) references Customer(Customer_Id)
); 

Create table Supplier 
(
	Name varchar (30), 
	Phone decimal (10,0), 
	Address nvarchar(100), 

	Primary key (Name)

); 

Create table Products 
(
	Product_Id bigint, 
	Name varchar(30), 
	Supplier varchar(30), 
	Base_Price money, 
	Quantity int

	Primary key (Product_Id), 
	Foreign key (Supplier) references Supplier (Name)
	
); 

Create table Products_In_Order
(
	Order_Id bigint Foreign key references Orders(Order_Id), 
	Product_Id bigint Foreign key references Products (Product_Id), 

); 

Create table Discount 
(	
	Discount_Id int, 
	Description nvarchar(50), 
	Percentage decimal (5,4), 
	Primary key(Discount_Id)

); 

Create table Product_Discount 
(
	Product_Id bigint Primary Key, 
	Discount_Id int Foreign key references Discount (Discount_Id), 
	Start_Date Date, 
	End_Date Date, 
); 