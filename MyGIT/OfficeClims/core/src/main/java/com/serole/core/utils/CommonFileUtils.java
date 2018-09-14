package com.serole.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.serole.core.exception.FileUploadException;

/**
 * 
 * @author vadivel
 *
 */
public class CommonFileUtils {
	private static final Logger LOG = LoggerFactory.getLogger(CommonFileUtils.class);

	private static String tempDirPath = null;
	static {
		if (tempDirPath == null) {
			final StringBuilder fileNameBuilder = new StringBuilder(System.getProperty("user.dir"));
			fileNameBuilder.append(File.separator);
			fileNameBuilder.append("mfileTempUpload");
			tempDirPath = fileNameBuilder.toString();
		}

		final File tempDir = new File(tempDirPath);
		if (tempDir.exists()) {
			tempDir.delete();
		} else {
			tempDir.mkdir();
		}
	}

	public static File store(final MultipartFile multipartFile) {
		File file = null;
		try {

			final String fileName = multipartFile.getOriginalFilename();
			final String title = StringUtils.substringBefore(fileName, CommonCoreUtil.DOT);
			final String extention = StringUtils.substringAfter(fileName, CommonCoreUtil.DOT);

			final StringBuilder fileNameBuilder = new StringBuilder(tempDirPath);
			fileNameBuilder.append(File.separator);
			fileNameBuilder.append(title);

			final Path path = Files.createTempFile(fileNameBuilder.toString(), CommonCoreUtil.DOT + extention);
			Files.write(path, multipartFile.getBytes());

			file = path.toFile();

		} catch (IOException e) {
			LOG.error("Unable to stroe file");
			throw new FileUploadException("Failed to store file ");
		}

		return file;
	}

	public static File createTempFileWithContent(final byte[] content, final String fileName) {
		Path path = null;
		try {
			
			final String title = StringUtils.substringBefore(fileName, CommonCoreUtil.DOT);
			final String extention = StringUtils.substringAfter(fileName, CommonCoreUtil.DOT);

			path = Files.createTempFile(title, CommonCoreUtil.DOT + extention);
			Files.write(path, content);

		} catch (final IOException e) {
			LOG.error("Unable to create/copy file due to {}", e);
			throw new FileUploadException("Unable to create/copy file");

		}

		return path.toFile();
	}

	public static Resource createTempResource(final MultipartFile multipartFile) {
		File file = null;
		try {
			file = createTempFileWithContent(multipartFile.getBytes(), multipartFile.getOriginalFilename());
		} catch (final IOException e) {
			LOG.error("Unable to create/copy file due to {}", e);
			throw new FileUploadException("Unable to create/copy file");

		}

		return new FileSystemResource(file);
	}
}