import org.bytedeco.javacv.*;

import static org.bytedeco.ffmpeg.global.avcodec.AV_CODEC_ID_AAC;
import static org.bytedeco.ffmpeg.global.avcodec.AV_CODEC_ID_H264;

public class WebCamTest {
    public static void main(String[] args) throws Exception {
        int imageHeight = 720;
        int imageWidth = 1080;
        CanvasFrame canvas = new CanvasFrame("Web Cam");

        FrameGrabber grabber = new OpenCVFrameGrabber(1);
        grabber.setImageMode(FrameGrabber.ImageMode.COLOR);
        grabber.setImageHeight(imageHeight);
        grabber.setImageWidth(imageWidth);
        grabber.start();

        Frame frame = null;

        int i = 0;
        while(i < 100){
            Thread.sleep(30);
            frame = grabber.grab();
            canvas.showImage(frame);
            i++;
        }
        grabber.stop();
        grabber.release();

        canvas.dispose();

    }
}
