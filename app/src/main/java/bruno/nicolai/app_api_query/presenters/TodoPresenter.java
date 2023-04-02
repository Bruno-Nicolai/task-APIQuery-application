package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.TodosAdapter;
import bruno.nicolai.app_api_query.repositories.TodoRepository;
import bruno.nicolai.app_api_query.services.TodoService;

public class TodoPresenter implements TodoPresenterInterface.Presenter {

    TodoPresenterInterface.View view;

    public TodoPresenter(TodoPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllTodos() {

        TodoService.getAllTodos(view.getContext(), () -> {

            TodosAdapter adapter = new TodosAdapter(new ArrayList(TodoRepository.getInstance().getTodos()));
            view.setTodosAdapter(adapter);

        });

    }
}
