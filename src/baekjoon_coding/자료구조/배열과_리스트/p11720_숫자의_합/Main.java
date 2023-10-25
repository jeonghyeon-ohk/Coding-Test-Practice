package baekjoon_coding.자료구조.배열과_리스트.p11720_숫자의_합;

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner stdin = new Scanner(System.in);

    int n = stdin.nextInt();
    String str = stdin.next();

    char[] ch = str.toCharArray();

    int sum = 0;
    for(int i=0;i<ch.length;i++){
      sum += ch[i]-'0';
    }

    System.out.print(sum);

  }

}