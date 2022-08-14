package com.atguigu.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/14/19:56
 * @Description:
 */
@DisplayName("参数化测试")
public class TestParameterDemo {

    @ParameterizedTest
    @DisplayName("参数化测试方法，数组")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameter(int i){
        System.out.println(i);
    }


    static Stream<String> stringProvider(){
        return Stream.of("apple","banana","orange");
    }

    @ParameterizedTest
    @DisplayName("参数化测试方法,传入方法参数")
    @MethodSource("stringProvider")
    void testParameterStream(String i){
        System.out.println(i);
    }
}
