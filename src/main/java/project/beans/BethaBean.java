package project.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.external.SomeBean;

@Component
public class BethaBean {

    @Autowired
    BethaBean(SomeBean somebean) {
    }

}
