# Use a a boolean array to store the result of whether a number "isPrime"
# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 0
        isPrime = [False, False] + [True] * (n - 2)
        for p in range(2, int(sqrt(n)) + 1):
            if isPrime[p]:
                # If a number is prime, then its multiples are not a prime
                for multiple in range(p * p, n, p):
                    isPrime[multiple] = False
        return sum(isPrime)