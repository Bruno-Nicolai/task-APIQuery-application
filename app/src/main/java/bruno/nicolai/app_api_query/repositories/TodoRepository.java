package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.Todo;

public class TodoRepository {

    private Map<Integer, Todo> todosMap;

    private static TodoRepository instance = null;

    private TodoRepository() {
        this.todosMap = new HashMap<>();
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }

    public void addTodo(Todo todo) {
        if (todo != null) {
            this.todosMap.put(todo.getId(), todo);
        }
    }

    public boolean contains(Todo todo) {
        return this.todosMap.containsValue(todo);
    }

    public boolean contains(Integer id) {
        return this.todosMap.containsKey(id);
    }

    public Collection<Todo> getTodos() {
        return this.todosMap.values();
    }

}
