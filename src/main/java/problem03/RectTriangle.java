package problem03;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;

		// A = L * W where A is the area, L is the length, W is the width, and *
		// means multiply.
	}

	@Override
	public double getArea() {
		System.out.println("");
		return (width * height) / 2;
	}

	@Override
	public double getPerimeter() {
		double c = Math.pow(width, 2) + Math.pow(height, 2);
		return width + height + Math.sqrt(c);
	}
}
