package com.atguigu.boot.bean;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/04/16:29
 * @Description:
 */
public class Pet {
    private String name;

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
