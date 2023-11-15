package thapelomasethe.co.za.pricingservice.costpricing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Thapelo Masethe
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CostPlusPricingController {

    private final CostPlusPricingService costPlusPricingService;

    @GetMapping("/cost-plus-pricing")
    WebAsyncTask<ResponseEntity<CostPlusPricingResponse>> determineCostPlusPricing(@RequestBody CostPlusPricingRequest request) {
        final long startTime = System.currentTimeMillis();

        final WebAsyncTask<ResponseEntity<CostPlusPricingResponse>> webAsyncTask = new WebAsyncTask<>(() -> {
            try {
                return ResponseEntity.ok(costPlusPricingService.determineCostPlusPricing(request));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        });

        webAsyncTask.onCompletion(() -> {
            final String uriPath = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
            log.info("{} - took {} ms", uriPath, System.currentTimeMillis() - startTime);
        });

        return webAsyncTask;
    }
}
