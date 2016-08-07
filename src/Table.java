import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 03.08.2016.
 */
public class Table  {
    public List<Integer> robotsStrategy = new ArrayList<>();
    public List<Robot> robots = new ArrayList<>();
    public List<Part> parts = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;
    int j;

    public Table() {
        try {
            setRobotStrategy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i <= 5; i++){
            robots.add(new Robot(i, robotsStrategy.get(i), false, false));
        }
        for (int i = 0; i <=5; i++){
            parts.add(new Part(i, false));
        }
        for (int i = 0; i <= 5; i++){
            System.out.println(parts.get(i).isPartWorking());
        }
        for (int i = 0; i <=5; i++){
            takeRightPart(i);
        }
        for (int i = 0; i <= 5; i++){
            System.out.println(parts.get(i).isPartWorking());
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
        for (int i = 0; i < robotsStrategy.size(); i++){
            System.out.println(robotsStrategy.get(i));
        }
    }

    private void takeLeftPart(int robot){
        if(!parts.get(robots.get(robot).getRobotNumber()).isPartWorking())
            {
        parts.get(robots.get(robot).getRobotNumber()).setPartWorking(true);
        robots.get(robots.get(robot).getRobotNumber()).setLeftHand(true);
        }
    }

    private void takeRightPart(int robot){
       try {
           if(!parts.get(robots.get(robot).getRobotNumber()).isPartWorking())
           {
           parts.get(robots.get(robot).getRobotNumber()+1).setPartWorking(true);
           robots.get(robots.get(robot).getRobotNumber()).setRightHand(true);
           }
       }
        catch (IndexOutOfBoundsException e){
            if(!parts.get(0).isPartWorking())
            {
            parts.get(0).setPartWorking(true);
            robots.get(robots.get(robot).getRobotNumber()).setRightHand(true);
            }
        }
    }



}
