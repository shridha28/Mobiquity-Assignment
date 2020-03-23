# Mobiquity-Assignment

Introducton:

You want to send your friend a package with different things.
Each thing you put inside the package has such parameters as index number, weight and cost. The
package has a weight limit. Your goal is to determine which things to put into the package so that the
total weight is less than or equal to the package limit and the total cost is as large as possible.
You would prefer to send a package which weighs less in case there is more than one package with the
same price.

Approach:

The above problem statement is related to knapsack where the end result is to determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.

There were additional constrains to be addressed which are listed below 
1. Max weight that a package can take is ≤ 100
2. There might be up to 15 items you need to choose from
3. Max weight and cost of an item is ≤ 100

This solution contains two approaches to solve the problem which are
1. Dynamic Programming Approach using sets method 
2. Recursive Approach using recursive algorithm

Running the Program:

In order to run the program, pass the items in below format. This should be placed in a text file

Sample:

81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)

8 : (1,15.3,€34)

75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)

56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)

Expected output for the above input:

4

-

2,7

8,9
