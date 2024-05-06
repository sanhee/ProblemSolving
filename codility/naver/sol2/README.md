<div class="TaskDescription__StandardTaskDescription-sc-7m9k5q-3 kHwARi"><h2 class="mod-hidden">Task description</h2><div class="TaskDescription__TaskContentWrapper-sc-7m9k5q-2 task-description-content">
<div class="brinza-task-description">
<p>You are given a string S of length N which encodes a non-negative number V in a binary form. Two types of operations may be performed on it to modify its value:</p>
<blockquote><ul style="margin: 10px; padding: 0px;"><li>if V is odd, subtract 1 from it;</li>
<li>if V is even, divide it by 2.</li>
</ul>
</blockquote><p>These operations are performed until the value of V becomes 0.</p>
<p>For example, if string S = "011100", its value V initially is 28. The value of V would change as follows:</p>
<blockquote><ul style="margin: 10px; padding: 0px;"><li>V = 28, which is even: divide by 2 to obtain 14;</li>
<li>V = 14, which is even: divide by 2 to obtain 7;</li>
<li>V = 7, which is odd: subtract 1 to obtain 6;</li>
<li>V = 6, which is even: divide by 2 to obtain 3;</li>
<li>V = 3, which is odd: subtract 1 to obtain 2;</li>
<li>V = 2, which is even: divide by 2 to obtain 1;</li>
<li>V = 1, which is odd: subtract 1 to obtain 0.</li>
</ul>
</blockquote><p>Seven operations were required to reduce the value of V to 0.</p>
<p>Write a function:</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap;"><tt>fun solution(S: String): Int</tt></p></blockquote>
<p>that, given a string S consisting of N characters containing a binary representation of the initial value V, returns the number of operations after which its value will become 0.</p>
<p><b>Examples:</b></p>
<p>1. Given S = "011100", the function should return 7. String S represents the number 28, which becomes 0 after seven operations, as explained above.</p>
<p>2. Given S = "111", the function should return 5. String S encodes the number V = 7. Its value will change over the following five operations:</p>
<blockquote><ul style="margin: 10px; padding: 0px;"><li>V = 7, which is odd: subtract 1 to obtain 6;</li>
<li>V = 6, which is even: divide by 2 to obtain 3;</li>
<li>V = 3, which is odd: subtract 1 to obtain 2;</li>
<li>V = 2, which is even: divide by 2 to obtain 1;</li>
<li>V = 1, which is odd: subtract 1 to obtain 0.</li>
</ul>
</blockquote><p>3. Given S = "1111010101111", the function should return 22.</p>
<p>4. Given string S consisting of "1" repeated 400,000 times, the function should return 799,999.</p>
<p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
<blockquote><ul style="margin: 10px; padding: 0px;"><li>string S is made only of the characters '<tt style="white-space: pre-wrap;">0</tt>' and/or '<tt style="white-space: pre-wrap;">1</tt>';</li>
<li>N, which is the length of string S, is an integer within the range [1..1,000,000];</li>
<li>the binary representation is big-endian, i.e. the first character of string S corresponds to the most significant bit;</li>
<li>the binary representation may contain leading zeros.</li>
</ul>
</blockquote></div>
<div style="margin-top: 5px;">
<small>Copyright 2009–2024 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.</small>
</div>

</div></div>