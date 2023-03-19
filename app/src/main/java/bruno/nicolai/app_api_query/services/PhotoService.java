package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Photo;
import bruno.nicolai.app_api_query.repositories.PhotoRepository;

public class PhotoService {

    public static Photo photoFromJson(JSONObject json) {

        Photo photo = null;
        try {

            photo = new Photo(
                    json.getInt("albumId"),
                    json.getInt("id"),
                    json.getString("title"),
                    json.getString("url"),
                    json.getString("thumbnailUrl")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return photo;

    }


    public static void getAllPhotos(Context context, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/photos",
                null,
                response -> {

                    System.out.println("Foi retornado");
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject json = response.getJSONObject(i);
                            PhotoRepository.getInstance().addPhoto(photoFromJson(json));

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (callback != null) {
                        callback.onServiceDone();
                    }

                }/*this*/, error -> {

            Toast.makeText(context, "Ocorreu uma falha na requisição " + error.getMessage(), Toast.LENGTH_SHORT).show();

        }/*this*/);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);

    }

}
