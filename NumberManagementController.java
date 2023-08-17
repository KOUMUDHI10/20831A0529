import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class NumberManagementController {

    @GetMapping("/numbers")
    public NumberResponse getMergedNumbers(@RequestParam List<String> url) {
        Set<Integer> mergedNumbers = new HashSet<>();

        RestTemplate restTemplate = new RestTemplate();

        for (String apiUrl : url) {
            try {
                NumberResponse response = restTemplate.getForObject(apiUrl, NumberResponse.class);
                if (response != null && response.getNumbers() != null) {
                    mergedNumbers.addAll(response.getNumbers());
                }
            } catch (Exception e) {
                // Ignore URL if it takes too long to respond
            }
        }

        return new NumberResponse(new HashSet<>(mergedNumbers));
    }
}
