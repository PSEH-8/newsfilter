package org.sapient.hiring.microservice.newsfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsFilterController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NewsService newsService;
	
	
	@GetMapping(value = "/newsfilter")
	public NewsResponse fetchNewsByKeyword(@RequestParam("country") String pCountry, @RequestParam("category") String pCatgeroy,@RequestParam("keyword") String pKeyword) {
			//@PathVariable String pCatgeroy, @PathVariable String pCountry, @PathVariable String pKeyword) {
		logger.info("country: {}", pCountry);
		logger.info("category: {}", pCatgeroy);
		logger.info("keyword: {}", pKeyword);
		NewsResponse lNewsResponse = newsService.findNewsByKeyword(pCountry, pCatgeroy, 
				pKeyword);
		
	    logger.info("{}", lNewsResponse);

		return lNewsResponse;
	}

}


