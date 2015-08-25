package ygoprocardmaker.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class ImageUtils {

    public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public static String toString(Image img) {
        BufferedImage bimage = SwingFXUtils.fromFXImage(img, null);
        byte[] imageInByte;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bimage, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
        } catch (IOException ex) {
            return null;
        }
        return Base64.getEncoder().withoutPadding().encodeToString(imageInByte);
    }

    public static Image fromString(String str) {
        Image image;
        try {
            image = SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(str))), null);
        } catch (IOException ex) {
            return null;
        }
        return image;
    }
}
