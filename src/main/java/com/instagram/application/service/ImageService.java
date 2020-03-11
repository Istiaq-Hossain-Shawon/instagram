package com.instagram.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instagram.application.dto.PostCommentDto;
import com.instagram.application.dto.PostDto;
import com.instagram.application.model.Post;
import com.instagram.application.model.PostComment;
import com.instagram.application.model.PostImage;
import com.instagram.application.repositories.PostCommentRepository;
import com.instagram.application.repositories.PostImageRepository;
import com.instagram.application.repositories.PostRepository;
import com.instagram.application.repositories.UserRepository;
import com.instagram.application.util.Constants;

import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageService {

	private static final String UPLOADED_FOLDER = "/WEB-INF/resources/img/";	
//	instagram\WEB-INF\resources\img\
	private Logger logger = Logger.getLogger(ImageService.class.getName());

	public String save(MultipartFile file, Long userId,String contextPath) {
		String url="";
		String path="";
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();

			File dir = Paths.get(contextPath+UPLOADED_FOLDER +"//"+ userId + "//").toFile();
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String extension = "";
			StringTokenizer tokenizer = new StringTokenizer(file.getOriginalFilename(), ".");
			while (tokenizer.hasMoreTokens()) {
				extension = tokenizer.nextToken();
			}
			var fileName = System.currentTimeMillis() + file.getOriginalFilename();
//			String url = UPLOADED_FOLDER + userId + "//" + attachment.getAttachmentId() + "." + extension;
			url = contextPath +UPLOADED_FOLDER+"//"+ userId + "//" + fileName;
			File serverFile = new File(url);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			logger.info("File written successfully.");
			path=userId + "//" + fileName;
//			url = "/temp/" + userId + "//" + attachment.getAttachmentId() + "." + extension;
//			attachment.setFileURL(url);
//			attachment.setFileType(Files.probeContentType(Paths.get(url)));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return path;
	}

}
