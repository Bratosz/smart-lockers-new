package pl.bratosz.smartlockers.service.orders.mainorder;

public class AcceptedMainOrderState implements MainOrderState {

    @Override
    public MainOrderStatus getStatus() {
       return MainOrderStatus.ACCEPTED;
    }


    @Override
    public void updateState(MainClothesOrder mainOrder) {

    }
}
