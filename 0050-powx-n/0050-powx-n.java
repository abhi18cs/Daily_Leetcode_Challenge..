//Brute Force multiply through loop Tc=O() Sc=O()
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }

        return result;
    }
}


// Optimal Approach Tc=O(logn), Sc=O(1)
// class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) return 1.0;
//         else if (n % 2 == 1) return x * myPow(x, n - 1);
//         else if (n % 2 == 0) return myPow(x * x, n / 2);
//         else return 1 / myPow(x, -n);
//     }
// }


