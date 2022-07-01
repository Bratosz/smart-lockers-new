package pl.bratosz.smartlockers.service.orders;

import pl.bratosz.smartlockers.model.clothes.ClothStatusHistory;
import pl.bratosz.smartlockers.model.clothes.LifeCycleStatus;
import pl.bratosz.smartlockers.service.orders.torelease.ClothReleaseOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.state.ClothReturnOrder;

import java.util.List;

public class ClothDomain {

    private long id;
    private int ordinalNumber;
    private List<ClothStatusHistory> statusHistory;
    private ClothReturnOrder returnOrder;
    private ClothReleaseOrder releaseOrder;

    public ClothReturnOrder getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(ClothReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
    }

    public ClothStatusHistory getClothStatus() {
        if(statusHistory == null) return new ClothStatusHistory();
        return statusHistory.get(statusHistory.size() - 1);
    }

    public LifeCycleStatus getLifeCycleStatus() {
        if(statusHistory == null || statusHistory.isEmpty()) return LifeCycleStatus.UNKNOWN;
        return statusHistory.get(statusHistory.size() - 1).getStatus().getLifeCycleStatus();
    }

    public ClothReleaseOrder getReleaseOrder() {
        return releaseOrder;
    }
}
