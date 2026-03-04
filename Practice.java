class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void displayDetails(){
        System.out.println("Student ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("MARKS : "+marks);
        System.out.println(" ");
    }
    boolean isPassed(){
        if (this.marks>-50){
            return true;
        } else {
            return false;
        }
    }
}

public class StudentDemo{
    public static void main(String [] args){
        Student student1 = new Student(2182,"Ash_kar",80);
        Student student2 = new Student(10570,"Ash",75);
        System.out.println("---Student Details---");
        student1.displayDetails();
        student2.displayDetails();

        System.out.println("---Status---");
        System.out.println("Result : "+(student1.isPassed() ? "passed" : "Fail"));
        System.out.println("Result : "+(student2.isPassed() ? "passed" : "Fail"));
        System.out.println(" ");

        System.out.println("---Marks checking--");
        compareMarks(student1,student2);
    }
    static void compareMarks(Student student1 , Student student2){
        if(student1.marks>student2.marks){
            System.out.println(student1.name+" higher than "+student2.name);
        }
        else if(student1.marks<student2.marks) {
            System.out.println(student2.name+" higher than "+student1.name);
        }
        else{
            System.out.println("Both are equals");
        }
    }
}
