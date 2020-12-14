import java.io.*;
import java.nio.*;
import java.security.*;
import java.math.*;

class Dir{
	List<Dir> subDirectories;
	List<File> files;
}

public static String hashFile(File file) {
	try {
		FileInputStream fileInput = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fileInput.read(data);
		fileInput.close();
		//returns instance of MessageDigest that will perform the requested crypto algorithm
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger test = new BigInteger(1,md.digest(data));
		String fileHash = test.toString(16);
		return fileHash;
	} catch (Exception e) {
		throw new RuntimeException("can't read file: " + file.getAbsolutePath(), e);
	}
}

public static String makeHashLean(File infile) {
	FileInputStream fileInput = new FileInputStream(file);
	int buffSize = 1024;
	byte[] buffer = new byte[buffSize];
	MessageDigest md = MessageDigest.getInstance("MD5");
	// calculate the hash of the whole file
	long fileLength = file.length();
	long read = 0;
	int chunk;
	while(read<offset) {
		if(fileLength-read>=buffSize){
			chunk = buffSize;
		}
		else{
			chunk = (int)(offset-read);
		}
		read += chunk;
		fileInput.read(buffer, 0, chunk);
		md.update(buffer, 0, chunk);
	}
	fileInput.close();
	String hash = new BigInteger(1, md.digest()).toString(16);
	return hash;
}


public static void findDupFiles(Map<String,List<String>> map, File file){
	String hash = hashFile(file);
	List<String> list = map.get(hash);
	if(!map.containsKey(hash)){
		List<String> list = new ArrayList<String>();
		list.add(file.getAbsolutePath());
		map.put(hash,list);
	}
	else{
		map.get(hash).add(file.getAbsolutePath());
	}
}

public static void findDupFilesinDir(Map<String,List<String>> map, Dir directory){
	for(File file: dir.files){
		findDupFiles(map,file);
	}
	for(Dir subDir: dir.subDirectories){
		findDupFilesinDir(map,subDir);
	}
}


public static void findDupFileBySize(Map<Integer,List<String>> map, File file){
	long size = file.length();
	if(!map.containsKey(size)){
		List<String> list = new ArrayList<String>();
		list.add(file.getAbsolutePath());
		map.put(size,list);
	}
	else{
		map.get(size).add(file.getAbsolutePath());
	}

}

public static void findDupFilesInDirBySize(Map<Integer,List<String>> map, Dir directory){
	for(File file: dir.files){
		findDupFilesBySize(map,file);
	}
	for(Dir subDir: dir.subDirectories){
		findDupFilesInDirBySize(map,subDir);
	}
}

public static List<List<String>> storeDuplicateFiles(Directory dir) {
	List<List<String>> ret = new ArrayList<List<String>>();
	Map<Integer, List<String>> listsBySize = new HashMap<Integer, List<String>>();
	findDupFilesinDir(listsBySize, dir);
	Map<String, List<String>> listsByMD5 = new HashMap<String, List<String>>();
	// findDupFilesinDir(listsByMD5, dir);
	for (List<String> list: listsBySize) {
		if (list.size()>1) {
			for(String file: list){
				findDupFiles(listsByMD5,new File(file));
			}
		}
	}
	for(List<String> list: listsByMD5){
		if(list.size()>1){
			ret.add(list);
		}
	}
	return ret;
}


LinkedHashMap<Integer, String> lhm 
            = new LinkedHashMap<Integer, String>(); 
            lhm.put(1,"apple");
            lhm.put(2,"banana");
            lhm.put(3,"peach");
            lhm.put(4,"orange");

            lhm.iterator().next();
            


