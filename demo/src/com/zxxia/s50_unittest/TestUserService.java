package com.zxxia.s50_unittest;

 import org.junit.*;

/**
 * 单元测试
 * 1. 自己写的单元测试弊端：
 * ----其中一个方法蹦了，会影响到其它方法
 * ----只有程序员自己能看到输出结果，不方便别人查看
 * ----无法自动化测试
 * 2. 解决上述问题，引入Junit单元测试框架
 * ----其中一个方法蹦了，不影响其它
 * ----会生成测试报告
 * ----灵活选择执行哪些测试方法，一键测试
 * 3. 如何使用Junit
 * ----导入Junit包：如何导入，输入@Test，会报错，然后修复下；或者将jar拷贝到lib下
 * ----类必须是公开的，无返回值，无参数
 * ----测试方法添加注解标记
 * -------@Test，@before, @after @beforeClass, @afterClass
 * ----Assert.assertEquals
 */
class UserService {
    public boolean loginName(String strName, String strPsw) {
        if (strName.equals("admin") && strPsw.equals("123456")) {
            return true;
        }
        return false;
    }

    public void selectNames() {
        System.out.println(10/2);
        System.out.println("查询全部用户");
    }

}

public class TestUserService {
    @Before
    public void before() {
        System.out.println("before");
    }
    @After
    public void after() {
        System.out.println("after");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @Test
    public void testLoginName() {
        UserService userService = new UserService();
        boolean rs = userService.loginName("admin", "123456");
        Assert.assertEquals("你的逻辑可能异常", true, rs);
        System.out.println("Ok");
    }
    @Test
    public void testSelectNames() {
        UserService userService = new UserService();
        userService.selectNames();
    }
}

