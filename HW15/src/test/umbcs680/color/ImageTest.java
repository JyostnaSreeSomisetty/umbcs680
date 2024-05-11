package umbcs680.color;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.color.Color;
import umbcs680.color.Image;
import umbcs680.color.Images;
import umbcs680.color.ColorAdjuster;
import umbcs680.color.GrayScaleAdjuster;

public class ImageTest {

    @Test
    public void testGrayScaleAdjuster() {
        Image img = new Image(3, 3);
        img.setColor(0, 0, new Color(255, 0, 0));
        img.setColor(0, 1, new Color(0, 255, 0));
        img.setColor(0, 2, new Color(0, 0, 255));

        ColorAdjuster grayScaleAdjuster = new GrayScaleAdjuster();
        Image grayScaleImg = Images.transform(img, grayScaleAdjuster);

        assertEquals(85, grayScaleImg.getColor(0, 0).getRedScale());
        assertEquals(85, grayScaleImg.getColor(0, 0).getGreenScale());
        assertEquals(85, grayScaleImg.getColor(0, 0).getBlueScale());

        assertEquals(85, grayScaleImg.getColor(0, 1).getRedScale());
        assertEquals(85, grayScaleImg.getColor(0, 1).getGreenScale());
        assertEquals(85, grayScaleImg.getColor(0, 1).getBlueScale());

        assertEquals(85, grayScaleImg.getColor(0, 2).getRedScale());
        assertEquals(85, grayScaleImg.getColor(0, 2).getGreenScale());
        assertEquals(85, grayScaleImg.getColor(0, 2).getBlueScale());
    }

    @Test
    public void testLambdaAdjuster() {
        Image img = new Image(3, 3);
        img.setColor(0, 0, new Color(255, 0, 0));
        img.setColor(0, 1, new Color(0, 255, 0));
        img.setColor(0, 2, new Color(0, 0, 255));

        ColorAdjuster lambdaAdjuster = color -> {
            int r = color.getRedScale();
            int g = color.getGreenScale();
            int b = color.getBlueScale();
            int avg = (r + g + b) / 3;
            return new Color(avg * 2, avg * 2, avg * 2);
        };

        Image lambdaAdjustedImg = Images.transform(img, lambdaAdjuster);

        assertEquals(170, lambdaAdjustedImg.getColor(0, 0).getRedScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 0).getGreenScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 0).getBlueScale());

        assertEquals(170, lambdaAdjustedImg.getColor(0, 1).getRedScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 1).getGreenScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 1).getBlueScale());

        assertEquals(170, lambdaAdjustedImg.getColor(0, 2).getRedScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 2).getGreenScale());
        assertEquals(170, lambdaAdjustedImg.getColor(0, 2).getBlueScale());
    }
}