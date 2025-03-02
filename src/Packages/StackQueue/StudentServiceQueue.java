package Packages.StackQueue;

import java.util.Scanner;

class Student {
    String index;
    int minutes;

    Student(String index, int minutes) {
        this.index = index;
        this.minutes = minutes;
    }
}

public class StudentServiceQueue {

    static Student iterateStudentsQueue(ArrayQueue<Student> studentsQueue) {
        int minutes = 180;
        Student tempStudent = studentsQueue.peek();
        while (tempStudent != null) {
            if (minutes < tempStudent.minutes) {
                break;
            } else {
                minutes -= tempStudent.minutes;
                studentsQueue.dequeue();
            }
            tempStudent = studentsQueue.peek();
        }
        return tempStudent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vnesi broj na studenti");
        int n = scanner.nextInt();
        ArrayQueue<Student> studentsQueue = new ArrayQueue<Student>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Vnesi index na studentot");
            String index = scanner.nextLine();
            System.out.println("Vnesi minuti potrebni za opsluzuvanje na studentot");
            int minutes = scanner.nextInt();
            Student student = new Student(index, minutes);
            studentsQueue.enqueue(student);
        }

        Student student = iterateStudentsQueue(studentsQueue);
        if (studentsQueue.isEmpty()) {
            System.out.println("Opsluzeni se site studenti");
        } else {
            System.out.println("Prviot student sto nema da e opsluzen e: " + student.index);
            System.out.println("Broj na studenti koi ne se opsluzeni za deneska: " + studentsQueue.length);
        }
    }
}
