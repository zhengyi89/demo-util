package other;

import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
//		String str = "{\"result\":{\"success\":\"zy57510015@163,aaa,bbb\",\"failed\":\"ccc,ddd\"}}";
		String str = "{\"result\":{\"success\"\"}}";
		JSONObject json = JSONObject.fromObject(str).getJSONObject("result");
		System.out.println(json);
	}

}
