public class BallMovement{
    private double xVelocity;
    private double yVelocity;
    private double xPosition;
    private double yPosition;
    private double diffX;
    private double diffY;
    private boolean collideFlag;
    private int blueCounter=0;
    private int orangeCounter=0;
    private double yTemp;
    private double tempVelocity;

    public void moveBall(Ball ball,Ball[] balls,Ball[] pots){
        ball.move(ball.getXVelocity(),ball.getYVelocity());
        boundaryCheck(ball);
        potCheck(ball,pots);
        if (ball.getColour() == "WHITE"){
            collisionCheckCue(ball,balls);
        }
        if (ball.getColour() != "WHITE"){
            collisionCheckSolid(ball,balls);
        }
    }

    public void boundaryCheck(Ball ball){
        xPosition = ball.getXPosition();
        yPosition = ball.getYPosition();
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        xVelocity = 0.99*xVelocity;
        yVelocity = 0.99*yVelocity;

        if(xPosition + xVelocity >= 1389.00 && xVelocity > 0){
            diffX = 1389.00 - xPosition;
            ball.move(diffX,yVelocity);
            xVelocity = -1.00*xVelocity;
        }
        else if(xPosition + xVelocity <= 411.00 && xVelocity < 0){
            diffX = 411.00 - xPosition;
            ball.move(diffX,yVelocity);
            xVelocity = -1.00*xVelocity;
        }
        else if(yPosition + yVelocity >= 739.00 && yVelocity > 0){
            diffY = 739.00 - yPosition;
            ball.move(xVelocity,diffY);
            yVelocity = -1.00*yVelocity;
        }
        else if(yPosition + yVelocity <= 261.00 && yVelocity < 0){
            diffY = 261.00 - yPosition;
            ball.move(xVelocity,diffY);
            yVelocity = -1.00*yVelocity;
        }
        ball.setXVelocity(xVelocity);
        ball.setYVelocity(yVelocity);
        return;
    }


    public void potCheck(Ball ball, Ball[] pots){
        for(int i=0; i<6;i++){
            Ball pot = pots[i];
            if(ball.collides(pot)==true){
                potConditions(ball);
            }
        }
    }

    public void potConditions(Ball ball){
        if(ball.getColour() == "WHITE"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
        }
        else if(ball.getColour() == "BLUE"){
            yTemp = 165.00 + blueCounter*50.00;
            ball.setXPosition(157.50);
            ball.setYPosition(yTemp);
            blueCounter++;
        }
        else if(ball.getColour() == "ORANGE"){
            yTemp = 165.00 + orangeCounter*50.00;
            ball.setXPosition(1642.50);
            ball.setYPosition(yTemp);
            orangeCounter++;
        }
        else if(ball.getColour() == "BLACK"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
        }
        ball.setXVelocity(0.00);
        ball.setXVelocity(0.00);
    }

    public void collisionCheckCue(Ball ball, Ball[] balls){
        collideFlag = false;
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        
        for(int i=0; i<15; i++){
            Ball temp = balls[i];
            if(ball.collides(temp) ==  true){
                collideFlag = true;
                tempVelocity = xVelocity + temp.getXVelocity();
                temp.setXVelocity(tempVelocity);
                tempVelocity = yVelocity + temp.getYVelocity();
                temp.setYVelocity(tempVelocity);
            }
        }
        
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
        return;
    }
    public void collisionCheckSolid(Ball ball, Ball[] balls){
        collideFlag = false;
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        
        for(int i=0; i<14; i++){
            Ball temp = balls[  i];
            if(ball.collides(temp) ==  true){
                collideFlag = true;
                tempVelocity = xVelocity + temp.getXVelocity();
                temp.setXVelocity(tempVelocity);
                tempVelocity = yVelocity + temp.getYVelocity();
                temp.setYVelocity(tempVelocity);
            }
        }
        
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
        return;
    }
    
    
    


}