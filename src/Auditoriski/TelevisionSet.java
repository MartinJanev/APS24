package Auditoriski.Prvi;

public class TelevisionSet extends Appliance {
    private int screenSize;
    private boolean isSmart;
    private String os;


    public TelevisionSet(String producer, int screenSize, boolean isSmart, String os) {
        super(producer);
        this.screenSize = screenSize;
        this.isSmart = isSmart;
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "TelevisionSet {" +
                super.toString() +
                "screenSize=" + screenSize +
                ", isSmart=" + isSmart +
                ", os='" + os + '\'' +
                '}';
    }
}
