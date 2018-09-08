package org.sapient.hiring.microservice.newsfilter;

public class News {
	private String status;
    private String totalResults;
    private Article[] articles;

    public News() {
    }
 
    public News(String status, String totalResults) {
		super();
		this.status = status;
		this.totalResults = totalResults;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

	@Override
    public String toString() {
        return "News {" +
                "status='" + getStatus() + '\'' +
                "articles='" + getArticles() + '\'' +
                ", totalResults=" + getTotalResults() +
                '}';
    }
	

}
