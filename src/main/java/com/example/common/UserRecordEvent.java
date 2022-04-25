package com.example.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;

/**
 * @author wf
 * @date 2022/4/22 11:08
 * @description
 */


public class UserRecordEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    public UserRecordEvent(@Qualifier("jacksonObjectMapper") Object source) {
        super(source);
    }
    private String name = "hello";
}
