import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class FaceDetection {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // Load the OpenCV face detector (Haar cascade)
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");

        // Open the webcam
        VideoCapture capture = new VideoCapture(0);

        if (!capture.isOpened()) {
            System.out.println("Error: Could not open video stream.");
            return;
        }

        Mat frame = new Mat();

        // Capture an image
        capture.read(frame);

        // Convert the image to grayscale for face detection
        Mat grayFrame = new Mat();
        Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);

        // Detect faces in the image
        MatOfRect faces = new MatOfRect();
        faceDetector.detectMultiScale(grayFrame, faces);

        // Analyze detected faces (skin region)
        for (Rect rect : faces.toArray()) {
            // Draw a rectangle around the face
            Imgproc.rectangle(frame, new Point(rect.x, rect.y), 
                                     new Point(rect.x + rect.width, rect.y + rect.height), 
                                     new Scalar(0, 255, 0));

            // Extract the skin region (inside the face)
            Mat faceROI = frame.submat(rect);
            
            // Here you can add custom skin condition detection logic.
            // For example, calculate color histograms, check for acne, spots, etc.
            analyzeSkin(faceROI);
        }

        // Save the processed image
        Imgcodecs.imwrite("output.png", frame);

        // Release the camera
        capture.release();
    }

    // Method to analyze skin based on the region of interest (ROI)
    public static void analyzeSkin(Mat faceROI) {
        // Convert the face ROI to the YCrCb color space (commonly used for skin detection)
        Mat skin = new Mat();
        Imgproc.cvtColor(faceROI, skin, Imgproc.COLOR_BGR2YCrCb);

        // Define the skin color range in YCrCb color space
        Scalar lower = new Scalar(0, 133, 77);
        Scalar upper = new Scalar(255, 173, 127);

        // Threshold the image to extract skin areas
        Core.inRange(skin, lower, upper, skin);

        // Here, add additional logic to detect specific skin conditions, e.g., acne, wrinkles, etc.
        // You can process the image further, extract features, or feed it to a machine learning model.
        // For now, we just print a message.
        System.out.println("Skin analysis complete for the detected face.");
    }
}
