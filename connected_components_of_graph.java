/*

1. You are given a graph. 2. You are required to find and print all connected components of the graph.

7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

 */


import java.util.ArrayList;
import java.util.Scanner;

public class connected_components_of_graph {

    static class Edge {
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
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

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        for(int i=0;i<vertices;i++) {
            if(!visited[i]) {
                ArrayList<Integer> component=new ArrayList<>();
                dfs(graph,i,visited,component);
                ans.add(component);
            }
        }

        System.out.println(ans);

        }

    public static void dfs(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> component){
        visited[src]=true;
        component.add(src);
            for(Edge e:graph[src]){
                if(!visited[e.nbr]) {
                    dfs(graph, e.nbr, visited, component);
                }
            }
    }

}