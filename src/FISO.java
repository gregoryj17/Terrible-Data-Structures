import java.util.PriorityQueue;
import java.util.Comparator;
import java.security.MessageDigest;

//A First-In, Scrambled-Out data structure
public class FISO<T> implements Structure<T> {
	private PriorityQueue<T> data;

	public FISO(){
		data = new PriorityQueue<T>(1, new TComp<T>());
	}

	public FISO(T t){
		data = new PriorityQueue<T>(1, new TComp<T>());
		data.add(t);
	}

	public FISO(T... ts) {
		data = new PriorityQueue<T>(ts.length, new TComp<T>());
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
		return data.poll();
	}

	public T pop(){
		return remove();
	}

	public boolean isEmpty(){
		return data.isEmpty();
	}

	public static void main(String[] args){
		FISO<String> fiso = new FISO<String>();
		for(int i = 0; i < 10; i++){
			fiso.push(""+i);
		}
		while(!fiso.isEmpty()){
			System.out.println(fiso.pop());
		}
	}

}

class TComp<T> implements Comparator<T>{
	
	public int compare(T o1, T o2){
		String s1 = hash(""+o1.hashCode(),"salt");
		String s2 = hash(""+o2.hashCode(),"salt");
		if(s1.hashCode()<s2.hashCode())return -1;
		else if(s1.hashCode()>s2.hashCode())return 1;
		else return 0;
	}
	
	public static String hash(String str, String salt){
		try {
			String toHash = str + salt;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(toHash.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(byte b : hash){
				sb.append(String.format("%02x",b));
			}
			return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
