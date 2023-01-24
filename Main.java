import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;

class Main {
  public static void main(String[] args) throws Exception {
    int counter = 0;

    BufferedReader myReader = new BufferedReader(new FileReader("lec.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("lecturesOnly.txt"));

    String line = myReader.readLine();
    while (line != null) {
      if (line.contains("Online") || line.contains("online")) {

        writer.write(line);

        counter++;
      }

      line = myReader.readLine();
    }
    writer.close();

    String location;

    Scanner ask = new Scanner(System.in);

    // String lecOrLab;

    System.out.print("- There are " + counter + " online lectures offered");
    System.out.print("\n - Enter the classroom: ");
    location = ask.nextLine();

    System.out.println("- lecturesOnly.txt is created");
    System.out.println("Goodbye!");

    System.out.println("_______________________________");
    System.out.println("Given the content of lec.txt, lecturesOnly.txt should be: ");

    System.out.println("Online Lectures\n");

    File file = new File("lec.txt");
    Scanner in = null;

    try {
      in = new Scanner(file);
      while (in.hasNext()) {
        String line1 = in.nextLine();
        if (line1.contains("Online") || line1.contains("online"))
          System.out.println(line1);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("\nLectures with No Lab\n");

    try {

      in = new Scanner(file);
      while (in.hasNext()) {
        String line2 = in.nextLine();
        if (line2.contains("No") || line2.contains("no"))
          System.out.println(line2);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      PrintStream out;

      out = new PrintStream(new FileOutputStream("lecturesOnly.txt"));

      System.setOut(out);
      System.out.println("Online Lectures\n");
      in = new Scanner(file);
      while (in.hasNext()) {
        String line1 = in.nextLine();
        if (line1.contains("Online") || line1.contains("online"))
          System.out.println(line1);
      }
      System.out.println("\nLectures with No Lab\n");
      in = new Scanner(file);
      while (in.hasNext()) {
        String line2 = in.nextLine();
        if (line2.contains("No") || line2.contains("no"))
          System.out.println(line2);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}