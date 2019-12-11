package dao;

import database.DBOperation;
import entity.Dislike;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODislike {
    private List<Dislike> dislikes;

    public DAODislike() {
        this.dislikes = new ArrayList<>();
    }

    public List<Dislike> getAll() {
        try {
            this.dislikes = DBOperation.get_all_dislikes();
        } catch (SQLException ignored) {
        }
        return dislikes;
    }

    public void addDislike(Dislike dislike) {
        try {
            DBOperation.insert_dislike(dislike);
        } catch (SQLException ignored) {
        }
    }
}
