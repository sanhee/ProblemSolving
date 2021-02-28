package com.example.BOJ._1052.JAVA;


import java.io.*;

public class BOJ_1052 {

    // Set up : I/O
    static StringBuilder output = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // Set up : Global Variables
        /* None */

            // Set up : Input
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int K = Integer.parseInt(inputs[1]);

            // Process
            int ans = 0;
            int bc = Integer.bitCount(N);
            int ofs = 1;
            while (bc > K) {
                while ((N&ofs) == 0) {
                    ofs <<= 1;
                }
                ans += ofs;
                N += ofs;
                bc = Integer.bitCount(N);
            }

            // Control : Output
            output.append(ans);

            bw.write(output.toString());
            bw.flush();

            // Close up : I/O
            br.close();
            bw.close();
        }

        // Helper Functions
        /* None */

}
