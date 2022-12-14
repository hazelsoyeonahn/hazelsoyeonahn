package exercises;

public class Box {
	private int height;
	private int width;
	private int depth;
	private boolean full;
	
	public Box(int height, int width, int depth) {
		this.setHeight(height);
		this.setWidth(width);
		this.setDepth(depth);
		this.full = false;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public boolean getisBoxFull() {
		return full;
	}
	
	public String toString() {
		return "Box's height: "+this.height+", width: "+this.width+", depth: "+this.depth+", Is box full? "+this.full;
	}
}
