public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(2000,1000);
        /*Test
        Ball a = new Ball(50.00,50.00,10.00,"RED");
        arena.addBall(a);
        */
        //Text Title
        Text title = new Text("Welcome to Cool Pool!",14,20.00,20.00,"WHITE");
        arena.addText(title);
        //Pool Table
        Rectangle table = new Rectangle(330.00,165.00,1340.00,670.00,"GRAY",1);
        Rectangle felt = new Rectangle(100.00,100.00,400.00,200.00,"GREEN",2);
        arena.addRectangle(table);
        arena.addRectangle(felt);
        //Outlay
        Rectangle powerBar = new Rectangle(650.00,825.00,700.00,100.00,"RED");
        arena.addRectangle(powerBar);
    }
}