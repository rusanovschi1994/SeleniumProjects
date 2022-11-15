import org.junit.*;

public class MainClassTest {

//    @BeforeClass
//    public static void beforeClassMethod(){
//
//    }
//
//    @Before
//    public void beforeEveryMethod(){
//
//    }

    @Test
    public void method1(){

        Assert.assertTrue(1+1==2);
    }

    @Test
    public void method2(){

        Assert.assertFalse("This test is true", 1-1==0);
    }

    @Test
    public void method3(){
        Assert.assertEquals(10, 5+5);

    }

    @Test
    public void method4(){
        Assert.assertNotEquals("This condition is equal", 20, 10 + 10);
    }

//    @After
//    public void afterEveryMethod(){
//
//    }
//
//    @AfterClass
//    public static void afterClassMethod(){
//
//    }
}
