import java.util.LinkedList;
import java.util.Stack;

//A First-In, Alternating-Out Data Structure
public class FIAO<T> implements Structure<T> {

	private Stack<T> stack;
	private LinkedList<T> queue;
	private boolean input;
	private boolean output;

	public FIAO(){
		stack = new Stack<T>();
		queue = new LinkedList<T>();
	}

	public FIAO(T t){
		stack = new Stack<T>();
		queue = new LinkedList<T>();
		add(t);
	}

	public FIAO(T... ts){
		stack = new Stack<T>();
		queue = new LinkedList<T>();
		for(T t : ts){
			add(t);
		}
	}

	public void add(T t){
		if(input){
			stack.push(t);
		}
		else{
			queue.add(t);
		}
		input=!input;
	}

	public void push(T t){
		add(t);
	}

	public T pop(){
		T ret = null;
		if(output){
			ret = stack.pop();
		}
		else{
			ret = queue.pop();
		}
		output=!output;
		return ret;
	}

	public T remove(){
		return pop();
	}

	public boolean isEmpty(){
		return stack.isEmpty()&&queue.isEmpty();
	}

	public static void main(String[] args){
		FIAO<Integer> fiao = new FIAO<Integer>();
		for(int i = 0; i < 10; i++){
			fiao.push(i);
		}
		while(!fiao.isEmpty()){
			System.out.println(fiao.pop());
		}
	}

}
