package thapelomasethe.co.za.pricingservice.costpricing;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Thapelo Masethe
 */
@Data
public class CostPlusPricingRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 4092570138136147061L;

    private BigDecimal totalCost;
    private Integer numberOfUnits;
    private BigDecimal markupPercentage;
}
