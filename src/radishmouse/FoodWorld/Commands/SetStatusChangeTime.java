package radishmouse.FoodWorld.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;
import radishmouse.FoodWorld.Status;

public class SetStatusChangeTime extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "statustime")) {
			if (args.length != 2) {
				EmbedBuilder msg = FoodWorld.sendMessage("Specify Status Change Time", "Usage: `" + FoodWorld.prefix + "statustime [# of seconds]`", "Blue");
				event.getChannel().sendMessageEmbeds(msg.build()).queue();
			}
			else {
				try {
					Status.updateTime = Integer.parseInt(args[1]);
					
					EmbedBuilder msg = FoodWorld.sendMessage(null, "Set status reload time to `" + args[1] + "` seconds", "Blue");
					event.getChannel().sendMessageEmbeds(msg.build()).queue();
				}
				catch (Exception e) {
					EmbedBuilder msg = FoodWorld.sendMessage("Specify Status Change Time", "Usage: `" + FoodWorld.prefix + "statustime [# of seconds]`", "Blue");
					event.getChannel().sendMessageEmbeds(msg.build()).queue();
				}
			}
		}
	}
}
