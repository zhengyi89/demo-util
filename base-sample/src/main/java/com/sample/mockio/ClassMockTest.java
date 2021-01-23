package com.sample.mockio;

import com.sample.mockio.depend.MyClass;
import com.sample.mockio.depend.Todo;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ClassMockTest {
    @Test
    public void test1() {
        //  创建mock对象
        MyClass test = mock(MyClass.class);
        // 定义getUniqueId()方法返回特定的值
        when(test.getUniqueId()).thenReturn(43);
        // 执行测试
        assertEquals(test.getUniqueId(), 43);
    }

    /**
     * 返回多个值的示例
     */
    @Test
    public void testMoreThanOneReturnValue() {
        Iterator<String> i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

    /**
     * 如何根据输入来返回值
     */
    @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable<String> c = mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

    /**
     * 返回值独立于输入值
     */
    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        Comparable<Integer> c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(9));
    }

    /**
     * 根据提供参数的类型返回特定的值
     */
    @Test
    public void testReturnValueInDependentOnMethodParameter2() {
        Comparable<Todo> c = mock(Comparable.class);
        when(c.compareTo(isA(Todo.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(new Todo(1)));
    }
}