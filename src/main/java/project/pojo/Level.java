package project.pojo;

public enum Level {
    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    private final String value;
    Level(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
