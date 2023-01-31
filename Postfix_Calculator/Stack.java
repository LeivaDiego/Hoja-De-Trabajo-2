import java.util.ArrayList;

/**
 *
 * @param <T>
 */
public class Stack<T> implements IStack{

    private ArrayList<T> values;

    /**
     *
     */
    public Stack(){
        values = new ArrayList<T>();
    }

    /**
     *
     * @return
     */
    @Override
    public int count() {
        return values.size();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     *
     * @param value
     */
    @Override
    public void push(Object value) {
        values.add(0, (T) value);
    }

    /**
     *
     * @return
     */
    @Override
    public Object pull() {
        if (!isEmpty()){
            return values.remove(0);
        }else return null;
    }

    /**
     * 
     * @return
     */
    @Override
    public Object peek() {
        if (!isEmpty()){
            return values.get(0);
        }else return null;
    }
}
