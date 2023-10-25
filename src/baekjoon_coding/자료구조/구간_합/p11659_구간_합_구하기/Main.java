package baekjoon_coding.자료구조.구간_합.p11659_구간_합_구하기;

import java.util.*;
import java.io.*;

// 구간 합 구하기, 11659번, 실버 3
public class Main{
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    int[] sumArr = new int[n];
    int sum = 0;

    for(int i=0 ;i<n; i++){
      int temp = Integer.parseInt(st.nextToken());
      sum+=temp;
      arr[i] = temp;
      sumArr[i] = sum;
    }

    for(int i=0 ;i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int temp = sumArr[b-1] - (a<2 ? 0 : sumArr[a-2]);
      bw.write(String.valueOf(temp));
      bw.newLine();
      bw.flush();
    }

    br.close();
    bw.close();

  }
}
