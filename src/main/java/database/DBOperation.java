package database;

import entity.Dislike;
import entity.Like;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOperation {
    public static List<User> get_all_users() throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "select * from users";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String email = outcome.getString("email");
            String name = outcome.getString("name");
            String surname = outcome.getString("surname");
            String password = outcome.getString("password");
            String picture_url = outcome.getString("picture_url");
            users.add(new User(id, email, name, surname, password,picture_url));
        }
        return users;
    }

    public static List<User> getLikedUsers(int user_id) throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "select distinct  u.*  from users u  where u.id  in(select liked_user_id from likes where user_id=" + user_id + ")";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String email = outcome.getString("email");
            String name = outcome.getString("name");
            String surname = outcome.getString("surname");
            String password = outcome.getString("password");
            String picture_url = outcome.getString("picture_url");
            users.add(new User(id, email, name, surname, password,picture_url));
        }
        return users;
    }

    public static void insert_user(User user) throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "insert into users (email, name, surname, password, picture_url) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getSurname());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getPictureUrl());
        stmt.execute();
    }

    public static List<Like> get_all_likes() throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "select * from likes";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<Like> likes = new ArrayList<>();
        while (outcome.next()) {
            int user_id = outcome.getInt("user_id");
            int liked_user_id = outcome.getInt("liked_user_id");
            likes.add(new Like(user_id, liked_user_id));
        }
        return likes;
    }

    public static void insert_like(Like like) throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "insert into likes (user_id,liked_user_id) values (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        stmt.setInt(1, like.getUserId());
        stmt.setInt(2, like.getLikedUserId());
        stmt.execute();
    }

    public static List<Dislike> get_all_dislikes() throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "select * from dislikes";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<Dislike> dislikes = new ArrayList<>();
        while (outcome.next()) {
            int user_id = outcome.getInt("user_id");
            int liked_user_id = outcome.getInt("liked_user_id");
            dislikes.add(new Dislike(user_id, liked_user_id));
        }
        return dislikes;
    }

    public static void insert_dislike(Dislike dislike) throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "insert into dislikes (user_id,disliked_user_id) values (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        stmt.setInt(1, dislike.getUserId());
        stmt.setInt(2, dislike.getDislikedUserId());
        stmt.execute();
    }

    public static List<User> getUsersToDisplay(int user_id) throws SQLException {
        Connection conn = DBConnection.get();
        String QUERY = "select distinct  u.*  from users u  where" +
                " u.id not in(select liked_user_id from likes where user_id=" + user_id + ") and " +
                "u.id not in(select disliked_user_id from dislikes where user_id="+user_id+" )and " +
                "u.id<>" + user_id;
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String email = outcome.getString("email");
            String name = outcome.getString("name");
            String surname = outcome.getString("surname");
            String password = outcome.getString("password");
            String picture_url = outcome.getString("picture_url");
            users.add(new User(id, email, name, surname, password,picture_url));
        }
        return users;
    }
}
