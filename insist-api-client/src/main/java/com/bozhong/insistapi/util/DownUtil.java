package com.bozhong.insistapi.util;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

/**
 * Created by xiezg@317hu.com on 2017/7/24 0024.
 */
public class DownUtil {
    /**
     * @param filePath
     * @param response
     * @param isOnLine
     * @throws Exception
     */
    public static void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

    public static void wkHtmlToPdf(String url, String filePath) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("wkhtmltopdf " + url + " " + filePath);
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
        try {
            IOUtils.copy(p.getInputStream(), System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
