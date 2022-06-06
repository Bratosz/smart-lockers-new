package pl.bratosz.smartlockers.model.orders.parameters.newArticle;

import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.clothes.LengthModification;
import pl.bratosz.smartlockers.model.orders.OrderType;

public class OrderParameters {
    private long articlesWithQuantityId;
    private long clientArticleId;
    private ClothSize size;
    private LengthModification lengthModification;
    private int quantity;
    private long employeeId;
    private OrderType orderType;
    private long [] barcodes;

    public OrderParameters() {
    }

    public long getClientArticleId() {
        return clientArticleId;
    }

    public void setClientArticleId(long clientArticleId) {

        this.clientArticleId = clientArticleId;
    }

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
    }

    public LengthModification getLengthModification() {
        return lengthModification;
    }

    public void setLengthModification(LengthModification lengthModification) {
        this.lengthModification = lengthModification;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getArticlesWithQuantityId() {
        return articlesWithQuantityId;
    }

    public void setArticlesWithQuantityId(long articlesWithQuantityId) {
        this.articlesWithQuantityId = articlesWithQuantityId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long[] getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(long[] barcodes) {
        this.barcodes = barcodes;
    }
}
