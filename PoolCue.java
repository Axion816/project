public class PoolCue{
    private double power;
    private double maxVelocity = 12.00;
    private double speed;
    private double width;
    private double xLineStart;
    private double yLineStart;
    private double xLineEnd;
    private double yLineEnd;
    private double angle;
    private double angleRadians;
    private double tempDouble;
    private double xVelocity;
    private double yVelocity;
    private boolean setup;
    private boolean playerTurn;
    private Rectangle powerBar;
    private Line lineDirection;
    
    public PoolCue(GameArena arena,Ball cueBall){
        powerBar = new Rectangle(650.00,850.00,0.00,30.00,"RED",1);
        xLineStart = cueBall.getXPosition();
        yLineStart = cueBall.getYPosition();
        xLineEnd = xLineStart + 30.00;
        yLineEnd = yLineStart + 0.00;
        lineDirection = new Line(xLineStart,yLineStart,xLineEnd,yLineEnd,5.00,"RED",4);
        arena.addRectangle(powerBar);
        playerTurn = false;
    }
    public void setupShot(GameArena arena,Ball cueBall,Layout initial){
        setup = false;
        power = 0.00;
        width = 0.00;
        powerBar.setWidth(width);
        angle = 0.00;
        tempDouble = cueBall.getXPosition() + 30.00;
        lineDirection.setLinePosition(cueBall.getXPosition(),cueBall.getYPosition(),tempDouble,cueBall.getYPosition());
        arena.addLine(lineDirection);
        if(playerTurn==false){
            playerTurn=true;
            initial.setPlayerOneTurn(arena);
        }
        else if(playerTurn==true){
            playerTurn=false;
            initial.setPlayerTwoTurn(arena);
        }
        while(setup != true){
            arena.pause();
            setPower(arena);
            setDirection(arena,cueBall);
            if(arena.spacePressed()==true){
                setup=true;
                arena.removeLine(lineDirection);
            }
            if(arena.escPressed()==true){
                arena.exit();
            }
        }
    }
    public void setPower(GameArena arena){
        for(int i=0;i<5;i++){
            arena.pause();
        }
        if(arena.upPressed()==true){
            if(power <= 0.90){
                power = power + 0.10;
                width = width + 50.00;
                powerBar.setWidth(width);
            }
        }
        if(arena.wPressed()==true){
            if(power <= 0.90){
                power = power + 0.10;
                width = width + 50.00;
                powerBar.setWidth(width);
            }
        }
        if(arena.downPressed() == true){
            if(power >= 0.10){
                power = power - 0.10;
                width = width - 50.00;
                powerBar.setWidth(width);
            }
        }
        if(arena.sPressed() == true){
            if(power >= 0.10){
                power = power - 0.10;
                width = width - 50.00;
                powerBar.setWidth(width);
            }
        }
        speed = maxVelocity*power;
    }
    public void setDirection(GameArena arena,Ball cueBall){
        if(arena.rightPressed() == true){
            angle = angle + 5.00;
        }
        if(arena.dPressed() == true){
            angle = angle + 5.00;
        }
        if(arena.leftPressed() == true){
            angle = angle - 5.00;
        }
        if(arena.aPressed() == true){
            angle = angle - 5.00;
        }
        angleRadians = Math.toRadians(angle);
        xLineStart = cueBall.getXPosition();
        yLineStart = cueBall.getYPosition();
        tempDouble = 30.00*Math.cos(angleRadians);
        xLineEnd = tempDouble + xLineStart;
        tempDouble = 30.00*Math.sin(angleRadians);
        yLineEnd = tempDouble + yLineStart;
        tempDouble = speed*Math.cos(angleRadians);
        if(Math.toDegrees(angleRadians)>90 && Math.toDegrees(angleRadians)<270){
            tempDouble = -1.00*tempDouble;
        }
        xVelocity = tempDouble;
        tempDouble = speed*Math.sin(angleRadians);
        if(Math.toDegrees(angleRadians)>0 && Math.toDegrees(angleRadians)<180){
            tempDouble = -1.00*tempDouble;
        }
        yVelocity = tempDouble;
        cueBall.setXVelocity(xVelocity);
        cueBall.setYVelocity(yVelocity);
        lineDirection.setLinePosition(xLineStart,yLineStart,xLineEnd,yLineEnd);
    }
}