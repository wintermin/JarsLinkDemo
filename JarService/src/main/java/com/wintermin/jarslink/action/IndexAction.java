package com.wintermin.jarslink.action;

import com.alipay.jarslink.api.Action;
import com.wintermin.jarslink.entity.Index;

/**
 * Created by liumin on 2018/4/6.
 */
public class IndexAction implements Action<String,Index>{

    @Override
    public Index execute(String indexName) {
        return new Index()
                .setName(indexName)
                .setX(666)
                .setY(666);
    }

    @Override
    public String getActionName() {
        return "index";
    }
}
