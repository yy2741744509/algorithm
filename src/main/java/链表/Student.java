package 链表;

public class Student {
	private String name;
	private String id;
	private int score;
	
	
	public Student() {
		super();
	}
	public Student(String id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", score=" + score + "]";
	}
	
}
