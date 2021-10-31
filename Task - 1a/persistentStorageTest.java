import static org.junit.Assert.*;

import org.junit.Test;



public class persistentStorageTest {

	@Test
	public void testPut() {
		persistentStorage Storage = new persistentStorage();
		Storage.put("Ivan",43);
		Storage.put("Nina", 3);
		Storage.put("Valko", 8);
		assertFalse(Storage.myhashmap.isEmpty());
		assertEquals(8,Storage.myhashmap.get("Valko"));
		assertEquals(3,Storage.myhashmap.size());
	}

	@Test
	public void testGet() {
		persistentStorage Storage = new persistentStorage();
		Storage.put("Ivan",43);
		Storage.put("Nina", 3);
		Storage.put("Valko", 8);
		assertEquals(3,Storage.myhashmap.get("Nina"));
	}

	@Test
	public void testContains() {
		persistentStorage Storage = new persistentStorage();
		Storage.put("Ivan",43);
		Storage.put("Nina", 3);
		Storage.put("Valko", 8);
		assertTrue(Storage.contains("Ivan"));
	}

	@Test
	public void testRemove() {
		persistentStorage Storage = new persistentStorage();
		Storage.put("Ivan",43);
		Storage.put("Nina", 3);
		Storage.put("Valko", 8);
		Storage.remove("Nina");
		assertFalse(Storage.myhashmap.containsKey("Nina"));
		Storage.remove("Ivan");
		Storage.remove("Valko");
		assertTrue(Storage.myhashmap.isEmpty());
	}

}
