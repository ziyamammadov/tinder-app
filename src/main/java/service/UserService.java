package service;

import dao.DAODislike;
import dao.DAOLike;
import dao.DAOUser;
import entity.Dislike;
import entity.Like;
import entity.User;

import java.util.List;

public class UserService {
    private final DAOUser daoUser;
    private final DAOLike daoLike;
    private final DAODislike daoDislike;

    public UserService(DAOUser daoUser, DAOLike daoLike, DAODislike daoDislike) {
        this.daoUser = daoUser;
        this.daoLike = daoLike;
        this.daoDislike = daoDislike;
    }

    public User getUserToDisplay(User curr) {
        List<User> likedUsers = daoUser.getUsersToDisplay(curr.getId());
        if (likedUsers.size() > 0) {
            return likedUsers.get(0);
        }
        return null;
    }

    public void addLike(Like like) {
        daoLike.addLike(like);
    }

    public void addDislike(Dislike dislike) {
        daoDislike.addDislike(dislike);
    }
}
