package service;

import dao.DAOUser;
import entity.User;

import java.util.List;

public class RegisterService {
    private final DAOUser daoUser;

    public RegisterService(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public String registerUser(String email, String name, String surname, String psw, String pswRepeat) {
        List<User> users = daoUser.getAll();
        if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            return "<label class=\"warning\">This email has already used!</label>\n";
        } else if (psw.equals(pswRepeat)) {
            User user = new User(email, name, surname, psw);
            daoUser.addUser(user);
            return "<label class=\"success\">Successfully registered!</label>\n";
        }
        return "<label class=\"error\">Password didn't match, try again!</label>\n";
    }
}
