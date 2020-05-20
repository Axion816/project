public class Layout{
    //Table and Outlay variables
    Ball[] pot = new Ball[6];
    Text title = new Text("Welcome to Cool Pool!",14,20.00,20.00,"WHITE",0);
    Line headSpot = new Line(650.00,251.99,650.00,748.99,5.00,"WHITE",3);
    Rectangle powerBar = new Rectangle(650.00,850.00,500.00,30.00,"WHITE",0);  
    Rectangle table = new Rectangle(315.00,165.00,1170.00,670.00,"GREY",1);
    Rectangle felt = new Rectangle(400.00,250.00,1000.00,500.00,"GREEN",2);
    //Game Balls
    Ball[] solid = new Ball[15];
    BallMovement[] ballMovement = new BallMovement[15];
    public Layout(GameArena arena){
        arena.addRectangle(powerBar);
        arena.addLine(headSpot);
        arena.addRectangle(table);
        arena.addRectangle(felt);
        arena.addText(title);
        for(int i=0;i<6;i++){
            if(i<3){
                pot[i] = new Ball(400.00+(i*500.00),250.00,49.00,"BLACK",4);
            }
            if(i>=3){
                pot[i] = new Ball(((i-3)*(500.00))+400.00,750.00,49.00,"BLACK",4);
            }
            arena.addBall(pot[i]);
        }
        solid[0] = new Ball(1150.00,500.00,22,"BLUE",5);
        solid[1] = new Ball(1172.00,511.00,22,"ORANGE",5);
        solid[2] = new Ball(1172.00,489.00,22,"ORANGE",5);
        solid[3] = new Ball(1194.00,522.00,22,"BLUE",5);
        solid[4] = new Ball(1194.00,478.00,22,"BLUE",5);
        solid[5] = new Ball(1216.00,533.00,22,"ORANGE",5);
        solid[6] = new Ball(1216.00,511.00,22,"BLUE",5);
        solid[7] = new Ball(1194.00,500.00,22.00,"BLACK",5);
        solid[8] = new Ball(1216.00,489.00,22,"ORANGE",5);
        solid[9] = new Ball(1216.00,467.00,22,"ORANGE",5);
        solid[10] = new Ball(1238.00,544.00,22,"BLUE",5);
        solid[11] = new Ball(1238.00,522.00,22,"BLUE",5);
        solid[12] = new Ball(1238.00,500.00,22,"ORANGE",5);
        solid[13] = new Ball(1238.00,478.00,22,"BLUE",5);
        solid[14] = new Ball(1238.00,456.00,22,"ORANGE",5);
        for(int j=0;j<15;j++){
            arena.addBall(solid[j]);
            Ball tempBall = solid[j];
            ballMovement[j] = new BallMovement(tempBall);
        }
    }
    public Ball[] getPots(){
        return pot;
    }
    public Ball[] getBalls(){
        return solid;
    }
    public BallMovement[] getMovementArray(){
        return ballMovement;
    }
}