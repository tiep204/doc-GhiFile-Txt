import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoiTuong {
    public static void main(String[] args) {
/*        List<Student> studentList = new ArrayList<>();
        Student student = new Student(1, "tiep", 12);
        Student student1 = new Student(2, "tiep1", 19);
        Student student2 = new Student(3, "tiep2", 20);
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        writeObjectToFile(studentList, "listStudent.txt");*/
        readObjectFromFile("listStudent.txt");
    }

    public static void writeObjectToFile(List<Student> list, String path) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //1.khoi tao doi tuong file
            file = new File(path);
            //2. khoi tao doi tuong outputStream
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            //3.Ghi du lieu ra file
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. dong cac ket noi
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readObjectFromFile(String path) {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream oos = null;
        try {
            //1. khoi tao doi tuong file
            file = new File(path);
            //2. khoi tao cac doi tuong inputSteam
            fis = new FileInputStream(file);
            oos = new ObjectInputStream(fis);
            //3.Doc doi tuong tu file va luu  o bien
            List<Student> listRead = (List<Student>) oos.readObject();
            System.out.println("danh sach sinh vien doc duoc tu file");
            System.out.printf("%-10s %-20s %-10s \n","ID","Name","Age");
            for (Student st : listRead) {
                System.out.printf("%-10d %-20s %-10d \n",st.getId(),st.getName(),st.getAge());
            }

        } catch (Exception e) {

        } finally {
            //4. dong cac ket noi
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fis != null) {
                    fis.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
