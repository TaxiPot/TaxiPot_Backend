package kr.hs.dsm.java.taxipot_backend.batch;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import org.springframework.batch.item.ItemProcessor;

public class TaxipotItemProcessor implements ItemProcessor<TaxiPot, TaxiPot> {
    @Override
    public TaxiPot process(TaxiPot taxiPot) throws Exception {
        return taxiPot;
    }
}
