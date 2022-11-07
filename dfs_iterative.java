import java.io.*;
import java.util.*;

public class dfs_iterative {

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
        int val;
        String str;
        Pair(int val,String str){
            this.val=val;
            this.str=str;
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

        dfs(graph,visited,src);

    }


    public static void dfs(ArrayList<Edge>[] graph,boolean[] visited,int src){

        Stack<Pair> st=new Stack<>();
        st.push(new Pair(src,""+src));

        while (st.size()!=0) {

            Pair p=st.pop();

            if(!visited[p.val]) {
                System.out.println(p.val+"@"+p.str);
                visited[p.val] = true;
                for (Edge e : graph[p.val]) {
                    if (!visited[e.nbr]) {
                        st.push(new Pair(e.nbr,p.str+e.nbr));
                    }
                }
            }

        }

    }

}