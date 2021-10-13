package lesson7;

public class Tests {

    @BeforeSuite
    public void beforeTask() {
        System.out.println("Before tasks");
    }

    @AfterSuite
    public void afterTask() {
        System.out.println("After tasks");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test task with priority 1");
    }

    @Test(priority = 3)
    public void test2() {
        System.out.println("Test task with priority 3");
    }

    @Test
    public void test3() {
        System.out.println("Test task with default priority");
    }

    @Test(priority = 7)
    public void test4() {
        System.out.println("Test task with priority 7");
    }

    @Test(priority = 9)
    public void test5() {
        System.out.println("Test task with priority 9");
    }

}
