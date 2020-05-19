public class BallMovement{
    //Movement
    private double velocityX = 2.00;
    private double velocityY = 3.00;
    //Table Interaction
    public void moveCueBall(Ball c,Ball[] p){
        c.move(velocityX,velocityY);
        //Conditions
        if(c.getXPosition()>=1389.00){
            velocityX = -1.00*velocityX;
        }
        if(c.getXPosition()<=411.00){
            velocityX = -1.00*velocityX;
        }
        if(c.getYPosition()>=739.00){
            velocityY = -1.00*velocityY;
        }
        if(c.getYPosition()<=261.00){
            velocityY = -1.00*velocityY;
        }
        for(int j=0;j<6;j++){
            Ball tempPot = p[j];
            if(c.collides(tempPot)==true){
                c.setXPosition(650.00);
                c.setYPosition(500.00);
                velocityX = 0.00;
                velocityY = 0.00;
            }
        }
    }
    public void collisionCheck(Ball c, Ball[] b){
        for(int i=0;i<15;i++){
            Ball tempBall = b[i];
            if(c.collides(tempBall)==true){
                velocityX = -1.00*velocityX;
                velocityY = -1.00*velocityY;
            } 
        }
    }
}