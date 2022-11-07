

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;


public class hascycle {

    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    static class Pair{
        int parent;
        int child;
        Pair(int child,int parent){
            this.child=child;
            this.parent=parent;
        }
    }

    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);

        int vertices=scn.nextInt();
        int edges=scn.nextInt();

        ArrayList<Edge>[] graph=new ArrayList[vertices];

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=edges;i++){
            int src=scn.nextInt();
            int nbr=scn.nextInt();
            int wt= scn.nextInt();
            Edge e=new Edge(src,nbr,wt);
            graph[src].add(e);
            Edge e_=new Edge(nbr,src,wt);
            graph[nbr].add(e_);
        }

        boolean[] visited=new boolean[vertices];
        boolean result=false;

        /*

        for(int src=0;src<vertices && !result;src++) {
            if (!visited[src]) {
                result = dfs(graph, src, -1, visited);
            }
        }

         */

        for(int src=0;src<vertices && !result;src++) {
            if (!visited[src]) {
                result =bfs(graph, src, visited);
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(ArrayList<Edge>[] graph,int src,int prev,boolean[] visited){

        visited[src]=true;

        for(Edge e:graph[src]){
            if(visited[e.nbr] && prev!=e.nbr){
                return true;
            }
            if(!visited[e.nbr]){
                if(dfs(graph,e.nbr,src,visited)){
                    return true;
                }
            }
        }

        return false;

    }


    public static boolean bfs(ArrayList<Edge>[] graph,int src,boolean[] visited){

        Queue<Pair> queue=new ArrayDeque<>();

        queue.add(new Pair(src,-1));
        visited[src]=true;

        while(queue.size()!=0){

            Pair p=queue.remove();

            for(Edge e:graph[p.child]){
                if(visited[e.nbr] && e.nbr!=p.parent){
                    return true;
                }
                if(!visited[e.nbr]){
                    queue.add(new Pair(e.nbr, e.src));
                    visited[e.nbr]=true;
                }
            }

        }
        return false;
    }

}
