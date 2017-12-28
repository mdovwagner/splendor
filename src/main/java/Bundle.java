import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bundle<T> extends HashMap<T,Integer> {

    public Bundle() {

    }

    public Bundle(Bundle b) {
        addBundle(b);
    }


    public Bundle(List<T> names, List<Integer> num){
        for (int i = 0; i < names.size(); i++){
            addMultiple(names.get(i),num.get(i));
        }
    }

    public Bundle(List<T> a){
        for (T o : a) {
            add(o);
        }
    }

    public Bundle(T... a){
        for (T o : a) {
            add(o);
        }
    }
    



    public List<T> toList(){
        List<T> L = new ArrayList<>();
        for (T t : keySet()) {
            for (int i = 0; i < get(t); i++) {
                L.add(t);
            }
        }
        return L;
    }

    public int amount(T key) {
        return getOrDefault(key,0);
    }

    public void add(T key) {
        putIfAbsent(key,0);
        compute(key,(Object x,Integer i) -> i+1);
        if (get(key) == 0) remove(key);

    }

    public void addMultiple(T key,int amount) {
        if (amount == 0) return;
        putIfAbsent(key,0);
        compute(key,(Object x,Integer i) -> i+amount);
        if (get(key) == 0) remove(key);
    }

    public void subtract(T key) throws Exception {
        if (!containsKey(key) || get(key) == 0) throw new Exception("Key not found");
        compute(key,(Object x,Integer i) -> i-1);
        if (get(key) == 0) remove(key);
    }

    public void subtractMultiple(T key, int amount) throws Exception{
        if (amount == 0) return;
        if (!containsKey(key) || get(key) == 0) throw new Exception("Key not found");
        compute(key,(Object x,Integer i) -> i-amount);
        if (get(key) == 0) remove(key);
    }


    public void addBundle(Bundle<T> other) {
        for (T o : other.keySet()) {
            addMultiple(o,other.get(o));
        }
    }

    public void subtractBundle(Bundle<T> other) throws Exception {
        for (T o : other.keySet()) {
            subtractMultiple(o,other.get(o));
        }
    }


}
