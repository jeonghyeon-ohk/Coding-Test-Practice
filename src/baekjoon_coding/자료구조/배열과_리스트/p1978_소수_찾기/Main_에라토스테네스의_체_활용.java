package baekjoon_coding.자료구조.배열과_리스트.p1978_소수_찾기;
import java.util.*;
import java.io.*;

public class Main_에라토스테네스의_체_활용{
  public static void main(String[] args) throws IOException {
    final int MAX_NUMBER = 1001;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    boolean isPrime[] = new boolean[MAX_NUMBER];

    isPrime[1] = false;
    for(int i=2;i<isPrime.length; i++)
      isPrime[i] = true;

    for(int i=2;i<=Math.sqrt(MAX_NUMBER);i++){
      if(isPrime[i]){
        for(int j=i+i; j<MAX_NUMBER; j+=i)
          isPrime[j] = false;
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;

    while(st.hasMoreTokens()) {
      if (isPrime[Integer.parseInt(st.nextToken())])
        count++;
    }

    bw.write(String.valueOf(count));

    br.close();
    bw.close();

  }
}