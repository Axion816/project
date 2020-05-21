public class CoolPool{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);
        Layout initial = new Layout(arena);

        //Movement
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5);
        Ball[] balls = new Ball[15];
        Ball[] exclusiveBalls = new Ball[14];
        balls = initial.getBalls();
        BallMovement movement = new BallMovement();
        arena.addBall(cueBall);
        PoolCue cue = new PoolCue(arena,cueBall);
        Ball tempBall;

        while(true){
            if(movement.checkVelocity(balls,cueBall)==true){
                cue.setupShot(arena,cueBall);
            }
            arena.pause();
            movement.moveBall(cueBall,initial.getBalls(),initial.getPots());
            for(int i=0;i<15;i++){
                tempBall = balls[i];
                exclusiveBalls = initial.getExclusiveBalls(tempBall,cueBall);
                movement.moveBall(tempBall,exclusiveBalls,initial.getPots());
            }
            if(arena.escPressed()==true){
                arena.exit();
            }
        }
    }
}