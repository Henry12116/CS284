public class Triangle extends Shape
{
	private int side1;
	private int side2;
	private int side3;

//non-default traingle with sides a b and c
	public Triangle(int a, int b, int c)
	{
		if ((a<=0)|| (a> (b+c)))
			a = 0;
		if ((b<=0)||(b>(a+c)))
			b = 0;
		if ((c<=0)||(c>(b+a)))
			c = 0;
		side1 = a;
		side2 = b;
		side3 = c;
	}

// default triangle if no paramerter is given
	public Triangle()
	{
		side1 = 1;
		side2 = 1;
		side3 = 1;
	}

// returns true if all sides are set, false if not
	public boolean setSides(int a, int b, int c)
	{
		if (a <=0 || b<=0 || c<=0)
			return false;
		if ((a> (b+c)) || (b>(c+a)) || (c>(a+b)))
			return false;
		side1 = a;
		side2 = b;
		side3 = c;
		return true;
	}

// returns length of side1
	public int getSide1()
	{
		return side1;
	}

// returns length of side2
	public int getSide2()
	{
		return side2;
	}

// returns length of side1
	public int getSide3()
	{
		return side3;
	}

// returns true if side1 is set, false if not
	public boolean setSide1(int s)
	{
		if (( s<=0) || (s>(side2+side3)))
			return false;
		side1 = s;
		return true;
	}

// returns true if side 2 is set, false if not
	public boolean setSide2(int s)
	{
		if (( s<=0) || (s>(side1 + side3)))
			return false;
		side2 = s;
		return true;
	}

// returns true if side 3 is set, fasle if not
	public boolean setSide3(int s)
	{
		if (( s<=0)||(s>(side2 + side1)))
			return false;
		side3 = s;
		return true;
	}

// returns perimeter of triangle
	public double perimeter()
	{
		if ((side1<=0)||(side2<=0)||(side3<=0))
			return 0;
		perimeter = (side1+side2+side3);
		return perimeter;
	}

//returns area of triangle
	public double area()
	{
		if ((side1<=0)||(side2<=0) || (side3<=0))
			return 0;
		area = Math.sqrt(((side1+side2+side3)/2)*(((side1+side2+side3)/2)-side1)*(((side1+side2+side3)/2)-side2)*(((side1+side2+side3)/2)-side3));
		return area;
	}

// returns sentence form description of triangle dimensions
	public String toString()
	{
		return "A triangle with sides of length " + side1 + " , " + side2 + " , and " + side3 +" has a perimeter of " + perimeter + " and an area of " + area +".";
	}

//returns only quantative data of triangle
	public void shortPrint()
	{
		System.out.println( "Triangle = " + side1 + " x " + side2 + " x " + side3 + " Perimeter = " + perimeter + " Area = " + area);
	}

//prints toString
	public void longPrint()
	{
		System.out.println(this.toString());
	}

//constructor
	public static void main(String[] args)
	{
		Triangle test1 = new Triangle();
		Triangle test2 = new Triangle(0,0,0);
		Triangle test3 = new Triangle(8,-6,5);
		Triangle test4 = new Triangle(10,20,30);

		System.out.println("test1 Side1 = " + test1.getSide1());
		System.out.println("test2 Side1 = " + test2.getSide1());
		System.out.println("test3 Side1 = " + test3.getSide1());
		System.out.println("test4 Side1 = " + test4.getSide1());

		System.out.println("test1 Side2 = " + test1.getSide2());
		System.out.println("test2 Side2 = " + test2.getSide2());
		System.out.println("test3 Side2 = " + test3.getSide2());
		System.out.println("test4 Side2 = " + test4.getSide2());

		System.out.println("test1 Side3 = " + test1.getSide3());
		System.out.println("test2 Side3 = " + test2.getSide3());
		System.out.println("test3 Side3 = " + test3.getSide3());
		System.out.println("test4 Side3 = " + test4.getSide3());

		if (test1.setSides(1,4,9))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test2.setSides(-4,0,0))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test3.setSides(9,9,9))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 


		if (test1.setSide1(1))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test2.setSide1(10))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test3.setSide1(0))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test4.setSide1(-7))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set.");


		if (test1.setSide2(-1))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test2.setSide2(0))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test3.setSide2(10))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test4.setSide2(3))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set.");


		if (test1.setSide3(10))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test2.setSide3(-6))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test3.setSide3(7))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set."); 
		if (test4.setSide3(0))
			System.out.println("Sides were set.");
		else
			System.out.println("Sides were not set.");


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