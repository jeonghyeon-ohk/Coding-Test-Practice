package baekjoon_coding.자료구조.배열과_리스트.p1546_평균_구하기;

import java.util.Scanner;

// 평균 구하기 1546번
public class Main{
  public static void main(String[] args){

    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int[] arr = new int[n];

    for(int i=0;i<arr.length;i++)
      arr[i] = stdin.nextInt();

    int max = arr[0];
    for(int i=0;i<arr.length;i++){
      if (arr[i] > max)
        max = arr[i];
    }

    double sum = 0;
    for(int i=0;i<arr.length;i++){
      double newAve = (double)arr[i]/max*100;
      sum+=newAve;
    }
    System.out.print(sum/arr.length);

  }
}