package FinalTest;

import java.io.Serializable;

public class Container implements Serializable {
    private static final long serialVersionUID = 1L;
    private String      containerNumber;
    private float       containerHeight;
    private float       containerWidth;
    private boolean     containerStatus;

    public Container (String containerNumber, float  containerHeight, float containerWidth, boolean containerStatus){
        this.containerNumber = containerNumber;
        this.containerHeight = containerHeight;
        this.containerWidth  = containerWidth;
        this.containerStatus = containerStatus;
    }

    public String showContainer(){
        return ("Container number: "+containerNumber+"\nContainerHeight: "+containerHeight+"\nContainerWidth: "+containerWidth+"\nContainerStatus: "+containerStatus);
    }
    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public float getContainerHeight() {
        return containerHeight;
    }

    public void setContainerHeight(float containerHeight) {
        this.containerHeight = containerHeight;
    }

    public float getContainerWidth() {
        return containerWidth;
    }

    public void setContainerWidth(float containerWidth) {
        this.containerWidth = containerWidth;
    }

    public boolean isContainerStatus() {
        return containerStatus;
    }

    public void setContainerStatus(boolean containerStatus) {
        this.containerStatus = containerStatus;
    }
}
