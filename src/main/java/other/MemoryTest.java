package other;

public class MemoryTest {
	  
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
       System.out.println( "memory info :" + toMemoryInfo ());
    }
  
    /**
     * 获取当前jvm的内存信息
     * @return
     */    
    public static String toMemoryInfo() {
  
       Runtime runtime = Runtime.getRuntime ();
       int freeMemory = ( int ) (runtime.freeMemory() / 1024 / 1024);
       int totalMemory = ( int ) (runtime.totalMemory() / 1024 / 1024);
       return freeMemory + "M/" + totalMemory + "M(free/total)" ;
    }
}
