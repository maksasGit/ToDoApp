public class User {
    private String login;
    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public String getName() {
        return this.name;
    }
}
