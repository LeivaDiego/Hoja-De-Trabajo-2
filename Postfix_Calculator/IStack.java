/**
 * @author MAAG
 *
 */
public interface IStack<T> {

	/**
	 *
	 * @return
	 */
	int count();

	/**
	 *
	 * @return
	 */
	boolean isEmpty();

	/**
	 *
	 * @param value
	 */
	void push(T value);

	/**
	 *
	 * @return
	 */
	T pull();

	/**
	 *
	 * @return
	 */
	T peek();
}
