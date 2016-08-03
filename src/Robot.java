
public class Robot {
    private int robotNumber;
    private int charge;
    private int action;
    private boolean work;

    public Robot(int robotNumber, int charge, int action) {
        this.robotNumber = robotNumber;
        this.charge = charge;
        this.action = action;
    }

    public void chargingRobot(){};

    public void sleep(){};

    public void function(){};

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

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }
}
