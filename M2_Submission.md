<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Natasha Das (nd367)</td></tr>
<tr><td> <em>Generated: </em> 7/16/2023 11:55:48 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone-2/grade/nd367" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-12T01.42.05m2s1.jpg.webp?alt=media&token=90da7b68-8a0c-48ab-9732-6432a4081604"/></td></tr>
<tr><td> <em>Caption:</em> <p>First screenshot of Payload code with comment<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-12T01.52.23m2s2fixed.jpg.webp?alt=media&token=c8da8e01-8da5-48e0-901d-af1a931d90a3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Second screenshot of Payload code with comment<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-12T03.55.10m2s3.jpg.webp?alt=media&token=a5b79980-f9d2-411a-92c4-a43161b32791"/></td></tr>
<tr><td> <em>Caption:</em> <p>payload content in terminal<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-16T04.18.24flipnroll1.jpeg.webp?alt=media&token=24487b5e-0487-44c5-bf44-bcd729640462"/></td></tr>
<tr><td> <em>Caption:</em> <p>Flip and Roll code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-16T04.23.11rollnflip2.jpeg.webp?alt=media&token=4711f20b-522a-4801-bb56-7a3354f6f8d2"/></td></tr>
<tr><td> <em>Caption:</em> <p>Roll and Flip code Setting payload types <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <ul><li>Created a Payload Type called ROLL. Set any message that starts with /roll<br>to the payload type ROLL.</li><ul><li>I created two methods in the Room.java file, one<br>for the /roll 0-X or 1-X and one for /roll #d#.</li><li>For /roll 0-X<br>or 1-X, I made sure to generate a random number between 1 and<br>the number given by the user. This result would be outputted along with<br>the client name.</li><li>For /roll #d#, the code checks if the second part (<br>the #d#) contains d. The first number before d I assigned to rollnum1(representing<br>number of dice being rolled)&nbsp; and the second number after d I assigned<br>to rollnum2 (representing number of sides of the dice). I used a for<br>loop to roll the dice a specific number of times based on rollnum1.<br>Inside the for loop it generates a random number between 1 and the<br>rollnum2. The total value is calculated then outputted along with the client name.</li></ul><li>Created<br>a Payload Type called FLIP. Set any message that starts with /roll to<br>the payload type FLIP.&nbsp;</li><ul><li>I use Math.random to generate a random number 0 to<br>1. If the number is less than 0.5 which means its equal to<br>0, it is considered heads. Otherwise if the number is more than 0.5<br>which means its 1, then it is tails. This is done through a<br>ternary operator and at the end it outputs the client name and the<br>result.&nbsp;</li></ul></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-17T03.20.40formatstyles1.jpeg.webp?alt=media&token=0771adb9-6efe-4a86-8c17-120077205f17"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for various style handling<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-17T03.25.23sendformat.jpeg.webp?alt=media&token=66fd0ed9-54e4-45d2-b235-8cb022837d57"/></td></tr>
<tr><td> <em>Caption:</em> <p>Sending the formatted message<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-17T03.35.35stylingoutput.jpeg.webp?alt=media&token=11cda706-cd5e-46bf-808a-c69190af1d8a"/></td></tr>
<tr><td> <em>Caption:</em> <p>Result output<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>I created a method called formatStyle that uses the Java String replaceAll method<br>where it matches the message with regex then replaces it with the applied<br>style. For example, I used formatresult = formatresult.replaceAll(&quot;\<em>(.</em>?)\*&quot;, &quot;&lt;b&gt;$1&lt;/b&gt;&quot;); to change <em>text</em> to<br>bold. I used the replaceAll method for all the styles.&nbsp;<div>To apply each method<br>the user would type:</div><div><ul><li><em>text</em> for bold</li><li><em>text</em> to underline</li><li>-text- for italics</li><li>#rtext#r for red text</li><li>#gtext#g<br>for green text</li><li>#btext#b for blue text</li></ul></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nd367/nd367-IT114-450/pull/6">https://github.com/nd367/nd367-IT114-450/pull/6</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone-2/grade/nd367" target="_blank">Grading</a></td></tr></table>