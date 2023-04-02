package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.Post;

public class PostRepository {

    private Map<Integer, Post> postsMap;

    private static PostRepository instance = null;

    private PostRepository() {
        this.postsMap = new HashMap<>();
    }

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    public void addPost(Post post) {
        if (post != null) {
            this.postsMap.put(post.getId(), post);
        }
    }

    public boolean contains(Post post) {
        return this.postsMap.containsValue(post);
    }

    public boolean contains(Integer id) {
        return this.postsMap.containsKey(id);
    }

    public Collection<Post> getPosts() {
        return this.postsMap.values();
    }

    public Post getPost(int id) {
        return this.postsMap.get(id);
    }

}
