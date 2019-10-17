package com.demo.spring.eventListener;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义保存事件
 * @author peter
 * 2019/1/27 14:59
 */
public class PersonSaveEvent<DATA> extends ApplicationEvent {
    private DATA data;

    public PersonSaveEvent(DATA source) {
        super(source);
        this.data = source;
    }

    public DATA getData() {
        return data;
    }
}

    