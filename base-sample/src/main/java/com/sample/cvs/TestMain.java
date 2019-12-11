package com.sample.cvs;

///**
// * @author zhengy
// * @date 18/8/20上午9:57
// */
//public class TestMain {
//    public static void main(String[] args) {
//        File csvData = new File("");
//        CSVParser parser = null;
//        try {
//            parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (CSVRecord csvRecord : parser) {
//            if (csvRecord.getRecordNumber()==1) {
//                continue;
//            }
//            // 生成展示列表
//            serverReslutMap.put(csvRecord.get(1), csvRecord);
//
//        }
//    }
//}