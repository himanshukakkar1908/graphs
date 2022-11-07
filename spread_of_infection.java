import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class spread_of_infection {

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
        int time=scn.nextInt();

        boolean[] visited=new boolean[vertices];

        System.out.println(spread_of_infection(graph,src,visited,time));
    }

    public static int spread_of_infection(ArrayList<Edge>[] graph,int src,boolean[] visited,int stop_time){

        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(src);
        visited[src]=true;

        int time=1;
        int count=1;

        while (queue.size()!=0 && time<stop_time){

            int size= queue.size();

            for(int i=0;i<size;i++) {

                int val = queue.remove();

                for(Edge e:graph[val]){
                    if(!visited[e.nbr]){
                        queue.add(e.nbr);
                        visited[e.nbr]=true;
                        count++;
                    }
                }

            }

            time++;

        }

        return count;
    }

}
