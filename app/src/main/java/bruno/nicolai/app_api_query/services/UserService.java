package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Address;
import bruno.nicolai.app_api_query.models.Geo;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.UserRepository;

public class UserService {

    public static User userFromJson(JSONObject json) {

        User user = null;
        try {

            user = new User(
                    json.getInt("id"),
                    json.getString("name"),
                    json.getString("username"),
                    json.getString("email"),
                    json.getString("phone"),
                    json.getString("website")
            );
            /*
            if (json.has("address")) {
                JSONObject jsonAddress = json.getJSONObject("address");
                JSONObject jsonGeo = json.getJSONObject("geo");

                Address address = new Address("", "", "", "", null);
                user.setAddress(address);
            }
            */
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return user;

    }


    public static void getAllUsers(Context context, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null,
                response -> {

                    System.out.println("Foi retornado");
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject json = response.getJSONObject(i);
                            UserRepository.getInstance().addUser(userFromJson(json));

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
