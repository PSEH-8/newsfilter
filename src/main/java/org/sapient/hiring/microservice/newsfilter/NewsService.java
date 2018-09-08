package org.sapient.hiring.microservice.newsfilter;

public interface NewsService {
	public NewsResponse findNewsByKeyword(String country, String category, String keyword);
}
