package service;

<<<<<<< HEAD
import java.util.List;

=======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
>>>>>>> 0eafb4db5eb1e157d695a0a93f7dc9681e64ae15
import dto.Todo;

public class TodoListServiceImpl implements TodoListService {

<<<<<<< HEAD
	@Override
	public List<Todo> getTodoList() {
		// 
		return null;
	}

	
=======
	private TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDaoImpl();
	}
	
	
	// 전체 메뉴
	@Override 
	public List<Todo> todoListFullView() {
		
		
		return dao.todoListFullView();
	}

	
	@Override
	public List<Todo> addTodo() {
		return null;
	}
	
>>>>>>> 0eafb4db5eb1e157d695a0a93f7dc9681e64ae15
	
}
