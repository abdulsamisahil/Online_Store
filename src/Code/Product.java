package Code;

public class Product
{
    private int productId, supplierId, unitsInStock;
    private String productName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    private double basePrice;

    public Product(int productId, String productName, int supplierId, double basePrice, int unitsInStock) {
        this.productId = productId;
        this.supplierId = supplierId;
        this.unitsInStock = unitsInStock;
        this.productName = productName;
        this.basePrice = basePrice;
    }
}
