package Java;

public class GarbageCollector {

	public void finalize() {
		System.out.println("object is garbage collected");
	}

	public static void main(String args[]) {
		GarbageCollector s1 = new GarbageCollector();
		GarbageCollector s2 = new GarbageCollector();
		GarbageCollector s3 = new GarbageCollector();
//		s1 = null;
//		s2 = null;
//		s3=null;
		System.gc();
		System.out.println("calling gc");
	}

}
