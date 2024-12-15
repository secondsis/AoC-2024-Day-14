import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));

        ArrayList<Robot> robots = new ArrayList<>();
        int width = 101;
        int height = 103;

        Robot[][] robots2d = new Robot[height][width];

        while(scan.hasNext()) {
            String line = scan.nextLine();

            String[] pAndV = line.split(" ");

            String p = pAndV[0];
            String v = pAndV[1];

            String[] pPoint = p.substring(2).split(",");
            String[] vPoint = v.substring(2).split(",");

            int pX = Integer.parseInt(pPoint[0]);
            int pY = Integer.parseInt(pPoint[1]);

            int vX = Integer.parseInt(vPoint[0]);
            int vY = Integer.parseInt(vPoint[1]);

            robots.add(new Robot(new Point(pX, pY),
                    new Point(vX, vY)));
            robots2d[pY][pX] = new Robot(new Point(pX, pY),
                    new Point(vX, vY));
        }

        int longest = 0;
        int streak = 0;

        for (int i = 0; i < 10000; i++) {
            // output the robots "static"

            StringBuilder grid = new StringBuilder();

            for(Robot[] row : robots2d) {
                for(Robot robot : row) {
                    grid.append((robot == null) ? "_" : "O");
                   // System.out.print((robot == null) ? "_" : "O");
                }
                grid.append("\n");
               // System.out.println();
            }

            if(grid.toString().contains("OOOOOO")) {
                // if it has the tree, it will PROBABLY have at least this
                System.out.println(grid);
                System.out.println((i+1));
            }

            robots2d = new Robot[height][width];

            for(Robot robot : robots) {
                robot.moveNext(width, height);
                robots2d[robot.getPosition().y][robot.getPosition().x] = robot;
            }
        }

        // Robots are all in their new locations

        // Multiply all robots together that are not in the middle lines
//
//        int midX = width / 2;
//        int midY = height / 2;
//
//        int quad1 = 0;
//        int quad2 = 0;
//        int quad3 = 0;
//        int quad4 = 0;
//
//        for(Robot robot : robots) {
//            Point pos = new Point(robot.getPosition().x, robot.getPosition().y);
//            if(pos.x == midX || pos.y == midY) {
//                continue;
//            }
//            if(pos.x < midX) {
//                // quad 2 / 3
//                if(pos.y < midY) {
//                    // quad 3
//                    quad3++;
//                } else {
//                    // quad 2
//                    quad2++;
//                }
//            } else {
//                // quad 1 / 4
//                if(pos.y < midY) {
//                    // quad 4
//                    quad4++;
//                } else {
//                    // quad 1
//                    quad1++;
//                }
//            }
//
//
//        }
////        System.out.println(quad1);
////        System.out.println(quad2);
////        System.out.println(quad3);
////        System.out.println(quad4);
//
//        int result = quad1 * quad2 * quad3 * quad4;
//
//        System.out.println(result);

        // TIME TO WATCH STATIC HAHAHAHAHA

    }
}