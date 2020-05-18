public class BallMovement{
    //Movement
    private double friction = 0.80;
    //Table Interaction
    public void moveCueBall(Ball b,double vx,double vy,GameArena a){
            //Conditions
            if(b.getXPosition()>=1239.00){
                vx = -1.00*vx;
                a.pause();
            }
            if(b.getXPosition()<=261.00){
                vx = -1.00*vx;
                a.pause();
            }
            if(b.getYPosition()>=739.00){
                vy = -1.00*vy;
                a.pause();
            }
            if(b.getYPosition()<=261.00){
                vy = -1.00*vy;
                a.pause();
            }
            b.move(vx,vy);
            
    }
}