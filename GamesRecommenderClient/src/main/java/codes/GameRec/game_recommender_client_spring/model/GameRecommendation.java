package codes.GameRec.game_recommender_client_spring.model;

public class GameRecommendation {
    private String name;
    private String image;

    public GameRecommendation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
