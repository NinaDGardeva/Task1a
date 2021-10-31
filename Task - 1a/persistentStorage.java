import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.io.IOException;

public class persistentStorage {
	public HashMap<String,Object> myhashmap;
	
	public persistentStorage(){
		
			HashMap<String,Object> myhashmap = new HashMap<String,Object>();
		
	}
	
		//check if there is info in the hashmap
		private void checkmap(){
	
			if(myhashmap == null){
		
				try{
					FileInputStream fis = new FileInputStream("persistentstorage.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					try {
						myhashmap = (HashMap<String,Object>) ois.readObject();
					} catch (ClassNotFoundException e) {}
					ois.close();
					fis.close();
				}catch(IOException e) {}
			}	
		}

		public void put(String key, Object value){

			try{
				FileOutputStream fos = new FileOutputStream("persistentstorage.ser", false);
				try{
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					checkmap();
					if(contains(key) == true)
						System.out.println("The Storage already contains this key!");
					else { 
						myhashmap.put(key,value);
						oos.writeObject(myhashmap);
						oos.close();
						fos.close();
					}
				}catch(Exception e) {System.out.println(e);}
			}catch(Exception e) {System.out.println(e);}
		}

		
		public Object get(String key){
	
			checkmap();	
			return 	myhashmap.get(key);
		}

		public boolean contains(String key){
	
			checkmap();
			return myhashmap.containsKey(key);
	
		}

		public boolean remove(String key){
	
			try{
				FileOutputStream fos = new FileOutputStream("persistentstorage.ser", false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				checkmap();
				if(contains(key) == false) {
					oos.close();
					fos.close();
					return false;
				}
				else {
					myhashmap.remove(key);
					oos.writeObject(myhashmap);
					oos.close();
					fos.close();
				}
			}catch(IOException e) {}
			return true;
		}
}
