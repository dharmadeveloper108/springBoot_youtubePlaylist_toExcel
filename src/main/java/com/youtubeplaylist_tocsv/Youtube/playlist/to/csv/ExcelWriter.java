package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

	public static void generateExcel(List<VideoDataModel> videoDataModelList) {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("YoutubeVideos");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 9000);
		sheet.setColumnWidth(2, 6000);
		sheet.setColumnWidth(3, 6000);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		Row header = sheet.createRow(0);

		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("Title");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(1);
		headerCell.setCellValue("Description");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(2);
		headerCell.setCellValue("Id");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(3);
		headerCell.setCellValue("Date");
		headerCell.setCellStyle(headerStyle);

		for (int i = 0; i < videoDataModelList.size(); i++) {
			Row row = sheet.createRow(i+1);

			Cell cell = row.createCell(0);
			cell.setCellValue(videoDataModelList.get(i).getTitle());
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(videoDataModelList.get(i).getDescr());
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(videoDataModelList.get(i).getId());
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(videoDataModelList.get(i).getDate());
			cell.setCellStyle(style);
		}
		try (FileOutputStream outputStream = new FileOutputStream("YoutubePlaylistVideos.xlsx")) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
