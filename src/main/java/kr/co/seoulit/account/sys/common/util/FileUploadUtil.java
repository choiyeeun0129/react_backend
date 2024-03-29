package kr.co.seoulit.account.sys.common.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;

public class FileUploadUtil {

	public static void doFileUpload(Part part,String path, String newFileName)
		throws FileNotFoundException, IOException {
		
		InputStream in = part.getInputStream();
		FileOutputStream fout =new FileOutputStream(path + newFileName);
		
			//������ ���ε��� ���� ��θ� �����ؾ� �Ѵ�. 
		int r = 0;
		byte[] buffer = new byte[8192];
		while ((r = in.read(buffer, 0, 8192)) != -1){
			fout.write(buffer, 0, r);
		}
					
		in.close();
		fout.close();
	}
}









