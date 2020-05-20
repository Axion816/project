public class PoolCue{
    private double power=0;
    private Rectangle powerDisplay;
    private double maxVelocity = 10.00;
    private boolean setup = true; 
    public void changePower(GameArena a,Ball cueBall){
        powerDisplay = new Rectangle(650.00,850.00,0.00,30.00,"RED",1);
        while(setup == true){
            a.pause();
            if(a.rightPressed()==true){
                if(power<1.00){
                    power = power + 0.10;
                }
            }
            if(a.leftPressed()==true){
                if(power>0.00){
                    power = power + 0.10;
                }
            }
            double velocityX = power*10.00;
            cueBall.setVelocity(velocityX,0.00);
            if(a.spacePressed()==true){
                setup = false;
            }
        }
        return;
    }
}