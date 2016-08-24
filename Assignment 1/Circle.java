public class Circle extends Shape
{
// 
	private int radius; 

// non-default circle with radius r
	public Circle(int r) 
	{
		if (r<=0)
			r = 0;
		radius = r;
	}

// default circle if no paramerter is given
	public Circle()
	{
		radius = 1;
	}

// returns radius
	public int getRadius() 
	{
		return radius;
	}

// returns true if radius is set, false if not
	public boolean setRadius(int r)
	{
		if (r <= 0)
			return false;
		radius = r;
		return true;
	}

//finds perimeter of circle
	public double perimeter()
	{
		if (radius <= 0)
			return 0;
		perimeter = (2*radius*Math.PI);
		return perimeter;
	}

//finds area of circle
	public double area()
	{
		if (radius <= 0)
			return 0;
		area = (Math.PI*(radius*radius));
		return area;
	}

// returns sentence form description of circle dimensions
	public String toString()
	{
		return "A circle with a radius of " + radius + ", has an area of " + area + ", and a perimeter of " + perimeter +".";
	}

// returns only quantative data of circle
	public void shortPrint()
	{
		System.out.println("Radius = " + radius + ", Perimeter =  " + perimeter + ", Area =  " + area);
	}

//prints toString 
	public void longPrint()
	{
		System.out.println(this.toString());
	}


//constructor
	public static void main(String[] args)
	{
		Circle test1 = new Circle();
		Circle test2 = new Circle(10);
		Circle test3 = new Circle(-1);
		System.out.println("test1 Radius = " + test1.getRadius());
		System.out.println("test2 Radius = " + test2.getRadius());
		System.out.println("test3 Radius = " + test3.getRadius());
		if (test1.setRadius(7))
			System.out.println("Radius was set.");
		else
			System.out.println("Radius was not set."); 
		if (test2.setRadius(-20))
			System.out.println("Radius was set.");
		else
			System.out.println("Radius was not set."); 
		if (test3.setRadius(3))
			System.out.println("Radius was set.");
		else
			System.out.println("Radius was not set."); 
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