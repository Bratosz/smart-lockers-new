package pl.bratosz.smartlockers.service.orders2;

import java.util.Set;

public class MyEmployee {
    private long id;
    private Set<MyMainOrder> mainOrders;

    public long getId() {
        return id;
    }

    public Set<MyMainOrder> getMainOrders() {
        return mainOrders;
    }
}
