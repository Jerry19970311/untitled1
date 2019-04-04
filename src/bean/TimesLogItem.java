package bean;

public class TimesLogItem {
    private String source;
    private String type;
    private long startTime;
    private long endTime;
    private int status;

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public int getStatus() {
        return status;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
