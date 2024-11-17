import Config.Database;
import entities.repositories.TodoListRepository;
import entities.repositories.TodoListRepositoryDblmpl;
import entities.repositories.TodoListRepositoryImpl;
import entities.services.TodoListService;
import entities.services.TodoListServiceImpl;
import entities.views.TodoListTerminalView;
import entities.views.TodoListView; // Fixed typo


public class Main {
    public static void main(String[] args) {
        Database database = new Database("databaseku", "root", "", "localhost", "3306");
        database.setup();
        // Create an instance of the repository
        TodoListRepository todoListRepository = new TodoListRepositoryDblmpl(database);

        // Pass the repository instance to the service
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        // Pass the service instance to the view
        TodoListView todoListView = (TodoListView) new TodoListTerminalView(todoListService);

        // Run the application
        todoListView.run();
    }
}