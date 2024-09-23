
public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;

	private int rateList[] = new int[3];
	@Override
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("Publish Date: " + publishDate);
		System.out.println("Author: " + author);
		System.out.println("Content: " + content);
		System.out.println("Average Rate: " + averageRate);
	}

	public int[] getRateList() {
		return rateList;
	}

	public void setRateList(int[] rateList) {
		this.rateList = rateList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}
	
	public void Calculate() {
		int sum = 0;
		for(int i = 0; i < rateList.length; i++) {
			sum = sum + rateList[i];
		}
		averageRate = sum / rateList.length;
	}
}
