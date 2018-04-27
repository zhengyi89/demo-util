package com.test.db;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoTest {
	//���ݿ����Ӷ���
	static Mongo connection = null;
	static MongoClient mc = null;
	//���ݿ�ʵ��
	static DB db = null;
//	public MongoTest(String dbname) throws UnknownHostException{
//		connection = new Mongo();
//		db = connection.getDB(dbname);
//	}
	
	public MongoTest(String dbname) throws UnknownHostException{
		mc = new MongoClient("210.14.158.50", 27017);
//		mc = new MongoClient("54.148.112.3", 17270);
//		mc = new MongoClient("127.0.0.1", 27017);
		db = mc.getDB(dbname);
	}
	
//	public MongoTest(String dbname) throws UnknownHostException{
//		mc = new MongoClient("54.148.112.3", 17270);
//		db = mc.getDB(dbname);
//	}
		
	public static void main(String[] args) throws UnknownHostException {
		//ʵ����
		MongoTest mongo = new MongoTest("test");
		//����һ���� test �����ݿ⼯��
//		mongo.createCollection("test");
		//Ϊ�������һ������
//		DBObject dbo = new BasicDBObject();
//		dbo.put("name", "zhangsan");
//		dbo.put("age", "13");
//		List<String> books = new ArrayList<String>();
//		books.add("HTML");
//		books.add("JAVA");
//		dbo.put("books", books);
//		mongo.insert(dbo, "test");
		
		//��������
		List<DBObject> dbobjects = new ArrayList<DBObject>();
		DBObject lisi =  new BasicDBObject();
		DBObject wangwu =  new BasicDBObject();
		DBObject zhaoliu =  new BasicDBObject();
		lisi.put("name", "lisi");
		wangwu.put("name", "wangwu");
		zhaoliu.put("name", "zhaoliu");
		dbobjects.add(lisi);
		dbobjects.add(wangwu);
		dbobjects.add(zhaoliu);
		mongo.insertBatch(dbobjects, "test");
		
		//����idɾ��
//		int rows = mongo.deleteById("55a6386fa0330b294aceebc8", "test");
//		System.out.println(rows);
		
		//in ɾ��
//		BasicDBList dbList=new BasicDBList();  //�����������
//		String[] idarr = {"47056","64679"};
//		for (String id : idarr) {
//			dbList.add(id);
//		}
//		DBObject inObj=new BasicDBObject("$in", dbList);  //$in���﷨
//		int i = db.getCollection("collection").remove(new BasicDBObject("id", inObj).append("userid", "1")).getN(); 
//		System.out.println(i);
		
		
		//����������ɾ��
//		DBObject lisi = new BasicDBObject();
//		lisi.put("mode", "a");
//		int rows = mongo.delete(lisi, "analyze");
//		System.out.println(rows);
		//����
//		DBObject dbo = new BasicDBObject();
////		dbo.put("$set", new BasicDBObject("1", "20150921181157"));
//		dbo.put("$inc", new BasicDBObject("count", 11));
//		BasicDBObject dbo1 = new BasicDBObject();
//		dbo1.put("tag", "play-_-brandcountbyid-_-Amazon-_-20150929-_-02-_-v11");
////		dbo1.put("type", "regioncount");
//		int rows = mongo.update(dbo1, dbo, false, true, "analyzetest");
//		System.out.println(rows);
//		//��ѯ
//		DBObject keys = new BasicDBObject();
//		keys.put("uid", true);
//		keys.put("sid", true);
//		keys.put("entitytype", true);
//		keys.put("region", true);
//		keys.put("1", true);
//		keys.put("2", true);
//		keys.put("1", true);
//		keys.put("amount", true);
//		DBObject con = new BasicDBObject();
//		con.put("time", "");
		
//		con.put("action", "buy");
//		Pattern pattern = Pattern.compile("^201509.*$");//ģ����ѯ  ����ȫƥ��
//		con.put("sid", "cetv");
//		con.put("1", new BasicDBObject("$gte", "20151005").append("$lte", "20151005999999"));
//		con.put("1", pattern);
//		
//		DBCursor cursor = mongo.find(con, null, "analyze");
//		
//		System.out.println(cursor);
//		double amount = 0;
//		int i = 0;
//		for (DBObject dbObject : cursor) {
//			i++;
//			amount += Double.parseDouble(dbObject.get("3")+"");
//			mongo.insert(dbObject, "buyloginfo");
//		}
//		System.out.println(String.format("%.2f", amount));
//		System.out.println("-------------:"+i);
		//ȥ�ز�ѯ
//		DBCollection coll = db.getCollection("loginfo");        
//		List l =  coll.distinct("entitytype"); 
//		int i = 0;
//		for (Object object : l) {
//			i++;
//			System.out.print(String.valueOf(object)+",");
//			if (i%20==0) {
//				System.out.println();
//			}
//		}

		//������ѯ
//		BasicDBList condList = new BasicDBList(); 
//		BasicDBList condList1 = new BasicDBList(); 
//		DBObject key1 = new BasicDBObject();
//		key1.put("type", "video");
//		DBObject key2 = new BasicDBObject();
//		key2.put("type", "tv");
//		key2.put("time", new BasicDBObject("$gte", "20151111 18:33:11"));
//		condList.add(key1);
//		condList.add(key2);
//		condList1.add(new BasicDBObject("play_time","12"));
//		DBObject base = new BasicDBObject("$or", condList);
//		condList1.add(base);
//		DBObject base1 = new BasicDBObject("$and", condList1);
//		DBObject show = new BasicDBObject();
//		show.put("_id", false);
//		DBCursor cur = mongo.find(base1, show, "playhistory");
//		for (DBObject dbObject : cur) {
//		System.out.println(dbObject);
		
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
	public void insertBatch(List<DBObject> dbobjects, String collName){
		DBCollection coll = db.getCollection(collName);
		coll.insert(dbobjects);
	}
	/**
	 * ����idɾ�� 
	 */
	public int deleteById(String id, String collName){
		DBCollection coll = db.getCollection(collName);
		return coll.remove(new BasicDBObject("_id", new ObjectId(id))).getN();
	}
	/**
	 * ɾ��
	 */
	private int delete(DBObject dbo, String columnName) {
		DBCollection coll = db.getCollection(columnName);
		return coll.remove(dbo).getN();
	}
	/**
	 * ��������
	 * @param basicDBObject ��ѯ��
	 * @param dbo �޸���
	 * @param b �Ƿ���²���
	 * @param c �Ƿ�����
	 * @param collname  
	 */
	private int update(BasicDBObject q, DBObject o, boolean b,
			boolean c, String collname) {
		DBCollection coll = db.getCollection(collname);
		return coll.update(q, o, b, c).getN();
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
