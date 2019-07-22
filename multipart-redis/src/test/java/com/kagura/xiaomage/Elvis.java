package com.kagura.xiaomage;

import java.util.Calendar;

/**
 * @author Karas
 * @date 2019/7/22 16:08
 */
public class Elvis {


    private final int beltSize;

    public static final Elvis INSTANCE = new Elvis();

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " +
                INSTANCE.beltSize() + " belt.");
    }


}
