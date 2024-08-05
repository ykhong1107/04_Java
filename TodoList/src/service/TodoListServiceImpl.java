package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService {

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
	
	
}
