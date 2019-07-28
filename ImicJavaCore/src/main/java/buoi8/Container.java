package buoi8;

import java.util.Date;

public class Container {
    private String      containerNumber;
    private String      containerType;
    private float       containerHeight;
    private float       containerLength;
    private boolean     containerStatus;
    private String      containerLook ="empty";
    private String      containerHold ="N";
    private Date        containerImportDate;
    private int         containerSubmmittedCharge;

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public float getContainerHeight() {
        return containerHeight;
    }

    public void setContainerHeight(float containerHeight) {
        this.containerHeight = containerHeight;
    }

    public float getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(float containerLength) {
        this.containerLength = containerLength;
    }

    public boolean isContainerStatus() {
        return containerStatus;
    }

    public void setContainerStatus(boolean containerStatus) {
        this.containerStatus = containerStatus;
    }

    public String getContainerLook() {
        return containerLook;
    }

    public void setContainerLook(String containerLook) {
        this.containerLook = containerLook;
    }

    public String getContainerHold() {
        return containerHold;
    }

    public void setContainerHold(String containerHold) {
        this.containerHold = containerHold;
    }

    public Date getContainerImportDate() {
        return containerImportDate;
    }

    public void setContainerImportDate(Date containerImportDate) {
        this.containerImportDate = containerImportDate;
    }

    public int getContainerSubmmittedCharge() {
        return containerSubmmittedCharge;
    }

    public void setContainerSubmmittedCharge(int containerSubmmittedCharge) {
        this.containerSubmmittedCharge = containerSubmmittedCharge;
    }
}
