package org.jugistanbul.ipm;

import static org.jugistanbul.constant.Constants.turkishCharacters;
/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 1.04.2020
 **/

public interface Normalizer
{
    default String normalizeByLanguage(final String text, final Language language){
        return language.equals(Language.TURKISH)
                ? normalizerByTurkish(text): normalizerByFrench(text);
    }

    private String normalizerByTurkish(final String text){
        final StringBuffer buffer = new StringBuffer();
        text.chars().mapToObj(Character::toChars).forEach(c -> {
            if(turkishCharacters.get(String.valueOf(c)) != null){
                buffer.append(turkishCharacters.get(String.valueOf(c)));
            } else {
                buffer.append(String.valueOf(c));
            }
        });
        return buffer.toString();
    }

    private String normalizerByFrench(final String text){
        return null;
    }
}

