import java.io.*;
import java.util.*;

public class totalC {
    public static long MOD = 1000000007;
    public static int N=10000000+10;
    private static long mul(long x, long y) {long res = x * y; return (res >= MOD ? res % MOD : res);}
    public static long power(long x, long y) {if (y < 0) return 1; long res = 1; x %= MOD; while (y!=0) {if ((y & 1)==1)res = mul(res, x); y >>= 1; x = mul(x, x);} return res;}

   public static void main(String[] args) {
    InputReader scn = new InputReader(System.in);
    OutputWriter w = new OutputWriter(System.out);
        boolean[] pp=new boolean[N];
        for(int i=2;i<N;i++)
        {
            if(!pp[i])
            for(int j=2*i;j<N;j+=i)
            {
                pp[j]=true;
            }
        }
        int[] cp=new int[N];
        int ct=0;
        for(int i=2;i<N;i++)
        {
            if(!pp[i]) ct++;
            cp[i]=ct;
        }
        int t=scn.nextInt();
            while(t-->0)
            {
                int n=scn.nextInt();
                if(n==2||n==3) w.println(n-1);
                else
                w.println(1+cp[n]-cp[n/2]);
            }
        w.close();    
    }

// javac totalC.java && java totalC<input.txt>output.txt
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void close() {
            writer.close();
        }

    }
}
