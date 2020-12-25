import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @Author: zhengyi
 * @Date: 2020/6/11 17:33
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s = ConfigTools.decrypt("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALzeqa4AewInhhTN4s37Bkq3" +
                "+UaDaStYpRZr6v485NBguj" +
                "/BX4how6mEjHegmjqsUoCrTtr+iv5QN+uEGiRXQjcCAwEAAQ==", "LTutAYlITMOjBmnV4zxQ9f" +
                "/7VofB5i3b8GNm8S9cUwgZLjkESwusNYMBAcp4AXQSbHqiATY5QYkU7jHRleGMzA==");
        System.out.println(s);
    }
}
