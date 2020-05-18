public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1500,1000);
        //Balls
        Ball cueBall = new Ball(500.00,500.00,22.00,"WHITE",4);
        arena.addBall(cueBall);
        //Text Title
        Text title = new Text("Welcome to Cool Pool!",14,20.00,20.00,"WHITE");
        arena.addText(title);
        //Pool Table
        Rectangle table = new Rectangle(165.00,165.00,1170.00,670.00,"GREY",1);
        Rectangle felt = new Rectangle(250.00,250.00,1000.00,500.00,"GREEN",2);
        arena.addRectangle(table);
        arena.addRectangle(felt);
        //Outlay
        Rectangle powerBar = new Rectangle(500.00,850.00,500.00,50.00,"RED");
        arena.addRectangle(powerBar);
        Line headSpot = new Line(500.00,251.99,500.00,748.99,5.00,"WHITE",3);
        arena.addLine(headSpot);
        //Movement
        while(true){
            public double speedX = 2.00;
            public double speedY = 0.00;
            cueBall.move(speedX,speedY);
        }
    }
}