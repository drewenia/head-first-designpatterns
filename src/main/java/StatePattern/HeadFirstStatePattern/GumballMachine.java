package StatePattern.HeadFirstStatePattern;

/* GumballMachine'de kodu statik tamsayılar yerine yeni sınıfları kullanacak şekilde güncelliyoruz. Bir sınıfta
tamsayılar ve diğerinde nesneler olması dışında kod oldukça benzerdir... */
public class GumballMachine {

    /* İşte yine tüm state'ler */
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    /* State instance variable */
    State state = soldOutState;

    /* count instance variable'i sakızların sayısını tutar - başlangıçta makine boştur. */
    int count = 0;

    /* Constructor başlangıçtaki sakız sayısını alır ve bunu bir instance variable'da saklar */
    public GumballMachine(int count) {
        /* Ayrıca her birinden birer tane olmak üzere State instance'ları oluşturulur */
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = count;

        /* Eğer 0'dan fazla sakız varsa State'i NoQuarterState olarak ayarlarız. */
        if (count > 0) {
            state = noQuarterState;
        }
    }

    /* Şimdi Action'lara geçelim. Bunları ŞİMDİ ÇOK KOLAY bir şekilde implemente etmek mümkün. Sadece mevcut State'e
    delege ediyoruz.*/
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        /* Unutmayın ki GumballMachine sınıfında dispense() için bir Action methoduna ihtiyacımız yok çünkü bu sadece
        internal bir action'dır; bir kullanıcının makineye doğrudan dispense yapmasını isteyemez. Ancak turnCrank()
        methodundan State nesnesinde dispense() methodunu çağırıyoruz.*/
        state.dispense();
    }

    /* Bu method, diğer nesnelerin (örneğin, State nesnelerimiz) makineyi farklı bir State'e geçirmesine izin verir.*/
    void setState(State state) {
        this.state = state;
    }

    /* Makine, topu serbest bırakan ve count instance variable'ini azaltan bir releaseBall() helper methodunu
    destekler.*/
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
