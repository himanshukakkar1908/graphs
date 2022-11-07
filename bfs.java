/*

Breadth First Traversal

1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path,
     starting from the src.

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {

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
        String psf;
        int vertice;
        Pair(int vertice,String psf){
            this.vertice=vertice;
            this.psf=psf;
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

        int src=scn.nextInt();

        bfs_function(graph,src);
    }



    public static void bfs_function(ArrayList<Edge>[] graph,int src){

        Queue<Pair> queue=new ArrayDeque<>();
        boolean[] visited=new boolean[graph.length];

        queue.add(new Pair(src,""+src));
        visited[src]=true;

        while (queue.size()!=0){

            Pair p=queue.remove();
            System.out.println(p.vertice+"@"+p.psf);

            for(Edge e:graph[p.vertice]){
                if(!visited[e.nbr]){
                    Pair pe=new Pair(e.nbr, p.psf+e.nbr);
                    queue.add(pe);
                    visited[e.nbr]=true;
                }
            }

        }

    }

}