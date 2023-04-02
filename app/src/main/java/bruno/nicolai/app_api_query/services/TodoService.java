package bruno.nicolai.app_api_query.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import bruno.nicolai.app_api_query.models.Todo;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.TodoRepository;
import bruno.nicolai.app_api_query.repositories.UserRepository;

public class TodoService {

    public static Todo todoFromJson(JSONObject json) {

        Todo todo = null;
        try {

            todo = new Todo(
                    null,
                    json.getInt("id"),
                    json.getString("title"),
                    json.getBoolean("completed")
            );
            User user = UserRepository.getInstance().getUser(json.getInt("userId"));
            todo.setUser(user);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return todo;

    }


    public static void getAllTodos(Context context, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",
                null,
                response -> {

                    System.out.println("Foi retornado");
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject json = response.getJSONObject(i);
                            TodoRepository.getInstance().addTodo(todoFromJson(json));

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
