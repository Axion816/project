public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(707,500);
        //Test
        Ball a = new Ball(50.00,50.00,10.00,"RED");
        arena.addBall(a);
        //Title
        Text title = new Text("Welcome to Cool Pool!",14,20.00,20.00,"WHITE");
        arena.addText(title);

    }
}