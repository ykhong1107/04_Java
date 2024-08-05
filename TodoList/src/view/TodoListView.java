package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

	private TodoListService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		
		try {
			service = new TodoListServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		}catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void mainMenu() throws IOException {
		
		
		
		int input = 0;
		do {
			
			
		try {
			input = selectMenu();
			
			switch(input) {
			case 1: todoListFullView(); break;
			case 2: break;
			case 3: addTodo(); break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 0: break;
			default : 
			
			
			
			}
			
		}catch(NumberFormatException e){
				input = -1;
				
				
			}
			
			
		}while(input != 0);
	
		
		
	}
	
	
	
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n========== Todo List ==========\n");
		
		System.out.println("1. Todo List View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Uptate");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		
		System.out.print("select menu number >>>");
		
		
		int input = Integer.parseInt( br.readLine());
		
		return input;
	}
	
	// [1. 전체적인 조회]
	private void todoListFullView() {
		System.out.println("============[1. Todo List Full View]===========");
		
		Map<String, Object> map = service.todoListFullView();
		
		List<Todo> todoList = (List<Todo>)map.get("todoList");
		
		int completeCount = (int)map.get("completeCount");
		
		
		
		System.out.printf("[ 완료된 Todo 개수/ 전체 Todo 수 : %d / %d ]\n",
						 completeCount, todoList.size());
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-10s %-10s %8s %12s \n",
							"인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0, len = todoList.size(); i < len ; i++) {
			String title = todoList.get(i).getTitle();
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			String regDate = service.dateFormat(todoList.get(i).getRegDate());
			
			System.out.printf("[%3d] %20s (%s)  %s \n",
							i, regDate, completeYN, title);
			
		}
		
	}
	
	// [3. 할일 추가]
	private void addTodo() throws IOException {
		System.out.println("============[3. Todo Add]===========");
		
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine();
		
		List<Todo> todoList = service.addTodo();
		
		
		
	}
	
	
	
}
