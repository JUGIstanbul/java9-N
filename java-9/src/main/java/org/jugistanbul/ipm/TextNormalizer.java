package org.jugistanbul.ipm;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 1.04.2020
 **/

public class TextNormalizer implements Normalizer
{

    public static void main(String[] args){
        String text = "Bu meetup serisinde Java 9'dan başlayarak, 14'e kadar gelen yenilik ve değişimleri ele almayı amaçlıyoruz.";
        TextNormalizer textNormalizer = new TextNormalizer();
        System.out.println(textNormalizer.normalizeByLanguage(text, Language.TURKISH));
    }
}
