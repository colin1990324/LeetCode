import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * */

public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] pointsOne = { new Point(0, 0), new Point(0, 1),
				new Point(1, 0), new Point(1, 1), new Point(2, 2) , new Point(3, 3) , new Point(4, 4)};
		Point[] pointsTwo = null;
		System.out.println(maxPoints(pointsOne));
		System.out.println(maxPoints(pointsTwo));
	}

	public static int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		} else if (points.length < 2) {
			return 1;
		} else if (points.length == 2) {
			return 2;
		}
		Line[] lineArray = new Line[points.length * (points.length - 1) / 2];
		int counter = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				lineArray[counter] = new Line(points[i], points[j]);
				counter++;
			}
		}
		int max=0;
		for (int i = 0; i < lineArray.length; i++) {
			counter=0;
			for (int j = 0; j < lineArray.length; j++) {
				if(Line.isSameLine(lineArray[i],lineArray[j]))
					counter++;
			}
			if(counter>max)
				max=counter;
		}
		return (int) Math.ceil(Math.sqrt(max*2));
	}
	
	public int maxPointsB(Point[] points) {
	int maxLine = 0;
    for (int i=0; i<(points.length-maxLine); i++) {
        int coincident = 0;
        Map<Double, Integer> pointCounts = new HashMap<Double, Integer>();
        for (int j=i+1; j<points.length; j++) {
            Double slope;
            if (points[i].x==points[j].x && points[i].y==points[j].y) {
                coincident++;
                continue;
            } else if (points[i].x == points[j].x) {
                slope = Math.PI;
            } else if (points[i].y == points[j].y) {
                slope = 0.0; // logically we don't need this, but in practice i find that we do
            } else {
                slope = new Double((double)(points[i].y-points[j].y) / (double)(points[i].x-points[j].x));
            }

            if (pointCounts.containsKey(slope))
                pointCounts.put(slope, pointCounts.get(slope)+1);
            else
                pointCounts.put(slope, new Integer(1));
        }
        maxLine = Math.max(maxLine, 1+coincident+maxValue(pointCounts));
    }

    return maxLine;
}

private int maxValue(Map<Double, Integer> doubleIntMap) {
    int max = 0;
    Set<Double> keys = doubleIntMap.keySet();
    Iterator iter = keys.iterator();
    while (iter.hasNext())
        max = Math.max(max, doubleIntMap.get(iter.next()));
    return max;
}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

class Line {
	static final double INFINITY = 2147483648d;
	double k;
	double b;
	Point aPoint;
	Point bPoint;

	Line(Point a, Point b) {
		this.aPoint = a;
		this.bPoint = b;
		if ((b.x - a.x) == 0) {
			k = INFINITY;
			this.b = b.x;
		} else {
			this.k = (a.y - b.y) / (b.x - a.x);
			this.b = -a.y + (a.x * (b.y - a.y) / (b.x - a.x));
		}
	}

	public static boolean isSameLine(Line a, Line b) {
		if (a.k == b.k && a.b == b.b)
			return true;
		else
			return false;
	}
}