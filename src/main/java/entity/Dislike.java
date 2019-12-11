package entity;

public class Dislike {
    private final int user_id;
    private final int disliked_user_id;

    public Dislike(int user_id, int disliked_user_id) {
        this.user_id = user_id;
        this.disliked_user_id = disliked_user_id;
    }

    public int getDislikedUserId() {
        return disliked_user_id;
    }

    public int getUserId() {
        return user_id;
    }
}
