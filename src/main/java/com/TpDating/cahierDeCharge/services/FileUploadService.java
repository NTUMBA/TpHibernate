package com.TpDating.cahierDeCharge.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * Handles requests for the application file upload requests
 */
@Service
public class FileUploadService {

	

	/**
	 * Upload single file using Spring Controller
	 */
	
	public boolean uploadFileHandler(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("user.dir");
				File dir = new File(rootPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "picture");
				System.out.println( );
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				

				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
//	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
//	public @ResponseBody
//	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
//			@RequestParam("file") MultipartFile[] files) {
//
//		if (files.length != names.length)
//			return "Mandatory information missing";
//
//		String message = "";
//		for (int i = 0; i < files.length; i++) {
//			MultipartFile file = files[i];
//			String name = names[i];
//			try {
//				byte[] bytes = file.getBytes();
//
//				// Creating the directory to store file
//				String rootPath = System.getProperty("catalina.home");
//				File dir = new File(rootPath + File.separator + "tmpFiles");
//				if (!dir.exists())
//					dir.mkdirs();
//
//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + name);
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//
//				logger.info("Server File Location="
//						+ serverFile.getAbsolutePath());
//
//				message = message + "You successfully uploaded file=" + name
//						+ "<br />";
//			} catch (Exception e) {
//				return "You failed to upload " + name + " => " + e.getMessage();
//			}
//		}
//		return message;
//	}
}
