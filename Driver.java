public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(707,500);
        //Test
        Ball a = new Ball(50.00,50.00,10.00,"RED");
        arena.addBall(a);
        //Title
        Text title = new Text(100,100,0,"Welcome To Cool Pool!","WHITE");
        arena.addText(title);

    }
}