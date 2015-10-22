package test.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/8/18 14:56
 * Intent : 作为工具类使用
 */
public class StreamTool {
    public static byte[] read(InputStream input) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] dataImg = new byte[1024];
        int len = 0;

        while ((len = input.read(dataImg)) != -1){
            output.write(dataImg,0,len);
        }
        input.close();
        return output.toByteArray();
    }
}
