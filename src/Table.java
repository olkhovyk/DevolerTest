import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 03.08.2016.
 */
public class Table  {
    public List<Integer> robotsStrategy;
    public List<Robot> robots;
    public List<Part> parts;
    BufferedReader reader;
    int i = 0;
    int j;



    public Table() {
        robotsStrategy = new ArrayList<>();
        robots = new ArrayList<>();
        parts = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            setRobotStrategy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i <= 5; i++){
            robots.add(new Robot(i, robotsStrategy.get(i), false, false, this, 50, true));

        }
        for (int i = 0; i <=5; i++){
            parts.add(new Part(i, false));
        }
        run();

    }

    private void setRobotStrategy() throws IOException {
        System.out.println("Введите номера стратегий (1-3) для 6 роботов");
        System.out.println("Или 0 - для выхода");
        while (i != 6){
            try{
            j = Integer.parseInt(reader.readLine());
            if(j == 1 || j == 2 || j ==3){
                robotsStrategy.add(j);
                i++;
            }
            else if (j == 0){
                System.out.println("Exit");
                System.exit(0);
            }
            else {
                System.out.println("Введено неправильное число, повторите ввод");
            }
            }
            catch (NumberFormatException e){
                System.out.println("Введено не число");
                System.exit(0);

            }
        }
        reader.close();
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Part> getParts() {
        return parts;
    }

    protected void run(){
        for (int i = 0; i <=5; i++){
            Thread t = new Thread(robots.get(i));
            t.start();
        }
    }


}
