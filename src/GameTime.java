public class GameTime {

    public static void tick() {

    double deltaTime = 0;
    double timePassed = 0;
    double currentTime = 0;
    while(true){
        timePassed = currentTime;
        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - timePassed;

    }

 }
}
