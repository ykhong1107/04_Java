package pkg2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* * Stream(스트림)  
 * - 데이터가 이동하는 통로
 * - 기본적으로 단방향
 * 
 * * Byte 기반 스트림
 * 
 * - 1byte 단위로 데이터를 입/출력하는 스트림
 * 
 * - 최상위 인터페이스 : InputStream, OutputStream
 * 
 * - 입/출력 할 수 있는 데이터
 *   문자열, 이미지, 영상, 오디오, pdf등 모든 데이터/파일
 *   (단, 문자열이 깨질 가능성이 있고,
 *   	  좁은 통로를 이용하다보니 속도가 상대적으로 느림)
 * 
 * 
 *  ********************************************************
 *  Stream(통로) 객체는 Java 프로그램이 종료가 되어도
 *  
 *  연결에 사용된 외부 파일 / 프로그램과 지속적으로
 *  연결되어있어 자동으로 사라지지 않는다!!!!!
 *  -> 직접 닫아서 없애주는 close() 구문을 필수로 수행!!!!!
 *  
 *  ********************************************************
 */
public class ByteService {

	/**
	 * 지정된 경로의 폴더에
	 * 파일생성 + 내용출력(바이트 기반 스트림 사용)
	 */
	public void fileByteOutput() {
		
		/* IO 관련 객체/기능 사용시 
		 * IOException 발생 가능성이 있기 때문에
		 * 예외처리 필수!!
		 *  */
		
		// FileOutputStream 참조변수 선언
		// -> try // finally에서 사용 예정
		FileOutputStream fos = null;
		
		try {
			String folderPath = "/io_test/byte";
			String fileName = "바이트기반테스트.txt";
			
			// 폴더 유무 확인
			File forder = new File(folderPath);
			
			if( !forder.exists() ) { // 폴더가 존재하지 않으면
				forder.mkdirs(); // 폴더 생성
			}
			
			// 출력할 파일과 연결되 출력용 스트림객체 생성
			// -> 출력하려는 파일이 존재하지 않으면 자동 생성!
			fos = new FileOutputStream(folderPath + "/" + fileName);
						// /io_test/byte/바이트기반테스트.txt
			
			// 만들어진 txt 파일에 들어갈 내용작성
			// StringBuilder : String 불변성 문제를 해결한 객체
			// 				 ->메모리 효율 Good
			StringBuilder sb = new StringBuilder();
			
			sb.append("Hello World!!!\n");
			sb.append("1234567890\n");
			sb.append("!@#%#@&^\n");
			sb.append("안녕하세요\n");
			sb.append("자바 너무 재미있어요!\n");
			sb.append("완전 쉽쥬?\n");
			
			
			// StringBuilder에 저장된 내용을 String으로 변환
			String content = sb.toString();
			
			/* 연결된 외부 파일로 출력 */
			
			// 방법1) 1byte씩 끊어서 출력하기

			// for문 수행전에 미리 반복 할 횟수를 얻어옴
			// -> content.length()를 1번만 수행하면 된다!
//			int length = content.length();
			
//			for(int i=0, length = content.length(); i<length; i++) {
//				
//				char ch = content.charAt(i); // 1번째 문자반환
//
//				fos.write(ch); // 출력스트림으로 출력하기
//							   // -> 이전 출력 내용뒤에 이어쓰기
//				
//				// 2바이트 문자(char)를
//				// 1바이트 스트림으로 출력하니까 문자가 깨짐!!
//			}
			
			// 방법 2) String을 먼저 byte로 변환한 후 출력
			// -> 미리 byte로 변환하면 손실되는 데이터가 없어서
			//    한글도 깨지지 않고 출력된다!
			
			
			byte[] bytes = content.getBytes(); // String -> byte로 변환
			
			fos.write(bytes); // byte[] 배열 한번에 출력

			System.out.println("[파일 출력 완료]");
			
		}catch(IOException e) {
			e.printStackTrace();
			// 예외종류, 메시지, 발생위치 출력
			
		}finally {
			
			// try에서 예외 발생여부와 관계없이
			// 연결된 FileOutPutstream 객체를 닫아서
			// 메모리 반환을 하겠다!!
			try {
				
				// NullPointerException 방지
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	/**
	 *  버퍼를 이용한 "빠르고 효율적인" 파일 출력
	 *  - FileOutputStream (기반 스트림)
	 *  - BufferedOutputStream (보조 스트림)
	 */
	public void bufferedFileByteOutput() {
		
		/* 버퍼(buffer)란??
		 * - 데이터가 모아져있는 메모리상의 임시공간
		 * == 장바구니라고 생각!!
		 * -> 한번에 많은양의 데이터를 이동시켜
		 * 	  시간효율이 좋음!!!
		 */
		
		// 스트림 참조변수 선선
		// -> try, finally에서 사용하기 위해 먼저선언
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림 생성
			fos = new FileOutputStream("/io_test/byte/버퍼_바이트.txt");
			
			// 보조 스트림 생성
			bos = new BufferedOutputStream(fos);
			// -> 기반 스트림을 매개변수로 전달하면 연결된다!
			
			// """ """ : 내부에 작성된 문자열 그대로 저장 == <pre>
			String content = """
Su su su Supernova
Nova
Can’t stop hyperstellar
원초 그걸 찾아
Bring the light of a dying star
불러낸 내 우주를 봐 봐
Supernova						
""";
			
			// 보조 스트림을 통해 출력
			// -> content를 byte[] 배열로 변환해서 출력
			// -> 출력시 버퍼를 사용해서 한번에 출력! 
			bos.write(content.getBytes());
			
			System.out.println("[출력 완료]");
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			// 사용완료된 스트림 객체 닫기(메모리 반환)
			try {
				if(bos != null) bos.close();
				// 보조스트림만 닫으면
				// 연결된 기반스트림도 같이 닫히게 된다!!!
				
			} catch (IOException e) {
				e.printStackTrace();
			
		    }
		}
	}
	
	/**
	 * 바이트 기반파일 입력 1
	 */
	public void fileByteInput1() {
		
		FileInputStream fis = null;
		
		try {
			// 파일 입력 스트림 객체 생성
			fis = new FileInputStream("/io_test/byte/블로그.txt");
			
			// 방법 1)
			// 파일 내부 문자열을 1byte씩 끊어서 읽어오기
			
			int value = 0; // 읽어온 1byte를 저장할 변수
			
			// 읽어온 값을 누적 저장할 객체생성
			StringBuilder sb = new StringBuilder();
			
			while(true) { // 무한 반복
				
				// fis.read()
				// - 다음 바이트 데이터를 반환
				// - 읽어올 내용이 없으면 -1 반환
				value = fis.read();
				
				if(value == -1) break; // 반복종료
				
				// 읽어온 데이터를 char로 변환하여 sb에 누적
				sb.append( (char)value 	);
				
			}
			
			// 읽어온 값 콘솔에 출력
			System.out.println(sb.toString());
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			
			// 스트림 객체 닫기(메모리 반환)
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	/**
	 * 바이트 기반파일 입력 2
	 */
	public void fileByteInput2() {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/io_test/byte/블로그.txt");
			
			// 방법 2)
			// byte[] fis.readAllBytes()
			// -> 연결된 파일의 내용을 모두~ byte로 변환 후
			//    하나씩 읽어와 byte[]에 저장하여 반환
			
			// -> byte[]을 이용해서 String 객체를 만들 수 있는데
			// 	  이때 바이트로 쪼개진 데이터가 정상적으로
			//    정상적으로 합쳐져 깨지지 않고 정상형태를 유지
			
			byte[] bytes = fis.readAllBytes();
			String content = new String(bytes);
			System.out.println(content);
					
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			
			// 스트림 객체 닫기(메모리 반환)
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	/**
	 * 버퍼를 이용해 효율적으로 파일 읽어오기 
	 */
	public void bufferedFileByteInput() {
		
		// try, finally 에서 사용할 참조변수 선언
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			
			// 기반스트림 생성
			fis = new FileInputStream("/io_test/byte/블로그.txt");
			
			// 보조스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 보조스트림을 이용해서
			// 파일내용 -> byte 변환해 한번에 읽어옴
			// -> byte[]에 저장 후 반환
			byte[] bytes = bis.readAllBytes();
			
			// byte[]을 String 변환 후 출력
			String content = new String(bytes);
			System.out.println(content);
			
			
		}catch(Exception e) { // 부모타입을 이용해
							  // 자식타입 예외 모두 처리가능!
			  				  // (다형성 - 업캐스팅)
			
			e.printStackTrace();
		}finally {
			try {
				// 보조스트림(bis)을 닫으면
				// 연결된 기반스트림(fis)도 같이 닫힘
				if(bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ---------------------------------------------------------------
	
	
		/** [파일복사]
		 * 
		 * <pre>
		 *  복사할 파일의 경로를 입력하여 
		 *  
		 *  해당 파일이 존재하지 않으면
		 *	-> "파일이 존재하지 않습니다" 콘솔 출력  
		 *
		 *  존재하면
		 *  -> 같은 경로에 "파일명_copy" 이름으로 파일 출력
		 *  
		 *  [실행화면]
		 *  파일경로 입력 : /io_test/byte/블로그.txt
		 *  복사완료 : /io_test/byte/블로그_copy.txt
		 *    
		 * </pre>
		 */
		public void fileCopy(){
			
			// 파일을 읽어올 기반/보조스트림
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			
			// 파일을 출력할 기반/보조스트림
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			
			// 키보드 입력 받을 스트림 준비(Scanner X)
			BufferedReader br = null;
			
			try {
				
				// 키보드 입력을 받기위한 스트림 객체생성
				br = new BufferedReader(new InputStreamReader(System.in));
			
				System.out.println("파일경로 입력 : ");
				String target = br.readLine(); // 키보드 입력 한줄 받기
				
				// -------------------------------------------------------
				
				// 입력 받은 경로의 파일과 연결되어 읽어올 스트림 생성
				fis = new FileInputStream(target);
				// -> 경로에 파일이 없으면
				//   FileNotFoundException이 던져지게 된다!!
				
				bis = new BufferedInputStream(fis); // 보조 스트림 생성 
				
				// 입력용 스트림을 이용해서 파일내용 읽어오기
				// (byte[] 형식으로 반환받기)
				byte[] bytes = bis.readAllBytes();
				
				// -------------------------------------------------------
				
				// 출력할 파일 경로에 "_copy" 붙이기
				StringBuilder sb = new StringBuilder();
				sb.append(target); // 대상경로를 sb에 추가
				
				// 	int	string.lastIndexOf("찾을값") :
				// - 찾을값이 String(문자열) 
				//   뒤에서 부터 검색하여 몇번째 인덱스에 존재하는지
				//   찾아서 반환, 없으면 -1 반환
				
				// /io_test/byte/블로그.txt 에서 확장자 구분하는 . 찾기!
				
				int insertPoint = target.lastIndexOf("."); //18
				
				// 문자열 중간에 "_copy" 삽입
				sb.insert(insertPoint, "_copy"); // "노래가사_copy.txt"
				
				String copy = sb.toString();
				
				// --------------------------------------------------------
				
				// 출력용 스트림 생성
				// -> 복사할 파일이 없기 때문에 생성됨!
				// 	  만약 있다면 덮어쓰기
				fos = new FileOutputStream(copy);
				bos = new BufferedOutputStream(fos);
				
				// 읽어온 내용 bytes를 bos를 이용해서 출력
				bos.write(bytes);
				
				System.out.println("복사 완료 : " + copy);
						
				
			}catch(FileNotFoundException e){
				System.err.println("입력한 경로에 파일이 존재하지 않습니다");
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {

				try { // 스트림 닫기
					if(bis != null) bis.close();
					if(bos != null) bos.close();
					if(br  != null) br.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		
	
}	
	
	
	

