package bruno.nicolai.app_api_query.models;

public class Todo {

    private User user;
    private int id;
    private String title;
    private Boolean completed;

    public Todo(User user, int id, String title, Boolean completed) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.completed = completed;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + this.title + '\'' +
                ", user id=" + user.getId() +
                ", id=" + this.id +
                ", completed='" + this.completed + '\'' +
                '}';
    }
}
