package nju.software.jxjs.util.excel;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.util.EncodeUtil;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class AjclExcelView extends AbstractExcelView 
{

	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		// create sheet
        HSSFSheet sheet = workbook.createSheet("�ӷ�����");
        sheet.setDefaultColumnWidth(20);
        
        // create style
        CellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// ��ֱ  
        style.setAlignment(CellStyle.ALIGN_CENTER);// ˮƽ  
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
        // create header
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("原审案号");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("当事人");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("生效法院");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("申请类型");
        header.getCell(3).setCellStyle(style);
        
        header.createCell(4).setCellValue("申请时间");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("申请次数");
        header.getCell(5).setCellStyle(style);
        
        // create data item
        int rowCount = 1;
        List<TJxjs> jxjsList = (List<TJxjs>)model.get("jxjsList");
        if(jxjsList != null)
        {
        	for(TJxjs jxjs : jxjsList)
        	{
        		HSSFRow aRow = sheet.createRow(rowCount++);
        		
                aRow.createCell(0).setCellValue(jxjs.getSxah());
                
//                aRow.createCell(1).setCellValue(jxjs.getDsr().getDsrxm());
//                aRow.createCell(2).setCellValue(jxjs.getSxfy().getFymc());
//                aRow.createCell(3).setCellValue(jxjs.getSqlxbh());
                aRow.createCell(4).setCellValue(jxjs.getSqsj());
                aRow.createCell(5).setCellValue(jxjs.getSqcs());
        	}
        }
        
        response.setContentType("application/vnd.ms-excel");     
        //set filename
        String curDateStr = DateUtil.format(new Date(), DateUtil.webFormat);
        String filename = "减刑假释-"+curDateStr+".xls";
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ EncodeUtil.encodeFilename(filename, request));
        OutputStream ouputStream = response.getOutputStream();     
        workbook.write(ouputStream);
        ouputStream.flush();     
        ouputStream.close();
	}

}
