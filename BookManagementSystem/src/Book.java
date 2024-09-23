
public class Book implements IBook{
	private int id;
	private String name;
	private String publishDate;
	private String author;
	private String language;
	private float averagePrice;
	@Override
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("PublishDate: " + publishDate);
		System.out.println("Author: " + author);
		System.out.println("Language: " + language);
		System.out.println("Average Price: " + averagePrice);
	}
	
	private int priceList[] = new int[5];
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public float getAveragePrice() {
		return averagePrice;
	}

	public int[] getPriceList() {
		return priceList;
	}

	public void setPriceList(int[] priceList) {
		this.priceList = priceList;
	}
	
	public void calculate() {
		int sum = 0;
		for(int i = 0 ; i < priceList.length ; i++) {
			sum = sum + priceList[i];
		}
		averagePrice = (float)sum / priceList.length;
	}
	
}
