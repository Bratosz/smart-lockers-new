package pl.bratosz.smartlockers.service.orders2;

public interface MyMainOrderState {
    MyMainOrderStatus getStatus();

    void updateState(MyMainOrder order);
}
