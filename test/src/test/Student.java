package test;

public class Student {

	private String name;
	private int score;
	
	public Student() {}
	
	// 매개변수 생성자가 없어서 값을 받아올 수 없음
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format("%s 학생의 점수 : %d 점", 
							name, score).toString();	
	}
	
	

}
