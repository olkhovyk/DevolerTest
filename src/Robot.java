

public class Robot {
    private Strategy strategy;
    private int robotNumber;
    private int charge;
    private int action;
    private boolean work;
    double i;
        public Robot(int robotNumber, int action) {
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
        public void chargingRobot(){
            setCharge(charge +=10);
        }

        public void sleep() {

            i =  Math.random() * 300;
            int s = (int) i;
            if(s <= 100) {s = 100;}
            System.out.println("Sleep " + s + "mc");
        }

        public void function(){}
}
