

public class Robot {
    Table table;
    private Strategy strategy;
    private int robotNumber;
    private int charge;
    private int action;
    private boolean work;
    private boolean leftHand;
    private boolean rightHand;
    double i;
        public Robot(int robotNumber, int action, boolean leftHand, boolean rightHand) {
            strategy = new Strategy();
            strategy.strategy(action);
            this.robotNumber = robotNumber;
            this.charge = 50;
            this.action = action;
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

    public void randomSleep(Thread thread) {
            i =  Math.random() * 3;
            int s = (int) i;
            if(s <= 1) {s = 100;}
            else if(s > 1 && s <=2){s=200;}
            else {s=300;}
            try {
                thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public void sleep(Thread thread, int i){
        try {
            thread.sleep(i);
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


    public void function(){}
}
