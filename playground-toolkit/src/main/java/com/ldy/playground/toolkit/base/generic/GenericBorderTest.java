package com.ldy.playground.toolkit.base.generic;

import java.util.List;
import java.util.Objects;

public class GenericBorderTest {

    public <T> T getFirstItem(List<T> list) {
        if (Objects.isNull(list)) {
            return null;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public void operateUpList(List<? extends Number> list) {

        // 写入非法，无法确定？的具体类型
//        list.add(Integer.valueOf(1));
//        list.add(Integer.valueOf(2));

        // 读取是安全的
        Number item = list.get(0);
    }

    public void operateDownList(List<? super GenericBorderTest> list) {
        // 写入是安全的
        list.add(new GenericBorderTest());
        list.add(new GenericBorderTestOne());

        // 读取返回的类型无法确定，因此是Object类型
        Object item = list.get(0);
    }

    public void operateNoBorderList(List<?> list) {
        // 写入非法，无法确定？的具体类型
//        list.add(1);
//        list.add(1);

        // 读取返回的类型无法确定，因此是Object类型
        Object item = list.get(0);
    }
}

class GenericBorderTestOne extends GenericBorderTest{

}
