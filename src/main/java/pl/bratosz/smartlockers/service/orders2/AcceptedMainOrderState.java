package pl.bratosz.smartlockers.service.orders2;

public class AcceptedMainOrderState implements MyMainOrderState {
    private final MyMainOrder order;

    public AcceptedMainOrderState(MyMainOrder order) {
        this.order = order;
    }

    @Override
    public MyMainOrderStatus getStatus() {
       return MyMainOrderStatus.ACCEPTED;
    }


    @Override
    public void updateState() {

    }
}
