public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5,10.00,5.00);
        BallMovement cB = new BallMovement(cueBall);
        arena.addBall(cueBall);
        BallMovement[] movementName = initial.getMovementArray();
        Ball[] balls = initial.getBalls();

        while(true){
            arena.pause();
            cB.updateVelocity(cueBall);
            cB.collisionCheck(cueBall,initial.getBalls());
            cB.potCheck(cueBall,initial.getPots());
            cB.moveBall(cueBall);
            for(int i=0;i<15;i++){
                Ball tempBall = balls[i];
                BallMovement tempMovement = movementName[i];
                tempMovement.updateVelocity(tempBall);
                tempMovement.collisionCheck(tempBall,balls);
                tempMovement.potCheck(tempBall,balls);
                tempMovement.moveBall(tempBall);
            }
        }
    }
}