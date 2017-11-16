/* Homework 8
 * @author NinnYu Chin
 * Instruction:	Write a program that goes through your file system and outputs a tree 
				diagram of all of your directories in a file called dir_tree.txt. The 
				methods in the File class will probably come in very handy. For a sample 
				output, check out this webpage: http://www.computerhope.com/treehlp.htm 
				Make sure you get the indentation right/tree branches right.

				NOTE: GIVEN THAT YOUR ENTIRE DIRECTORY TREE WILL PROBABLY BE HUGE, FEEL 
				FREE TO START FROM ANY FOLDER JUST AS LONG AS THAT FOLDER CONTAINS A 
				BUNCH OF SUB FOLDERS AND A BUNCH OF SUB-SUB FOLDERS, AND FILES AT EACH 
				LEVEL. THE LOGIC IS THE SAME.
 */
import java.io.*;

public class DirTree {
	//Helper variable for keeping track of the depth of the directory tree
	static int dirlevel = 0;

	public static void main (String[] args) {
		File f = new File("/Users/potatopaloozac/Documents/OOP");
		File[] filelist = f.listFiles();
		System.out.println(f.getName());

		printFiles(filelist);
	}
	
	static void printFiles(File[] flist) {
		for (int i=0; i<flist.length; i++) {
			//Checks if the file is a directory or hidden and prints the filenames if it's not
			if (!flist[i].isDirectory() && !flist[i].isHidden()) {
				String tabs1 = new String("");
				for (int j=0; j<dirlevel; j++) {
					tabs1 = tabs1 + "\t";
				}
				System.out.println( tabs1 + "-> " + flist[i].getName());
				if (i == flist.length-1)
					dirlevel--;
			}
			
			//Checks if the file is a directory and prints then goes into the directory
			//and repeats using recursion to print the filenames
			if (flist[i].isDirectory()) {
				String tabs2 = new String("");
				for (int j=0; j<dirlevel; j++) {
					tabs2 = tabs2 + "\t";
				}
					System.out.println( tabs2 + "-> " + flist[i].getName());
					dirlevel++;
					printFiles(flist[i].listFiles());
			}
		}
	}
}

