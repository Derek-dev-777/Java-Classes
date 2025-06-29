package cap03_Set_Exercise02.Application;

import cap03_Set_Exercise02.Models.Entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        Set<Student> set = new HashSet<>();

        System.out.print("How many Students for course A: ");
        int courseA = sc.nextInt();

        System.out.println("Enter the students ID");
        for(int i = 0; i < courseA; i++){
            int alunoId = sc.nextInt();
            set.add(new Student(alunoId));

        }

        System.out.print("How many Students for course B: ");
        int courseB = sc.nextInt();

        System.out.println("Enter the students ID");
        for(int i = 0; i < courseB; i++){
            int alunoId = sc.nextInt();
            set.add(new Student(alunoId));

        }

        System.out.print("How many Students for course C: ");
        int courseC = sc.nextInt();

        System.out.println("Enter the students ID");
        for(int i = 0; i < courseC; i++){
            int alunoId = sc.nextInt();
            set.add(new Student(alunoId));

        }

        System.out.println("Total students: " + set.size());



    }
}
