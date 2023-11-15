package thapelomasethe.co.za.pricingservice.markuppricing.impl;

import org.springframework.stereotype.Service;
import thapelomasethe.co.za.pricingservice.markuppricing.MarkupPricingRequest;
import thapelomasethe.co.za.pricingservice.markuppricing.MarkupPricingResponse;
import thapelomasethe.co.za.pricingservice.markuppricing.MarkupPricingService;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Thapelo Masethe
 */
@Service
public class MarkupPriceServiceImpl implements MarkupPricingService {

    @Override
    public MarkupPricingResponse determineMarkupPricing(MarkupPricingRequest request) {
        final BigDecimal unitCost = request.getTotalCost().divide(new BigDecimal(request.getNumberOfUnits()), 2, RoundingMode.HALF_UP);
        final BigDecimal percentage = BigDecimal.ONE.subtract(request.getDesiredReturnPercentage());
        final BigDecimal markedUpPrice = unitCost.divide(percentage, 2, RoundingMode.HALF_UP);
        return MarkupPricingResponse.builder().unitCost(unitCost).markedUpPrice(markedUpPrice).build();
    }
}
