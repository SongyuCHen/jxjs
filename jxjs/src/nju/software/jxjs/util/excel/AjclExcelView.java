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
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class AjclExcelView extends AbstractExcelView 
{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		// ����Sheet
        HSSFSheet sheet = workbook.createSheet("�ӷ�����");
        sheet.setDefaultColumnWidth(20);
        
        // ������ʽ
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
        
        // ������ͷ
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("ԭ�󰸺�");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("������");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("��Ч��Ժ");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("��������");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("����ʱ��");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("�������");
        header.getCell(5).setCellStyle(style);
        
        // ����������
        int rowCount = 1;
        List<TJxjs> jxjsList = (List<TJxjs>)model.get("jxjsList");
        if(jxjsList != null)
        {
        	for(TJxjs jxjs : jxjsList)
        	{
        		HSSFRow aRow = sheet.createRow(rowCount++);
                aRow.createCell(0).setCellValue(jxjs.getAj().getAh());
                aRow.createCell(1).setCellValue(jxjs.getDsr().getDsrxm());
                aRow.createCell(2).setCellValue(jxjs.getSxfy().getFymc());
                aRow.createCell(3).setCellValue(jxjs.getSqlx().getMc());
                aRow.createCell(4).setCellValue(jxjs.getSqsj());
                aRow.createCell(5).setCellValue(jxjs.getSqcs());
        	}
        }
        
        response.setContentType("application/vnd.ms-excel");     
        //����excel�ļ���
        String curDateStr = DateUtil.getStandardFormat(new Date());
        String filename = "���̼���-"+curDateStr+".xls";
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ EncodeUtil.encodeFilename(filename, request));
        OutputStream ouputStream = response.getOutputStream();     
        workbook.write(ouputStream);
        ouputStream.flush();     
        ouputStream.close();
	}

}
