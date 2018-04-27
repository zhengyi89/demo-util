package com.test.db;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class MongTest {
	public static void main(String[] args) {
		Mongo mg = new Mongo("127.0.0.1:27017");
		System.out.println(mg);
		List<String> dbname = mg.getDatabaseNames();
//			for (String string : dbname) {
//				System.out.println(string);
//			}
		DB db = mg.getDB("zhengy");
//			Set<String> collNames = db.getCollectionNames();
//			for (String string : collNames) {
//				System.out.println("collname:"+string);
//			}
		DBCollection person = db.getCollection("person");
		DBCursor dc = person.find();
		while(dc.hasNext()){
			DBObject dbo = dc.next();
			System.out.println(dbo);
		}
		System.out.println(dc.count());
		System.out.println(JSON.serialize(dc));
	}

}
