package essai;

public class Essai {
	
	private int val;
	
	public void setVal(int val) { this.val = val;}
	
	public int getVal() { return this.val; }

	public Essai(int val) {
		this.val = val;
	}
	
	public float inv() {
		return 1/val;
	}
}
