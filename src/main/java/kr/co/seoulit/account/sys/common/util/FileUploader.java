package kr.co.seoulit.account.sys.common.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

public class FileUploader {


    public static String doFileUpload(FileItem fileItem, String empId) throws IOException {
        InputStream in = fileItem.getInputStream();

        String realFileName = fileItem.getName().substring(fileItem.getName().lastIndexOf("//") + 1);

        String fileExt = realFileName.substring(realFileName.lastIndexOf("."));

        String saveFileName = empId + fileExt;

        String uploadPath = "C:\\jsp\\study\\account\\Account\\WebContent\\photos\\";
        String uploadPath2 ="C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Account\\";
        FileOutputStream fout = new FileOutputStream(uploadPath + saveFileName);
        FileOutputStream fout2 = new FileOutputStream(uploadPath2 + saveFileName);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            fout.write(buffer, 0, bytesRead);
            fout2.write(buffer, 0, bytesRead);
        }
        in.close();
        fout.close();
        fout2.close();

        return "/photos/" + saveFileName;

    }
}