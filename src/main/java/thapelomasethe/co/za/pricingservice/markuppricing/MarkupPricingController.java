package thapelomasethe.co.za.pricingservice.markuppricing;

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
public class MarkupPricingController {

    private final MarkupPricingService markupPricingService;

    @GetMapping("/determine-markup-pricing")
    public WebAsyncTask<ResponseEntity<MarkupPricingResponse>> determineMarkupPricing(@RequestBody MarkupPricingRequest request) {
        final long startTime = System.currentTimeMillis();

        final WebAsyncTask<ResponseEntity<MarkupPricingResponse>> webAsyncTask = new WebAsyncTask<>(() -> {
           try {
               return ResponseEntity.ok(markupPricingService.determineMarkupPricing(request));
           } catch (Exception e) {
               log.error(e.getMessage(), e);
               return ResponseEntity.internalServerError().build();
           }
        });

        webAsyncTask.onCompletion(() -> {
            final String uriPath = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
            log.info("{} took {} ms", uriPath, System.currentTimeMillis() - startTime);
        });

        return webAsyncTask;
    }
}
