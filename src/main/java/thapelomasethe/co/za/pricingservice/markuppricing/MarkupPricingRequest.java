package thapelomasethe.co.za.pricingservice.markuppricing;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Thapelo Masethe
 */
@Data
public class MarkupPricingRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -174609885867623540L;

    private BigDecimal totalCost;
    private Integer numberOfUnits;
    private BigDecimal desiredReturnPercentage;
}
