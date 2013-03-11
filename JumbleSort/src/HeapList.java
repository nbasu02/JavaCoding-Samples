import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * An extension of ArrayList that remains sorted
 * @author Neil Basu
 */
@SuppressWarnings("serial")
public class HeapList<T> extends ArrayList<T> {
	
	/**
	 * Inserts new entry into list.  Searches for where in the list it should be inserted to keep it 
	 * in sorted order.  Does not resort an unsorted list.
	 * @param newEntry A new value to insert into the list.  
	 */
	@SuppressWarnings("unchecked")
	public void insertSorted(T newEntry)
	{
		add(newEntry);
		Comparable<T> comparable;
		if (newEntry instanceof String)
		{
			comparable = (Comparable<T>) ((String) newEntry).toLowerCase();
			Collections.sort(this, new SortIgnoreCase());
		}
		else
		{
			comparable = (Comparable<T>) newEntry;
			for (int i = size()-1; i > 0 && comparable.compareTo(get(i-1)) < 0; i--)
	            Collections.swap(this, i, i-1);

		}
		
	}
	
	/**
	 * @return Removes and returns the smallest element in the list
	 */
	public T pop()
	{
		return remove(0);
	}
	
    /**
     * Extends comparators to more effectively sort strings regardless of case
     * @author Neil Basu
     * 
     */
    public class SortIgnoreCase implements Comparator<Object> {
        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(Object object1, Object object2) {
            String string1 = (String) object1;
            String string2 = (String) object2;
            return string1.toLowerCase().compareTo(string2.toLowerCase());
        }
    }

}