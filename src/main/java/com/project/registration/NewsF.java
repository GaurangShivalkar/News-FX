package com.project.registration;

public class NewsF {
	 private int id;
	    private String title;
	    private String description;
	    private String url;
	    private String published;
	   

	    public NewsF(int id, String title, String description, String url, String published) {
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.url = url;
	        this.published = published;
	    }

	    public String getUrl() {
			return url;
		}

	

		public String getPublished() {
			return published;
		}

		public int getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getDescription() {
	        return description;
	    }

	   
	
}
