import java.io.*;
import java.util.*;

public class prims_algo {

    static class Edge implements Comparable<Edge>{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt-o.wt;
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

        prims_algo_func(graph,0);

    }

    public static void prims_algo_func(ArrayList<Edge>[] graph,int src){

        ArrayList<Edge>[] mst=new ArrayList[graph.length];

        for(int i=0;i< graph.length;i++){
            mst[i]=new ArrayList<>();
        }

        boolean[] visited=new boolean[graph.length];

        PriorityQueue<Edge> p=new PriorityQueue<>();
        visited[src]=true;

        for(Edge e:graph[src]){
            p.add(new Edge(src, e.nbr, e.wt));
        }

        while (p.size()!=0){


            //removing the smallest weight edge from the PQ
            Edge current=p.remove();

            if(visited[current.nbr]){
                continue;
            }

            //marking the new_vertex as visited
            visited[current.nbr]=true;

            //addding the edge to mst
            mst[current.src].add(current);

            //adding the relevant edges to pq starting from new_vertex
            for(Edge e:graph[current.nbr]){
                if(!visited[e.nbr]){
                    p.add(e);
                }
            }

        }

        for(int i=0;i< graph.length;i++){
            for(Edge e:mst[i]){
                System.out.println("["+e.nbr+"-"+e.src+"@"+e.wt+"]");
            }
        }

    }

}