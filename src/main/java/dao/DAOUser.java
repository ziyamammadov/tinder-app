package dao;

import database.DBOperation;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser {
    private List<User> users;

    public DAOUser() {
        this.users = new ArrayList<>();
    }

    public List<User> getAll() {
        try {
            this.users = DBOperation.get_all_users();
        } catch (Exception ignored) {
        }
        return users;
    }

    public void addUser(User user) {
        try {
            DBOperation.insert_user(user);
        } catch (SQLException ignored) {
        }
    }

    public List<User> getUsersToDisplay(int id ) {
        try {
            return DBOperation.getUsersToDisplay(id);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<User> getLikedUsers(int id){
        List<User> likedUsers;
        try {
            likedUsers = DBOperation.getLikedUsers(id);
        } catch (SQLException e) {
            likedUsers=new ArrayList<>();
        }
        return likedUsers;
    }
}
