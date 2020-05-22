public class Layout{
    //Table and Outlay variables
    Ball[] pot = new Ball[6];
    Text[] text = new Text[17];
    Ball[] solid = new Ball[15];  
    Line headSpot = new Line(650.00,251.99,650.00,748.99,5.00,"WHITE",3);
    Rectangle powerBar = new Rectangle(650.00,850.00,500.00,30.00,"WHITE",0);  
    Rectangle table = new Rectangle(315.00,165.00,1170.00,670.00,"GREY",1);
    Rectangle felt = new Rectangle(400.00,250.00,1000.00,500.00,"GREEN",2);
    int ballIndex;
    int index;
    //Game Balls
    Ball[] exclusiveBalls = new Ball[15];
    public Layout(GameArena arena){
        text[0] = new Text("Welcome to Cool Pool!",18,800.00,50.00,"WHITE",0);
        text[1] = new Text("Player 1",18,100.00,100.00,"WHITE",0);
        text[2] = new Text("Player 2",18,1585.00,100.00,"WHITE",0);
        text[3] = new Text("Power Bar",18,850.00,900.00,"WHITE",0);
        text[4] = new Text("Press Space to take the shot",14,750.00,950.00,"WHITE",0);
        text[5] = new Text("Up Key: Increase Power",14,1510.00,875.00,"WHITE",0);
        text[6] = new Text("Down Key: Decrease Power",14,1510.00,900.00,"WHITE",0);
        text[7] = new Text("W Key = Increase Power",14,50.00,875.00,"WHITE",0);
        text[8] = new Text("S Key = Decrease Power",14,50.00,900.00,"WHITE",0);
        text[9] = new Text("Left Key: Rotate shot anti-clockwise",14,1510.00,925.00,"WHITE",0);
        text[10] = new Text("Right Key: Rotate shot clockwise",14,1510.00,950.00,"WHITE",0);
        text[11] = new Text("A Key: Rotate shot anti-clockwise",14,50.00,925.00,"WHITE",0);
        text[12] = new Text("D Key: Rotate shot clockwise",14,50.00,950.00,"WHITE",0);
        text[13] = new Text("Player 1 wins!!!",24,750.00,100.00,"RED",0);
        text[14] = new Text("Player 2 wins!!!",24,750.00,100.00,"RED",0);
        text[15] = new Text("Player 1's turn",24,815.00,125.00,"WHITE",0);
        text[16] = new Text("Player 2's turn",24,815.00,125.00,"WHITE",0);

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
        arena.addRectangle(powerBar);
        arena.addLine(headSpot);
        arena.addRectangle(table);
        arena.addRectangle(felt);
        for(int i=0;i<6;i++){
            if(i<3){
                pot[i] = new Ball(400.00+(i*500.00),250.00,49.00,"BLACK",4);
            }
            if(i>=3){
                pot[i] = new Ball(((i-3)*(500.00))+400.00,750.00,49.00,"BLACK",4);
            }
            arena.addBall(pot[i]);
        }
        for(int j=0;j<15;j++){

            arena.addBall(solid[j]);
        }
        for(int i=0;i<13;i++){
            arena.addText(text[i]);
        }
    }
    public Ball[] getPots(){
        return pot;
    }
    public Ball[] getBalls(){
        return solid;
    }

    public Ball[] getExclusiveBalls(Ball ball,Ball cueBall){
        index = 0;
        for(int j=0;j<15;j++){
            if(solid[j]==ball){
                ballIndex = j;
            }
        }
        for(int k=0;k<15;k++){
            if(k!=ballIndex){
                exclusiveBalls[index]=solid[k];
                index++;
            }
        }
        exclusiveBalls[14]=cueBall;
        return exclusiveBalls;
    }
    public void setPlayerOneTurn(GameArena arena){
        arena.removeText(text[16]);
        arena.addText(text[15]);
    }
    public void setPlayerTwoTurn(GameArena arena){
        arena.removeText(text[15]);
        arena.addText(text[16]);
    }
}