public class BallMovement{
    //Movement
    private double friction = 0.80;
    //Table Interaction
    public void moveCueBall(Ball b,double vx,double vy){
            //Conditions
            if(b.getXPosition()+vx>=1239.00){
                vx = -1.00*vx;
            }
            if(b.getXPosition()-vx<=261.00){
                vx = -1.00*vx;
            }
            if(b.getYPosition()+vy>=739.00){
                vy = -1.00*vy;
            }
            if(b.getYPosition()-vy<=261.00){
                vy = -1.00*vy;
            }
            b.move(vx,vy);
            
    }
}