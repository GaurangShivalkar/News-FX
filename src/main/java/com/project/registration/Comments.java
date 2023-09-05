package com.project.registration;

public class Comments {
	private String comment;
    private int parentId;
    private int userId;
    private String userN;
    private int commentId;


	public Comments(String comment, int parentId, int userId, String userN, int commentId) {
        this.comment = comment;
        this.parentId = parentId;
        this.userId = userId;
        this.userN = userN;
        this.commentId = commentId;
    }

    public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
        return comment;
    }

    public int getParentId() {
        return parentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN;
	}
}
