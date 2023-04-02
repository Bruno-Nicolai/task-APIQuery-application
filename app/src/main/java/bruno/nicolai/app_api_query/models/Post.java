package bruno.nicolai.app_api_query.models;

public class Post {

    private User user;
    private int id;
    private String title, body;


    public Post(User user, int id, String title, String body) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user=" + this.user.getName() + '\'' +
                ", id=" + this.id +
                ", title='" + this.title +
                ", body='" + this.body + '\'' +
                '}';
    }
}
