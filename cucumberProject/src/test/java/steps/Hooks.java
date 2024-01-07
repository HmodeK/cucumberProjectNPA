//package steps;
//
//import infrastructure.Setup;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//    public static Setup newDriver = null;
//
//    @Before
//    public void setUp() {
//        newDriver = new Setup();
//        newDriver.setupDriver();
//        newDriver.navigateToURL("https://www.nba.com/stats/leaders");
//
//    }
//
////    @After
////    public void tearDown(){
////        if (newDriver != null)
////            newDriver.closeDriver();
////    }
//
//    public static Setup getNewDriver() {
//        return newDriver;
//    }
//}