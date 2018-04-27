package com.test.db;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;

public class MongoTest2 {
	//���ݿ����Ӷ���
	Mongo connection = null;
	MongoClient mc = null;
	static DBCollection coll = new MongoClient("210.14.158.50", 27017).getDB("useraction").getCollection("loginfo");
	//���ݿ�ʵ��
	DB db = null;
	
	public MongoTest2(String host, int port, String dbname) throws UnknownHostException{
		mc = new MongoClient(host, port);
		db = mc.getDB(dbname);
	}
	
		
	public static void main(String[] args) throws UnknownHostException {
		List<String> list = new ArrayList<String>();
		MongoTest2 mongo3 = new MongoTest2("52.69.253.111", 17270, "useraction");
//		MongoTest2 mongo3 = new MongoTest2("54.148.112.3", 17270, "useraction");
		MongoTest2 mongo50 = new MongoTest2("210.14.158.50", 27017, "useraction");
		DBObject conf = new BasicDBObject();
		conf.put("action", "play");
		conf.put("savetime", new BasicDBObject(QueryOperators.GT, "20151203180302"));
//		conf.put("savetime", new BasicDBObject(QueryOperators.LT, "20151211000000"));
//		conf.put("1", new BasicDBObject("$gte", "20151005"));
		DBCursor cursor = mongo50.find(conf, null, "loginfo");
		System.out.println(cursor.count());
		for (DBObject dbObject : cursor) {
			list.add(dbObject.get("_id").toString());
		}
		int i = 0;
		int j = 0;
		DBCursor cursor1 = mongo3.find(conf, null, "loginfo");
		for (DBObject dbObject : cursor1) {
			if (list.remove(dbObject.get("_id").toString())) {
				i++;
				System.out.println("yipaichu:"+i);
			}else {
				System.out.println(j++);
				mongo50.insert(dbObject, "loginfo");
			}
		}
		System.out.println(i);
//		final Iterator<DBObject> it = cursor.iterator();
//		
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
	}
	
	
	private DBCursor find(DBObject ref, DBObject keys, String string) {
		DBCollection coll = db.getCollection(string);
		DBCursor cursor = coll.find(ref, keys);
		return cursor;
	}
	/**
	 * �������ݿ⼯��
	 * @param columnName
	 */
	public void createCollection(String columnName){
		DBObject dbo = new BasicDBObject();
		db.createCollection(columnName, dbo);
	}
	/**
	 * �����ݼ����в���
	 */
	public void insert(DBObject dbo, String collName){
		DBCollection coll = db.getCollection(collName);
		coll.insert(dbo);
	}
	/*
	 * ��������
	 */
	public synchronized void insertBatch(List<DBObject> dbobjects){
		coll.insert(dbobjects);
	}
	/**
	 * ����idɾ�� 
	 */
	public int deleteById(String id, String collName){
		DBCollection coll = db.getCollection(collName);
		return coll.remove(new BasicDBObject("_id", new ObjectId(id))).getN();
	}
	
	
	public static String genRandomCode(int length) { //length��ʾ�����ַ����ĳ���
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789abcdefghijklmnopqrstuvwxyz";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();
	 }  
	
	/**
	 * ����������ظ����û���
	 * @return
	 */
	public static String genUsername() { //length��ʾ�����ַ����ĳ���
	    return format("yyMMdd", new Date())+genRandomCode(6).toString();
	}  
	
	public static String format(String patten, Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		return sdf.format(date);
	}
}
