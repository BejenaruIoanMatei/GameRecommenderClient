package codes.GameRec.game_recommender_client_spring.model;

import java.util.List;

public class GameRecommendation {
    private String input;
    private List<GameInfo> recommendations;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<GameInfo> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<GameInfo> recommendations) {
        this.recommendations = recommendations;
    }
}
