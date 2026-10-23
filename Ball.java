public class Ball{
    private double radius;
    private double x, y;

    public Ball(double r, double x, double y){
        this.radius = r;
        this.x = x;
        this.y = y;
    }

    public double calcDistance(Ball b){
        return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
    }

    /**
     * returns true if this ball overlaps
     * with the object referenced by Ball b;
     * false otherwise
     * 
     * if the distance between the balls is 
     * less than the sum of radii of the 
     * balls then they are overlapping
     */
    public boolean overlap(Ball b){
        //do this
        return (calcDistance(b) < (this.radius + b.radius));
    }
    public static void main(String[] args) {
        Ball b1 = new Ball(1.0, 5, 10);
        Ball b2 = new Ball(1.0, 2, 5);
        Ball b3 = new Ball(1.0, 5, 10);

        System.out.println(b1.calcDistance(b2));
        System.out.println(b1.overlap(b3));
        System.out.println(b2.overlap(b1));
    }
}