import java.awt.*;

public class Robot2D {
    private Point originalPos;
    private Point position;
    private Point velocity;
    private int iterations;
    private int numRobots;

    public Robot2D(Point pos, Point vel) {
        this.originalPos = pos;
        this.position = pos;
        this.velocity = vel;
        this.iterations = 0;
        this.numRobots = 1;
    }

    public void addRobot() {
        this.numRobots++;
    }

    public void subtractRobot() {
        this.numRobots--;
    }

    public int getRobots(){
        return this.numRobots;
    }

    public Point moveNext(int width, int height) {
        int newX = this.position.x + this.velocity.x;
        int newY = this.position.y + this.velocity.y;
        if(newX >= width) {
            newX -= width;
        }
        if(newX < 0) {
            newX += width;
        }
        if(newY >= height) {
            newY -= height;
        }
        if(newY < 0) {
            newY += height;
        }
        this.position = new Point(newX, newY);
        this.iterations++;
        return this.position;
    }

    public void moveNext() {
        int width = 11;
        int height = 7;
        int newX = this.position.x + this.velocity.x;
        int newY = this.position.y + this.velocity.y;
        if(newX >= width) {
            newX -= width;
        }
        if(newX < 0) {
            newX += width;
        }
        if(newY >= height) {
            newY -= height;
        }
        if(newY < 0) {
            newY += height;
        }
        this.position = new Point(newX, newY);
        this.iterations++;
    }

    public Point getOriginalPos() {
        return originalPos;
    }

    public void setOriginalPos(Point originalPos) {
        this.originalPos = originalPos;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getVelocity() {
        return velocity;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "originalPos=" + originalPos +
                ", position=" + position +
                ", velocity=" + velocity +
                ", iterations=" + iterations +
                '}';
    }
}
