package baekjoon_coding.자료구조.구간_합.p11660_구간_합_구하기_2;

import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long arr[][] = new long[n+1][n+1];

    for(int i=1;i<=n;i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    long sumarr[][] = new long[n+1][n+1];
    for(int i=1;i<=n;i++) {
      for (int j = 1; j <= n; j++) {
        sumarr[i][j] = arr[i][j] + sumarr[i-1][j] + sumarr[i][j-1] - sumarr[i-1][j-1];
      }
    }

    for(int i=0 ;i<m;i++) {
      st = new StringTokenizer(br.readLine());
      int  x1 = Integer.parseInt(st.nextToken());
      int  y1 = Integer.parseInt(st.nextToken());
      int  x2 = Integer.parseInt(st.nextToken());
      int  y2 = Integer.parseInt(st.nextToken());

      long temp = sumarr[x2][y2] - sumarr[x1-1][y2] - sumarr[x2][y1-1] + sumarr[x1-1][y1-1];
      System.out.println(temp);
    }

    br.close();

  }
}

