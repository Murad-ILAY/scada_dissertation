//package az.spring.demo.scada;
//import az.spring.demo.scada.beans.Employee;
//import az.spring.demo.scada.model.FlameDetector;
//import az.spring.demo.scada.services.impl.FlameDetectorService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class TestSpringApp {
//    public static void main(String[] args) {
//
//        ApplicationContext context = SpringApplication.run(TestSpringApp.class, args);
////        int [][] grid1 = {{0,1,0,0,0},{1,0,0,0,0}};
////        int [][] grid2 = {{0,1,1,0},{1,0,0,1}};
////        System.out.println("Grid 1 is valid: "+ isValidRobotSeries(grid1));
////        context.getBean(FlameDetectorService);
//
//    }
//    @Bean
//    CommandLineRunner run(FlameDetectorService flameDetectorService) {
//        return args -> {
//            // Example: Saving a new FlameDetector
//            FlameDetector flameDetector = new FlameDetector();
//            flameDetectorService.saveUser(flameDetector);
//
//            // Fetching and displaying all Flame Detectors
//            flameDetectorService.getAllUsers().forEach(System.out::println);
//            System.out.println("Alma");
//        };
//    }
//
//
////    public boolean isValidPath(int[][] grid, int numRobots){
////    for(int row=0; row<grid.length;row++){
////    int robotsPerRow = 0;
////    for(int col=0; col<grid[0].length;col++){
////        if(grid[row][col]==1){
////            robotsPerRow++;
////        }
////    }
////    if(robotsPerRow!=numRobots){
////        return false;
////    }
////
////
////
////}
////
////int[] robotIndecesCur = getRobotIndeces(grid[0]);
////for(int row=1;row<grid.length;row++) {
////    int[] robotIndecesNext = getRobotIndeces(grid[row]);
////    if (!isValidPath(robotIndecesCur, robotIndecesNext)) {
////        return false;
////    }
////    robotIndecesCur = robotIndecesNext;
////}
////return true;
////    }
//
//
////    public static boolean isValidRobotSeries(int[][]grid){
////    for (int t = 0; t < grid.length-1; t++) {
////        int[] current = grid[0];
////        int[] next = grid[t + 1];
////
////
//////  int [][] grid1 = {{0,1,1,0,0},{1,0,0,0,1}};
////    for(int i = 0; i < current.length; i++){
////        if(current[i]==1){
////            boolean validMove =false;
////            for(int j=Math.max(0, i-1);j<=Math.min(current.length-1,i+1);j++){
////
////                if(next[j]==1){
////                    validMove=true;
////                    next[j]=0;
////                    break;
////                }
////            }
////            if(!validMove){
////                return false;
////            }
////        }
////    }
////    for(int j=0; j < next.length; j++){
////        if(next[j]==1){
////            return false;
////        }
////}
////
////    }
////    return true;
////}
//
//}