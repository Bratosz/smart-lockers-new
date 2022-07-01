package pl.bratosz.smartlockers.service.orders.torelease;

import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.state.PendingForAssignmentOrderState;

import java.util.LinkedList;
import java.util.List;

public class ClothReleaseOrder {

    private ReleaseOrderState actualState;
    private MainClothesOrder mainOrder;
    private List<ReleaseOrderStatusExtended> statusHistory;
    private ClothDomain clothToRelease;

    public static ClothReleaseOrder create(ClothDomain c, MainClothesOrder m, User u) {
        ClothReleaseOrder o = new ClothReleaseOrder();
        o.mainOrder = m;
        o.createStatus(u);
        o.setClothToRelease(c);
        return o;
    }

    private void setClothToRelease(ClothDomain c) {
        clothToRelease = c;
    }

    private void createStatus(User u) {
        if(statusHistory == null) statusHistory = new LinkedList<>();
        statusHistory.add(new ReleaseOrderStatusExtended(actualState.getStatus(), u));
    }

    public ClothReleaseOrder() {
        actualState = new PendingForAssignmentState();
    }
}
