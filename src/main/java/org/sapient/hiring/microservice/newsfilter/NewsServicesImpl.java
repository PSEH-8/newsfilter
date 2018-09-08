package org.sapient.hiring.microservice.newsfilter;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServicesImpl implements NewsService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public NewsResponse findNewsByKeyword(String pCountry, String pCategory, 
    		String pKeyword) {
		
		String newsUrl = "https://newsapi.org/v2/top-headlines?country=" + pCountry + "&category=" + pCategory + 
				"&apiKey=ccaf5d41cc5140c984818c344edcc14d";
		
		logger.info("newsUrl: {}", newsUrl);


		ResponseEntity<News> lResponseEntity =  new RestTemplate().getForEntity(newsUrl, News.class);
		
		News lNews = lResponseEntity.getBody();
		
		logger.info("News: {}", lNews);
		
		List<ResponseArticle> lResponseArticles = new ArrayList<ResponseArticle>();
		
		if(lNews.getArticles() != null) {
			for(Article article: lNews.getArticles()) {
				logger.info("Article: {}", article);
				if((article.getTitle() != null && article.getTitle().contains(pKeyword)) || (article.getDescription() != null && article.getDescription().contains(pKeyword))) {
					lResponseArticles.add(new ResponseArticle(article.getTitle(),article.getDescription(),article.getUrl()));
				}
			}
		}
		
		logger.info("ResponseArticles: {}", lResponseArticles);
		
		NewsResponse lNewsResponse = new NewsResponse();
		lNewsResponse.setCategory(pCategory);
		lNewsResponse.setCountry(pCountry);
		lNewsResponse.setKeyword(pKeyword);
		lNewsResponse.setTotalResults(lResponseArticles.size());
		lNewsResponse.setArticles(lResponseArticles.toArray(new ResponseArticle[0]));
		logger.info("Response: {}", lNewsResponse);
		return lNewsResponse;
	}

}
