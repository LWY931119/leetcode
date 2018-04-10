/*问题描述:有0-n-1,n节课,给出这个n节课的前后先修课关系,判断有没有可能修完这些课
*判断有向无环图的问题,使用拓扑排序的方法.根据边的信息整理出邻接矩阵和入度的数组.
*将入度为0的点入队列,不断删除掉这些点(与其相同的点的入度减一)并将入度为0 的点入队列.
*最后判断能不能访问到所有的点.
*类似题 210,按顺序将课程输出即可.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matric = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int last = prerequisites[i][0];
            matric[pre][last] = 1;
            indegree[last]++;
        }
        Queue<Integer> courses = new LinkedList<Integer>();
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] == 0)courses.offer(i);
        }
        int count = 0;
        while(!courses.isEmpty()){
            int c = courses.poll();
            count++;
            for(int i = 0;i < numCourses;i++){
                if(matric[c][i] == 1){
                    indegree[i]--;
                    if(indegree[i] == 0)
                        courses.offer(i);
                }
            }
        }
        if(count == numCourses)return true;
        else return false;
    }
}
