/*

Multisolver - Smallest, Longest, Ceil, Floor, Kthlargest Path

1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of
3.1 Smallest path and it's weight separated by an "@"
3.2 Largest path and it's weight separated by an "@"
3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
3.5 Kth largest path and it's weight separated by an "@"

7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
6
30
4

Sample Output

Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48

 */


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class multisolver_graph {
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
    static class path implements Comparable<path>{
        int weight_sum;
        String pathstring;
        path(int weight_sum,String path){
            this.weight_sum=weight_sum;
            this.pathstring=path;
        }

        @Override
        public int compareTo(path o) {
            return this.weight_sum-o.weight_sum;
        }

    }

    static PriorityQueue<path> paths=new PriorityQueue<>();

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
        int mid=scn.nextInt();
        int k=scn.nextInt();

        boolean[] visited=new boolean[vertices];

        multisolver_graph_func(graph,src,dest,0,visited,"");

        int smallest_path=-1;
        String smallest_path_string="";
        int largest_path=-1;
        String largest_path_string="";
        int ceil_path=Integer.MAX_VALUE;
        String ceil_path_string="";
        int floor_path=Integer.MIN_VALUE;
        String floor_path_string="";
        int kth_path=1;
        String kth_path_string="";

        int size=paths.size();

        while (paths.size()!=0){

            path p=paths.remove();

            if(paths.size()==0){
                largest_path_string=p.pathstring;
                largest_path=p.weight_sum;
            }

            if(paths.size()==size-1){
                smallest_path_string=p.pathstring;
                smallest_path=p.weight_sum;
            }

            if(p.weight_sum<mid && p.weight_sum>floor_path){
                floor_path=p.weight_sum;
                floor_path_string=p.pathstring;
            }

            if(p.weight_sum>mid && p.weight_sum<ceil_path){
                ceil_path=p.weight_sum;
                ceil_path_string=p.pathstring;
            }

            if(paths.size()==k-1){
                kth_path=p.weight_sum;
                kth_path_string=p.pathstring;
            }

        }

        System.out.println("Smallest Path = " + smallest_path_string + "@" + smallest_path);
        System.out.println("Largest Path = " + largest_path_string + "@" + largest_path);
        System.out.println("Just Larger Path than " + mid + " = " + ceil_path_string + "@" + ceil_path);
        System.out.println("Just Smaller Path than " + mid + " = " + floor_path_string + "@" + floor_path);
        System.out.println(k + "th largest path = " + kth_path_string + "@" + kth_path);


    }

    public static void multisolver_graph_func(ArrayList<Edge>[] graph, int src, int dest, int wtsum, boolean[] visited, String psf){

        visited[src]=true;
        psf+=src;

        if(src==dest){
            path val=new path(wtsum,psf);
            paths.add(val);
            visited[src]=false;
            return;
        }

        for(Edge e:graph[src]){
            if(!visited[e.nbr]) {
                multisolver_graph_func(graph, e.nbr, dest, wtsum + e.wt, visited, psf);
            }
        }

        visited[src]=false;

    }

}
