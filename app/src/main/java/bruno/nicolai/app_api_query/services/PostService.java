package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Post;
import bruno.nicolai.app_api_query.repositories.PostRepository;

public class PostService {

    public static Post postFromJson(JSONObject json) {

        Post post = null;
        try {

            post = new Post(
                    json.getInt("userId"),
                    json.getInt("id"),
                    json.getString("title"),
                    json.getString("body")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return post;

    }


    public static void getAllPosts(Context context, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts",
                null,
                response -> {

                    System.out.println("Foi retornado");
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject json = response.getJSONObject(i);
                            PostRepository.getInstance().addPost(postFromJson(json));

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (callback != null) {
                        callback.onServiceDone();
                    }

                }, error -> {

            Toast.makeText(context, "Ocorreu uma falha na requisição " + error.getMessage(), Toast.LENGTH_SHORT).show();

        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);

    }

}
