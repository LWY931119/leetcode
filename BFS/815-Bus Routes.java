/*
*给出每条公交线路routes[i]经过的站点routes[i][j],起点S和终点T,求出起点到终点最少乘坐的线路数.
*是典型的最短路问题,dijkstra,或folyd都可以计算,对于此题起点固定所以dijstra更符合.
*只是对于该题的数据量routes.length<=500,routes[i].length<=500,routes[i][j]<10^6,最坏情况有500*500个节点,需要开辟500*500*500*500的二维数组记录两点之间长度.显然失败.
*只能用BFS来做.数据处理阶段:将经过每个站点的线路号用map保存起来.为了避免绕圈,将乘坐过的线路保存在set里.用queue队列辅助BFS的实现.
*首先将起点放进队列里,对于队列中的每个元素i进行遍历,在map中取出经过该节点的所有线路号,对于每个线路j,遍历routes[j]的每个站点k,若是终点则返回,否则将节点加入到队列中.
*其中每访问一条线路之前检查是否访问过,否则就加入visited;每经过一次大循环证明更换过一次线路,线路数++
*循环结束后若没有到达终点返回-1
*特殊情况处理:在该算法中若S==T会返回1,实际为0
*/
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T)return 0;
        Map<Integer,ArrayList<Integer>> busmap = new HashMap<Integer,ArrayList<Integer>>();
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < routes.length;i++){
            for(int j = 0;j < routes[i].length;j++){
                ArrayList<Integer> tmp = busmap.getOrDefault(routes[i][j],new ArrayList<Integer>());
                tmp.add(i);
                busmap.put(routes[i][j],tmp);
            }
        }
        q.offer(S);
        int re = 0;
        while(!q.isEmpty()){
            re++;
            int size = q.size();
            for(int i = 0;i < size;i++){
                int s = q.poll();
                //visited.add(s);
                ArrayList<Integer> route = busmap.get(s);
                for(int j = 0; j < route.size();j++){
                    int line = route.get(j);
                    if(visited.contains(line))continue;
                    visited.add(line);
                    for(int k = 0;k < routes[line].length;k++){
                        if(routes[line][k] == T)return re;
                        q.offer(routes[line][k]);
                    }
                }
            }
            
        }
        return -1;
    }
}
