package com.sample.mockio;

import com.sample.mockio.depend.MyClass;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


/**
 * Mockito将会追踪所有方法的调用和传入模拟对象的参数.
 * 你可以在模拟对象上使用verify()方法验证指定的条件是否满足.
 * 例如,你可以验证是否使用某些参数调用了方法.这种测试称为行为测试.
 * 行为测试并不能检查方法调用的结果,但是它可以验证一个方法是否使用正确的参数被调用.
 */
public class VerifyTest {
    @Test
    public void testVerify() {
        // 创建模拟对象
        MyClass test = Mockito.mock(MyClass.class);
        when(test.getUniqueId()).thenReturn(43);

        // 调用模拟对象的方法testing,并传入参数12
        test.testing(12);
        test.getUniqueId();
        test.getUniqueId();

        // 检查方法testing是否使用参数
        //12调用了
        verify(test).testing(ArgumentMatchers.eq(12));

        // 验证调用两次getUniqueId
        verify(test, times(2)).getUniqueId();

        // 也可以使用下面的方法来替代调用的次数
//        verify(test, never()).someMethod("never called 从来没有调用");
//        verify(test, atLeastOnce()).someMethod("called at least once 至少被调用一次");
//        verify(test, atLeast(2)).someMethod("called at least twice 至少被调用5次");
//        verify(test, times(5)).someMethod("called five times 被调用5次");
//        verify(test, atMost(3)).someMethod("called at most 3 times 至多被调用3次");
        //下面的方法用来检查是否所有的用例都涵盖了,如果没有将测试失败
        //放在所有的测试后面
        verifyNoMoreInteractions(test);
    }
}
