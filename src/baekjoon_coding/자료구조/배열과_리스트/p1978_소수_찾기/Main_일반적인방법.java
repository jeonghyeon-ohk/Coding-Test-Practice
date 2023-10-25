package baekjoon_coding.자료구조.배열과_리스트.p1978_소수_찾기;
import java.util.*;
import java.io.*;
public class Main_일반적인방법{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int n = Integer.parseInt(br.readLine());
    int count = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    while(st.hasMoreTokens()){
      boolean isPrimeNumber = true;
      int num = Integer.parseInt(st.nextToken());

      if(num==1)
        continue;
      if(num==2) {
        count++;
        continue;
      }

      for(int j=2; j<num; j++){
        if(num%j == 0){
          isPrimeNumber = false;
          break;
        }
      }

      if(isPrimeNumber){
        count++;
      }
    }
    bw.write(String.valueOf(count));

    br.close();
    bw.close();

  }
}

