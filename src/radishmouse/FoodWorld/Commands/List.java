package radishmouse.FoodWorld.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class List extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		String msgtxt = "Commands that FoodWorld uses:" + "\n `"
				+ FoodWorld.prefix + "list` | gives you a list of all of the commands" + "\n `"
				+ FoodWorld.prefix + "clear [x]` | clears [x] amount of messages" + "\n `"
				+ FoodWorld.prefix + "mute @mention` | mutes mentioned user";
		
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "list")) {
			EmbedBuilder msg = FoodWorld.sendMessage("List of Commands", msgtxt, "Blue");
			
			event.getChannel().sendMessageEmbeds(msg.build()).queue();
		}
	}
}
