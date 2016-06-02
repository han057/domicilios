package com.hsofttecnologies.domicilios.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String path = "/var/data/";
	
	public FileUtil() {
		
	}
	
	public FileUtil(String path) {
		FileUtil.path = path;
	}

	public void SaveFile(MultipartFile file, String name) throws IOException {
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + name)));
		stream.write(bytes);
		stream.close();
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		FileUtil.path = path;
	}

}