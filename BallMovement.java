public class BallMovement{
    //Movement
    private double velocityX = 1.00;
    private double velocityY = 2.00;
    private double friction = 0.80;
    //Table Interaction
    public void moveCueBall(Ball b){
            arena.pause();
            //Conditions
            if(b.getXPosition()>=1239.00){
                velocityX = -1.00*velocityX;
            }
            if(b.getXPosition()<=261.00){
                velocityX = -1.00*velocityX;
            }
            if(b.getYPosition()>=739.00){
                velocityY = -1.00*velocityY;
            }
            if(b.getYPosition()<=261.00){
                velocityY = -1.00*velocityY;
            }
            //Move
            b.move(velocityX,velocityY);
    }
}