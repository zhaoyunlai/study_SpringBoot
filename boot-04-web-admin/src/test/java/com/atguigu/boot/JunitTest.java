package com.atguigu.boot;

import lombok.ToString;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/14/12:27
 * @Description:
 */
@DisplayName("Junit5功能测试类")
public class JunitTest {

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(1==2,"结果不是true");
        //如果条件不满足，测试的报告里会归为跳过的方法或者忽略的方法
        System.out.println(11111);
    }


    /**
     * 断言：前面的断言失败了，后面得代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int res = add(2,3);
        assertEquals(5,res,"业务逻辑计算失败");

        //前面的断言失败了后面的逻辑就不会运行
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2);
    }

    int add(int i,int j){
        return i+j;
    }

    /**
     * 数组断言
     */
    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }


    @DisplayName("组合断言")
    @Test
    void all(){
        assertAll("testAll",
                ()->assertTrue(true && true,"结果不是ture"),
                ()->assertEquals(1,1,"result is not 1"));
    }

    @DisplayName("异常断言")
    @Test
    void Exception(){
        assertThrows(ArithmeticException.class,()->{
            int i = 10/0;
        },"业务逻辑正常运行了，没有抛异常，肯定有问题");
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    /**
     * 快速失败，通过fail方法直接使得测试失败
     */
    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

    @DisplayName("测试DisplayName注解")
    @Test
    public void testDisplayName(){
        System.out.println("测试DisplayName注解");
    }

    @DisplayName("测试方法2")
    @Test
    void test(){
        System.out.println("测试方法2");
    }

    //多长时间后超时之后超时
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(520);
    }

    //每一个测试方法开始之前
    @BeforeEach
    public void testBeforeEach(){
        System.out.println("测试要开始了...");
    }

    //每一个测试方法结束之后
    @AfterEach
    public void testAfterEach(){
        System.out.println("测试结束了...");
    }

    //只执行一次，声明为静态的
    @BeforeAll
    public static void testBeforeAll(){
        System.out.println("所有测试就要开始了...");
    }

    //只执行一次，声明为静态的
    @AfterAll
    public static void testAfterAll(){
        System.out.println("所有测试结束了...");
    }

}
