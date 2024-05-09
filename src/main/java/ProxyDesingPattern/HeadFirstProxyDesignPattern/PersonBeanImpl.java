package ProxyDesingPattern.HeadFirstProxyDesignPattern;

public class PersonBeanImpl implements PersonBean{
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterest() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        /* rating'leri ratingCount'a bölerek rating'lerin ortalamasını hesaplar */
        return ratingCount == 0 ? 0 : rating / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterest(String interests) {
        this.interests = interests;
    }

    /* setHotOrNotRating() methodu toplam ratingCount değerini artırır */
    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
        ratingCount++;
    }
}
