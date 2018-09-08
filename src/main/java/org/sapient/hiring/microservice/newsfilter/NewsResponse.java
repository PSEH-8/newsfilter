package org.sapient.hiring.microservice.newsfilter;

import java.util.Arrays;

public class NewsResponse {
    private String country;
    private String category;
    private String keyword;
    private Integer totalResults;
    private ResponseArticle[] articles;
    
    public NewsResponse() {
    	super();
    }
    
	public NewsResponse(String country, String category, String keyword, ResponseArticle[] articles) {
		super();
		this.country = country;
		this.category = category;
		this.keyword = keyword;
		this.articles = articles;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ResponseArticle[] getArticles() {
		return articles;
	}

	public void setArticles(ResponseArticle[] articles) {
		this.articles = articles;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	@Override
	public String toString() {
		return "NewsResponse [country=" + country + ", category=" + category + ", keyword=" + keyword
				+ ", totalResults=" + totalResults + ", ResponseArticle=" + Arrays.toString(articles) + "]";
	}

}
