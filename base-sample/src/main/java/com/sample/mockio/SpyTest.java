package com.sample.mockio;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 可以使用@Spy注解 或者 spy() 方法来包装一个真实的对象.
 * 除非有特殊的指定,否则每次调用都会委托给该对象.
 */
public class SpyTest {
    @Test
    public void testLinkedListSpyWrong() {
        // 让我们来模拟一个LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);

        // spy.get(0)将会调用真实的方法
        // 将会抛出 IndexOutOfBoundsException (list是空的)
        when(spy.get(0)).thenReturn("foo");
        assertEquals("foo", spy.get(0));
    }

    @Test
    public void testLinkedListSpyCorrect() {
        // 让我们来模拟一个LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);
        // 必须使用doReturn来插桩
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }
}
