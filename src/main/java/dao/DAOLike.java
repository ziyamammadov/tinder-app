package dao;

import database.DBOperation;
import entity.Like;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLike {
    private List<Like> likes;

    public DAOLike() {
        this.likes = new ArrayList<>();
    }

    public List<Like> getAll() {
        try {
            this.likes = DBOperation.get_all_likes();
        } catch (SQLException e) {
            likes = new ArrayList<>();
        }
        return likes;
    }

    public void addLike(Like like) {
        try {
            DBOperation.insert_like(like);
        } catch (SQLException ignored) {
        }
    }
}
