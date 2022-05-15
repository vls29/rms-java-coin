# The Coin Test

I started by writing a series of tests in the existing CoinConverterTest class which will hopefully go green once I've implemented the code.

Next, I added in a coin type so that I can have a toString method that will be used for printing out the value of the coin later on to meet the requirements of the string output.  The plan is to write a coin change method, sort the coins in descending order, pass in the amount and then get it to traverse the coins one by one asking if the amount (or remainder) can be divided by the coin.  With the output I'll then use produce the output string using the coins toString method.