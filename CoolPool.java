public class CoolPool{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5);
        BallMovement cB = new BallMovement(cueBall);
        BallMovement[] exclusiveBalls = new BallMovement[14];
        arena.addBall(cueBall);
        BallMovement[] movementName = initial.getMovementArray();
        Ball[] balls = initial.getBalls();
        PoolCue cue = new PoolCue();
        cue.changePower(arena,cB);

        while(true){
            arena.pause();
            cB.collisionCheckCueBall(movementName);
            cB.potCheck(initial.getPots());
            cB.moveBall();
            
            for(int i=0;i<15;i++){
                exclusiveBalls = initial.getExclusiveBalls(i);
                BallMovement tempMovement = movementName[i];
                tempMovement.collisionCheck(exclusiveBalls,cB);
                tempMovement.potCheck(initial.getPots());
                tempMovement.moveBall();
            }
            if(arena.escPressed()==true){
                arena.exit();
            }
        }
    }
}