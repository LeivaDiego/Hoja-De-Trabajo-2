import java.util.ArrayList;

public class Stack<T> implements IStack{

    private ArrayList<T> values;

    public Stack(){
        values = new ArrayList<T>();
    }

    @Override
    public int count() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public void push(Object value) {
        values.add(0, (T) value);
    }

    @Override
    public Object pull() {
        if (!isEmpty()){
            return values.remove(0);
        }else return null;
    }

    @Override
    public Object peek() {
        if (!isEmpty()){
            return values.get(0);
        }else return null;
    }
}
