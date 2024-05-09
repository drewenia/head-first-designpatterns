package ProxyDesingPattern.HeadFirstProxyDesignPattern;

/* Bu interface'dir; birazdan implementasyona geçeceğiz... */
public interface PersonBean {
    /* Burada kişinin adı, cinsiyeti, ilgi alanları ve HotOrNot derecelendirmesi (1-10) hakkında bilgi alabiliriz */
    String getName();
    String getGender();
    String getInterest();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterest(String interests);
    void setHotOrNotRating(int rating);
}
