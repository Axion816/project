public class BallMovement{
    //Movement
    private double friction = 0.80;
    //Table Interaction
    public void moveCueBall(Ball b,double vx,double vy){
            b.move(vx,vy);
            //Conditions
            if(b.getXPosition()>=1239.00){
                vx = -1.00*vx;
            }
            if(b.getXPosition()<=261.00){
                vx = -1.00*vx;
            }
            if(b.getYPosition()>=739.00){
                vy = -1.00*vy;
            }
            if(b.getYPosition()<=261.00){
                vy = -1.00*vy;
            }    
    }
}