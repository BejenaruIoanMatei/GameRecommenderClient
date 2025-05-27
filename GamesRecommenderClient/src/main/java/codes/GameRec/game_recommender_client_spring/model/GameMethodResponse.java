package codes.GameRec.game_recommender_client_spring.model;

import java.util.List;

public class GameMethodResponse {
    private List<GameRecommendation> recommendations;
    private String error;

    public GameMethodResponse() {}

    public List<GameRecommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<GameRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "GameMethodResponse{" +
                "recommendations=" + recommendations +
                ", error='" + error + '\'' +
                '}';
    }
}
