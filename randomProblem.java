import java.io.*;
import java.util.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class randomProblem {

  public static ArrayList<String> read() {
    ArrayList<String> problems = new ArrayList<String>();
    // The name of the file to open.
    String fileName = "problems.txt";

    // This will reference one line at a time
    String line = null;

    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader =
      new FileReader(fileName);

      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader =
      new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        //System.out.println(line);
        problems.add(line);

      }

      // Always close files.
      bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println(
      "Unable to open file '" +
      fileName + "'");
    }
    catch(IOException ex) {
      System.out.println(
      "Error reading file '"
      + fileName + "'");
      // Or we could just do this:
      // ex.printStackTrace();
    }
    return problems;
  }
  public static void write(ArrayList<String> completed) {

    // The name of the file to open.
    String fileName = "problems.txt";

    try {
      // Assume default encoding.
      FileWriter fileWriter =
      new FileWriter(fileName);

      // Always wrap FileWriter in BufferedWriter.
      BufferedWriter bufferedWriter =
      new BufferedWriter(fileWriter);

      // Note that write() does not automatically
      // append a newline character.
      for(int i = 0; i < completed.size(); i++){
        bufferedWriter.write(completed.get(i));
        bufferedWriter.newLine();
      }

      // Always close files.
      bufferedWriter.close();
    }
    catch(IOException ex) {
      System.out.println(
      "Error writing to file '"
      + fileName + "'");
      // Or we could just do this:
      // ex.printStackTrace();
    }
  }

  public static void main(String[] args){
    ArrayList<String> probList = new ArrayList<String>();
    probList = read();

    try {
      if(args[0].equals("new")){
        Random randomizer = new Random();
        String random = probList.get(randomizer.nextInt(probList.size()));

        String[] languages = new String[2];
        languages[0] = "Java";
        languages[1] = "Python";
        String lang = languages[new Random().nextInt(languages.length)];

        System.out.println("Try problem number " + random + " in "+lang+".");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = "https://projecteuler.net/problem="+random;

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
      }
      else if (args[0].equals("completed")){
        probList.remove(args[1]);
        System.out.println("Completed problem "+args[1]+".");
        write(probList);
      }
      else if (args[0].equals("list")){
        System.out.println("Here are the remaining problems:");
        for(int i = 0; i < probList.size(); i++){
          System.out.println(probList.get(i));
        }
      }
    }
    catch(ArrayIndexOutOfBoundsException ex){
      if(args.length == 0){
        System.out.println("No command given.");
      }
      else if(args[0].equals("completed")){
        System.out.println("Please provide a problem number.");
      }
    }
  }
}
