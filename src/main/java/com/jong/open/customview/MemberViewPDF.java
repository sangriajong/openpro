package com.jong.open.customview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.jong.open.member.Member;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@Component(value = "memberPdf")
public class MemberViewPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
				Map<String, Object> model,
				Document document,
				PdfWriter writer,
				HttpServletRequest request,
				HttpServletResponse response
			) throws Exception {
		@SuppressWarnings("unchecked")
List<Member> result = (List<Member>) model.get("result");
		
		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
         Paragraph para = new Paragraph("PDF 로 보여주는 멤버 리스트  ", font);
		
		// 1. 테이블의 사이즈 정의 -> new Table(열, 행)
		Table table = new Table(3, result.size() + 1);
		
		table.setPadding(5);
		Cell cell = new Cell(new Paragraph("회원 아이디", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("회원 이름 ", font));
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("회원 비번", font));
		table.addCell(cell);
		table.endHeaders();
		
		for(Member member : result) {
			table.addCell(member.getId());
			cell = new Cell(new Paragraph(member.getName(), font));
			table.addCell(cell);
			cell = new Cell(new Paragraph(member.getPassword(), font));
			table.addCell(cell);
		}
		
		document.add(para);
		document.add(table);
	}
}