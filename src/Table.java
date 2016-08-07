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
            robots.add(new Robot(i, robotsStrategy.get(i), false, false));
            Thread t = new Thread(robots.get(i));
            t.start();
        }
        for (int i = 0; i <=5; i++){
            parts.add(new Part(i, false));
        }

    }

    private void setRobotStrategy() throws IOException {
        System.out.println("Введите номера стратегий (1-3) для 6 роботов");
        System.out.println("Или 0 - для выхода");
        while (i != 6){
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
        reader.close();
    }

    protected void takeLeftPart(int idRobot){
        if(!parts.get(robots.get(idRobot).getRobotNumber()).isPartWorking())
            {
        parts.get(robots.get(idRobot).getRobotNumber()).setPartWorking(true);
        robots.get(robots.get(idRobot).getRobotNumber()).setLeftHand(true);
        }
    }

    protected void takeRightPart(int idRobot){
       try {
           if(!parts.get(robots.get(idRobot).getRobotNumber()+1).isPartWorking())
           {
           parts.get(robots.get(idRobot).getRobotNumber()+1).setPartWorking(true);
           robots.get(robots.get(idRobot).getRobotNumber()).setRightHand(true);
           }
       }
        catch (IndexOutOfBoundsException e){
            if(!parts.get(0).isPartWorking())
            {
            parts.get(0).setPartWorking(true);
            robots.get(robots.get(idRobot).getRobotNumber()).setRightHand(true);
            }
        }
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Part> getParts() {
        return parts;
    }


}
