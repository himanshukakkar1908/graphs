import java.util.Scanner;

public class two_groupd {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();

        for(int test=1;test<=t;test++){

            int size=scn.nextInt();
            long positive=0;
            long negative=0;

            for(int i=0;i<size;i++){

                int val=scn.nextInt();
                if(val<0){negative+=val;}
                else {positive+=val;}

            }

            negative=-(negative);

            if((negative)>positive){
                System.out.println((negative)-positive);
            }

            else{
                System.out.println(positive-negative);
            }

        }

    }

}
