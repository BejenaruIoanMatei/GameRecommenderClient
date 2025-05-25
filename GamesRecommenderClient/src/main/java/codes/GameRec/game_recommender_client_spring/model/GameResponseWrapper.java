package codes.GameRec.game_recommender_client_spring.model;

public class GameResponseWrapper {
    private GameRecommendation nn;
    private GameRecommendation cosine;

    // Getters & setters
    public GameRecommendation getNn() {
        return nn;
    }

    public void setNn(GameRecommendation nn) {
        this.nn = nn;
    }

    public GameRecommendation getCosine() {
        return cosine;
    }

    public void setCosine(GameRecommendation cosine) {
        this.cosine = cosine;
    }
}
