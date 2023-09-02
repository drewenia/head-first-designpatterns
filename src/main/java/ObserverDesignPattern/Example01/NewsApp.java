package ObserverDesignPattern.Example01;

public class NewsApp {
    public static void main(String[] args) {
        NewsSubject newsSubject = new NewsSubject();
        NewsObserver observer = new NewsObserver();

        newsSubject.addObserver(observer);
        newsSubject.setNews("new news available");
        System.out.println(observer.getNews());
    }
}
