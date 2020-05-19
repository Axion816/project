public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);
        Ball cueBall;
        cueBall = initial.getBall(cueBall);
        /*
        //Balls
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",4);
        arena.addBall(cueBall);
        //Text Title
        Text title = new Text("Welcome to Cool Pool!",14,20.00,20.00,"WHITE");
        arena.addText(title);
        
        //Pool Table
        Rectangle table = new Rectangle(315.00,165.00,1170.00,670.00,"GREY",1);
        Rectangle felt = new Rectangle(400.00,250.00,1000.00,500.00,"GREEN",2);
        //Ball Pots
        Ball[] pot = new Ball[6];
        for(int i=0;i<6;i++){
            if(i<3){
                pot[i] = new Ball(400.00+(i*500.00),250.00,49.00,"BLACK",5);
            }
            if(i>=3){
                pot[i] = new Ball(((i-3)*(500.00))+400.00,750.00,49.00,"BLACK",5);
            }
            arena.addBall(pot[i]);
        }
        //Game Balls
        Ball[] solid = new Ball[14];
        solid[j] = new Ball();
        Ball eightBall = new Ball(11940.00,500.00,22.00,"BLACK",4)
        arena.addBall(eightBall);
        arena.addRectangle(table);
        arena.addRectangle(felt);
        //Outlay
        Rectangle powerBar = new Rectangle(650.00,850.00,500.00,50.00,"RED");
        arena.addRectangle(powerBar);
        Line headSpot = new Line(650.00,251.99,650.00,748.99,5.00,"WHITE",3);
        arena.addLine(headSpot);
        */

        //Movement
        double velocityX = 1.00;
        double velocityY = 2.00;
        BallMovement cueB = new BallMovement();
        while(true){
            arena.pause();
            cueB.moveCueBall(cueBall);
        }
    }
}