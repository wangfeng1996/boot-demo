package com.example;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootDemoApplication.class)
public class DemoApplicationTests {

    @Test
    public void excelUtils() {

        // 创建新的Excel 工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
        HSSFSheet sheet = workbook.createSheet();
        //HSSFSheet sheet = workbook.createSheet("SheetName");

        // 用于格式化单元格的数据
        HSSFDataFormat format = workbook.createDataFormat();

        // 创建新行(row),并将单元格(cell)放入其中. 行号从0开始计算.
        HSSFRow row = sheet.createRow((short) 1);

        // 设置字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setItalic(true); //是否使用斜体
//        font.setStrikeout(true); //是否使用划线

        // 设置单元格类型
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION); //水平布局：居中
        cellStyle.setWrapText(true);

        // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("Xuys.");


        

        try {
            FileOutputStream fileOut = new FileOutputStream("/Users/wangfeng/Desktop/poi/3.xlsx");
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}