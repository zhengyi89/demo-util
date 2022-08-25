
package com.sample.mockio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTests {

    @Mock
    private LinkedList mockedList;

    @Before
    public void before() {
        //use @Mock annotation don't miss initMocks()
//        MockitoAnnotations.initMocks(this);
    }

    /**
     * 验证某些行为
     */
    @Test
    public void mockAndVerify() {
        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //using mock object 使用mock对象
        mockedList.add("one");
        mockedList.clear();

        //verification 验证
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 测试桩 (Stub)
     */
    @Test
    public void stubTest() {
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 输出“first”
        System.out.println(mockedList.get(0));

        // 抛出异常
//        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
        //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
        verify(mockedList, times(2)).get(anyInt());
    }

    /**
     * 验证函数的确切、最少、从未调用次数
     */
    @Test
    public void invocateTest() {
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        // 使用atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    /**
     * 为返回值为void的函数通过Stub抛出异常
     */
    @Test
    public void voidTest() {
        LinkedList mockedList = mock(LinkedList.class);
        // 不能这样写
//        when(mockedList.clear()).thenThrow(new RuntimeException());
        doThrow(new RuntimeException()).when(mockedList).clear();

        // 调用这句代码会抛出异常
        mockedList.clear();
    }

    /**
     * 验证执行执行顺序
     */
    @Test
    public void orderTest() {
        // 第一次调用时返回"one",第二次返回"two",第三次返回"three"
//        doReturn("one", "two", "three").when(mockedList).get(anyInt());

//        when(mockedList.get(anyInt())).thenReturn("one", "two", "three");
        doReturn("one", "two", "three").when(mockedList).get(anyInt());

        for (int i = 0; i < 10; i++) {
            System.out.println("get list:" + mockedList.get(i));
        }
    }


    @Test
    public void dd(){
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(anyInt())).thenReturn("11","22","33");
        for (int i = 0; i < 10; i++) {
            System.out.println("get list:" + mockedList.get(i));
        }
    }
}
