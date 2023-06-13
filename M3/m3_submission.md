<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Natasha Das (nd367)</td></tr>
<tr><td> <em>Generated: </em> 6/13/2023 12:41:08 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-number-guesser/grade/nd367" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><ol><li><a href="https://gist.github.com/MattToegel/aced06400c812f13ad030db9518b399f">https://gist.github.com/MattToegel/aced06400c812f13ad030db9518b399f</a><br></li></ol><li>Add/commit the files as-is from the lesson material (this is the base template)</li><li>Pick two (2) of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject user direct edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-06-13T03.57.52highlow.jpg.webp?alt=media&token=485b5595-37b5-44a8-ac69-c6f5180e0920"/></td></tr>
<tr><td> <em>Caption:</em> <p>Display higher or lower as a hint after a wrong guess- code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-06-13T04.02.10highlow2.jpg.webp?alt=media&token=1f87a38e-82ae-4dba-bf2e-2e492a437a95"/></td></tr>
<tr><td> <em>Caption:</em> <p>Running Display high or low after a wrong guess<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I used conditional statements print that the answer is too high when the<br>guess is greater than the number(in if statement). Then an else statement was<br>used to print the answer is low if the first condition is not<br>met.&nbsp;&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-06-13T04.11.39hotcold1.jpg.webp?alt=media&token=5fa759df-debf-45f2-af51-5398fac803a4"/></td></tr>
<tr><td> <em>Caption:</em> <p>Display a cold, warm, hot indicator based on how close to the correct<br>value the guess is - running code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-06-13T04.11.59hotorcold2.jpg.webp?alt=media&token=4259f1cb-df22-433b-8ec4-e73637ff3930"/></td></tr>
<tr><td> <em>Caption:</em> <p>Display a cold, warm, hot indicator based on how close to the correct<br>value the guess is - code<br></p>
</td></tr>
<tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> <p>Display a cold, warm, hot indicator based on how close to the correct<br>value the guess is - running code another example<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I used conditional statements and java operators &amp; and | to make sure<br>the correct statement is printed for the correct situation. If the correct answer<br>is 2 numbers away, it would print &quot;Hot&quot;. If the number is more<br>than 2 numbers away and less than 5 numbers away then it will<br>print &quot;Getting warm&quot;. Lastly if it does not meet any of those conditions<br>(meaning 5 numbers or more away)&nbsp; the number is too far away from<br>the answer and prints &quot;Cold&quot;.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nd367/nd367-IT114-450/pull/3">https://github.com/nd367/nd367-IT114-450/pull/3</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>This week&#39;s lesson I learned about the importance of Java&#39;s Scanner class when<br>utilizing user input. I know to make sure to import java.util.Scanner, new Scanner<br>is wrapped around System.in, it has a hasNext() method and nextLine() method.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-number-guesser/grade/nd367" target="_blank">Grading</a></td></tr></table>