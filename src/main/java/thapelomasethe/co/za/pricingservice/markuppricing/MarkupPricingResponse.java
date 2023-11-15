package thapelomasethe.co.za.pricingservice.markuppricing;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Thapelo Masethe
 */
@Data
@Builder
public class MarkupPricingResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -6997930243470733475L;

    private BigDecimal markedUpPrice;
    private BigDecimal unitCost;
}
