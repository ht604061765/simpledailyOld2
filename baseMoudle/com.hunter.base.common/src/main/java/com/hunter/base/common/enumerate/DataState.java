package com.hunter.base.common.enumerate;

/**
 * 数据状态.
 * @author hantao
 * @date 2020/08/19
 */
public enum DataState {

    NORMAL("启用"),

    CANCEL("作废"),

    STOP("停用"),

    LOCK("锁定"),

    DRAFT("草稿");

    private String name;

    DataState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
