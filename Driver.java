public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5,2.00,3.00);
        BallMovement cB = new BallMovement(cueBall);
        arena.addBall(cueBall);
        while(true){
            arena.pause();
            cB.moveBall(cueBall,initial.getPots());
            cB.collisionCheck(cueBall,initial.getBalls());
            cB.potCheck(cueBall,initial.getPots());
        }
    }
}