import java.util.*;

public class isbipartite {

    public static void main(String[] args) {

        int[][] graph= {{1,3},{0,2},{1,3},{0,2}};

        System.out.println(isbipartitefunc(graph));

    }

    public static boolean isbipartitefunc(int[][] graph){
        int[] visited=new int[graph.length];
        Arrays.fill(visited,-1);

        boolean ans=true;

        for(int i=0;i<graph.length && ans;i++){
            if(visited[i]==-1){
                ans=bfs(graph,i,visited);
            }
        }

        return ans;
    }

    /*

    public static boolean dfs(int[][] graph,int parent_color,int src,int[] visited){

        int[] neighbours=graph[src];
        visited[src]=1-parent_color;

        for(int i=0;i<neighbours.length;i++){
            if(visited[neighbours[i]]==-1){
                if(!dfs(graph,visited[src],neighbours[i],visited)){
                    return false;
                }
            }
            if(visited[neighbours[i]]==visited[src]){
                return false;
            }
        }

        return true;
    }


     */

    public static boolean bfs(int[][] graph,int src,int[] visited){

        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(src);
        visited[src]=0;

        while (queue.size()!=0){

            int e=queue.remove();
            int[] neighbours=graph[e];

            for(int i=0;i<neighbours.length;i++){

                if(visited[neighbours[i]]==-1){
                    queue.add(neighbours[i]);
                    visited[neighbours[i]]=1-visited[e];
                }

                if(visited[neighbours[i]]==visited[e]){
                    return false;
                }

            }

        }

        return true;

    }

}