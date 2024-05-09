package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    PersonBean personBean;

    /* Constructor'da Real Subject'i aktarırız ve ona bir referans tutarız */
    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    /* Proxy'de bir method her çağrıldığında çağrılan invoke methodu burada yer alır */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try{
            /* Method bir getter ise, devam eder ve onu real subject üzerinde çağırırız.*/
            if (method.getName().startsWith("get")){
                return method.invoke(personBean,args);
            }

            /* Aksi takdirde, setHotOrNotRating() methodu ise IllegalAccessException atarak buna izin vermeyiz.*/
            else if(method.getName().equals("setHotOrNotRating")){
                throw new IllegalAccessException();
            }

            /* Owner biz olduğumuz için başka herhangi bir set methodu uygundur ve devam edip onu real subject üzerinde
            çağırırız*/
            else if(method.getName().startsWith("set")){
                return method.invoke(personBean,args);
            }
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }

        /* Başka bir method çağrılırsa, riske girmek yerine null değerini döndüreceğiz.*/
        return null;
    }
}
