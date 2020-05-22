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
    private Ball[] tempBalls = new Ball[16];
    private boolean velocityFlag;

    public void moveBall(Ball ball,Ball[] balls,Ball[] pots,PoolCue cue){
        
        ball.move(ball.getXVelocity(),ball.getYVelocity());
        boundaryCheck(ball);
        potCheck(ball,pots,cue);
        if (ball.getColour() == "WHITE"){
            collisionCheckCue(ball,balls);
        }
        if (ball.getColour() != "WHITE"){
            collisionCheckSolid(ball,balls);
        }
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        if (xVelocity < 0){
            xVelocity = -1.00*xVelocity;
        }
        if(yVelocity < 0){
            yVelocity = -1.00*yVelocity;
        }
        if(xVelocity <= 0.20 && yVelocity <= 0.20){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
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
    }

    //NEEDS FIXING FOR TURN BASED
    public void potCheck(Ball ball, Ball[] pots,PoolCue cue){
        for(int i=0; i<6;i++){
            Ball pot = pots[i];
            if(ball.collides(pot)==true){
                potConditions(ball,cue);
            }
        }
    }

    public void potConditions(Ball ball,PoolCue cue){
        double playerOneSide = 157.50;
        double playerTwoSide = 1642.50;
        if(ball.getColour() == "WHITE"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
        }
        else if(ball.getColour() == "BLUE"){
            yTemp = 165.00 + blueCounter*60.00;
            ball.setXPosition(157.50);
            ball.setYPosition(yTemp);
            blueCounter++;
        }
        else if(ball.getColour() == "ORANGE"){
            yTemp = 165.00 + orangeCounter*60.00;
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
                tempVelocity = 0.90*(xVelocity + temp.getXVelocity());
                temp.setXVelocity(tempVelocity);
                tempVelocity = 0.90*(yVelocity + temp.getYVelocity());
                temp.setYVelocity(tempVelocity);
            }
        }
        
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
    }
    public void collisionCheckSolid(Ball ball, Ball[] balls){
        collideFlag = false;
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        
        for(int i=0; i<15; i++){
            Ball temp = balls[  i];
            if(ball.collides(temp) ==  true){
                collideFlag = true;
                tempVelocity = 0.99*(xVelocity + temp.getXVelocity());
                temp.setXVelocity(tempVelocity);
                tempVelocity = 0.99*(yVelocity + temp.getYVelocity());
                temp.setYVelocity(tempVelocity);
            }
        }
        
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
    }
    public boolean checkVelocity(Ball[] balls,Ball cueBall){
        velocityFlag = true;
        for(int i=0;i<15;i++){
            tempBalls[i]=balls[i];
        }
        tempBalls[15] = cueBall;
        for(int j=0;j<16;j++){
            Ball tempBall = tempBalls[j];
            if(tempBall.getXVelocity() != 0.00 || tempBall.getYVelocity() != 0.00)
            velocityFlag = false;
        }
        return velocityFlag;
    }
}