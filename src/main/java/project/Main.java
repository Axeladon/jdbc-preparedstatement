package project;

import project.database.DatabaseQueryService;
import project.model.LongestProject;
import project.model.MaxProjectCountClient;
import project.model.MaxSalaryWorker;
import project.model.YoungestEldestWorkers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        printMaxProjectCountClients();
        printLongestProject();
        printMaxSalaryWorker();
        printYoungestEldestWorkers();
    }

    private static void printMaxProjectCountClients() {
        List<MaxProjectCountClient> mpccList = new DatabaseQueryService().findMaxProjectsClient();
        for (MaxProjectCountClient mpcc : mpccList) {
            System.out.print(mpcc.getName() + " has " + mpcc.getProjectCount() + " projects\n");
        }
    }

    private static void printLongestProject() {
        List<LongestProject> lpList = new DatabaseQueryService().findLongestProject();
        for (LongestProject lp : lpList) {
            System.out.print("Project ID: " + lp.getId() + " has the longest time " + lp.getMonthCount() + " months\n");
        }
    }

    private static void printMaxSalaryWorker() {
        List<MaxSalaryWorker> msList = new DatabaseQueryService().findMaxSalaryWorker();
        for (MaxSalaryWorker lp : msList) {
            System.out.print(lp.getName() + " has the biggest salary = " + lp.getSalary() + "\n");
        }
    }

    private static void printYoungestEldestWorkers() {
        List<YoungestEldestWorkers> yewList = new DatabaseQueryService().findYoungestEldestWorkers();
        for (YoungestEldestWorkers yew : yewList) {
            System.out.println("The " + yew.getType() + " worker is " + yew.getName() + " who has a birthday on " + yew.getBirthday());
        }
    }
}
