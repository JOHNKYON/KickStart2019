# Problem 1. Even Digits

The idea is simple, go from the most significant digit to the least one (a.k.a, from left to right),
When encountered with the first odd digit, that's where we're gonna change the number.

We could change the number into a greater one or a smaller one, but how do we know which is the correct answer? Simple
math gives us the answer.

Say we have a number of `ab` where `a` is an odd digit, thus we want to change the number into `(a+1)b'` or `(a-1)b'`,
so that both `(a-1)` and `b'` are even digits (things may be a little bit different when `a` is `9`, but we'll
 discuss it latter). It's easy to tell that, the 
smallest `b'` is `0` and the greatest `b'` is `8`. Here we can see that, the threshold of 
`b` is `4`. For any `b` greater than `4`, it takes less moves to go up than go down, vice versa. And this 
works for any string after the first odd digits, that the threshold is `444...4`.

If `a` is `9`, we can only go down, simply because if we want to make it greater, we add 1 to the previous
digit, which is an odd digit (if it's the first digit, imagine there's a leading `0`). Thus the number of moves
would be around 100 times than go down (because we need to make the previous number even again).

Be careful about the input data range, integer does not work, you'll need long.