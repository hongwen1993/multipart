package com.kagura.desgin.适配器模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 17:01
 * @since 1.0.0
 */
public class SDCardToTFCardAdpater implements TFCard {

    private SDCard sdCard;

    public SDCardToTFCardAdpater(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public void readTFCard() {
        sdCard.readSDCard();
    }
}
