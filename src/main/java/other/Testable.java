package other;

import org.junit.Test;


public class Testable {
	@Test 
	public void execute(){
		System.out.println("execute.,...");
	}
	public void testExecute(){
		execute();
	}
}
