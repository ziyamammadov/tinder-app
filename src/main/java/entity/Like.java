package entity;

public class Like {
    private final int user_id;
    private final int liked_user_id;

    public Like(int user_id, int liked_user_id) {
        this.user_id = user_id;
        this.liked_user_id = liked_user_id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getLikedUserId() {
        return liked_user_id;
    }
}
