import java.util.ArrayList;

//A First-In, Never-Out data structure
public class FINO<T> implements Structure<T> {
	private int data;

	public FINO(){
		data = 0;
	}

	public FINO(T t){
		data = 1;
	}

	public FINO(T... ts) {
		data = ts.length;
	}

	public void add(T t){
		data++;
	}

	public void push(T t){
		add(t);
	}

	public T remove(){
		if(isEmpty())(new ArrayList<>()).remove(0);
		data--;
		return null;
	}

	public T pop(){
		return remove();
	}

	public boolean isEmpty(){
		return data <= 0;
	}

	public static void main(String[] args){
		FINO<Integer> fino = new FINO<Integer>();
		for(int i = 0; i < 10; i++){
			fino.push(i);
		}
		while(!fino.isEmpty()){
			System.out.println(fino.pop());
		}
	}

}
