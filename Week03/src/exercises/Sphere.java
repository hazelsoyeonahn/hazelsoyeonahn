package exercises;

public class Sphere {
	private int diameter;
	final static double PI = 3.14;
	
	public Sphere(int diameter) {
		this.setDiameter(diameter);
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	public String toString() {
		return "Volume area = "+4/3*PI*this.diameter*this.diameter*this.diameter+" m3, Surface area = "+4*PI*this.diameter*this.diameter+" m3";
	}

}
