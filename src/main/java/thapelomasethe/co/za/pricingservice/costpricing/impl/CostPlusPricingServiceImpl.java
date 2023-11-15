package thapelomasethe.co.za.pricingservice.costpricing.impl;

import org.springframework.stereotype.Service;
import thapelomasethe.co.za.pricingservice.costpricing.CostPlusPricingRequest;
import thapelomasethe.co.za.pricingservice.costpricing.CostPlusPricingResponse;
import thapelomasethe.co.za.pricingservice.costpricing.CostPlusPricingService;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Thapelo Masethe
 */
@Service
public class CostPlusPricingServiceImpl implements CostPlusPricingService {

    @Override
    public CostPlusPricingResponse determineCostPlusPricing(final CostPlusPricingRequest request) {
        final BigDecimal unitCost = request.getTotalCost()
                .divide(new BigDecimal(request.getNumberOfUnits()), 2, RoundingMode.HALF_UP);
        final BigDecimal markupPrice = unitCost.multiply(request.getMarkupPercentage());
        final BigDecimal sellingPrice = unitCost.add(markupPrice);

        return CostPlusPricingResponse.builder()
                .unitCost(unitCost)
                .markupPrice(markupPrice)
                .sellingPrice(sellingPrice).build();
    }
}
