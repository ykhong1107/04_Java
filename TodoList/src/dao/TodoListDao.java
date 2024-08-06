package dao;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListDao {

	
	List<Todo> todoListFullView();
	
	
	void saveFile() throws IOException;

	
}
