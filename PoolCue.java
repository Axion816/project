public class PoolCue{
    private double power=0;
    private Rectangle powerDisplay;
    private double maxVelocity = 10.00;
    private boolean setup = true; 
    private double width=0;
    private double powerY=0;
    public void changePower(GameArena a,BallMovement cueBall){
        powerDisplay = new Rectangle(650.00,850.00,0.00,30.00,"RED",1);
        a.addRectangle(powerDisplay);
        while(setup == true){
            if(a.rightPressed()==true){
                if(power<1.00){
                    power = power + 0.10;
                    width = width + 50;
                    powerDisplay.setWidth(width);
                }
            }
            if(a.leftPressed()==true){
                if(power>0.00){
                    power = power + 0.10;
                    width = width - 50;
                    powerDisplay.setWidth(width);
                }
            }
            if(a.upPressed()==true){
                powerY = powerY - 0.10;
            }
            if(a.downPressed()==true){
                powerY = powerY + 0.10;
            }
            double xVelocity = power*10.00;
            double yVelocity = powerY*10.00;
            cueBall.setYVelocity(yVelocity);
            cueBall.setXVelocity(xVelocity);
            if(a.spacePressed()==true){
                setup = false;
            }
            for(int i=0;i<7;i++){
                a.pause();
            }
        }
        return;
    }
}