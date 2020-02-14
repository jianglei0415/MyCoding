package com.springboot.chapter10.view;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/30 17:05
 */
public interface PdfExportService {
    void make(Map<String, Object> model,
              Document document,
              PdfWriter writer,
              HttpServletRequest request,
              HttpServletResponse response);
}
