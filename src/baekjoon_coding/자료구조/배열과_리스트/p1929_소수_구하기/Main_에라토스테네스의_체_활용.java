package baekjoon_coding.자료구조.배열과_리스트.p1929_소수_구하기;
import java.util.*;
import java.io.*;

// 에라토스테네스의 체 활용한 풀이방법
public class Main_에라토스테네스의_체_활용{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    boolean isPrime[] = new boolean[n+1];

    isPrime[1] = false;
    for(int i=2;i<isPrime.length; i++)
      isPrime[i] = true;

    for(int i=2;i<=Math.sqrt(n);i++){
      if(isPrime[i]){
        for(int j=i+i; j<=n; j+=i)
          isPrime[j] = false;
      }
    }

    for(int i=m; i<=n; i++){
      if(isPrime[i])
        sb.append(i).append("\n");
    }

    bw.append(sb);

    br.close();
    bw.close();

  }
}