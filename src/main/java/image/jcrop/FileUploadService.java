package image.jcrop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadService {

	@RequestMapping(value = "/upload", method =RequestMethod.POST)
    public void getImg(HttpServletRequest request, HttpServletResponse response, String imgUrl) throws Exception
    {
       MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
       MultipartFile file =multiRequest.getFiles("imageName").get(0);
       String originalFilename = file.getOriginalFilename();

       BufferedInputStream bis = new BufferedInputStream (file.getInputStream());
       BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\" + originalFilename+".jpg")));
       int len = 0;
		byte[] buffer=new byte[(int)file.getSize()];
       while((len=bis.read(buffer))!=-1){
    	   out.write(buffer, 0, len);
       }
       //刷新此缓冲的输出流，保证数据全部都能写出

//		out.write(file.getBytes());
		out.flush();

		bis.close();
		out.close();
    }
}
