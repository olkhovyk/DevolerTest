

public class Robot implements Runnable {
    public final static int MAX_CHARGE = 100;
    Table table;
    private int robotNumber;
    private int charge;
    private int action;
    private boolean work;
    private boolean leftHand;
    private boolean rightHand;
    double i;
        public Robot(int robotNumber, int action, boolean leftHand, boolean rightHand, Table table, int charge, boolean work) {
            this.robotNumber = robotNumber;
            this.charge = charge;
            this.action = action;
            this.table = table;
            this.work = work;

        }

        public int getRobotNumber() {
        return robotNumber;
    }

        public void setRobotNumber(int robotNumber) {
        this.robotNumber = robotNumber;
    }

        public int getCharge() {
        return charge;
    }

        public void setCharge(int charge) {
        this.charge = charge;
    }

        public int getAction() {
        return action;
    }

        public void setAction(int action) {
        this.action = action;
    }

        public boolean isWorking() {
        return work;
    }

        public void setWorking(boolean work) {
        this.work = work;
    }

    public boolean isLeftHand() {
        return leftHand;
    }

    public void setLeftHand(boolean leftHand) {
        this.leftHand = leftHand;
    }

    public boolean isRightHand() {
        return rightHand;
    }

    public void setRightHand(boolean rightHand) {
        this.rightHand = rightHand;
    }

    public void chargingRobot(){
            setCharge(charge +=10);
        }

    public void unchargingRobot(){
        setCharge(charge -=10);
    }

    public void randomSleep() {
            i =  Math.random() * 3;
            int s = (int) i;
            if(s <= 1) {s = 100;}
            else if(s > 1 && s <=2){s=200;}
            else {s=300;}
            try {
                Thread.currentThread().sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public void sleep(int i){
        try {
            Thread.currentThread().sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void takeRightPart(int robot){
        try {
            if(!table.getParts().get(table.getRobots().get(robot).getRobotNumber()+1).isPartWorking())
            {
                table.getParts().get(table.getRobots().get(robot).getRobotNumber()+1).setPartWorking(true);
                table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setRightHand(true);
            }
        }
        catch (IndexOutOfBoundsException e){
            if(!table.getParts().get(0).isPartWorking())
            {
                table.getParts().get(0).setPartWorking(true);
                table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setRightHand(true);
            }
        }
    }

    protected void takeLeftPart(int robot){
        if(!table.getParts().get(table.getRobots().get(robot).getRobotNumber()).isPartWorking())
        {
            table.getParts().get(table.getRobots().get(robot).getRobotNumber()).setPartWorking(true);
            table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setLeftHand(true);
        }
    }

    protected void releaseLeftPart(int robot){
        if(table.getParts().get(table.getRobots().get(robot).getRobotNumber()).isPartWorking())
        {
            table.getParts().get(table.getRobots().get(robot).getRobotNumber()).setPartWorking(false);
            table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setLeftHand(false);
        }
    }
    protected void releaseRightPart(int robot){
        try {
            if(table.getParts().get(table.getRobots().get(robot).getRobotNumber()+1).isPartWorking())
            {
                table.getParts().get(table.getRobots().get(robot).getRobotNumber()+1).setPartWorking(false);
                table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setRightHand(false);
            }
        }
        catch (IndexOutOfBoundsException e){
            if(!table.getParts().get(0).isPartWorking())
            {
                table.getParts().get(0).setPartWorking(false);
                table.getRobots().get(table.getRobots().get(robot).getRobotNumber()).setRightHand(false);
            }
        }
    }

    public void strategy(int strategy){
        if(strategy == 1){random();}
        else if (strategy == 2){greedy();}
        else if(strategy == 3){gentleman();}
        else {
            System.out.println("Wrong strategy");
        }
    }
    public void random(){
        for(int i = 0; i <=5; i++) {
            if(table.getRobots().get(i).isWorking()){
            if(table.getRobots().get(i).getCharge() == MAX_CHARGE){
                releaseLeftPart(i);
                releaseRightPart(i);
            }
                if(table.getRobots().get(i).getCharge() < MAX_CHARGE)
                {
                    table.getRobots().get(i).setCharge(100);
                }
            if(table.getRobots().get(i).getAction() == 1){
            if (table.getRobots().get(i).getCharge() < MAX_CHARGE) {
                    takeLeftPart(i);
                    takeRightPart(i);
                }
            }
            if (table.getRobots().get(i).isLeftHand() && table.getRobots().get(i).isRightHand()){
                table.getRobots().get(i).chargingRobot();
            }

        }
            if(table.getRobots().get(i).getCharge() == 0){
                table.getRobots().get(i).setWorking(false);
                releaseLeftPart(i);
                releaseRightPart(i);
            }
        }
        for (int i = 0; i <= 5; i++){
            if(table.getRobots().get(i).getAction() == 1){
                releaseLeftPart(i);
                releaseRightPart(i);
            }
        }
        randomSleep();
    }

    public void greedy(){
        for(int i = 0; i <=5; i++){
            if(table.getRobots().get(i).isWorking()) {
                if (table.getRobots().get(i).getAction() == 2) {
                    if (table.getRobots().get(i).getCharge() < 60) {
                        takeLeftPart(i);
                        takeRightPart(i);
                        if (table.getRobots().get(i).isLeftHand() && table.getRobots().get(i).isRightHand()) {
                            table.getRobots().get(i).chargingRobot();
                            if (table.getRobots().get(i).getCharge() == MAX_CHARGE) {
                                releaseLeftPart(i);
                                releaseRightPart(i);
                            }
                        }

                        if (table.getRobots().get(i).getCharge() == MAX_CHARGE) {
                            releaseLeftPart(i);
                            releaseRightPart(i);
                        }
                    }
                    if(table.getRobots().get(i).getCharge() == 0){
                        table.getRobots().get(i).setWorking(false);
                        releaseLeftPart(i);
                        releaseRightPart(i);
                    }
                } else {
                    sleep(500);
                }
            }
        }
    }


    public void gentleman(){
        for(int i = 0; i <=5; i++) {
            if(table.getRobots().get(i).isWorking()) {
              if(table.getRobots().get(i).getCharge() == MAX_CHARGE){
                releaseLeftPart(i);
                releaseRightPart(i);
                }
            if(table.getRobots().get(i).getAction() == 3){
                    takeLeftPart(i);
                    takeRightPart(i);
            }
            if (table.getRobots().get(i).isLeftHand() && table.getRobots().get(i).isRightHand()){
                table.getRobots().get(i).chargingRobot();
                if(table.getRobots().get(i).getCharge() == MAX_CHARGE){
                    releaseLeftPart(i);
                    releaseRightPart(i);
                }
            }
            try {
                if(table.getRobots().get(i-1).getCharge() <table.getRobots().get(i).getCharge()
                        || table.getRobots().get(i+1).getCharge() <table.getRobots().get(i).getCharge()){
                    releaseLeftPart(i);
                    releaseRightPart(i);
                }
                sleep(200);
            }
            catch (IndexOutOfBoundsException e){
                //table.getRobots().get(i-1).getCharge() <table.getRobots().get(i).getCharge()

                if( table.getRobots().get(0).getCharge() <table.getRobots().get(i).getCharge()){
                    releaseLeftPart(i);
                    releaseRightPart(i);
                }
                sleep(200);
            }
            }
            if(table.getRobots().get(i).getCharge() == 0){
                table.getRobots().get(i).setWorking(false);
                releaseLeftPart(i);
                releaseRightPart(i);
            }
          /*  catch (Exception e){
                if(table.getRobots().get(5).getCharge() <table.getRobots().get(i).getCharge()
                        || table.getRobots().get(i+1).getCharge() <table.getRobots().get(i).getCharge()){
                    releaseLeftPart(i);
                    releaseRightPart(i);
                }
                sleep(200);
            } */
        }
    }

    @Override
    public void run() {
        strategy(action);
    }


}
