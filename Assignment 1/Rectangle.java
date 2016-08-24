public class Rectangle extends Shape
{
	private int base;
	private int height;

// non-default rectangle with int base b and in height h
	public Rectangle(int b, int h)
	{
		if (b<=0)
			b = 0;
		if (h<=0)
			h=0;
		base = b;
		height = h;
	}

// default rectangle
	public Rectangle()
	{
		base = 1;
		height = 1;
	}

// returns height
	public int getHeight()
	{
		return height;
	}

// returns base
	public int getBase()
	{
		return base;
	}

// returns true if height is set, false if not
	public boolean setHeight(int h)
	{
		if (h <=0)
			return false;
		height = h;
		return true;
	}

// returns true if base is set, false if not
	public boolean setBase(int b)
	{
		if (b <= 0)
			return false;
		base = b;
		return true;
	}

//returns perimeter of rectangle
	public double perimeter()
	{
		if ((base<=0)||(height<=0))
			return 0;
		perimeter = (base*2 + height*2);
		return perimeter;
	}

//returns area of rectangle
	public double area()
	{
		if ((base<=0)||(height<=0))
			return 0;
		area = (base*height);
		return area;
	}

// returns sentence form description of rectangle dimensions
	public String toString()
	{
		return "A rectagle with dimensions " +base + " x " + height + " has an area of " + area + " and a perimeter of " + perimeter +".";
	}

// returns only quantative data of rectangle
	public void shortPrint()
	{
		System.out.println("base:" + base + " height:" + height + " perimeter:" + perimeter + " area: " + area);
	}

//prints toString
	public void longPrint()
	{
		System.out.println(this.toString());
	}

//constructor
	public static void main(String[] args)
	{
		Rectangle test1 = new Rectangle(0,0);
		Rectangle test2 = new Rectangle(5,10);
		Rectangle test3 = new Rectangle(-6, 11);
		Rectangle test4 = new Rectangle();
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
			System.out.println("height not set!");  
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