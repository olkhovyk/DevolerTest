

public class Robot {
    private int robotNumber;
    private int charge;
    private int action;
    private boolean work;

        public Robot(int robotNumber, int charge, int action) {
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
        };

        public void sleep(int i){
            i = (int) Math.random() * 300/100;

            System.out.println("Sleep " + i + "mc");
        };

        public void function(){};
}
