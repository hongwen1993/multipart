package com.kagura.desgin.适配器模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 15:43
 * @since 1.0.0
 */
public class PC {

    public void read(TFCard card) {
        card.readTFCard();
    }

    public static void main(String[] args) {
        PC pc = new PC();
        TFCard tfCard = new TFCardImpl();
        pc.read(tfCard);

        SDCardToTFCardAdpater tfCardAdpater = new SDCardToTFCardAdpater(new SDCardImpl());
        pc.read(tfCardAdpater);

    }

}
