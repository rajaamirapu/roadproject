package com.bostonwalker;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.KeyPoint;
import org.opencv.highgui.Highgui;  

public class Main {

    public static void main(String[] args)
    {
        System.loadLibrary("opencv_java249");

//        String sourcePath = "E:\\RAJA\\opencv-2.4.9\\picturestobeanalyzed\\distress5.jpg";
        String sourcePath = "E:\\RAJA\\opencv-2.4.9\\picturestobeanalyzed\\IMG_20140425_173515.jpg";
        String blankPath = "E:\\RAJA\\opencv-2.4.9\\picturestobeanalyzed\\new.jpg";

        Mat srcImgMat = Highgui.imread(sourcePath);
        Mat srcImgBlank = Highgui.imread(blankPath);


        if (srcImgMat == null)
        {
            System.out.println("Failed to load image at " + sourcePath);
            return;
        }

        System.out.println("Loaded image at " + sourcePath);

        MatOfKeyPoint matOfKeyPoints = new MatOfKeyPoint();

        FeatureDetector blobDetector = FeatureDetector.create(FeatureDetector.ORB);
        blobDetector.detect(srcImgMat, matOfKeyPoints);

        System.out.println("Detected " + matOfKeyPoints.size()+ " blobs in the image");
        System.out.println(matOfKeyPoints.depth());
        List<KeyPoint> lstKp=matOfKeyPoints.toList();
        //matOfKeyPoints.
        for(KeyPoint kp:lstKp)
        {
        	//MatOfKeyPoint mkp=new MatOfKeyPoint();

        	//System.out.println(kp.pt.x);
        	//System.out.println(kp.pt.y);
        	Core.circle(srcImgMat, kp.pt, 2, new Scalar(255.0,0,0));

        }


        Highgui.imwrite("E:\\RAJA\\opencv-2.4.9\\picturestobeanalyzed\\modified" + System.currentTimeMillis() +  ".jpg",srcImgMat);
       //Core.
        //System.out.println(matOfKeyPoints.toList());
        int rows=matOfKeyPoints.rows();
        int cols=matOfKeyPoints.cols();
        Integer[] data=new Integer[rows];
        List<List<Double>> dblList=new ArrayList<List<Double>>();
        List<Double> lst=new ArrayList<Double>();
        //Core.line(srcImgBlank, matOfKeyPoints., pt2, color)
     //MinMaxLocResult minMax=   Core.minMaxLoc(srcImgMat);
     Core.line(srcImgBlank, new Point(0,20), new Point(1200,20), new Scalar(70,0));

     for(KeyPoint kp:lstKp)
     {
     	//System.out.println(kp.pt.x);
     	//System.out.println(kp.pt.y);
    	 //MatOfPoint mp=new MatOfPoint(kp.pt.x,kp.pt.y);


     	Core.circle(srcImgBlank, kp.pt, 2, new Scalar(255.0));


     }
     Highgui.imwrite("E:\\RAJA\\opencv-2.4.9\\picturestobeanalyzed\\line.jpg",srcImgBlank);

        /*for(int row=0;row<=rows; row++)
        {
        	for(int col=0;col<=cols; col++)
        	{

        		double[] width=matOfKeyPoints.get(row, col);
        		if(width!=null)
        		{
	        		for(int i=0;i<width.length;i++)
	        		{
	        			lst.add(width[i]);

	        		}
        		}
        		dblList.add(lst);
        	//	System.out.println(width);
        	//	dblList=Arrays.asList(width);

        		//System.out.println(dblList);
        }
        }*/
        System.out.println(dblList);
        //int height=matOfKeyPoints.height();

   //    System.out.println(width);
     //   System.out.println(height);


        //List<KeyPoint> keyPoints = matOfKeyPoints.toList();

    }
}
