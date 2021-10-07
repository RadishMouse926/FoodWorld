package radishmouse.FoodWorld.Commands;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "clear")) {
			if (args.length < 2) {
				// no argument
				EmbedBuilder msg = FoodWorld.sendMessage("Specify Amount To Delete", "Usage: `" + FoodWorld.prefix + "clear [# of messages]`", "Blue");
				event.getChannel().sendMessageEmbeds(msg.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					EmbedBuilder msg = FoodWorld.sendMessage("Succesfully deleted `" + args[1] + "` messages", null, "Blue");
					event.getChannel().sendMessageEmbeds(msg.build()).queue();
				}
				catch (IllegalArgumentException e) {
					// too many messages
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						EmbedBuilder msg = FoodWorld.sendMessage("Too Many Messages Selected", "Discord bots can only delete 1-100 messages at once", "Red");
						event.getChannel().sendMessageEmbeds(msg.build()).queue();
					}
					else {
						// messages too old
						if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
							EmbedBuilder msg = FoodWorld.sendMessage("Selected Messages Are Too Old", "Discord bots can only delete messages that aren't older than 2 weeks", "Red");
							event.getChannel().sendMessageEmbeds(msg.build()).queue();
						}
					}
				}
			}
		}
	}
}
