import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class has_path {

    /*

  Has Path

1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true
otherwise print false.

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
        0
        6

*/

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

        int src=scn.nextInt();
        int dest=scn.nextInt();

        boolean[] visited=new boolean[vertices];

        System.out.println(ispath(graph,src,dest,visited));

    }

    public static boolean ispath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){

        if(visited[src]==true){
            return false;
        }

        visited[src]=true;

        if(src==dest){
            return true;
        }

        for(Edge e:graph[src]){
            if(ispath(graph,e.nbr,dest,visited)){
                return true;
            }
        }

        return false;
    }

}
