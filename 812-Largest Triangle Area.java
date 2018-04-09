/*
*给出平面中若干点的坐标，求出它们其中三点组成的三角形最大面积。
*海伦公式，S = sqrt(p*(p-a)*(p-b)*(p-c))
*其中p是(a+b+c)/2,a b c是三边长
*平面坐标系中两点之间距离sqrt(pow((x1-x2),2)+pow((y1,y2),2))
*/
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        //int m = points[0].length;
        double max = 0.0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    double a = Math.sqrt(Math.pow((points[i][0] - points[j][0]),2) + Math.pow((points[i][1] - points[j][1]),2));
                    double b = Math.sqrt(Math.pow((points[i][0] - points[k][0]),2) + Math.pow((points[i][1] - points[k][1]),2));
                    double c = Math.sqrt(Math.pow((points[k][0] - points[j][0]),2) + Math.pow((points[k][1] - points[j][1]),2));
                    double p = (a+b+c)/2.0;
                    //System.out.println(i+" "+j+" "+k+" "+a+" "+b+" "+c);
                    double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                    if(area>max)max = area;
                }
            }
        }
        return max;
    }
}
