
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class FileManager
{
	public FileManager(){}

	// for the files we expect a .txt file only!!
	public boolean validTxtFormat(String fname)
	{
		String p = "(.+)(\\.txt)";
		return Pattern.matches(p, fname);
	}

	public boolean fileExists(String fname)
	{
		File f = new File(fname);
		return f.exists() && !f.isDirectory();
	}

	public boolean createOutputFile(String fname)
	{
		File f = new File(fname);
		try 
		{
			// https://www.mkyong.com/java/how-to-create-a-file-in-java/
			if(!f.createNewFile())
			{
				f.delete(); // ensure new file
				f.createNewFile();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void deleteFile(String fname)
	{
		File f = new File(fname);
		f.delete();
	}

	public void addNewLine(String fname, String nLine)
	{
		try
		{ // true in 2nd param of file writer is to append 
			Writer fout = new BufferedWriter(new FileWriter(fname, true));
			fout.append(nLine + "\n");
			fout.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}