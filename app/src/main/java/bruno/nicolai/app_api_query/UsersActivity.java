package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityUsersBinding;
import bruno.nicolai.app_api_query.models.User;

public class UsersActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    private ActivityUsersBinding binding;
    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarUsers.setTitle(R.string.user);
        binding.toolbarUsers.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
//                "https://jsonplaceholder.typicode.com/users/1",
//                null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    User user = new User(
//                            response.getInt("id"),
//                            response.getString("name"),
//                            response.getString("username"),
//                            response.getString("email"));
//                    System.out.println(user);
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(response);
//            }
//        }, /*new Response.ErrorListener() {

//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // TODO: Handle error
//
//            }
//        }*/this);

//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);



        binding.usersBtnSearchAll.setOnClickListener(view -> {
            getAllUsers();
        });

    }


    private void getAllUsers() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null, /*response -> {
        }*/this, /*error -> {
        }*/this);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Ocorreu uma falha na requisição " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            User user = null;
            try {

                JSONObject json = response.getJSONObject(i);

                user = new User(
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("username"),
                        json.getString("email"));
                users.add(user);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(users);
    }
}