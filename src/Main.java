import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ///day la ghi file
        String str = "D:/BaiHoc2/MD-3-JavaCore/bai16-Io-file/filelungtung/untitled/demo.txt";
        writeDatatoFile(sc, str);
        ///day la doc file
        readDataFromFile("demo.txt");
    }

    public static void writeDatatoFile(Scanner sc, String path) {
        ///1. khoi tao doi tượng file
        File file = new File(path);
        //2. khoi tao doi tuong outputStream
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        ///3. thuc hien nhap du lieu tu ban phim va luu ra file
        do {
            System.out.println("nhap 1 dong du lieu");
            String line = sc.nextLine();
            //ghi ra file
            try {
                bw.write(line);
                bw.flush();
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ban co muon ghi du lieu tiep khong");
            System.out.println("1. co");
            System.out.println("2. khong");
            System.out.println("su lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
        //4. dong cac ket noi
        try {
            bw.close();
            osw.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readDataFromFile(String path) {
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            //1.khoi tao doi tuong file
            file = new File(path);
            //2. khoi tao cac doi tuong InputStream
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            //3. doc du lieu tu file
            String line = br.readLine();
            System.out.println("cac du lieu trong file la");
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
                if (isr!=null){
                    isr.close();
                }
                if (fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}