package com.kagura;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/30 17:24
 * @since 1.0.0
 */
public enum PowerOfTen {
    ONE(1), TEN(10),
    HUNDRED(100) {
        @Override
        public String toString() {
            return Integer.toString(HUNDRED.val);
        }
    };
    private final int val;

    PowerOfTen(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(ONE + " " + TEN + " " + HUNDRED);
    }
}