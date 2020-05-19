public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        double velocityX = 1.00;
        double velocityY = 2.00;
        BallMovement cueB = new BallMovement();
        while(true){
            arena.pause();
            cueB.moveCueBall(initial.getcueBall());
        }
    }
}