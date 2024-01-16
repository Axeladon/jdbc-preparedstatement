package project.pojo;

import java.sql.Date;

public class ProjectPojo {
    private int clientId;
    private Date startDate;
    private Date finishDate;

    public ProjectPojo(int clientId, Date startDate, Date finishDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }
}