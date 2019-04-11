//A First In, Middle Out data structure
public class FIMO<T> {
	private T[] data;

	public FIMO(){
		data = (T[])(new Object[0]);
	}

	public FIMO(T t){
		data = (T[])(new Object[1]);
		data[0] = t;
	}

	public FIMO(T... ts){
		data = (T[])(new Object[0]);
		for(T t : ts){
			add(t);
		}
	}

	public void add(T t){
		T[] olddata = data;
		data = (T[])(new Object[data.length+1]);
		if(olddata.length%2==0){
			System.arraycopy(olddata, 0, data, 1, olddata.length);
			data[0] = t;
		}
		else{
			System.arraycopy(olddata, 0, data, 0, olddata.length);
			data[olddata.length] = t;
		}
	}

	public void push(T t){
		add(t);
	}

	public T pop(){
		T ret = data[0];
		T[] olddata = data;
		data = (T[])(new Object[data.length-1]);
		System.arraycopy(olddata, 1, data, 0, data.length);
		return ret;
	}

	public boolean isEmpty(){
		return data.length==0;
	}

	public static void main(String[] args){
		FIMO<Integer> fimo = new FIMO<Integer>();
		for(int i = 0; i < 10; i++){
			fimo.push(i);
		}
		while(!fimo.isEmpty()){
			System.out.println(fimo.pop());
		}
	}

}
