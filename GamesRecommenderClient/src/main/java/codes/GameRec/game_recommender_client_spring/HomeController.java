package codes.GameRec.game_recommender_client_spring;

import codes.GameRec.game_recommender_client_spring.model.GameRecommendation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam("title") String title, Model model) {
        String apiUrl = "http://127.0.0.1:8000/recommend/cosine?title=" + title;

        try {
            GameRecommendation response = restTemplate.getForObject(apiUrl, GameRecommendation.class);
            model.addAttribute("title", response.getInput());
            model.addAttribute("recommendations", response.getRecommendations());
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch recommendations.");
        }

        return "home";
    }
}
