<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Natasha Das (nd367)</td></tr>
<tr><td> <em>Generated: </em> 7/5/2023 9:14:37 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-milestone1/grade/nd367" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project if one doesn't exist yet</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github (yes it'll be blank for now)</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet, just have it in open status)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Fix the package references at the top of each file (these are the only edits you should do at this point)</li><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><ol><li>Note: The client commands likely are different in part 5 with the /name and /connect options instead of just connect</li></ol><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-05T23.04.05m1s1.jpg.webp?alt=media&token=3def8321-09d8-45af-9245-95edddbc5f8b"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server being started and running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-05T23.09.05m1s2.jpeg.webp?alt=media&token=94a3a63f-3aed-41fe-b311-9cf30d307614"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client being started and running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>For server-side connection the clients are connected and the server reference is created<br>for each room. When the client is connected, a new room is created<br>and desginated as the lobby.&nbsp;<div><br></div><div>For the client side connection, to establish the connection<br>the sendConnect method is used. It generates a connect payload and writes it<br>to the output stream. Additionally, the isName method is used to add a<br>name command, allowing to set the client&#39;s name during the connection process. Furthermore,<br>the payload is passed for processing based on the PayloadType.<br><div><br></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-05T23.47.46m1s3.jpeg.webp?alt=media&token=eed4b079-fc5c-4569-b9f3-5028f77b590b"/></td></tr>
<tr><td> <em>Caption:</em> <p>At least two clients connected to the server, Client can send messages to<br>the server, Server sends the message to all clients in the same room,<br>Messages clearly show who the message is from (some client identifier like a<br>name or id)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-05T23.54.59m1s4.jpeg.webp?alt=media&token=3384e8d9-fa7f-488b-8f3b-9953079f8425"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrate clients in two different rooms can&#39;t send/receive messages to each other (clearly<br>show the clients are in different rooms)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted (sent to all connected clients), and received</td></tr>
<tr><td> <em>Response:</em> <p><span style="font-size: 13px;"><b>Client perspective (sending):&nbsp;</b> The client generates a payload to be sent<br>to the server thread. This is done through the sendMessage method. The generated<br>payload is then read and processed after being sent to the processMessage method.</span><div>&lt;span<br>style=&quot;font-size: 13px;&quot;&gt;<b>ServerThread:</b>&nbsp;Messages that are recieved are handled using methods like the processMessage method,<br>where the payload data is processed based on its Payload Type. For example,<br>if the Payload type is MESSAGE, the message is broadcasted within the created<br>room. All the rooms will be looped over and the messages will be<br>sent out.&nbsp;</span></div><div><b>Room:</b>&nbsp;a default room called lobby is created and the messages will be<br>sent and recieved in that room unless a new room is created. A<br>message sent from a different room cannot be seen in the lobby/or another<br>room.&nbsp;</div><div><b>Client Perspective(receiving): </b>The server thread is responsible for generating payloads, which are then<br>received by the client.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-06T00.48.27m1s5.jpg.webp?alt=media&token=348c4c1c-083c-4008-a50e-b1fbcf5a9e97"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show a client disconnecting from the server; Server should still be running without<br>issue<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-06T00.59.28m1s6.jpeg.webp?alt=media&token=9583a00b-b22d-4a24-b811-0d320b75d6a3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the server terminating<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>When a client needs to be disconnected, a switch statement is used to<br>handle the disconnect case. Helper methods are there which use static references to<br>disconnect the client by calling the appropriate cliebt disconnect function. Additionally, there are<br>methods to check the connection status and handle disconnection. After disconnection, the server<br>closes its connection and the connection is dropped when terminated. As a result<br>the client program doesnt crash and the server doesnt crash when disconnecting.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nd367/nd367-IT114-450/pull/5">https://github.com/nd367/nd367-IT114-450/pull/5</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>I learned about the different useful methods that were created to make the<br>code more cleaner. This includes the handleDisconnect method which handles the removable of<br>a client after disconnecting.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-milestone1/grade/nd367" target="_blank">Grading</a></td></tr></table>