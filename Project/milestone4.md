<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Natasha Das (nd367)</td></tr>
<tr><td> <em>Generated: </em> 8/8/2023 7:51:55 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone4/grade/nd367" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T05.05.47exportbutton.jpg.webp?alt=media&token=978d7e51-0860-494c-80fc-2c9bd570367e"/></td></tr>
<tr><td> <em>Caption:</em> <p>export button on chat panel<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T05.06.28exportchatcode2.jpg.webp?alt=media&token=e5ec687f-5296-477e-8b51-0d604dba5eec"/></td></tr>
<tr><td> <em>Caption:</em> <p>export button code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T05.31.50export_code.jpg.webp?alt=media&token=b8053fa4-942c-47b1-8266-a06e95395805"/></td></tr>
<tr><td> <em>Caption:</em> <p>export method code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T05.32.35exportedMessage.jpg.webp?alt=media&token=dc5e90a8-730d-4111-95ec-e8ccfb43d9b6"/></td></tr>
<tr><td> <em>Caption:</em> <p>Exported Message<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T05.24.10exportedchatfile1.jpg.webp?alt=media&token=7b2fa956-5c58-4d83-bbef-69e06205e300"/></td></tr>
<tr><td> <em>Caption:</em> <p>exported data in generated file<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I first created a button just like the send button. I implemented addActionListener<br>where I called my exportChat method.<div>In exportChat, I created a for loop that<br>iterated through each component in chatArea. Then used an if statement to check<br>if the component is an instance of JEditorPane which holds the chat messages.<br>I assigned the component to textContainer. Then used textContainer.getText(); to retrieve the chat<br>messages and assign them to chat_message. Then append it into my StringBuilder&nbsp; chatHistory.&nbsp;</div><div><br></div><div>I<br>assigned newFile to create a new file named chat_history.html. Then used FileWriter writer<br>which I assigned to writing the content into newFile. Then I used JOptionPane&#39;s<br>showMessageDialog method to show a success or error message.&nbsp;</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T22.14.582ndmuted.jpeg.webp?alt=media&token=5366d613-0d57-4b45-aee0-9b65758afcf1"/></td></tr>
<tr><td> <em>Caption:</em> <p>2nd session: read csv file with muted users so those users are already<br>muted. Need to unmute to see their messages<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-07T22.18.06csvMuted.jpg.webp?alt=media&token=20db681b-f549-424a-af4b-1e6b552dd88d"/></td></tr>
<tr><td> <em>Caption:</em> <p>csv file with muted list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T05.02.12mutelistCode1.jpg.webp?alt=media&token=42b0799e-f56d-470a-a04b-b70b5221c8b4"/></td></tr>
<tr><td> <em>Caption:</em> <p>save and load methods<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T05.14.57callingSaveMuted.jpg.webp?alt=media&token=925dae22-bfd4-42fa-b6fb-5ff215f3b843"/></td></tr>
<tr><td> <em>Caption:</em> <p>calling saveMuted method when adding/removing muted user<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T18.42.54loadMuted.jpg.webp?alt=media&token=73179d26-cd2f-4e18-8fa7-d8d9f9e0a9c1"/></td></tr>
<tr><td> <em>Caption:</em> <p>calling load muted method when a new serverthread instance is created<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I created two methods, one for saving the muted list and one for<br>loading the muted list.<div>&nbsp;</div><div>In my saveMuted method I used Filewriter to write into<br>a file called mute_list.csv. I then used a for loop to iterate through<br>each username in the mutedUsers list and write the username in the file<br>along with a new line character to separate the usernames. This method is<br>called when using the methods for adding or removing a client from the<br>list.</div><div><br></div><div>For my loadMuted method I used BufferedReader and FileReader to read mute_list.csv. BufferedReader<br>helps read data in larger chunks. Then used String username; to store each<br>username from the file in a String variable. Then used that to loop<br>through each line in the csv file and add each username to the<br>mutedUsers list. This method was called in the ServerThread method so the muted<br>users can be loaded when a new ServerThread instance is created.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T17.47.46mutenotify2.jpg.webp?alt=media&token=32a3fb72-e6f0-4142-bd37-83d28875a01b"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client&#39;s will receive a message when they get muted/unmuted by another user<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T18.00.54notifycode2.jpg.webp?alt=media&token=6af6f160-bc40-4285-9211-84cbe8f428cf"/></td></tr>
<tr><td> <em>Caption:</em> <p>code: method for mute notification <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T18.01.53notifycode1.jpg.webp?alt=media&token=b7a1c165-e840-4d1b-90eb-4691b58cdfec"/></td></tr>
<tr><td> <em>Caption:</em> <p>code:calling mute notification method when adding/removing from mute list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I created a getClientByUsername method that checks if a username matches with the<br>list of clients in the room through a for loop.<div>I created a muteNote<br>method which uses the getClientByUsername method by matching the target&#39;s username. If the<br>target username is found then I used the ternary operator to say if<br>the boolean notifyMuted is true, output muted. If not, then output unmuted. Then<br>that is used to create the notification message to say the muter muted/unmuted<br>you. Lastly I used target.sendMessage to have the message sent to only the<br>target being muted.</div><div>&nbsp;</div><div>I called the muteNote method in serverThread class in the methods<br>I created for adding and removing a user from the muted list. Therefore,<br>when a user is muted or unmuted, the notification is sent.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> <p>could not figure it out/ran out of time<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-08T23.26.57highlight.jpg.webp?alt=media&token=6af222b3-5b78-4c72-8a0a-44e50f14eec8"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for styling the message to be highlighted<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I didn&#39;t have enough time left to figure out<span style="letter-spacing: 0.09996px;">&nbsp;&quot;Muted users by<br>the client should appear grayed out&quot;. The way I would go about it<br>is in the Send Message method in the room class I would check<br>if the client is muted, if yes then use html to send the<br>message with gray text.&nbsp;</span><div><span style="letter-spacing: 0.09996px;"><br></span></div><div><span style="letter-spacing: 0.09996px;">I also didn&#39;t have time to<br>finish figuring out &quot;last person to send a message gets highlighted&quot;. In the<br>code I provided is a way to highlight the message by wrapping the<br>message using html tags(to change the background color to yellow) in the sendMessage<br>method in the room class.&nbsp; This is put in an if statement so<br>the message would only be highlighted if the message was from the last<br>sender.&nbsp;</span></div><div><span style="letter-spacing: 0.09996px;"><br></span></div><div><span style="letter-spacing: 0.09996px;">How I would try to get this feature to<br>work is maybe create a boolean to say if it is the last<br>message (true) then highlight the message otherwise if false then don&#39;t highlight.</span></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone4/grade/nd367" target="_blank">Grading</a></td></tr></table>