/**
 * Created by ilya on 07.08.2016.
 */
public class Part {
    private int partNumber;
    private boolean partWorking = false;

    public Part(int partNumber, boolean partWorking) {
        this.partNumber = partNumber;
        this.partWorking = partWorking;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public boolean isPartWorking() {
        return partWorking;
    }

    public void setPartWorking(boolean partWorking) {
        this.partWorking = partWorking;
    }
}
