package project.model;

public class LongestProject {
    private Integer id;
    private Integer monthCount;
    public LongestProject(int id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }
    public Integer getId() { return id; }
    public Integer getMonthCount() { return monthCount; }
}
