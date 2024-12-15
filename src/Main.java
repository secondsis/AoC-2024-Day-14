import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));

        ArrayList<Robot> robots = new ArrayList<>();
        int width = 101;
        int height = 103;

        while(scan.hasNext()) {
            String line = scan.nextLine();

            String[] pAndV = line.split(" ");

            String p = pAndV[0];
            String v = pAndV[1];

            String[] pPoint = p.substring(2).split(",");
            String[] vPoint = v.substring(2).split(",");

            robots.add(new Robot(new Point(Integer.parseInt(pPoint[0]), Integer.parseInt(pPoint[1])),
                    new Point(Integer.parseInt(vPoint[0]), Integer.parseInt(vPoint[1]))));
        }

        for (int i = 0; i < 100; i++) {
            for(Robot robot : robots) {
                robot.moveNext(width, height);
            }
        }

        // Robots are all in their new locations

        // Multiply all robots together that are not in the middle lines

        int midX = width / 2;
        int midY = height / 2;

        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4 = 0;

        for(Robot robot : robots) {
            Point pos = new Point(robot.getPosition().x, robot.getPosition().y);
            if(pos.x == midX || pos.y == midY) {
                continue;
            }
            if(pos.x < midX) {
                // quad 2 / 3
                if(pos.y < midY) {
                    // quad 3
                    quad3++;
                } else {
                    // quad 2
                    quad2++;
                }
            } else {
                // quad 1 / 4
                if(pos.y < midY) {
                    // quad 4
                    quad4++;
                } else {
                    // quad 1
                    quad1++;
                }
            }


        }
//        System.out.println(quad1);
//        System.out.println(quad2);
//        System.out.println(quad3);
//        System.out.println(quad4);

        int result = quad1 * quad2 * quad3 * quad4;

        System.out.println(result);
    }
}