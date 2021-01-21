/**
Only products that have not been sold yet can be deleted, trigger! 
**/
CREATE TRIGGER deleteProducts ON Products
FOR DELETE AS

IF(SELECT QuantitySold FROM deleted) != 0
BEGIN
RAISERROR('Only 0 sold products allowed to delete', 16, 1)
ROLLBACK
END
GO

Select * from Products


Delete from Products 
where Product_Id = 3301; 

update Products 
Set QuantitySold = 2
Where Name = 'Samsung S8'; 