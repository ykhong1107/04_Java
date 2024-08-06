package dto;

// DTO(Data Transfer Object) : 데이터 전달용 객체
// - 전달될 데이터를 묶어서 관리하는 객체

public class MemberDTO {
	
	// 필드 작성
	private String memberId;
	private String memberPw;
	private String memberName;
	private int    memberage;
	
	// 생성자
	
	// [이클립스의 생성자 자동완성 기능]
	// 상단 source 메뉴
	// 또는 alt + shift + s -> 컨텍스트 메뉴에서
	// Generate Constructor Using Fields... (단축기 o)
	
	public MemberDTO() {} // 기본 생성자(매개 변수 없음!!!)

	public MemberDTO(String memberId, String memberPw, String memberName, int memberage) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberage = memberage;
	}

	
	// [이클립스의 생성자 자동완성 기능]
	// 상단 source 메뉴
	// 또는 alt + shift + s -> 컨텍스트 메뉴에서
	// Generate Getters and Setters... 선택 (단축키 r)
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberage() {
		return memberage;
	}

	public void setMemberage(int memberage) {
		this.memberage = memberage;
	}
	
	/** 
	 * 현재 객체가 가지고 있는 필드값 모두 출력하는 메서드
	 */
	public void inform() {
		System.out.println("\n--------------------------");
		System.out.println("memberId   : " + memberId);
		System.out.println("memberPw   : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberAge  : " + memberage);
		System.out.println("--------------------------\n");
	}
	
	
	
	
	
	
	

}
