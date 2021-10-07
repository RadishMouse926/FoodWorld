package radishmouse.FoodWorld.Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		/* If the bot ever sends a message, then add a ❌ reaction so users can delete that message */
		if (event.getAuthor().equals(event.getJDA().getSelfUser())) {
			event.getMessage().addReaction("❌").queue();
		}
	}
}
