public class BallMovement{
    //Movement
    private double velocityX = 5.00;
    private double velocityY = 5.00;
    //Table Interaction
    public void moveCueBall(Ball b){
        b.move(velocityX,velocityY);
            //Conditions
            if(b.getXPosition()>=1389.00){
                velocityX = -1.00*velocityX;
            }
            if(b.getXPosition()<=411.00){
                velocityX = -1.00*velocityX;
            }
            if(b.getYPosition()>=739.00){
                velocityY = -1.00*velocityY;
            }
            if(b.getYPosition()<=261.00){
                velocityY = -1.00*velocityY;
            }
    }
}