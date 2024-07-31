package pkg3.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 라이브러리
// - 자바 애플리케이션 개발 시
// 	 자주 사용하는 구문을 자동으로 생성하도록 만든 라이브러리

// - @(어노테이션)을 작성하면
//   컴파일 단계에서 자동으로 코드가 추가됨

@Getter // 모든필드의 getter 자동생성
@Setter // 모든필드의 setter 자동생성
@NoArgsConstructor // 전달 인자가 없는 생성자 == 기본 생성자
@AllArgsConstructor // 모든 필드에 대한 매개변수 생성자
@ToString // toString() 오버라이딩
public class Member implements Serializable{
	
	// serialVersionUID : 직렬화 식별 번호
	// -> 직렬화/역직렬화 시
	//    같은 객체가 맞는지 비교할때 사용하는 번호
	// 	  따로 작성 안하면 JVM이 랜덤 값 지정
	
	// 직렬화를 위해 Serializable 인터페이스 상속
	// -> 스트림이용시 객체가 직렬화되어짐
	// --> 마커 인터페이스(무슨 역할 / 대상임을 명시)
	
	
	private String id;
	private String pw;
	private String name;
	private int age;
	
	
	
}
