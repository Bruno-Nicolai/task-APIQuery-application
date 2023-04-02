package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Address;
import bruno.nicolai.app_api_query.models.Company;
import bruno.nicolai.app_api_query.models.Geo;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.UserRepository;

public class UserService {

    public static Geo geoFromJson(JSONObject json) {

        Geo geo = null;

        try {
            geo = new Geo(
                    json.getDouble("lat"),
                    json.getDouble("lng")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return geo;

    }

    public static Address addressFromJson(JSONObject json) {

        Address address = null;

        try {
            address = new Address(
                    json.getString("street"),
                    json.getString("suite"),
                    json.getString("city"),
                    json.getString("zipcode"),
                    null);
            if (json.has("geo")) {
                address.setGeo(geoFromJson(json.getJSONObject("geo")));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return address;

    }

    public static Company companyFromJson(JSONObject json) {

        Company company = null;

        try {

            company = new Company(
                    json.getString("name"),
                    json.getString("catchPhrase"),
                    json.getString("bs")
            );

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return company;

    }

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
            if (json.has("address")) {
                JSONObject jsonAddress = json.getJSONObject("address");
//                Address address = new Address("", "", "", "", null);
                Address address = addressFromJson(jsonAddress);
                user.setAddress(address);
            }
            if (json.has("company")) {
                JSONObject jsonCompany = json.getJSONObject("company");
                Company company = companyFromJson(jsonCompany);
                user.setCompany(company);
            }

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


    public static void getUser(Context context, int id, ServiceDone callback) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users/" + id,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                User user;
                user = /*new User(
                                response.getInt("id"),
                                response.getString("name"),
                                response.getString("username"),
                                response.getString("email"),
                                response.getString("phone"),
                                response.getString("website")
                        );*/userFromJson(response);
            }
        }, error -> {
            Toast.makeText(context, "Ocorreu uma falha na requisição " + error.getMessage(), Toast.LENGTH_SHORT).show();
        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }
}
