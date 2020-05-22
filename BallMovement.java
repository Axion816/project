public class BallMovement{
    private double xVelocity;                   //Holds ball velocity in x
    private double yVelocity;                   //Holds ball velocity in y
    private double xPosition;                   //Holds x position of ball
    private double yPosition;                   //Holds y position of ball
    private double diffX;                       //Holds the difference between the x position and boundary
    private double diffY;                       //Holds the difference between the y position and boundary
    private int blueCounter=0;                  //Counter for the number of blue balls potted
    private int orangeCounter=0;                //Counter for the number of orange balls potted
    private double yTemp;
    private double tempVelocity;                //Holds a temporary velocity value
    private double bluePlayerSide;              //X position for the blue player's balls
    private double orangePlayerSide;            //X Position for the orange player's balls
    private Ball[] tempBalls = new Ball[16];    //Temporary ball array for collision check
    private boolean velocityFlag;               //Boolean holds if balls are moving
    private boolean bluePlayer;                 //Boolean holds the blue player. TRUE == player 1 , FALSE == player 2
    private boolean orangePlayer;               //Boolean holds the orange player. TRUE == player 1 , FALSE == player 2
    private boolean collideFlag;                //Flags if a ball collides
    private boolean playerTurn;                 //Holds which player's turn it is
    
    /*
    ** Constructor
    ** Sets start to player one
    */

    public BallMovement(){
        playerTurn = true;
    }

    /*
    ** moveBall()
    ** Runs the sequence of movement checks and velocity changes for Ball ball. 
    */

    public void moveBall(GameArena arena,Ball ball,Ball[] balls,Ball[] pots,PoolCue cue,Layout initial){

        ball.move(ball.getXVelocity(),ball.getYVelocity());
        boundaryCheck(ball);
        potCheck(arena,ball,pots,cue,initial);
        // balls holds initial.balls
        if (ball.getColour() == "WHITE"){
            collisionCheckCue(ball,balls);
        }
        // balls holds exclusive balls
        if (ball.getColour() != "WHITE"){
            collisionCheckSolid(ball,balls);
        }
        // Following if's make xVelocity positive for check
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        if (xVelocity < 0){
            xVelocity = -1.00*xVelocity;
        }
        if(yVelocity < 0){
            yVelocity = -1.00*yVelocity;
        }
        // Sets Velocity to 0 if the velocity goes below 0.20 for both axes
        if(xVelocity <= 0.20 && yVelocity <= 0.20){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
        // Changes current player turn
        if(playerTurn == true){
            playerTurn = false;
            }
        else if(playerTurn == false){
            playerTurn = true;
        }
    }

    /*  boundaryCheck()
    ** Changes the velocity of the ball and move it to the boundary to simulate colliding with the cushions
    ** Also applies friction
    */

    public void boundaryCheck(Ball ball){
        xPosition = ball.getXPosition();
        yPosition = ball.getYPosition();
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        // Friction applied
        xVelocity = 0.99*xVelocity;
        yVelocity = 0.99*yVelocity;
        // Checks for collision with boundary
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

    /*
    ** potCheck()
    ** Checks if a ball is potted. If so calls potConditions()
    */

    public void potCheck(GameArena arena,Ball ball, Ball[] pots,PoolCue cue,Layout initial){
        for(int i=0; i<6;i++){
            Ball pot = pots[i];
            if(ball.collides(pot)==true){
                potConditions(arena,ball,cue,initial);
            }
        }
    }

    /*
    ** potConditions()
    ** Runs the conditions for potted balls
    ** First run sets the players' ball colours
    ** Sets win rules
    */

    public void potConditions(GameArena arena,Ball ball,PoolCue cue,Layout initial){
        double playerOneSide = 157.50;
        double playerTwoSide = 1642.50;
        ball.setXVelocity(0.00);
        ball.setYVelocity(0.00);
        // Runs on first potted ball, assigns balls
        if(blueCounter == 0 && orangeCounter == 0){
            if(ball.getColour() == "BLUE"){
                if(cue.getPlayerTurn() == true)
                    bluePlayerSide = playerOneSide;
                    orangePlayerSide = playerTwoSide;
                    bluePlayer = true;
                    orangePlayer = false;
                if(cue.getPlayerTurn() == false){
                    bluePlayerSide = playerTwoSide;
                    orangePlayerSide = playerOneSide;
                    bluePlayer = false;
                    orangePlayer = true;
                }
            }
            else if(ball.getColour() == "ORANGE"){
                if(cue.getPlayerTurn() == false)
                    bluePlayerSide = playerTwoSide;
                    orangePlayerSide = playerOneSide;
                    bluePlayer = true;
                    orangePlayer = false;
                if(cue.getPlayerTurn() == true){
                    bluePlayerSide = playerOneSide;
                    orangePlayerSide = playerTwoSide;
                    bluePlayer = false;
                    orangePlayer = true;
                }
            }
        }
        // Condition for white potted
        if(ball.getColour() == "WHITE"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
            cue.resetTurn();
        }
        // Condition for blue potted
        else if(ball.getColour() == "BLUE"){
            yTemp = 165.00 + blueCounter*60.00;
            ball.setXPosition(bluePlayerSide);
            ball.setYPosition(yTemp);
            // Increase held number of potted blue balls
            blueCounter++;
        }
        // Condition for orange potted
        else if(ball.getColour() == "ORANGE"){
            yTemp = 165.00 + orangeCounter*60.00;
            ball.setXPosition(orangePlayerSide);
            ball.setYPosition(yTemp);
            // Increase held number of potted orange balls
            orangeCounter++;
        }
        // Condition for eight ball potted
        else if(ball.getColour() == "BLACK"){
            ball.setXPosition(650.00);
            ball.setYPosition(500.00);
            // Blue player win
            if(blueCounter==7){
                if(bluePlayer == true){
                    initial.playerOneWin(arena);
                }
                if(bluePlayer == false){
                    initial.playerTwoWin(arena);
                }
            }
            // Orange player win
            else if(orangeCounter==7){
                if(orangePlayer==true){
                    initial.playerOneWin(arena);
                }
                if(orangePlayer==false){
                    initial.playerTwoWin(arena);
                }
            }
            // blue player loses
            else if(playerTurn == bluePlayer && blueCounter!=7){
                if(bluePlayer == true){
                    initial.playerTwoWin(arena);
                }
                if(bluePlayer == false){
                    initial.playerOneWin(arena);
                }
            }
            // orange player lose
            else if(playerTurn == orangePlayer && orangeCounter!=7){
                if(orangePlayer==true){
                    initial.playerTwoWin(arena);
                }
                if(orangePlayer==false){
                    initial.playerOneWin(arena);
                }    
            }
        }
    }

    /*
    ** collisionCheckCue()
    ** Checks for collision between all balls with cue ball. Transfers a fraction of the velocity from the cue ball.
    */

    public void collisionCheckCue(Ball ball, Ball[] balls){
        collideFlag = false;
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        // Transfers velocity to ball that has been collided with
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
        // Sets velocity of cue ball to 0
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
    }

    /*
    ** collisionCheckSolid()
    ** Checks for collision between ball and all other balls. Transfers a fraction of ball's velocity.
    */

    public void collisionCheckSolid(Ball ball, Ball[] balls){
        collideFlag = false;
        xVelocity = ball.getXVelocity();
        yVelocity = ball.getYVelocity();
        // If balls collide, transfers velocity
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
        // Sets velocity of colliding ball to 0
        if(collideFlag == true){
            ball.setXVelocity(0.00);
            ball.setYVelocity(0.00);
        }
    }

    /*
    ** checkVelocity()
    ** returns true if balls are stationary, else returns false
    */

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