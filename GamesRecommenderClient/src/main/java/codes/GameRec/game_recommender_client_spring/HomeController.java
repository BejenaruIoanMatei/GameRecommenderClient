package codes.GameRec.game_recommender_client_spring;

import codes.GameRec.game_recommender_client_spring.model.GameRecommendation;
import codes.GameRec.game_recommender_client_spring.model.GameResponseWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam("title") String title, Model model) {
        String apiUrl = "http://127.0.0.1:8000/recommend/?title=" + title;
        System.out.println("Calling API: " + apiUrl); // DEBUG

        try {
            GameResponseWrapper response = restTemplate.getForObject(apiUrl, GameResponseWrapper.class);
            System.out.println("API Response: " + response); // DEBUG

            boolean nnHasError = response.getNn() != null && response.getNn().getError() != null;
            boolean cosineHasError = response.getCosine() != null && response.getCosine().getError() != null;

            if (nnHasError && cosineHasError) {
                model.addAttribute("error", "Game not found. Please try another title.");
            } else {
                List<GameRecommendation> nnRecs = nnHasError ? Collections.emptyList() : response.getNn().getRecommendations();
                List<GameRecommendation> cosineRecs = cosineHasError ? Collections.emptyList() : response.getCosine().getRecommendations();

                model.addAttribute("title", title);
                model.addAttribute("nnRecommendations", nnRecs);
                model.addAttribute("cosineRecommendations", cosineRecs);
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Failed to fetch recommendations.");
        }

        return "home";
    }

}
