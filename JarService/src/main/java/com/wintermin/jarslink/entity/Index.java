package com.wintermin.jarslink.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by liumin on 2018/4/6.
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Index {

    private int x;

    private int y;

    private String name;
}
