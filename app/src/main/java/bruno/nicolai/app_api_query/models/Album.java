package bruno.nicolai.app_api_query.models;

public class Album {

    private User user;
    private int id;
    private String title;

    public Album(User user, int id, String title) {
        this.user = user;
        this.id = id;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
