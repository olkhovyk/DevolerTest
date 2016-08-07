import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Created by ilya on 04.08.2016.
 */
public class Test {

    Table table = new Table();
    Logger log = Logger.getLogger(Test.class.getName());

    public Test() {
    }
    public Table getTable() {
        return table;
    }

    public void run() throws IOException {
        for(int i = 0; i <=5; i++){
            log.info(String.valueOf(table.getRobots().get(i).getRobotNumber()) + " charge = "
                    + table.getRobots().get(i).getCharge());
        }
    }

}
