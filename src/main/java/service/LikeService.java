package service;

import dao.DAOUser;
import entity.User;

import java.util.List;

public class LikeService {
    private final DAOUser daoUser;

    public LikeService(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public List<User> getLikedUsers(int user_id){
        return daoUser.getLikedUsers(user_id);
    }
}
