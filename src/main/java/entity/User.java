package entity;

public class User {
    private final String email;
    private final String name;
    private final String surname;
    private final String password;
    private final String pictureUrl;
    private int id;

    public User(int id, String email, String name, String surname, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.pictureUrl = RandomPicture.randomPictureGenerator();
    }

    public User(int id, String email, String name, String surname, String password, String pictureUrl) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.pictureUrl = pictureUrl;
    }

    public User(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.pictureUrl = RandomPicture.randomPictureGenerator();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
