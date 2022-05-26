package testUtilities;

import java.io.File;

public class getlatestfile {
	
	public static File getLatestExcelFilefromDir(){

		File dir = new File(System.getProperty("user.dir")+"/Data_Files/");
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

}
