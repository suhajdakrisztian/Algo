import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;





class BruteForce {
  public static List<Integer> S = new ArrayList<Integer>();
  
  public static void Search(String text, String pattern) {

    int n = text.length();
    int m = pattern.length();

    for(int s = 0; s < (n - m); s++) {
      if(text.substring(s, s+m).equals(pattern))
        S.add(s);
    }
    for(Integer element: S)
      System.out.print(element + " ");
  }
}

class KMP_String_Matching {
  void KMPSearch(String pat, String txt)
  {
      int M = pat.length();
      int N = txt.length();

      int comparisonCount = 0;

      int lps[] = new int[M];
      int j = 0;

      computeLPSArray(pat, M, lps);

      int i = 0;
      while (i < N) {
          if (pat.charAt(j) == txt.charAt(i)) {
              j++;
              i++;
              comparisonCount++;
          }
          if (j == M) {
              System.out.println("Found pattern "
                                 + "at index " + (i - j));
              j = lps[j - 1];
          }
          else if (i < N && pat.charAt(j) != txt.charAt(i)) {
            comparisonCount++;
              if (j != 0)
                  j = lps[j - 1];
              else
                  i = i + 1;
          }
          
      }
      System.out.println(comparisonCount);
  }

  void computeLPSArray(String pat, int M, int lps[])
  {

      int len = 0;
      int i = 1;
      lps[0] = 0;
      
      while (i < M) {
          if (pat.charAt(i) == pat.charAt(len)) {
              len++;
              lps[i] = len;
              i++;
          }
          else
          {

              if (len != 0) {
                  len = lps[len - 1];
              }
              else
              {
                  lps[i] = len;
                  i++;
              }
          }
      }
      for (int j = 0; j < lps.length; j++) {
        if(j == lps.length - 1)
          System.out.print(lps[j]);
        else
          System.out.print(lps[j] + ",");
      }
      System.out.print("\n");
  }
}

class QuickSearch {

  public static HashMap<Character, Integer> shift = new HashMap<>();
  public static List<Integer> S = new ArrayList<Integer>();

  public static void init() {
    shift.put('A',1);
    shift.put('B',2);
    shift.put('C',8);
    shift.put('D',6);

  }


  public static void Search(String text, String pattern) {

    init();

    int m = pattern.length();
    int comparisons = 0;

    for(int s = 0; (s + m) <= text.length(); s++) {
      for(int i = 0; i < m && text.substring(s, m).charAt(i) == pattern.charAt(i); i++)
        comparisons++;
      if(s + m < text.length())
        s += shift.get(text.charAt(s + m + 1));
    }

      System.out.println(comparisons);

  }
}





public class patternMatch {
  public static void main(String[] args) {
    new KMP_String_Matching().KMPSearch("ABCA", "ABDAEBBCBBCABCBABCA");
  }
}
