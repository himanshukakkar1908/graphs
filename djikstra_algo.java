import java.io.*;
import java.util.*;

public class djikstra_algo {

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

    static class Node implements Comparable<Node>{
        int vertice;
        int weight;
        String path;
        Node(int vertice,int weight,String path){
            this.vertice=vertice;
            this.weight=weight;
            this.path=path;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int vertices = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edges; i++) {
            int src = scn.nextInt();
            int nbr = scn.nextInt();
            int wt = scn.nextInt();
            Edge e = new Edge(src, nbr, wt);
            graph[src].add(e);
            Edge e_ = new Edge(nbr, src, wt);
            graph[nbr].add(e_);
        }

        Node[] visited = new Node[vertices];
        int src=scn.nextInt();
        for(int i=0;i<visited.length;i++){
            visited[i]=new Node(i,Integer.MAX_VALUE,"");
        }

        djikstra(graph,visited,src);

    }

    public static void djikstra(ArrayList<Edge>[] graph,Node[] visited,int src){

        PriorityQueue<Node> p=new PriorityQueue<Node>();
        p.add(new Node(src,0,""+src));
        visited[0].weight=0;
        visited[0].path="0";

        while(p.size()!=0){

            Node current_node=p.remove();

            for(Edge e:graph[current_node.vertice]){
                int next_vertex= e.nbr;
                if(visited[next_vertex].weight>current_node.weight+e.wt){
                    Node replace=new Node(next_vertex,current_node.weight+e.wt, current_node.path+next_vertex);
                    visited[next_vertex]=replace;
                    p.add(replace);
                }
            }

        }
        print(visited);
    }

    public static void print(Node[] visited){
        for(int i=0;i<visited.length;i++){
            System.out.println(visited[i].vertice+" via "+visited[i].path+" @ "+visited[i].weight);
        }
    }

}