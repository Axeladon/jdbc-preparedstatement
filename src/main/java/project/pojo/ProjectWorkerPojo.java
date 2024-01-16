package project.pojo;

public class ProjectWorkerPojo {
    private int project_id;
    private int worker_id;

    public ProjectWorkerPojo(int project_id, int worker_id) {
        this.project_id = project_id;
        this.worker_id = worker_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getWorker_id() {
        return worker_id;
    }
}
