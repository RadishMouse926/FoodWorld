# FoodWorld

Foodworld 1.2 is the newsest version. The source code was made using the [Eclipse IDE](https://www.eclipse.org/eclipseide/) by the Eclipse Foundation, and the [Java Discord API](https://github.com/DV8FromTheWorld/JDA) by DV8FromTheWorld.  
The .settings folders and .project folders are made to work with Eclipse becuase that is the IDE used.

# Stuff it does

### 1) clears messages in the past

People can use the -clear command to clear messages in the past.  
The syntax is `-clear <x>` where x is the number of messages to clear.

### 2) Mutes members

People with roles `Owner` and `Mod` (case sensitive) can use the -mute command.  
The syntax is `-mute <mention>` where mention is an @mention of the user to mute.

### 3) Censors chat

The filter in `radishmouse.FoodWorld.Events.GuildMessageReceived.java` contains the words to censor.  
The string array `private String[] cuss_words = {};` is the list.  
Add the words you want to filter out here.

# Changes you need to make

### Add your Discord bots token

In `radishmouse.FoodWorld.FoodWorld.java`, where it says `private static String token = "Classified";`, insert your bot token in the string where it says `Classified`.  
Learn more about getting your own Discord bot token [here](https://www.writebots.com/discord-bot-token/).

### Change the "cuss filter" words.

`radishmouse.FoodWorld.Events.GuildMessageReceived.java` contains the string array `private String[] cuss_words = {};`. Add the words you want to filter out here.

### Change the rules message

In `radishmouse.FoodWorld.Commands.Rules.java` there is the String `String msgtxt = "msg";`. Add your own message here.  
I used `+ "\n"` after each line to make a new line and `▫` as a bullet point.