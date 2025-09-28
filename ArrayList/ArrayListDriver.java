public class ArrayListDriver 
{
	public static void main(String[] args) throws WrongInitialCapacityException
	{
		ArrayList<Integer> a1=new ArrayList<Integer>(10);
		a1.addObject(10);
		a1.addObject(20);
		a1.addObject(30);
		a1.addObject(40);
		a1.addObject(50);
		a1.addObject(60);
		
		System.out.println(a1);
		
		ArrayList<Integer> a2=new ArrayList<Integer>(10);
		a2.addObject(10);
		a2.addObject(20);
		a2.addObject(30);
		a2.addObject(40);
		a2.addObject(50);
		a2.addObject(60);
		
		
		System.out.println(a2);
		
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a1.equals(a2));
		
		
	}
}
