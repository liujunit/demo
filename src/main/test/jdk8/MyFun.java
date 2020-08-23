package jdk8;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@FunctionalInterface
public interface MyFun {

    String format(BigDecimal o, DecimalFormat df);

}
