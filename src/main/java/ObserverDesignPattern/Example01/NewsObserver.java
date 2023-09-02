package ObserverDesignPattern.Example01;

public class NewsObserver implements Observer{

    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }
}
