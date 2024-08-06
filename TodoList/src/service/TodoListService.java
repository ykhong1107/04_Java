package service;

<<<<<<< HEAD
import java.util.List;

=======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dao.TodoListDao;
>>>>>>> 0eafb4db5eb1e157d695a0a93f7dc9681e64ae15
import dto.Todo;

public interface TodoListService {
	
	public abstract List<Todo> getTodoList();

	
	public abstract List<Todo> todoListFullView();
	

	public abstract String dateFormat(LocalDateTime regDate);
	
	public abstract String todoDetailView(int index);
	
	public abstract boolean todoComplete(int index) throws FileNotFoundException, IOException;


	public abstract List<Todo> addTodo();
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
