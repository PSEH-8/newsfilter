package org.sapient.hiring.microservice.newsfilter;

public class ResponseArticle {
	private String title;
	private String shortDescription;
	private String url;

	private final String ELLIPSIS = "..";
	private final int WORDS_LIMIT = 100;
	
	public ResponseArticle(String title, String description, String url) {
		this.title= title;
		this.shortDescription = (description != null && description.length() > WORDS_LIMIT) ? description.substring(0, 99) + ELLIPSIS : description;
		this.url=url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	 
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
    public String getShortDescription() {
		return shortDescription;
	}
    
    public void setShortDescription(String shortDescription) {
    		this.shortDescription = shortDescription;
    }
    
	@Override
    public String toString() {
        return "ResponseArticle {" +
                "title='" + getTitle() + '\'' +
                "url='" + getUrl() + '\'' +
                ", shortDescription=" + getShortDescription() +
                '}';
    }
}
