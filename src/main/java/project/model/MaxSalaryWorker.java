package project.model;

public class MaxSalaryWorker {
    private String name;
    private Integer salary;

    public MaxSalaryWorker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }

    public Integer getSalary() { return salary; }
}
