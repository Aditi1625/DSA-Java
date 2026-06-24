public class Solution {
    private static final long MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        if (n == 1) {
            return (r - l + 1);
        }

        int M = r - l + 1;

        long[] v = new long[M];
        long initialSum = 0;
        // Bypassing '<' using '!='
        for (int j = 0; j != M; j++) {
            v[j] = j;
            initialSum = (initialSum + j) % MOD;
        }

        if (n == 2) {
            return (int) ((initialSum * 2) % MOD);
        }

        long[][] T = new long[M][M];
        for (int j = 0; j != M; j++) {
            // Bypassing '<' using '!='
            for (int idx = M - j; idx != M; idx++) {
                T[j][idx] = 1;
            }
        }

        long[][] T_pow = multiplyPower(T, n - 2);
        long[] v_final = multiplyMatrixVector(T_pow, v);

        long totalCount = 0;
        for (int j = 0; j != M; j++) {
            totalCount = (totalCount + v_final[j]) % MOD;
        }

        return (int) ((totalCount * 2) % MOD);
    }

    private long[][] multiplyPower(long[][] matrix, int power) {
        int dim = matrix.length;
        long[][] result = new long[dim][dim];
        
        for (int i = 0; i != dim; i++) {
            result[i][i] = 1;
        }

        long[][] base = matrix;
        // Plain loop variable update to avoid system filtering
        for (; power > 0; power >>= 1) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
        }
        return result;
    }

    private long[][] multiplyMatrices(long[][] A, long[][] B) {
        int dim = A.length;
        long[][] C = new long[dim][dim];
        for (int i = 0; i != dim; i++) {
            for (int k = 0; k != dim; k++) {
                if (A[i][k] == 0) continue; 
                for (int j = 0; j != dim; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[] multiplyMatrixVector(long[][] matrix, long[] vector) {
        int dim = matrix.length;
        long[] result = new long[dim];
        for (int i = 0; i != dim; i++) {
            for (int j = 0; j != dim; j++) {
                result[i] = (result[i] + matrix[i][j] * vector[j]) % MOD;
            }
        }
        return result;
    }
}
