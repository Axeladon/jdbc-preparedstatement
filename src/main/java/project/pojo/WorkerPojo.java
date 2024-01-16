package project.pojo;

import java.sql.Date;

public class WorkerPojo {
    String name;
    Date date;
    Level level;
    Integer salary;

    public WorkerPojo(String name, Date date, Level level, Integer salary) {
        this.name = name;
        this.date = date;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getLevel() {
        return level.getValue();
    }

    public Integer getSalary() {
        return salary;
    }
}
