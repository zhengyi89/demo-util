import com.alibaba.fastjson.JSONObject
import com.test.velocity.User


	
	println "hello world"
	def var1  = "hello"
	println var1
	println var1.class
	var1 = 123
	println var1
	println var1.class

	def list = ["Rod", "Neeta", "Eric", "Missy"]//定义一个集合并将数据放入集合中
	
	User user = new User();
	user.age = 1
	user.name = "zhangsan"
	user.pwd = "zy575100105"
	
	def s = JSONObject.toJSONString(user);
	println s