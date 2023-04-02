package bruno.nicolai.app_api_query.models;

public class Comment {

    private int id;
    private Post post;
    private String name, email, body;

    public Comment(int id, Post post, String name, String email, String body) {
        this.id = id;
        this.post = post;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", post id=" + post.getId() +
                ", name=" + name +
                ", email=" + email +
                ", body='" + body + '\'' +
                '}';
    }
}
