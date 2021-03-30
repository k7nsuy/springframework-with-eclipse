package com.example.entity;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "review")
@SequenceGenerator(name = "SEQ",
sequenceName = "seqReviewNumber",
allocationSize = 1,
initialValue = 1)
public class Review {

	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "reviewNumber")
	private long reviewNumber;
	
	@Column(name = "reviewTitle")
	private String reviewTitle;
	
	@Column(name = "reviewContent")
	private String reviewContent;
	
	@Column(name = "reviewHit")
	private String reviewHit;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "reviewDate")
	private Date reviewDate;
	
	@Lob
	@Column(name = "reviewImage")
	private byte[] reviewImage;
	
	@Transient
	private String base64;
	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member member;

	public long getReviewNumber() {
		return reviewNumber;
	}

	public void setReviewNumber(long reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewHit() {
		return reviewHit;
	}

	public void setReviewHit(String reviewHit) {
		this.reviewHit = reviewHit;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public byte[] getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(byte[] reviewImage) {
		this.reviewImage = reviewImage;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Review [reviewNumber=" + reviewNumber + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewHit=" + reviewHit + ", reviewDate=" + reviewDate + ", reviewImage="
				+ Arrays.toString(reviewImage) + ", base64=" + base64 + ", member=" + member + "]";
	}

	public Review(long reviewNumber, String reviewTitle, String reviewContent, String reviewHit, Date reviewDate,
			byte[] reviewImage, String base64, Member member) {
		super();
		this.reviewNumber = reviewNumber;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewHit = reviewHit;
		this.reviewDate = reviewDate;
		this.reviewImage = reviewImage;
		this.base64 = base64;
		this.member = member;
	}
	
	public Review() {
		super();
	}
}