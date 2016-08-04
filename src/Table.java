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
            robots.add(new Robot(i+1, robotsStrategy.get(i)));
        }

    }

    public void setRobotStrategy() throws IOException {
        System.out.println("������� ������ ��������� (1-3) ��� 6 �������");
        System.out.println("��� 0 - ��� ������");
        while (i != 6){
            j = Integer.parseInt(reader.readLine());
            if(j == 1 || j == 2 || j ==3){
                robotsStrategy.add(j);
                i++;
            }
            else if (j == 0){
                System.out.println("Exit");
                break;
            }
            else {
                System.out.println("������� ������������ �����, ��������� ����");
            }
        }
        for (int i = 0; i < robotsStrategy.size(); i++){
            System.out.println(robotsStrategy.get(i));
        }
    }


}
