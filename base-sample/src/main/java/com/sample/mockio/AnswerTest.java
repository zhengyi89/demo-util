package com.sample.mockio;

import org.junit.Test;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * 在写测试用例时针对复杂的方法结果往往会使用Answer.
 * 虽然使用thenReturn可以每次返回一个预定义的值,但是通过answers可以让你的插桩方法(stubbed method)根据参数计算出结果.
 * <p>
 * 下面是使用Answer实现插桩方法返回第一个参数值的示例
 */
public class AnswerTest {
    //假设存在这么一个类(仅为测试,毫无意义)
    class TestObj {
        public String add(String firstArg, String lastArg) {
            return "";
        }
    }

    //...
    @Test
    public final void answerTest() {
        TestObj testObj = mock(TestObj.class);
        // with doAnswer():
        doAnswer(returnsFirstArg()).when(testObj).add(anyString(), anyString());
        // with thenAnswer():
        when(testObj.add(anyString(), anyString())).thenAnswer(returnsFirstArg());
        // with then() alias:
        when(testObj.add(anyString(), anyString())).then(returnsFirstArg());
        //测试打印结果
        System.out.println(testObj.add("FirstArg", "LastArg"));
    }
}
