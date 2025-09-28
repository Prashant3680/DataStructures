public interface ResizableArray<E>
{
	int initCap=10;
	double loadFactor=0.75;
	
	boolean addObject(E o);
	boolean addObject(int index,E o);
	boolean addAll(ResizableArray ar);
	boolean addAll(int index,ResizableArray ar);
	boolean remove(E o);
	boolean remove(int index);
	boolean removeAll(ResizableArray ar);
	boolean retainAll(ResizableArray ar);
	void clear();
	int size();
	boolean contains(E o);
	boolean containsAll(ResizableArray ar);
	boolean isEmpty();
	Object get(int index);
	Object[] toArray();
	boolean equals(Object o);
	int hashCode();
	String toString();

}