public class PoolCue{
    private double power;                       // Holds coefficient from 0 to 1 of power of the shot
    private double maxVelocity = 12.00;         // Maximum velocity of the ball
    private double speed;                       // Overall speed of the ball from the shot
    private double width;                       // Width of the red power bar
    private double xLineStart;                  // Start of the trajectory line, x position
    private double yLineStart;                  // Start of the trajectory line, y position
    private double xLineEnd;                    // End of the trajectory line, x position
    private double yLineEnd;                    // End of the trajectory line, y position
    private double angle;                       // Angle from the starting trajectory
    private double angleRadians;                // Angle in radians
    private double tempDouble;                  // A temporary variable to hold double values
    private double xVelocity;                   // Holds velocity of the ball in the x axis
    private double yVelocity;                   // Holds velocity of the ball in the y axis
    private double mousePosition;               // Hold current y coordinate for the mouse position
    private boolean setup;                      // Flags the completion of the setup. True if completed
    private boolean playerTurn;                 // Holds which player's turn it is
    private Rectangle powerBar;                 // Red bar representing the power of the shot
    private Line lineDirection;                 // Line show trajectory the shot will send the ball
    private int turn;                           // flags the setup shot to let you move the ball
    
    /*
    ** Constructor
    ** Sets length of the trajectory line. Adds the bar to the arena. Sets all values to their default
    */

    public PoolCue(GameArena arena,Ball cueBall){
        powerBar = new Rectangle(650.00,850.00,0.00,30.00,"RED",1);
        xLineStart = cueBall.getXPosition();
        yLineStart = cueBall.getYPosition();
        xLineEnd = xLineStart + 30.00;
        yLineEnd = yLineStart + 0.00;
        lineDirection = new Line(xLineStart,yLineStart,xLineEnd,yLineEnd,5.00,"RED",4);
        arena.addRectangle(powerBar);
        playerTurn = false;
        turn = 0;
    }

    /*
    ** setupShot()
    ** Runs the process of seting up your shot
    ** Ends on space bar being pressed
    */

    public void setupShot(GameArena arena,Ball cueBall,Layout initial){
        setup = false;
        power = 0.00;
        width = 0.00;
        // Resets power bar width
        powerBar.setWidth(width);
        angle = 0.00;
        // Moves trajectory line to the ball
        tempDouble = cueBall.getXPosition() + 30.00;
        lineDirection.setLinePosition(cueBall.getXPosition(),cueBall.getYPosition(),tempDouble,cueBall.getYPosition());
        arena.addLine(lineDirection);
        // Changes player turn
        if(playerTurn==false){
            playerTurn=true;
            initial.setPlayerOneTurn(arena);
        }
        else if(playerTurn==true){
            playerTurn=false;
            initial.setPlayerTwoTurn(arena);
        }
        // Setup Loop
        while(setup != true){
            arena.pause();
            moveBall(arena,cueBall);
            setPower(arena);
            setDirection(arena,cueBall);
            // Takes the shot
            if(arena.spacePressed()==true){
                setup=true;
                arena.removeLine(lineDirection);
                turn++;
            }
            // Exits the window
            if(arena.escPressed()==true){
                arena.exit();
            }
        }
    }

    /*
    ** moveBall()
    ** Lets user move the ball up and down the line
    */

    public void moveBall(GameArena arena,Ball cueBall){
        if(turn == 0){
            if(arena.leftMousePressed()==true){
                mousePosition = arena.getMousePositionY();
                // Boundary condition
                if(mousePosition <= 735.00 && mousePosition >= 265.00){
                    cueBall.setYPosition(mousePosition);
                }
            }
        }
    }

    /*
    ** setPower()
    ** Lets user change the power of the shot
    */

    public void setPower(GameArena arena){
        for(int i=0;i<5;i++){
            arena.pause();
        }
        // Increases power on up press
        if(arena.upPressed()==true){
            if(power <= 0.90){
                power = power + 0.10;
                width = width + 50.00;
                powerBar.setWidth(width);
            }
        }
        // Increases power on w press
        if(arena.wPressed()==true){
            if(power <= 0.90){
                power = power + 0.10;
                width = width + 50.00;
                powerBar.setWidth(width);
            }
        }
        // Decreases power on down press
        if(arena.downPressed() == true){
            if(power >= 0.10){
                power = power - 0.10;
                width = width - 50.00;
                powerBar.setWidth(width);
            }
        }
        // Decreases power on s press
        if(arena.sPressed() == true){
            if(power >= 0.10){
                power = power - 0.10;
                width = width - 50.00;
                powerBar.setWidth(width);
            }
        }
        speed = maxVelocity*power;
    }

    /*
    ** setDirection()
    ** Lets the user change the trajectory of the shot
    */

    public void setDirection(GameArena arena,Ball cueBall){
        // Moves trajectory clockwise
        if(arena.rightPressed() == true && angle <= 175.00){
            angle = angle + 5.00;
        }
        if(arena.dPressed() == true && angle <= 175.00){
            angle = angle + 5.00;
        }
        // Moves trajectory anti-clockwise
        if(arena.leftPressed() == true && angle >= -175.00){
            angle = angle - 5.00;
        }
        if(arena.aPressed() == true && angle >= -180.00){
            angle = angle - 5.00;
        }
        angleRadians = Math.toRadians(angle);
        // Sets new line to show trajectory
        xLineStart = cueBall.getXPosition();
        yLineStart = cueBall.getYPosition();
        tempDouble = 30.00*Math.cos(angleRadians);
        xLineEnd = tempDouble + xLineStart;
        tempDouble = 30.00*Math.sin(angleRadians);
        yLineEnd = tempDouble + yLineStart;
        tempDouble = speed*Math.cos(angleRadians);
        // Sets x and y velocities
        xVelocity = tempDouble;
        tempDouble = speed*Math.sin(angleRadians);
        yVelocity = tempDouble;
        cueBall.setXVelocity(xVelocity);
        cueBall.setYVelocity(yVelocity);
        lineDirection.setLinePosition(xLineStart,yLineStart,xLineEnd,yLineEnd);
    }

    /*
    ** getPlayerTurn()
    ** returns TRUE for player 1, FALSE for player 2
    */

    public boolean getPlayerTurn(){
        return playerTurn;
    }

    /*
    ** resetTurn()
    ** Resets turn to 0 to cue ball can be moved again
    */

    public void resetTurn(){
        turn = 0;
    }

}