package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Comment;
import bruno.nicolai.app_api_query.repositories.CommentRepository;

public class CommentService {

    public static Comment commentFromJson(JSONObject json) {

        Comment comment = null;
        try {

            comment = new Comment(
                    json.getInt("id"),
                    json.getInt("postId"),
                    json.getString("name"),
                    json.getString("email"),
                    json.getString("body")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return comment;

    }


    public static void getAllComments(Context context, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments",
                null,
                response -> {

                    System.out.println("Foi retornado");
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject json = response.getJSONObject(i);
                            CommentRepository.getInstance().addComment(commentFromJson(json));

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
