package banking.Observer;

import java.math.BigDecimal;

public interface Observer {
    void updateBalance(int rekeningId, BigDecimal newBalance);
}
