
package com.example.sfsb_use;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 * ServletからSFSBを利用するサンプル用に定義したクラス.
 *
 * @see http://leakfromjavaheap.blogspot.jp/2013/02/injecting-stateful-session-bean-into.html
 */
@Stateful(name = "sfsbean")
public class SFSBean {
    private final List <String> greetings = new ArrayList <>();

    public void addGreeting(final String greeting) {
        greetings.add(greeting);
    }

    public List <String> getAllGreetings() {
        return new ArrayList <>(greetings);
    }
}
