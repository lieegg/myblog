package com.my.blog.website;

import java.io.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试读取pdf文件中的内容
 */
public class PrintTextLocations extends PDFTextStripper {

    static List<Float> list_postion=new ArrayList<Float>();
    static List<String> list_text=new ArrayList<String>();


    public PrintTextLocations() throws IOException {
        super.setSortByPosition(true);
    }

    public static void main(String[] args) throws Exception {

        PDDocument document=null;
        try {
            File input=new File("D://test.pdf");
            document=PDDocument.load(input);
            if (document.isEncrypted()) {
                document.decrypt("");
            }
            PrintTextLocations printer=new PrintTextLocations();
            List allPages=document.getDocumentCatalog().getAllPages();
            for (int i=0; i < allPages.size(); i++) {
                PDPage page=(PDPage) allPages.get(i);
                System.out.println("Processing page: " + i);
                PDStream contents=page.getContents();
                if (contents != null) {
                    printer.processStream(page, page.findResources(), page.getContents().getStream());
                }
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }

        System.out.println(list_text.size());
        for (int i=0; i < list_text.size(); i++) {
            System.out.println("第"+i+"行："+list_text.get(i));
        }

    }

    /**
     * @param text The text to be processed
     */
    @Override /* this is questionable, not sure if needed... */
    protected void processTextPosition(TextPosition text) {
        System.out.println("String[" + text.getXDirAdj() + ","
                + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
                + text.getXScale() + " yscale="
                + text.getYScale() + " height=" + text.getHeightDir() + " space="
                + text.getWidthOfSpace() + " width="
                + text.getWidthDirAdj() + " x="
                + text.getX() + " y="
                + text.getY() + " y1="
                + text.getTextPos().getYPosition() + " x1="
                + text.getTextPos().getXPosition() + " x1="
                + text.getTextPos().getXScale() + " x1="
                + text.getTextPos().getYScale() + "]" + text.getCharacter());
    }
}
