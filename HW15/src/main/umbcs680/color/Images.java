package umbcs680.color;

import umbcs680.color.Color;
import umbcs680.color.Image;
import umbcs680.color.ColorAdjuster;

public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster) {
        Image adjusted = new Image(image.getHeight(), image.getWidth());
        for (int x = 0; x < adjusted.getWidth(); x++) {
            for (int y = 0; y < adjusted.getHeight(); y++) {
                Color originalColor = image.getColor(x, y);
                Color adjustedColor = adjuster.adjust(originalColor);
                adjusted.setColor(x, y, adjustedColor);
            }
        }
        return adjusted;
    }

}
