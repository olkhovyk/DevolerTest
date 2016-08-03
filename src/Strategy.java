/**
 * Created by ilya on 03.08.2016.
 */
public class Strategy {

    public void strategy(int strategy){
        if(strategy == 1){random();}
        else if (strategy == 2){greedy();}
        else if(strategy == 3){gentleman();}
        else {
            System.out.println("Wrong strategy");
        }
    }

    public void random(){}

    public void greedy(){}

    public void gentleman(){}

}
