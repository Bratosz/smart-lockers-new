package pl.bratosz.smartlockers.model.orders.parameters.newArticle;

import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.clothes.LengthModification;

public class OrderParametersForNewArticle {
    private long id;
    private long clientArticleId;
    private ClothSize size;
    private LengthModification lengthModification;
    private int quantity;

    public OrderParametersForNewArticle() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
