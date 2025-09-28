public class ArrayList<E> implements ResizableArray<E>
{

	Object[] ar;
	int count;
	
	
	ArrayList()
	{
		ar=new Object[ResizableArray.initCap];
	}
	
	ArrayList(int size) throws WrongInitialCapacityException
	{
		if(size>0)
		{
			ar=new Object[size];
		}
		else
		{
			throw new WrongInitialCapacityException("Initial capacity cannot be zero or negative");
		}
		
		
	}
	

	public boolean addObject(E o)
	{
		return addObject(count,o);	
	}
	
	public boolean addObject(int index,E o)
	{
		if(count>ar.length*ResizableArray.loadFactor)
		{
			Object[] temp=new Object[ar.length*2];
			int i=0;
			while(i<index)
			{
				temp[i]=ar[i++];
			}
			temp[i++]=o;
			while(i<count)
			{
				temp[i]=ar[i-1];
			}
			
			ar=temp;
			count++;
			return true;
		}
		
		for(int i=count;i>index;i--)
		{
			ar[i]=ar[i-1];
		}
		ar[index]=o;
		count++;
		return true;
	}
	
	public boolean addAll(ResizableArray ref)
	{
		return addAll(count,ref);
	}
	
	public boolean addAll(int index,ResizableArray ref)
	{
		ArrayList<E> a=(ArrayList<E>)ref;
		Object[] temp=new Object[(count+ref.size())*2];
		
		int i=0,j=0,k=index;
		while(i<index)
		{
			temp[i]=ar[i++];
		}
		
		while(j<a.size())
		{
			temp[i++]=a.get(j++);
		}
		
		while(k<size())
		{
			temp[i++]=ar[k++];
		}
		
		 ar=temp;
		
		return true;
	}
	
	public boolean remove(E o)
	{
		boolean flag=false;
		for(int i=0;i<count;i++)
		{
			if(o.equals((E)ar[i]))
			{
				remove(i);
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean remove(int index)
	{
		if(index>=count||index<0)
			return false;
		
		for(int i=index;i<count;i++)
		{
			ar[i]=ar[i+1];
		}
		count--;
		return true;
	}
	
	public boolean removeAll(ResizableArray ref)
	{
		ArrayList<E> a=(ArrayList<E>) ref;
		boolean flag=false;
		for(int i=0;i<a.size();i++)
		{
			if(remove((E)a.ar[i]))
				flag=true;
		}
		return flag;
	}
	
	public boolean retainAll(ResizableArray ref)
	{
		ArrayList<E> a=(ArrayList<E>)ref;
		boolean flag=false;
		Object[] temp=new Object[a.ar.length];
		for(int i=0,j=0;i<count;i++)
		{
			if(a.contains((E)ar[i]))
			{
				flag=true;
				temp[j++]=ar[i];
			}
		}
		ar=temp;
		return flag;
	}
	
	public void clear()
	{
		ar=new Object[ResizableArray.initCap];
		count=0;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean contains(E o)
	{
		for(int i=0;i<count;i++)
		{
			if(((E)ar[i]).equals(o))
				return true;
		}
		return false;
	}
	
	public boolean containsAll(ResizableArray ref)
	{
		ArrayList<E> a=(ArrayList<E>)ref;
		for(int i=0;i<a.count;i++)
		{
			if(!contains((E)a.ar[i]))
				return false;
		}
		return true;
	}
	
	public boolean isEmpty()
	{
		return count==0;
	}
	
	public Object get(int index)
	{
		return ar[index]; 
	}
	
	public Object[] toArray()
	{
		Object[] op=new Object[count];
		for(int i=0;i<count;i++)
		{
			op[i]=ar[i];
		}
		return op;
	}
	public boolean equals(Object o)
	{	
		ArrayList<E> a=(ArrayList<E>)o;
		if(count==a.size())
		{
			for(int i=0;i<count;i++)
			{
				if(!((E)ar[i]).equals((E)a.ar[i]))
					return false;
			}
			return true;
		}
		return false;
		
	}
	
	public int hashCode()
	{
		int op=0;
		for(int i=0;i<count;i++)
		{
			op+=((E)ar[i]).hashCode();
		}
		return op;
	}
	
	public String toString()
	{
		String op="[";
		for(int i=0;i<count;i++)
		{
			op+=ar[i];
			if(i<count-1)
				op+=",";
		}
		op+="]";
		return op;
	}
	
	

}