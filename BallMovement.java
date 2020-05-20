public class BallMovement{
    private double velocityX;
    private double velocityY;
    private double XPosition;
    private double YPosition;
    private double diffX;
    private double diffY;
    public BallMovement(Ball a){
        this.velocityX = a.getVelocityX();
        this.velocityY = a.getVelocityY();
    }
    public void updateVelocity(Ball a){
        velocityX = 0.99*a.getVelocityX();
        velocityY = 0.99*a.getVelocityY();
    }
    //Table Interaction
    public void moveBall(Ball c){
        if(c.getXPosition() + velocityX >=1389.00){
            diffX = 1389.00 - c.getXPosition();
            c.move(diffX,velocityY);
            double newV = -1.00*velocityX;
            velocityX=-1.00*velocityX;
        }
        else if(c.getXPosition() + velocityX <=411.00){
            diffX = 411.00 - c.getXPosition();
            c.move(diffX,velocityY);
            double newV = -1.00*velocityX;
            velocityX=-1.00*velocityX;
        }
        else if(c.getYPosition() + velocityY >=739.00){
            diffY = 739.00 - c.getYPosition();
            c.move(velocityX,diffY);
            double newV = -1.00*velocityY;
            velocityY=-1.00*velocityY;
        }
        else if(c.getYPosition() + velocityY<=261.00){
            diffY = 261.00 - c.getYPosition();
            c.move(velocityX,diffY);
            double newV = -1.00*velocityY;
            velocityY=-1.00*velocityY;
        }
        else{
            c.move(velocityX,velocityY);
        }
        c.setVelocity(velocityX,velocityY);
    }
    public void collisionCheck(Ball c, Ball[] b){
        for(int i=0;i<15;i++){
            Ball tempBall = b[i];
            if(c.collides(tempBall)==true){
                c.setVelocity(0.00,0.00);
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