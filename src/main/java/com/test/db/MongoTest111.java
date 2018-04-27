package com.test.db;


import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoTest111 {
	//���ݿ����Ӷ���
	Mongo connection = null;
	MongoClient mc = null;
	//���ݿ�ʵ��
	DB db = null;
	public static DBCollection coll ;
	public MongoTest111(String host, int port, String dbname) throws UnknownHostException{
		mc = new MongoClient(host, port);
		db = mc.getDB(dbname);
	}
	
		
	public static void main(String[] args) throws UnknownHostException {
		MongoTest111 mongo3 = new MongoTest111("54.148.112.3", 17270, "useraction");
//		DBCursor cursor = mongo3.find(new BasicDBObject("action", "play").append("1", new BasicDBObject("$gte","20151015111111")), null, "loginfo");
		DBCursor cursor = mongo3.find(new BasicDBObject("action", "play").append("1", new BasicDBObject("$lte","20151015111111")), null, "loginfo");
		System.out.println(cursor.count());
		final Iterator<DBObject> it = cursor.iterator();
		coll = new MongoClient("210.14.158.50", 27017).getDB("useraction").getCollection("loginfo");
		int i = 0;
//		List<DBObject> dbobjects = new ArrayList<DBObject>();
		while (it.hasNext()) {
			System.out.println(i);
			i++;
//			dbobjects.add(it.next());
//			if (i%100 == 0) {
//				System.out.println("11-------------"+i);
//				insertBatch(dbobjects);
//				dbobjects = new ArrayList<DBObject>();
//			}
			insert(it.next());
		}
		
	}
	
	private static void insertBatch(List<DBObject> dbobjects) {
		coll.insert(dbobjects);
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
	public static void insert(DBObject dbo){
		coll.insert(dbo);
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
