import java.io.*;
import java.util.*;

public class toplogical_sorting {
    static class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
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
            Edge e=new Edge(src,nbr);
            graph[src].add(e);
        }

        boolean[] visited=new boolean[graph.length];
        Stack<Integer> ans=new Stack<>();

        for(int i=0;i< graph.length;i++){
            if(!visited[i]){
                dfs(graph,i,ans,visited);
            }
        }

        while (ans.size()!=0){
            System.out.println(ans.pop());
        }

    }
    public static void dfs(ArrayList<Edge>[] graph,int src,Stack<Integer> s,boolean[] visited){

        visited[src]=true;

        for(Edge e:graph[src]){
            if(!visited[e.nbr]){
                dfs(graph, e.nbr,s,visited);
            }
        }

        s.push(src);

    }

}