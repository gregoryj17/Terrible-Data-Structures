import java.util.ArrayList;
import java.util.Random;

//A First-In, Random-Out data structure
public class FIRO<T> implements Structure<T> {
	private ArrayList<T> data;

	public FIRO(){
		data = new ArrayList<T>();
	}

	public FIRO(T t){
		data = new ArrayList<T>();
		data.add(t);
	}

	public FIRO(T... ts) {
		data = new ArrayList<T>();
		for(T t : ts){
			add(t);
		}
	}

	public void add(T t){
		data.add(t);
	}

	public void push(T t){
		add(t);
	}

	public T remove(){
		return data.remove((new Random()).nextInt(data.size()));
	}

	public T pop(){
		return remove();
	}

	public boolean isEmpty(){
		return data.isEmpty();
	}

	public static void main(String[] args){
		FIRO<Integer> firo = new FIRO<Integer>();
		for(int i = 0; i < 10; i++){
			firo.push(i);
		}
		while(!firo.isEmpty()){
			System.out.println(firo.pop());
		}
	}

}
