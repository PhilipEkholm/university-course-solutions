package laboration7;

public class Table {
	private String 	material;
	
	private int width,
				depth,
				height;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Table [material=" + material + ", width=" + width + ", depth=" + depth + ", height=" + height + "]";
	}
	
	public int size() {
		return (width * depth);
	}
}
