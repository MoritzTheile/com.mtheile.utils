package com.mtheile.utils.file.directory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class FileUtils {
	
		/**
	 * This method returns a new file object which points to the physical data 
	 * referenced by the input file before calling this method.
	 * 
	 * @param file the file to be renamed
	 * @param name the new name of the file
	 * @return a new file object
	 * @throws Exception is thrown if the file given as attribute doesn't exist
	 * 			 
	 */
	public static File renameFile(File file, String name)throws Exception{
		if(!file.exists()){
			throw new Exception("file "+file.getAbsolutePath()+" doesn't exist");
		}
		String newPath = file.getParent()+"/"+name;
		newPath = newPath.replaceAll("\\\\", "/" );
		File renamedFile = new File(newPath); 
		if(renamedFile.exists()){
			renamedFile.delete();
		}
		file.renameTo(renamedFile);
		return renamedFile;
	}

	public static List<File> listFiles(String directory, boolean recurse){
		return listFiles(new File(directory), recurse);
	}
	
	/**
	 * This method returns a Collection with Files from given directory. If recurse==true 
	 * files from sub directories are returned as well.
	 * 
	 */
	public static List<File> listFiles(File directory, boolean recurse){

		List<File> files = new ArrayList<File>();

		File[] entries = directory.listFiles();

		for (File entry : entries){

			// If the file is a directory and the recurse flag
			// is set, recurse into the directory
			if (recurse && entry.isDirectory())	{
				files.addAll(listFiles(entry, recurse));
			}else {
				files.add(entry);
			}
			
		}
		
		return files;
		
	}
	
	
	/**
	 * Deletes folder recursively.
	 * 
	 */
	public static void deleteTree( File path ){
		
		for ( File file : path.listFiles() ){
	
			if ( file.isDirectory() ){
	
				deleteTree( file );
	
			}
	
			file.delete();
	
		}
	
		path.delete();
	
	}

	/**
	 * Returns all lines in a file as String-List.
	 */
	public static List<String> getLines(File file) throws Exception{
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		try{
			while((line=reader.readLine())!=null){
				lines.add(line);
			}
		}finally{
			reader.close();
		}
		return lines;
	}

	public static void main(String args[]) throws Exception{
		File file = new File("c:/tmp/test.txt");
		file.createNewFile();
		renameFile(file,"test_renamed.txt");
		System.out.println("file.exists()="+file.exists());

		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
	}
}