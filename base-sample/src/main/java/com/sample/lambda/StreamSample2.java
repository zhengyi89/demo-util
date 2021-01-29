package com.sample.lambda;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream是对集合的包装,通常和lambda一起使用。 使用lambdas可以支持许多操作,如 map, filter, limit, sorted,
 * count, min, max, sum, collect 等等。 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst()
 * 这样的方法就会结束链式语法。
 *
 * @author zhengy
 */
public class StreamSample2 {
    private final static Logger logger = LoggerFactory.getLogger(StreamSample2.class);

    List<KlassGroup> groupList = Arrays.asList(
            new KlassGroup(new Klass(1), new Klass(2), new Klass(3)),
            new KlassGroup(new Klass(4), new Klass(5), new Klass(6)),
            new KlassGroup(new Klass(7), new Klass(8), new Klass(9)),
            new KlassGroup(new Klass(10))
    );

    @Test
    public void userMap() {
        List<List<Klass>> result = groupList.stream()
                .map(it -> it.getGroup())
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 将每个KlassGroup对象中的那些Klass类取出来，放到一个ArrayList里面，得到一个List<Klass>
     * <p>
     * flatMap方法最终会把所有返回的stream合并，map方法做不到这一点
     */
    @Test
    public void useFlatMap() {
        List<Klass> result = groupList.stream()
                .flatMap(it -> it.getGroup().stream())
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result));
    }


    @Data
    class Klass {
        private int field;

        public Klass(int field) {
            this.field = field;
        }
    }

    @Data
    class KlassGroup {
        private List<Klass> group = new ArrayList<>();

        public KlassGroup(Klass... objList) {
            for (Klass item : objList) {
                this.group.add(item);
            }
        }
    }
}
