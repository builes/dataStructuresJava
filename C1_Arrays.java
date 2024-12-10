public class C1_Arrays {
    public static void main(String[] args){
        // created array object of Student class
        Student[] students = new Student[5];
        // set the values through the constructor
        students[0] = new Student(1,"John", 19);
        students[1] = new Student(2,"Juan", 25);
        students[2] = new Student(3,"Luis", 26);
        students[3] = new Student(4,"Fredy", 45);
        students[4] = new Student(5,"Diana", 14);


        // TODO 2: Uncomment the method call once you have completed the mentioned tasks
        int IndexToDelete = (int) (Math.random() * 4) + 1;
        removeElement(IndexToDelete, students);


        //AddElement(new Student(6, "Shally", 19), students);

        int IndexToUpdate = (int) Math.random() * 4 + 1;
        //updateElement(IndexToUpdate, students);
    }
    public static void removeElement(int IndexToDelete, Student[] originalArray){
        Student[] newStudents = new Student[originalArray.length - 1];

        for (int i = 0, counter = 0; i < originalArray.length; i++) {
            if(i != IndexToDelete){
                newStudents[counter++] = originalArray[i];
            }
        }

        printArray("Remove", newStudents);

    }
    public static void AddElement(Student newStudent,Student[] originalArray){
        Student[] newStudents = new Student[originalArray.length + 1];

        for (int i = 0; i < newStudents.length; i++) {
            if( i == newStudents.length - 1){
                newStudents[i] = newStudent;
            }else {
                newStudents[i] = originalArray[i];
            }
        }

        printArray("Add", newStudents);

    }
    public static void updateElement(int indexToUpdate, Student[] originalArray){

        Student student = originalArray[indexToUpdate];
        student.setAge(33);
        student.setName("Mauricio");

        printArray("Update",originalArray);
    }
    public static void printArray(String message, Student[] students){
        System.out.printf("%s a student%n", message );

        for (int i = 0; i < students.length; i++) {
            System.out.printf("""
                    %s has %d years old
                    """, students[i].getName(), students[i].getAge());
        }
    }
}


class Student {
    private int rollNumber;
    private String name;
    private int age;

    /* default constructor */
    public Student(){

    }
    /* parameterized constructor*/
    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
