package umbcs680.color;

import umbcs680.color.Color;
import umbcs680.color.ColorAdjuster;

public class GrayScaleAdjuster implements ColorAdjuster {
    @Override
    public Color adjust(Color color) {
        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();
        int avg = (r + g + b) / 3;
        return new Color(avg, avg, avg);
    }
}
