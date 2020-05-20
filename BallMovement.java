public class BallMovement{
    private double xVelocity;
    private double yVelocity;
    private double xPosition;
    private double yPosition;
    private double diffX;
    private double diffY;
    private Ball ball;
    private BallMovement[] balls;

    public BallMovement(Ball b){
        double xVelocity = 0;
        double yVelocity = 0;
        ball = b;
    }
    
    public Ball getBall(){
        return ball;
    }

    public double getXVelocity(){
        return xVelocity;
    }

    public double getYVelocity(){
        return yVelocity;
    }

    public void setXVelocity(double xV){
        xVelocity = xV;
    }

    public void setYVelocity(double xY){
        yVelocity = xY;
    }
    public void moveBall(){
        xVelocity = 0.99*xVelocity;
        yVelocity = 0.99*yVelocity;
        xPosition = ball.getXPosition();
        yPosition = ball.getYPosition();

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

        ball.move(xVelocity,yVelocity);
        

    }

    public void potCheck(Ball[] pots){
        for(int i=0; i<6;i++){
            Ball pot = pots[i];
            if(ball.collides(pot)==true){
                potConditions();
            }
        }
    }

    public void potConditions(){
        if(ball.getColour() == "WHITE"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
        }
        else if(ball.getColour() == "BLUE"){
            ball.setXPosition(1000.00);
            ball.setYPosition(10.00);
        }
        else if(ball.getColour() == "ORANGE"){
            ball.setXPosition(1000.00);
            ball.setYPosition(10.00);
        }
        else if(ball.getColour() == "BLACK"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
        }
        xVelocity = 0;
        yVelocity = 0;
    }

    public void collisionCheckCueBall(BallMovement[] balls){
        for(int i=0; i<15; i++){
            BallMovement temp = balls[i];
            if(ball.collides(temp.getBall()) ==  true){
                temp.setXVelocity(xVelocity);
                temp.setYVelocity(yVelocity);
                xVelocity = 0.00;
                yVelocity = 0.00;
            }
        }
    }
    
    public void collisionCheck(BallMovement[] exclusiveBalls, BallMovement cueBall){
        for(int i=0; i<14;i++){
            BallMovement temp = exclusiveBalls[i];
            if(ball.collides(temp.getBall()) == true){
                temp.setXVelocity(xVelocity);
                temp.setYVelocity(yVelocity);
                xVelocity = 0.00;
                yVelocity = 0.00;
            }
            else if(ball.collides(cueBall.getBall()) == true){
                cueBall.setXVelocity(xVelocity);
                cueBall.setYVelocity(yVelocity);
                xVelocity = 0.00;
                yVelocity = 0.00;
            }
        }
    }
    


}