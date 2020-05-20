public class Driver{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5,2.00,3.00);
        BallMovement cB = new BallMovement(cueBall);
        arena.addBall(cueBall);
        BallMovement[] movementName = initial.getMovementArray();
        while(true){
            arena.pause();
            cB.updateVelocity(cueBall);
            cB.collisionCheck(cueBall,initial.getBalls());
            cB.potCheck(cueBall,initial.getPots());
            cB.moveBall(cueBall);
            Ball[] b = initial.getBalls();
            for(int i=0;i<15;i++){
                Ball tempBall = b[i];
                BallMovement tempMovement = movementName[i];
                tempMovement.updateVelocity(tempBall);
                tempMovement.collisionCheck(tempBall,b);
                tempMovement.potCheck(tempBall,b);
                tempMovement.moveBall(tempBall);
            }
        }
    }
}