package test;

import java.awt.Point;

public class StatLib {

	
// simple average
public static float avg(float[] x){
	float sum=0;
	for(int i=0;i<x.length;i++)
		sum+=x[i];

	return sum/x.length;
}

// returns the variance of X and Y
public static float var(float[] x){
	float sum=0;
	float avgX=avg(x);
	for(int i=0;i<x.length;i++)
		sum+=Math.pow(x[i],2);
	return (sum/x.length)-(Math.pow(avgX,2));

}
 
	// returns the covariance of X and Y
	public static float cov(float[] x, float[] y){
float sum=0;
avgX=avg(x);
avgY=avg(y);
for(int i=0;i<x.length;i++)
{
sum+=(x[i]-avgX)*(y[i]-avgY);
}
	return sum/x.length;
	}


	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y){
	float covXY=cov(x,y);
	float sX=var(x);
	float sY=var(y);
	Float totalS=Math.sqrt(sX,2)*Math.sqrt(sY,2);
	return covXY/totalS;
	}

	// performs a linear regression and returns the line equation
	public static Line linear_reg(Point[] points){
	float _X[]=new float[points.length];
	float _Y[]=new float[points.length];
	for(int i=0;i<points.length;i++)
	{
		_X[i]=points[i].x;
		_Y[i]=points[i].y;

	}
	float covXY=cov(_X,_Y);
	float varX=var(_X);
	float a=covXY/varX;
    float avgX=avg(_X);
    float avgY=avg(_Y);
	float b=avgY-a*avgX;

	Line Y=new Line(a,b);
	return Y;
	
}

	// returns the deviation between point p and the line equation of the points
	public static float dev(Point p,Point[] points){
		Line Y=linear_reg(points);
		float F=Y.f(p.x);
		float  deviation=F-p.y;
		return Math.abs(deviation);
	}

	// returns the deviation between point p and the line
	public static float dev(Point p,Line l){
		float F=l.f(p.x);
		float  deviation=F-p.y;
		return Math.abs(deviation);
	}
	
}
