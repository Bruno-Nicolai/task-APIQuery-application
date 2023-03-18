package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityUsersBinding;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.UserRepository;
import bruno.nicolai.app_api_query.services.UserService;

public class UsersActivity extends AppCompatActivity /*implements Response.Listener<JSONArray>, Response.ErrorListener*/ {

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

        UserService.getAllUsers(this, () -> System.out.println("API: " + UserRepository.getInstance().getUsers()));

    }
/*
    @Override
    public void onErrorResponse(VolleyError error) {
    }

    @Override
    public void onResponse(JSONArray response) {

    }
*/

}