<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Natasha Das (nd367)</td></tr>
<tr><td> <em>Generated: </em> 8/1/2023 10:36:48 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone3/grade/nd367" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-25T23.44.23hostPort.jpg.webp?alt=media&token=4eae42f4-9c80-4770-bc40-e603a1af1c81"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screen with Host and Port<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-25T23.48.36usernameScreen.jpg.webp?alt=media&token=05e171ff-6297-49ce-a2e2-cec47954935d"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screen with Username<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <ul><li>A ConnectionPanel and UserInputPanel is created&nbsp;</li><li>Connection Panel<br></li><ul><li>creates a panel for content</li><li>creates a label<br>and text field for Host and a label for hostError which are then<br>added to content panel</li><li>creates a label for port, a text field for the<br>value, and label for portError which are then added to the content panel</li><li>create<br>a new Jbutton for going to the next page</li><ul><li>use addActionListener when button is<br>clicked&nbsp;</li><ul><li>checks if port value is an integer, if not error will be visible</li></ul></ul></ul><li>UserInputPanel</li><ul><li>also<br>creates a content panel</li><li>creates a label for username, text field for value, and<br>userError for an error. Then it is added to content panel</li><li>has a previous<br>button which calls card.previous(container) to go back a page</li><li>has a connect button which<br>uses addActionListener to:</li><ul><li>check the username value and make sure its set. If not<br>send error message</li><li>If null send error message</li><li>if valid, will show chosen username</li></ul></ul></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-26T00.03.25relatedUI.jpg.webp?alt=media&token=dc4576d7-aee1-4497-9307-ec12a24610af"/></td></tr>
<tr><td> <em>Caption:</em> <p>RelatedUI (list of users in room, chat message area with chat history, create<br>message area with send button)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-02T02.35.11enterM3.jpg.webp?alt=media&token=454e0bb0-11b2-427f-92f5-b48db8096f86"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show a snippet for the code that lets the enter key send the<br>message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-28T23.33.40milestone3rollandflip.jpg.webp?alt=media&token=35b29aa3-8433-4b69-a144-8004e62bd3cc"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show /flip (should clearly show who triggered it along with the output), show<br>/roll (should clearly show who triggered it along with the output and any<br>relevant data), and output appears in a different text format of my choice.<br>I used bold and italic.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T00.24.56milestone3sub2i1.jpg.webp?alt=media&token=d557ced5-b9fc-40a3-8092-d67770d5c1b4"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows the text format logic of displaying html formatted text<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T00.34.32milestone3sub2i2.jpg.webp?alt=media&token=f0ef6c8d-02ee-4ef7-bd82-2c9e0f557d5b"/></td></tr>
<tr><td> <em>Caption:</em> <p>shows server-side code for /flip generation, shows server side code for /roll generation<br>(both formats), shows text format logic.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T00.38.04milestone3sub2i3.jpg.webp?alt=media&token=853cd5ef-0e18-4359-9a05-97aece83dcf6"/></td></tr>
<tr><td> <em>Caption:</em> <p>Calling the flipping and rolling method through processCommands (shows server-side code for /flip<br>generation, shows server side code for /roll generation (both formats))<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>Flip: the flip command uses a ternary operator to randomly assign Heads or<br>Tails to the result. Then I put the html tags &lt;i&gt; and &lt;/i&gt;<br>around the message to italicize it.&nbsp;<div><br></div><div>Rolling: It checks which format the command is<br>in (the /roll 0-X or /roll #d#). It does this by checking if<br>the command conatins &quot;d&quot;. A random number is generated for the roll then<br>sends the output based on the format. For both messages for both formats<br>I put the html tags &lt;b&gt; and &lt;/b&gt; to bold the output.&nbsp;</div><div><br></div><div>The client<br>initiates roll or flip through the trigger /roll or /flip. The server then<br>goes through the processes mentioned above and then the sendMessage method to send<br>the output back to the client.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T01.36.26milestone3customtext1.jpg.webp?alt=media&token=7b029e8f-7a9c-455d-b094-c48030fb9eb6"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of bold, italic, colors, underline, combinations of effects together working (bold, italic,<br>underline and color). Look at all lines. <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T01.46.43m3t1.jpeg.webp?alt=media&token=1d22e9d1-0970-47d0-bec7-d91a86d78526"/></td></tr>
<tr><td> <em>Caption:</em> <p>Input string used in chat send area for bold and italics. Look at<br>line 1 and 3 in screenshot.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T01.54.31milestone3t3.jpeg.webp?alt=media&token=fcf61d02-b005-4dd3-a23d-282d7c60998a"/></td></tr>
<tr><td> <em>Caption:</em> <p>Input string used in chat send area for underline. Look at line 5<br>in screenshot.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-29T02.03.34milsetone3t4.jpg.webp?alt=media&token=ddb677e3-91ea-43ec-aa0b-38aa9073ba9b"/></td></tr>
<tr><td> <em>Caption:</em> <p>input string for combination of effects together working and input string for color<br>working. Look at line 1 in both screens.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>I got the UI side to render the text accordingly by adjusting code<br>in the ChatPanel.java so that the JEditorPane textConatiner is used to display the<br>html text format. Before, the JEditor&#39;s paramter included &quot;text/plain&quot;, but I changed it<br>to &quot;text/html&quot;. As a result, rendering and displaying a message in html styles<br>is possible instead of just plain text.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-30T21.26.54milestone3whisper.jpg.webp?alt=media&token=659ff67f-582a-4638-90f2-41a1432b0030"/></td></tr>
<tr><td> <em>Caption:</em> <p>demo of whisper triggered by @username<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-07-30T21.28.44whispercode.jpg.webp?alt=media&token=69b6025a-c6a3-43ef-9d02-3445f39b0d20"/></td></tr>
<tr><td> <em>Caption:</em> <p>server-side code of whisper<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>In the sendMessage method, the code first checks if the message starts with<br>@. Then I assigned the characters after @ to the first space to<br>the username, and the characters after the first space to be the message.<br>This makes sense for the format @username message to work.&nbsp;<div><br></div><div>I then used a<br>for loop to iterate through the clients and an if statement to check<br>if the client matches the username. The client that receives the message is<br>assigned to the variable whisperedUser.</div><div><br></div><div>I used whisperedUser.sendMessage with the parameters of sender.getClientID() and<br>the message to send the message to only the client who is whisperedUser<br>from the client sending the whisper.</div><div>Then I used sender.sendMessage with parameters sender.getClientID() and<br>the message so the client who sent the message also recieves a message<br>that the whisper was successfully sent.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-01T23.31.37M3mutenunmute.jpg.webp?alt=media&token=966b5e4b-f468-4ec4-b4b3-ec6eb0787831"/></td></tr>
<tr><td> <em>Caption:</em> <p>mute/unmute demo<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-01T23.40.45serverThreadM3.jpg.webp?alt=media&token=2971f20d-0d11-4743-b1ac-797bb63f33f0"/></td></tr>
<tr><td> <em>Caption:</em> <p>code in serverthread class for mute/unmute (creating list, checking if muted, adding muted<br>user to list, removing unmuted user from list)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-01T23.52.06mute%26unmuteRoom1.jpg.webp?alt=media&token=e0bf5267-3751-4327-9fb0-a98bab002f6c"/></td></tr>
<tr><td> <em>Caption:</em> <p>Sending message for mute/unmute. Uses muteUser, unmuteUser, and mutedCheck from ServerThread.java <br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fnd367%2F2023-08-02T00.00.40muteunmuteRoom2.jpg.webp?alt=media&token=53196dbc-12d3-487c-a8c3-eb1d05e57ed0"/></td></tr>
<tr><td> <em>Caption:</em> <p>Does not send message to the muter from the muted client<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>In the serverThread class I created the list mutedUsers. I also created three<br>methods mutedCheck, muteUser, and unmuteUser. MutedCheck checks if the list contains a username,<br>thus checking if the user is muted. MuteUser adds the username to the<br>list and unmutedUser removes the username from the list.&nbsp;<div><br></div><div>In processCommands in the Room<br>class I created a MUTE and UNMUTE case. When triggered with /mute the<br>server sends a message and calls muteUser to add the client to the<br>list. When triggered with /unmute mutedCheck is called to check if the username<br>is muted, then sends a message from the server and uses unmuteUser method<br>to remove the username from the list.</div><div><br></div><div>In&nbsp; sendMessage in the Room class, I<br>used mutedCheck to check if the client muted the sender. If yes, then<br>the message does not send to that client.&nbsp;</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nd367/nd367-IT114-450/pull/7">https://github.com/nd367/nd367-IT114-450/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M23/it114-chatroom-milestone3/grade/nd367" target="_blank">Grading</a></td></tr></table>