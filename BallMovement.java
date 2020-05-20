public class BallMovement{
    private double velocityX;
    private double velocityY;
    public BallMovement(Ball a){
        this.velocityX = a.getVelocityX();
        this.velocityY = a.getVelocityY();
    }
    public void updateVelocity(Ball a){
        this.velocityX = a.getVelocityX();
        this.velocityY = a.getVelocityY();
    }
    //Table Interaction
    public void moveBall(Ball c){
        c.move(velocityX,velocityY);
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
    }
    public void collisionCheck(Ball c, Ball[] b){
        for(int i=0;i<15;i++){
            Ball tempBall = b[i];
            if(c.collides(tempBall)==true){
                velocityX = 0.10*(velocityX + tempBall.getVelocityX());
                velocityY = 0.10*(velocityY + tempBall.getVelocityY());
                double tBVelocityX = velocityX + tempBall.getVelocityX();
                double tBVelocityY = velocityY + tempBall.getVelocityY();
                tempBall.setVelocity(tBVelocityX,tBVelocityY);
            } 
        }
    }

    public void potCheck(Ball b, Ball[] p){
        for(int j=0;j<6;j++){
            Ball tempPot = p[j];
            if(b.collides(tempPot)==true){
                potConditions(b);
            }
        }
    }
    private void potConditions(Ball b){
        if(b.getColour()=="WHITE"){
            b.setXPosition(650.00);
            b.setYPosition(500.00);
        }
        b.setVelocity(0.00,0.00);
    }
}