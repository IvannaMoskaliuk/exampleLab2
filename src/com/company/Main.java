package com.company;

import com.company.model.FullTimeEmployee;
import com.company.model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FullTimeEmployee f1 = new FullTimeEmployee("f1", 7000);
        FullTimeEmployee f2 = new FullTimeEmployee("f2", 6000);
        FullTimeEmployee f3 = new FullTimeEmployee("f3", 4000);
        FullTimeEmployee f4 = new FullTimeEmployee("f4", 5500);
        FullTimeEmployee f5 = new FullTimeEmployee("f5", 4800);

        PartTimeEmployee designer = new PartTimeEmployee("designer", 25, 150);
        PartTimeEmployee tester = new PartTimeEmployee("tester", 35, 176);
        PartTimeEmployee backEnd = new PartTimeEmployee("JavaDev", 50, 200);
        PartTimeEmployee gui = new PartTimeEmployee("gui", 38, 200);
        PartTimeEmployee devops = new PartTimeEmployee("admin", 40, 176);

        List<IAcounting> employees = new ArrayList<>();
        employees.add(f1);
        employees.add(f2);
        employees.add(f3);
        employees.add(f4);
        employees.add(f5);

        employees.add(designer);
        employees.add(tester);
        employees.add(backEnd);
        employees.add(gui);
        employees.add(devops);

        int salary = employees.stream().mapToInt(IAcounting::getSalary).sum();

        IAcounting highestSalaryMan = employees.stream()
                .max(Comparator.comparingInt(IAcounting::getSalary))
                .orElse(null);

        IAcounting lowestSalaryMan = employees.stream()
                .min(Comparator.comparingInt(IAcounting::getSalary))
                .orElse(null);

        double avg = employees.stream().mapToInt(IAcounting::getSalary)
                .average().orElse(0);

        int partTimeSalary = employees.stream().filter(el -> el instanceof PartTimeEmployee)
                .mapToInt(IAcounting::getSalary).sum();

        int fullTimeSalary = employees.stream().filter(el -> el instanceof FullTimeEmployee)
                .mapToInt(IAcounting::getSalary).sum();

        if ( partTimeSalary > fullTimeSalary) {
            System.out.println("Part time workers get greater salary than " +
                    "Full timers");
        } else {
            System.out.println("Fulltimers are the best");
        }




    }
}
