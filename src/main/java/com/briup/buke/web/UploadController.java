package com.briup.buke.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.briup.buke.bean.Chapter;
import com.briup.buke.service.IArticleService;
import com.briup.buke.service.IChapterService;

@Controller
public class UploadController {
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IChapterService chapterService;

	@PostMapping("/background/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile fileUpload, HttpServletRequest request) {
		// 获取文件名
		String fileName = fileUpload.getOriginalFilename();
		// 获取文章名
		int dot = fileName.lastIndexOf('.');
		String articleName = fileName.substring(0, dot);
		System.out.println(articleName);
		// 根据文章名获取文章id
		Long articleId = articleService.findArticleIdByArticleName(articleName);
		// 指定本地文件夹存储图片
		String filePath = "D:\\birup\\upload\\";
		// 文件保存路径
		String path = filePath + fileName;
		File dest = new File(path);
		if (!dest.exists()) {
			dest.mkdir();
		}
		try {
			// 将文件保存到指定文件夹里
			fileUpload.transferTo(dest);
			String fileNamedirs = path;
			// 将文件保存到数据库
			try {
				// 编码格式
				String encoding = "UTF-8";
				// 文件路径
				File file = new File(fileNamedirs);
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					// 输入流
					InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					String newStr = null;
					String titleName = null;
					String newChapterName = null;// 新章节名称
					String substring = null;
					int indexOf = 0;
					int indexOf1 = 0;
					// 小说内容类
					Chapter chapter;
					// 正则表达式
					Pattern p = Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");
					lineTxt = bufferedReader.readLine();
					//存储文件全部内容
					newStr = newStr +"<p>"+ lineTxt + "</p>";
					while (lineTxt != null) {
						// 用正则表达式与每一行比对
						Matcher matcher = p.matcher(lineTxt);
						//发现匹配行
						if (matcher.find()) {
							//新建一个chapter对象
							chapter = new Chapter();
							chapter.setArticleId(articleId);
							titleName = matcher.group();
							// 章节去空
							newChapterName = titleName.trim();
							// 获取章节
							chapter.setSubtitle(newChapterName);
							indexOf = newStr.indexOf(newChapterName);
							indexOf1 = indexOf;
							while ((lineTxt = bufferedReader.readLine()) != null) {
								Matcher matcher1 = p.matcher(lineTxt);
								newStr = newStr +"<p>"+ lineTxt + "</p>";
								if(matcher1.find()) {
									String nextChapter = matcher1.group();
									indexOf = newStr.indexOf(nextChapter);
									System.out.println(indexOf1);
									System.out.println(indexOf);
									substring = newStr.substring(indexOf1+newChapterName.length()+5, indexOf);
									substring = substring.replaceAll(" ", "");
									substring = substring.replaceAll("<p></p>", "");
									
									chapter.setContent(substring);
									break;
								}
							}
							if(chapter.getContent()==null) {
								substring = newStr.substring(indexOf+newChapterName.length()+5);
								substring = substring.replaceAll(" ", "");
								substring = substring.replaceAll("<p></p>", "");
								chapter.setContent(substring);
							}
							System.out.println(chapter);
						}
					}
					bufferedReader.close();
				} else {
					System.out.println("找不到指定的文件");
				}
			} catch (Exception e) {
				System.out.println("读取文件内容出错");
				e.printStackTrace();
			}
			return "上传成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败";
		}
	}
}
