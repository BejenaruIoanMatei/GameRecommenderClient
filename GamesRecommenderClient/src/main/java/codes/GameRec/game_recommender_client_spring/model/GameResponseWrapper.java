package codes.GameRec.game_recommender_client_spring.model;

public class GameResponseWrapper {
    private GameMethodResponse nn;
    private GameMethodResponse cosine;

    public GameMethodResponse getNn() {
        return nn;
    }

    public void setNn(GameMethodResponse nn) {
        this.nn = nn;
    }

    public GameMethodResponse getCosine() {
        return cosine;
    }

    public void setCosine(GameMethodResponse cosine) {
        this.cosine = cosine;
    }
}
