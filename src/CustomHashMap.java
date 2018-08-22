class MyHashMap<K,V>{
	public K key;
	public V value;
	public MyHashMap<K,V> next;
	
	public MyHashMap(K key, V value, MyHashMap<K, V> next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}	
}
public class CustomHashMap {
	static MyHashMap [] hashArray =new MyHashMap[10];
	
	
	//Put into HashMap
	static <K, V> void putHash(K key, V value) {
		
		MyHashMap<K, V> map=new MyHashMap<K, V>(key, value, null);
		int index=key.hashCode() & (hashArray.length-1);
		
		if(hashArray[index]==null) {
		hashArray[index]=map;
		}
		else {
			MyHashMap<K, V> m=hashArray[index];
			
			while(m.next!=null) {
				m=m.next;
			}
			if(!map.key.equals(m.key))
				m.next=map;
		}	
	}
	
	//Get from HashMap
	static <K, V> Object getHash(K key) {
		
		int index=key.hashCode() & (hashArray.length-1);
		MyHashMap<K, V> m=hashArray[index];
		
		do{
			if(hashArray[index]==null) {
				return null;
			}
			else if(m.key.equals(key))
				return m.value;
		}while(m.next!=null);
		
		return null;
			
	}
	
	public static void main(String[] args) {

		//Try for Put
		putHash("one","Hello");
		putHash("one","World");
		
		//Try for get
		System.out.println(getHash("one"));
		
	}

	

	

}
