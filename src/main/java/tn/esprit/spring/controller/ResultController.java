package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Badge;
import tn.esprit.spring.entities.Difficulty;
import tn.esprit.spring.entities.Result;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.services.IResultService;

@RestController
@Api(tags = "management of  Results")
@RequestMapping("/Result")
@Slf4j
public class ResultController {
	
	@Autowired
	IResultService resultService;
	
	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Result.csv";
		response.setHeader(headerKey, headerValue);
		List<Result> listProjects =  resultService.GetAllResults();
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"idResult", "Score", "creationdate"};
		String[] nameMapping = {"idResult", "Score", "creationdate"};
		csvWriter.writeHeader(csvHeader);
		for (Result project : listProjects) {
			csvWriter.write(project, nameMapping);
		}
		csvWriter.close();
	}  
	@GetMapping("/{id}/{type}/{Bad}")
	public Integer listemployebytype(@PathParam ("id") Integer id,@PathParam ("type") Type type,@PathParam ("Bad") Badge badge)
	{
		return resultService.resultbytype(id, type, badge);
	}
}
