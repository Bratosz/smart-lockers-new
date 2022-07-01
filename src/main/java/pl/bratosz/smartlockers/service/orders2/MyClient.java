package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.model.orders.OrderType;

public class MyClient {
    public ExchangeStrategy getExchangeStrategy(OrderType orderType) {
        return ExchangeStrategy.PIECE_FOR_PIECE;
    }
}
