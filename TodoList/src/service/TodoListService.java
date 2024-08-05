package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dao.TodoListDao;
import dto.Todo;

public interface TodoListService {

	
	public abstract List<Todo> todoListFullView();
	

	public abstract String dateFormat(LocalDateTime regDate);
	
	public abstract String todoDetailView(int index);
	
	public abstract boolean todoComplete(int index) throws FileNotFoundException, IOException;


	public abstract List<Todo> addTodo();
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
