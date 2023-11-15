package thapelomasethe.co.za.pricingservice.costpricing;

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
public class CostPlusPricingResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -8354447510177023121L;

    private BigDecimal unitCost;
    private BigDecimal markupPrice;
    private BigDecimal sellingPrice;
}
