import java.io.File;
import java.util.Scanner; 

public class FilesInDir {
  public static void main(String[] args) {
    // Prompt the user to enter a directory or a file
    System.out.print("Enter a directory or a file: ");    
    Scanner input = new Scanner(System.in);
    String directory = input.nextLine();
    
    // Display the size
    System.out.println(getSize(new File(directory)) + " files in " + directory);
  }

  public static long getSize(File file) {
    int fileCount = 0;
    
    if (file.isDirectory()) {
      File[] files = file.listFiles(); // All files and subdirectories
      for (int i = 0; files != null && i < files.length; i++) {
    	fileCount += getSize(files[i]); // Recursive call
      }
    }
    else { // Base case
    	fileCount++;
    }

    return fileCount;
  }
}