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
    private boolean test = false;



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

    /**
    *
    * Ввводим стратегии роботам
    *
     */

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

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    /**
    *
    * Запускаем робота в отдельном потоке
     */
    protected void run(){
        for (int i = 0; i <=5; i++){
            Thread t = new Thread(robots.get(i));
            t.start();
        }
    }
    /**
    * Проверка на соответствие требованиям завершения моделирования
     */
    public void test(){
        if((getRobots().get(0).getCharge() == 0 ||getRobots().get(0).getCharge() == 0) &&
                (getRobots().get(1).getCharge() == 0 ||getRobots().get(1).getCharge() == 0) &&
                (getRobots().get(2).getCharge() == 0 ||getRobots().get(2).getCharge() == 0) &&
                (getRobots().get(3).getCharge() == 0 ||getRobots().get(3).getCharge() == 0) &&
                (getRobots().get(4).getCharge() == 0 ||getRobots().get(4).getCharge() == 0) &&
                (getRobots().get(5).getCharge() == 0 ||getRobots().get(5).getCharge() == 0)  )
        {
            setTest(true);
        }
        else {
            setTest(false);
        }
    }


}
