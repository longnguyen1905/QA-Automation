package api.market_place.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangePayload {
    String fromCurrency;
    String toCurrency;
    double amount;
    String requestId;
}
