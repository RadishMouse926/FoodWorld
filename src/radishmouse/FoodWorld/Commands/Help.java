package radishmouse.FoodWorld.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class Help  extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		String msgtxt = "FoodWorld is for administrating and moderating channels \n"
				+ "Type `" + FoodWorld.prefix + "list` to see a list of all of FoodWorld's commands \n"
				+ "The prefix for commands in this guild is `" + FoodWorld.prefix + "`";
		
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "help")) {
			EmbedBuilder msg = FoodWorld.sendMessage("Stuff to Know", msgtxt, "Blue");
			msg.setFooter("This bot was made by Radishmouse2");
			
			event.getChannel().sendMessageEmbeds(msg.build()).queue();
		}
	}
}