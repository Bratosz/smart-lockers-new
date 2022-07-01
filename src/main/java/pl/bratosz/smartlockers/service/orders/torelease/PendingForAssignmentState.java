package pl.bratosz.smartlockers.service.orders.torelease;

public class PendingForAssignmentState implements ReleaseOrderState {

    @Override
    public ReleaseOrderStatus getStatus() {
        return ReleaseOrderStatus.PENDING_FOR_ASSIGNMENT;
    }
}
