package com.demo.junit;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.*;
import org.springframework.format.annotation.DateTimeFormat;

import static org.junit.Assert.assertEquals;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 18/7/12下午8:15
 */
public class TestMain {

    @Before
    public void before() {
        System.out.println("@Before");
    }

    @Test
    @DateTimeFormat
    @JsonFormat
    /**
     *Mark your test cases with @Test annotations.
     *You don’t need to prefix your test cases with “test”.
     *tested class does not need to extend from “TestCase” class.
     */
    public void test() {
        System.out.println("@Test");
        assertEquals(5 + 5, 10);
    }

    @Ignore
    @Test
    public void testIgnore() {
        System.out.println("@Ignore");
    }

    @Test(timeout = 50)
    public void testTimeout() {
        System.out.println("@Test(timeout = 50)");
        assertEquals(5 + 5, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testExpected() {
        System.out.println("@Test(expected = Exception.class)");
        throw new ArithmeticException();
    }

    @After
    public void after() {
        System.out.println("@After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    };

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    };
}