package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.Comment;

public class CommentRepository {

    private Map<Integer, Comment> commentsMap;

    private static CommentRepository instance = null;

    private CommentRepository() {
        this.commentsMap = new HashMap<>();
    }

    public static CommentRepository getInstance() {
        if (instance == null) {
            instance = new CommentRepository();
        }
        return instance;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            this.commentsMap.put(comment.getId(), comment);
        }
    }

    public boolean contains(Comment comment) {
        return this.commentsMap.containsValue(comment);
    }

    public boolean contains(Integer id) {
        return this.commentsMap.containsKey(id);
    }

    public Collection<Comment> getComments() {
        return this.commentsMap.values();
    }

}
