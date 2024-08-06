package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.MemberService;
import service.MemberServiceImpl;

public class MemberView {

	private MemberService service = null;
	private BufferedReader br = null;
	
	public MemberView() {
		
		try {
			
			service = new MemberServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			
			System.exit(0);
		}
		
		
		
	}
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			
			try { 
				input = selectMenu();
				
				switch(input){
				case 1: break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 0: System.out.println("##프로그램종료$$"); break;
				
				default : 
				}
				
				
				
			}catch(NumberFormatException e) {
				System.out.println("\n## 숫자만 입력해주세요 ##\n");
				input = -1;
			}catch(IOException e) {
				System.out.println("\n## 입출력 관련 예외발생 ##\n");
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}while(input != 0);
		
	}
	
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n===== 회원관리프로그램 =====\n");
		
		System.out.println("1. 회원 가입(추가)");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
		System.out.println("4. 특정 회원 사용 금액 누적하기");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 종료");
		
		System.out.println("메뉴 선택 >>> ");
		
		int input = Integer.parseInt( br.readLine());
		System.out.println();
		
		return input;
		
	}
	
	//[회원 가입(추가)]
	private void addMember() throws IOException {
		System.out.println("\n----- 회원 가입(추가) -----\n");
		
		System.out.println("이름 :");
		String name = br.readLine();
		
		String phone = null;
		
		while(true){
			System.out.println("휴대폰 번호(- 제외): ");
			phone = br.readLine();
			
			if(phone.length() != 11) {
				System.out.println("다시입력해주세요");
				continue;
			}
			break;
		}
		
		
		
		
	}
	
}
