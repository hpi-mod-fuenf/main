import java.lang.Process;
import java.lang.Runtime;
import java.io.IOException;
import java.lang.InterruptedException;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.File;
public class ExitCodeManager {
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime rt = Runtime.getRuntime();
		Process pr=null;
		pr = rt.exec("pdflatex -interaction=nonstopmode main.tex");
		pr.waitFor();
		
		int i= pr.exitValue();
		
		String log = readFile("main.log");
		System.out.println(log);
		log=log.toLowerCase();
		if (i==1) {
			if (log.contains("package babel error")) {
				System.out.println("There was an unimportant 'Package Babel Error', see the log file for more information, the build will not fail because of this");
				log.replaceAll("package babel error:","");
			}
			if (log.contains("Error")) {
				System.out.println("Latex exited with Exit code 1 - BUILD FAILED");
				System.exit(1);
			}
			System.exit(0);
		} if (i==0) {
			System.out.println("Latex exited with Exit code 0 - BUILD SUCESS");
			System.exit(0);
		}
	}
	
	static String readFile(String pathname) throws IOException {

		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");

		try {
			while(scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	}
}
