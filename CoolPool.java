public class CoolPool{
    public static void main(String[] Args){
        GameArena arena = new GameArena(1800,1000);                     // GameArena window
        Layout initial = new Layout(arena);                             // Layout at the start of the game
        Ball cueBall = new Ball(650.00,500.00,22.00,"WHITE",5);         // Creates the cue ball
        Ball[] balls = new Ball[15];                                    // Ball[] holds all solid balls
        Ball[] exclusiveBalls = new Ball[14];                           // Ball[] holds all solid balls excluding the temp ball
        balls = initial.getBalls();
        BallMovement movement = new BallMovement();                     // Creates BallMovement
        arena.addBall(cueBall);
        PoolCue cue = new PoolCue(arena,cueBall);                       // Creates PoolCue for shot setup
        Ball tempBall;                                                  // Temporary Ball holds a given ball
        // Game starts
        while(true){
            // Checks if balls are stationary before setup shot
            if(movement.checkVelocity(balls,cueBall)==true){
                cue.setupShot(arena,cueBall,initial);
            }
            arena.pause();
            // Moves cueball
            movement.moveBall(arena,cueBall,initial.getBalls(),initial.getPots(),cue,initial);
            // Moves all other balls
            for(int i=0;i<15;i++){
                tempBall = balls[i];
                exclusiveBalls = initial.getExclusiveBalls(tempBall,cueBall);
                movement.moveBall(arena,tempBall,exclusiveBalls,initial.getPots(),cue,initial);
            }
            // Exits the window on pressing escape
            if(arena.escPressed()==true){
                arena.exit();
            }
        }
    }
}