public class NewRectangle extends Shape{
	private int base;
	private int height;

	public NewRectangle(int b, int h){
	if((b <= 0)||(h <= 0))
		b = 0;
		h = 0;
	base = b;
	height = h;
	}

	//constructor if no parameters are given
	public NewRectangle(){
		base = 1;
		height = 1;
	}

	public int getBase(){
		return base;
	}

	public int getHeight(){
		return height;
	}

	public boolean setBase(int b){
		if(b <= 0)
			return false;
		base = b;
		return true;
	}

	public boolean setHeight(int h){
		if(h <= 0)
			return false;
		height = h;
		return true;	
	}

	public double perimeter(){
		if((base <= 0) || (height <= 0))
			return 0;
		perimeter = 2*(base + height);
		return perimeter;
	}

	public double area(){
		if((base <= 0) || (height <= 0))
			return 0;
		area = base * height;
		return area;
	}

	public String toString(){
		return "A rectangle with base: " + base + " and height: " + height + " has an area of " + area + " and a perimeter of " + perimeter + ".";
	}

	public void shortPrint(){
		System.out.println("Base: "+base+" Height: "+height+" Area: "+area+" Perimeter: "+perimeter);
	}

	public void longPrint(){
		System.out.println(this.toString());
	}

	public static void main(String[] args)
	{
		NewRectangle test1 = new NewRectangle(0,0);
		NewRectangle test2 = new NewRectangle(5,7);
		NewRectangle test3 = new NewRectangle(-6, 8);
		NewRectangle test4 = new NewRectangle();
		System.out.println("test1 base = " + test1.getBase() + "  height = " + test1.getHeight());
		System.out.println("test2 base = " + test2.getBase() + "  height = " + test2.getHeight());
		System.out.println("test3 base = " + test3.getBase() + "  height = " + test3.getHeight());
		System.out.println("test4 base = " + test3.getBase() + "  height = " + test4.getHeight());
		if (test1.setBase(6))
			System.out.println("Base was set.");
		else
			System.out.println("Base was not set."); 
		if (test2.setBase(-2))
			System.out.println("Base was set.");
		else
			System.out.println("Base was not set."); 
		if (test3.setBase(3))
			System.out.println("Base was set.");
		else
			System.out.println("Base was not set."); 
		if (test4.setBase(8))
			System.out.println("Base was set.");
		else
			System.out.println("Base was not set.");

		if (test1.setHeight(5))
			System.out.println("Height was set.");
		else
			System.out.println("Height was not set."); 
		if (test2.setHeight(0))
			System.out.println("Height was set.");
		else
			System.out.println("Height was not set."); 
		if (test3.setHeight(2))
			System.out.println("Height was set.");
		else
			System.out.println("Height was not set."); 
		if (test4.setHeight(7))
			System.out.println("Height was set.");
		else
			System.out.println("Height not set.");  
		System.out.println("test1 Area = " + test1.area());
		System.out.println("test2 Area = " + test2.area());
		System.out.println("test3 Area = " + test3.area());
		System.out.println("test4 Area = " + test4.area());
		System.out.println("test1 Perimeter = " + test1.perimeter());
		System.out.println("test2 Perimeter = " + test2.perimeter());
		System.out.println("test3 Perimeter = " + test3.perimeter());
		System.out.println("test4 Perimeter = " + test4.perimeter());
		test1.shortPrint();
		test2.shortPrint();
		test3.shortPrint();
		test4.shortPrint();
		test1.longPrint();
		test2.longPrint();
		test3.longPrint();
		test4.longPrint();
	}
}