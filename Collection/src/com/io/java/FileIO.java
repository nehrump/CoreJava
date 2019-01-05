package com.io.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO  {

	FileReader fr;

	
	public void fileWriter() throws IOException {
		System.out.println("FileWriter Method : ");
		File g=new File("Test.txt");
		FileWriter fw=new FileWriter("FileWriter.txt",true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Hello ");
		bw.write("Nehru");
		bw.newLine();
	
		String encoding=fw.getEncoding();
		System.out.println(encoding);
		bw.flush();
		fw.close();
		bw.close();
		
	}


	public void charArrayFileWriter() throws IOException {	
		fr=new FileReader("FileWriter.txt");
		File f=new File("FileWriter");
		long l=f.length();
		char[] ch=new char[(int) l];
		System.out.println("Character array :\n");
		fr.read(ch);
		System.out.println(ch);
		for(char c:ch) {
			System.out.println(c);
		}
	}

	public void charFileReader() throws IOException {
		fr=new FileReader("FileWriter.txt");
		BufferedReader br=new BufferedReader(fr);
		String i;
		
		System.out.println("while loop by char :\n");
		while((i=br.readLine())!=null) {

			System.out.print(i+"\n");

		}
		br.close();

	}

	public void fileMethod() throws IOException {	
		File f=new File("File.txt");
		f.createNewFile();
		System.out.println(f.exists());
		File f2=new File("C:\\Users\\Nehru\\Documents\\WS\\CollectionLocal\\");
		System.out.println(f.getAbsolutePath());
		String[] dirs=f2.list();
		for(String dir:dirs) {
			File f1=new File(f2,dir);
			if(f1.isFile()) {
				System.out.println(f1);}
			else {
				System.out.println("Directory : "+f1);
			}


		}


	}
}
