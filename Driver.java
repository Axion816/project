public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        BallMovement play = new BallMovement();
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5);
        arena.addBall(cueBall);
        while(true){
            arena.pause();
            play.moveCueBall(cueBall,initial.getPots());
            play.collisionCheck(cueBall,initial.getBalls());
        }
    }
}