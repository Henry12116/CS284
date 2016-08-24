public class Square extends Rectangle
{
	private int side;

// non-default square
	public Square(int s)
	{
		if (s<=0)
			s=0;
		side = s;
	}

// default square
	public Square()
	{
		side = 1;
	}

// returns side
	public int getSide()
	{
		return side;
	}

// returns true if sides is set, false if not
	public boolean setSide(int s)
	{
		if (s <=0)
			return false;
		side = s;
		return true;
	}

//fnids perimeter of square
	public double perimeter()
	{
		if (side<=0)
			return 0;
		perimeter = (side*4);
		return perimeter;
	}

//find area of square
	public double area()
	{
		if (side<=0)
			return 0;
		area = (side*side);
		return area;
	}

// returns sentence form description of square dimensions
	public String toString()
	{
		return "A square with side length of " + side + ", has a perimeter of " + perimeter + ", and an area of " + area +".";
	}

// returns only quantative data of square
	public void shortPrint()
	{
		System.out.println("Side = " + side + " Perimeter = " + perimeter + " Area = " + area);
	}

//prints toString
	public void longPrint()
	{
		System.out.println(this.toString());
	}

//constructor
	public static void main(String[] args)
	{
		Square test1 = new Square();
		Square test2 = new Square(5);
		Square test3 = new Square(-6);
		System.out.println("test1 Side = " + test1.getSide());
		System.out.println("test2 Side = " + test2.getSide());
		System.out.println("test3 Side = " + test3.getSide());
		if (test1.setSide(1))
			System.out.println("Side was set.");
		else
			System.out.println("Side was not set."); 
		if (test2.setSide(0))
			System.out.println("Side was set.");
		else
			System.out.println("Side was not set."); 
		if (test3.setSide(-2))
			System.out.println("Side was set.");
		else
			System.out.println("Side was not set."); 
		System.out.println("test1 Area = " + test1.area());
		System.out.println("test2 Area = " + test2.area());
		System.out.println("test3 Area = " + test3.area());
		System.out.println("test1 Perimeter = " + test1.perimeter());
		System.out.println("test2 Perimeter = " + test2.perimeter());
		System.out.println("test3 Perimeter = " + test3.perimeter());
		test1.shortPrint();
		test2.shortPrint();
		test3.shortPrint();
		test1.longPrint();
		test2.longPrint();
		test3.longPrint();
	}
}